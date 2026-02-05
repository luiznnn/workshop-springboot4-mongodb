package com.luiz.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.workshopmongo.domain.Post;
import com.luiz.workshopmongo.repository.PostRepository;
import com.luiz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id)
            .orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado! Id: " + id)
            );
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
