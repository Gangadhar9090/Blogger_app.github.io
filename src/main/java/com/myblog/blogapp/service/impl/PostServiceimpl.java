package com.myblog.blogapp.service.impl;

import com.myblog.blogapp.entities.Post;
import com.myblog.blogapp.exception.ResourceNotFoundException;
import com.myblog.blogapp.payload.PostDto;
import com.myblog.blogapp.payload.PostResponse;
import com.myblog.blogapp.repository.PostRepository;
import com.myblog.blogapp.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service

public class PostServiceimpl implements PostService {

    private PostRepository postRepo;
    private ModelMapper mapper;

    public PostServiceimpl(PostRepository postRepo,ModelMapper mapper) {

        this.postRepo = postRepo;
        this.mapper=mapper;
    }

    @Override
    //convert entity into DTO class
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);

        Post postEntity = postRepo.save(post);
        PostDto dto = mapToDto(postEntity);
        return dto;


    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepo.findAll();
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        PostDto postDto = mapToDto(post);
        return postDto;
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {

        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post post1 = postRepo.save(post);
        return mapToDto(post1);

    }

    @Override
    public void deletePost(long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepo.deleteById(id);
    }

    @Override
    public PostResponse getallposts(int pageNo, int pageSize, String sortBy,String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageable = PageRequest.of(pageNo,pageSize, sort);

        Page<Post> posts = postRepo.findAll(pageable);
        List<Post> content = posts.getContent();

        List<PostDto> contents=content.stream().map(post->mapToDto(post)).collect(Collectors.toList());
      PostResponse postResponse=new PostResponse();
      postResponse.setContent(contents);
      postResponse.setPageNO(posts.getNumber());
      postResponse.setPageSize(posts.getSize());;
      postResponse.setTotalPages(posts.getTotalPages());
      postResponse.setTotalElements(posts.getTotalElements());
      postResponse.setLast(posts.isLast());

        return postResponse;
    }

    public Post mapToEntity(PostDto postDto) {
        Post post=mapper.map(postDto,Post.class);
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        return post;
    }

    public PostDto mapToDto(Post post) {
        PostDto dto=mapper.map(post,PostDto.class);
//        PostDto dto = new PostDto();
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//        dto.setDescription(post.getDescription());
//        dto.setContent(post.getContent());
        return dto;

    }

}
