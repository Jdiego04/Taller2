package co.edu.poli.movies.mapper;

public interface IMapper<I, O> {

    public O mapper(I in);
}
