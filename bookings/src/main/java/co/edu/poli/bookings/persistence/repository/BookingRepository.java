package co.edu.poli.bookings.persistence.repository;

import co.edu.poli.bookings.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Booking findByUserId(Long userId);
}
