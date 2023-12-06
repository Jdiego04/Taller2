package co.edu.poli.users.mapper;

public interface IMapper<I,O>{

    public O mapper(I in);
}
