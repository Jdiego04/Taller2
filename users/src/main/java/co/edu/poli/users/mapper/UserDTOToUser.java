package co.edu.poli.users.mapper;

import co.edu.poli.users.persistence.entity.User;
import co.edu.poli.users.service.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDTOToUser implements IMapper<UserDTO, User> {

    @Override
    public User mapper(UserDTO userDTO){
        User user = new User();

        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());

        return user;
    }
}
