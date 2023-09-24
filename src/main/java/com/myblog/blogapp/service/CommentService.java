package com.myblog.blogapp.service;

import com.myblog.blogapp.payload.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    CommentDto createComment(long postId,CommentDto commentDto);
    List<CommentDto> getCommentBYPostId(long postId);

    CommentDto updateComment(long postId, long id, CommentDto commentDto);

    CommentDto deletecomment(long postId, long commentId);
}


