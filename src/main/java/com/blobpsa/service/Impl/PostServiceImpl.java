package com.blobpsa.service.Impl;

import com.blobpsa.entity.Post;
import com.blobpsa.payload.PostDto;
import com.blobpsa.repository.PostRepository;
import com.blobpsa.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {
    //  autowiring with field
    private PostRepository postRepository;

    //AutoWiring with cobstructor
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost = postRepository.save(post);
        PostDto dto= new PostDto(); //refreing to this means refering to the data that got saved
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent((savedPost.getContent()));
         return dto;

    }
}

