package edu.miu.services;

import edu.miu.modling.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();
    public PostDto findById(long id);
    public void insert(PostDto p);
    public void deleteById(long id);
    public void update(long id, PostDto p);
    List<PostDto> findAllByAuther(String author);
}
