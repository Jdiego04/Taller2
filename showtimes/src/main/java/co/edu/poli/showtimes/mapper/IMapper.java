package co.edu.poli.showtimes.mapper;

public interface IMapper<I, O> {

    public O mapper(I in);
}
