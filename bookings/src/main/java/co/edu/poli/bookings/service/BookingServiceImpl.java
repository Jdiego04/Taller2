package co.edu.poli.bookings.service;

import co.edu.poli.bookings.clientFeign.UserClient;
import co.edu.poli.bookings.mapper.BookingDTOToBooking;
import co.edu.poli.bookings.model.User;
import co.edu.poli.bookings.persistence.entity.Booking;
import co.edu.poli.bookings.persistence.repository.BookingRepository;
import co.edu.poli.bookings.service.dto.BookingDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingDTOToBooking bookingDTOToBooking;

    private final UserClient userClient;

    private CircuitBreakerFactory cbFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(BookingDTO bookingDTO) {
        bookingRepository.save(bookingDTOToBooking.mapper(bookingDTO));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking findByUserId(Long userId) {
        Booking booking = bookingRepository.findByUserId(userId);
        ModelMapper modelMapper = new ModelMapper();

        booking.setUser(findByIDUser(modelMapper, booking.getUserId()));

        return booking;
    }

    public User findByIDUser(ModelMapper modelMapper, Long id){
        return cbFactory.create("findByIDCustomer")
                .run(()->modelMapper.map(userClient.findById(id).getData(),User.class),
                        e-> new User()  );
    }
}
