package com.example.adminpanel.service;

import com.example.adminpanel.entity.Post;
import com.example.adminpanel.exceptions.NoSuchElementFoundException;
import com.example.adminpanel.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() throws NoSuchElementFoundException {
        return postRepository.findAll();
    }

    public void savePost(Post post){
        postRepository.save(post);
    }

    public Post getPostById(Long id){
        return postRepository.findById(id).get();
    }

    public void updatePost(Post post){
        postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
