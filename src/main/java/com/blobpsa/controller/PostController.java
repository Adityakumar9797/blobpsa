package com.blobpsa.controller;

import com.blobpsa.payload.PostDto;
import com.blobpsa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    public PostController(PostService postservice) {
        this.postservice = postservice;
    }

    private PostService postservice; //it will automatically create the object of Impl and inject into it


    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {


        PostDto dto = postservice.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
