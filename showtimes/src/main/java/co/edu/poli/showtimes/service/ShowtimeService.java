package co.edu.poli.showtimes.service;

import co.edu.poli.showtimes.persistence.entity.Showtime;
import co.edu.poli.showtimes.service.dto.ShowtimeDTO;

import java.util.List;

public interface ShowtimeService {

    List<Showtime> findAll();
    void save(ShowtimeDTO showtimeDTO);
    Showtime findById(Long id);
    void update(Showtime showtime,ShowtimeDTO showtimeDTO);
}
