package edu.miu.services.impl;

import edu.miu.helper.ListMapper;
import edu.miu.modling.Post;
import edu.miu.modling.dto.PostDto;
import edu.miu.repo.PostRepo;
import edu.miu.services.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    public List<PostDto> findAll() {
        return (List<PostDto>) listMapperPostToDto.
                mapList(postRepo.findAll(),new PostDto());
    }

    @Override
    public PostDto  findById(long id) {
        PostDto object = modelMapper.map(postRepo.findById(id), PostDto.class);
        return object;
    }
    public void insert(PostDto p){
        postRepo.insert(modelMapper.map(p, Post.class));
    }
    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(long id, PostDto p) {
        postRepo.update(id ,(Post) modelMapper.map(p, Post.class));
    }

    @Override
    public List<PostDto> findAllByAuther(String author) {
       return  postRepo.findAllByAuther(author)
                .stream()
                .map( e-> modelMapper.map(e, PostDto.class))
                .collect(Collectors.toList());
    }
}
