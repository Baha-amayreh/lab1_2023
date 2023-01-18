package edu.miu.repo;

import edu.miu.modling.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();
    public Post findById(long id);
    public void insert(Post p);
    public void deleteById(long id);
    public void update(long id, Post p);
    List<Post> findAllByAuther(String author);
}
