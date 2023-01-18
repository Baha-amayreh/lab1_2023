package edu.miu.controller;
import edu.miu.modling.dto.PostDto;
import edu.miu.modling.dto.PostV2;
import edu.miu.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
@RestController
public class PostController {
    private final PostService  postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
//    @GetMapping
//    public List<PostDto> getAll() {
//        return postService.findAll();
//    }
    @GetMapping("/{id}")
    public PostDto findById(@PathVariable long id){
        return this.postService.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody PostDto p) {
        postService.insert(p);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id){
        postService.deleteById(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody PostDto p) {
        postService.update(id,p);
    }
    @GetMapping("")
    public List<PostDto> allPost(@RequestParam(value = "filter" ,required = false) String author) {
        return author == null ? postService.findAll() : postService.findAllByAuther(author);
    }

    @GetMapping(value = "/{id}", headers = "V=2")
    public PostV2 getByIdV2(@PathVariable int id){
        return new PostV2(id, "Version2", "Version2","Version2");
    }
}
