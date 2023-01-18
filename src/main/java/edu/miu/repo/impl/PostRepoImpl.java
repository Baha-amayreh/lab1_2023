package edu.miu.repo.impl;

import edu.miu.modling.Post;
import edu.miu.repo.PostRepo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl  implements PostRepo {
    private static List<Post> posts;
    private static int PostId =0 ;
    static {
        posts = new ArrayList<>();
        Post p1 = new Post(PostId++,"programming C++","computer","A");
        Post p2 = new Post(PostId++,"programming java","computer","B");
        Post p3= new Post(PostId++,"programming kotlin","computer","C");
        posts.add(p1);   posts.add(p2);   posts.add(p3);
        for(int i=1;i<10;i++){
            Post p= new Post(PostId++,"programming kotlin "+i,"computer","C"+i);
            posts.add(p);
        }
    }
    public List<Post> findAll(){
        return this.posts;
    }

    @Override
    public Post findById(long id) {
        return this.posts.stream()
                .filter(e->e.getId()==id)
                .findFirst().orElse(null);
    }

    @Override
    public void insert(Post p) {
        p.setId(PostId++);
        posts.add(p);
    }

    @Override
    public void deleteById(long id) {
      var post =posts.stream().filter(e->e.getId()==id)
              .findFirst().orElse(null);
      if(post!=null){
          posts.remove(post);
      }
    }
    @Override
    public void update(long id, Post p) {
        var object=findById(id);
        if(object!=null){
            object.setAuthor(p.getAuthor());
            object.setContent(p.getContent());
            object.setTitle(p.getTitle());
        }
    }

    @Override
    public List<Post> findAllByAuther(String author) {
        return posts.stream().filter(e->e.getAuthor()
                .equals(author))
                .collect(Collectors.toList());
    }
}
