package co.edu.poli.users.service;

import co.edu.poli.users.persistence.entity.User;
import co.edu.poli.users.service.dto.UserDTO;

import java.util.List;
public interface UserService {

    List<User> findAll();
    void save(UserDTO userDTO);
    void delete(User user);
    User findById(Long id);
}
