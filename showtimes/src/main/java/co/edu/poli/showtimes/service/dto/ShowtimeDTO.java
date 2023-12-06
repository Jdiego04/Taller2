package co.edu.poli.showtimes.service.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ShowtimeDTO {

    private Date date;
    private List<Long> movieIds;
}
