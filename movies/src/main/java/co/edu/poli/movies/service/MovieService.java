package co.edu.poli.movies.service;

import co.edu.poli.movies.persistence.entity.Movie;
import co.edu.poli.movies.service.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();
    void save(MovieDTO movieDTO);
    Movie findById(Long id);
    void delete(Movie movie);
}
