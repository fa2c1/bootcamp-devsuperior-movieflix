package com.devsuperior.movieflix.services;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    GenreRepository repository;

    @Autowired
    AuthService authService;

    public List<GenreDTO> findAll() {
        authService.authenticated();
        List<Genre> list = repository.findAll();
        return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
    }

}
