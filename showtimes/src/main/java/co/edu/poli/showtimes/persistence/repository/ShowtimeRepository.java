package co.edu.poli.showtimes.persistence.repository;

import co.edu.poli.showtimes.persistence.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {

}
