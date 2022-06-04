package com.devsuperior.movieflix.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        authService.authenticated();
        Optional<Movie> obj = movieRepository.findById(id);
        Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new MovieDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAllPage(Long genreId, Pageable pageable) {
        authService.authenticated();
        Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId);
        Page<Movie> page = movieRepository.find(genre, pageable);
        movieRepository.findMovieCategory(page.getContent());
        return page.map(x -> new MovieDTO(x));
    }

    @Transactional(readOnly = true)
    public List<ReviewDTO> movieReview(Long id) {
        authService.authenticated();
        Movie movie = movieRepository.getOne(id);
        return movie.getReviews().stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
    }
}
