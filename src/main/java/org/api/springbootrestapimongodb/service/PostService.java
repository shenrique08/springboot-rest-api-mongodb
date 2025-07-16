package org.api.springbootrestapimongodb.service;


import org.api.springbootrestapimongodb.domain.Post;
import org.api.springbootrestapimongodb.repository.PostRepository;
import org.api.springbootrestapimongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found with ID: " + id));
    }
}
