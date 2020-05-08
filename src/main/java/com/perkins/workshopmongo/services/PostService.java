package com.perkins.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perkins.workshopmongo.domain.Post;
import com.perkins.workshopmongo.repository.PostRepository;
import com.perkins.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> optional = repo.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
