package co.edu.poli.showtimes.mapper;

import co.edu.poli.showtimes.persistence.entity.Showtime;
import co.edu.poli.showtimes.service.dto.ShowtimeDTO;
import org.springframework.stereotype.Component;

@Component
public class ShowtimeDTOToShowtime implements IMapper<ShowtimeDTO, Showtime>{

    @Override
    public Showtime mapper(ShowtimeDTO showtimeDTO){
        Showtime showtime = new Showtime();

        showtime.setDate(showtimeDTO.getDate());
        showtime.setMovieIds(showtime.getMovieIds());

        return showtime;
    }
}
