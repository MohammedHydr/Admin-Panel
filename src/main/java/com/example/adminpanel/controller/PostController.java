package com.example.adminpanel.controller;

import com.example.adminpanel.entity.Post;
import com.example.adminpanel.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String listPosts(Model model) {
        //keys and values , access this key using thymeleaf syntax ${listPosts}
        model.addAttribute("listPosts", postService.getAllPosts());
        return "post/posts"; // name of the html file
    }

    @GetMapping("/posts/new")
    public String createPostForm(Model model) {
        // create post object to hold post from data
        Post post = new Post();
        model.addAttribute("addPost", post);
        return "post/create_post";
    }

    @PostMapping("/posts")
    public String savePost(@ModelAttribute("posts") Post post,
                            @RequestParam("file") MultipartFile file) throws IOException {

        byte[] contents = file.getBytes();
        post.setImage(contents);
        postService.savePost(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        model.addAttribute("editPost", postService.getPostById(id));
        return "post/edit_post";
    }

    @PostMapping("/posts/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute("updatePost") Post post,
                              @RequestParam("file") MultipartFile file) throws IOException {
        //get post from database by id
        Post existingPost = postService.getPostById(id);
        existingPost.setPost_id(id);
        byte[] contents = file.getBytes();
        existingPost.setImage(contents);
        existingPost.setComment(post.getComment());
        existingPost.setPlace(post.getPlace());
        existingPost.setUser(post.getUser());
        postService.updatePost(existingPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
