package co.edu.poli.bookings.service;

import co.edu.poli.bookings.persistence.entity.Booking;
import co.edu.poli.bookings.service.dto.BookingDTO;

import java.util.List;
public interface BookingService {

    List<Booking> findAll();
    void save(BookingDTO bookingDTO);
    void delete(Booking booking);
    Booking findById(Long id);

    Booking findByUserId(Long id);
}
