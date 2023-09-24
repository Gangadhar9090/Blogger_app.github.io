package com.myblog.blogapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

   private List<PostDto> content;
   private int pageNO;
   private int pageSize;
   private long totalElements;
   private int totalPages;

   private boolean last;


   public List<PostDto> getContent() {
      return content;
   }

   public void setContent(List<PostDto> content) {
      this.content = content;
   }

   public int getPageNO() {
      return pageNO;
   }

   public void setPageNO(int pageNO) {
      this.pageNO = pageNO;
   }

   public int getPageSize() {
      return pageSize;
   }

   public void setPageSize(int pageSize) {
      this.pageSize = pageSize;
   }

   public long getTotalElements() {
      return totalElements;
   }

   public void setTotalElements(long totalElements) {
      this.totalElements = totalElements;
   }

   public int getTotalPages() {
      return totalPages;
   }

   public void setTotalPages(int totalPages) {
      this.totalPages = totalPages;
   }

   public boolean isLast() {
      return last;
   }

   public void setLast(boolean last) {
      this.last = last;
   }
}
