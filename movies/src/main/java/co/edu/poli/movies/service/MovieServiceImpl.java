package co.edu.poli.movies.service;

import co.edu.poli.movies.mapper.MovieDTOToMovie;
import co.edu.poli.movies.persistence.entity.Movie;
import co.edu.poli.movies.persistence.repository.MovieRepository;
import co.edu.poli.movies.service.dto.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final MovieDTOToMovie movieDTOToMovie;

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(MovieDTO movieDTO) {
        movieRepository.save(movieDTOToMovie.mapper(movieDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }
}
