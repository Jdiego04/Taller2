package co.edu.poli.movies;

import co.edu.poli.movies.persistence.entity.Movie;
import co.edu.poli.movies.persistence.repository.MovieRepository;
import co.edu.poli.movies.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static reactor.core.publisher.Mono.when;

class MoviesApplicationTests {

    @Mock
    private  MovieService movieService;

    private Movie movie;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        movie = new Movie();

        movie.setId(Long.valueOf(1));
        movie.setTitle("Fast & Furious");
        movie.setDirector(" Rob Cohen");
        movie.setRating(5);

    }

    @Test
    void findAll(){
        Mockito.when(movieService.findAll()).thenReturn(Arrays.asList(movie));
        assertNotNull(movieService.findAll());
        System.out.println("findAll:" +movieService.findAll());
    }

}
