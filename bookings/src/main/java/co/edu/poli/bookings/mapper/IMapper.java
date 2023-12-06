package co.edu.poli.bookings.mapper;

public interface IMapper<I,O>{

    public O mapper(I in);
}
