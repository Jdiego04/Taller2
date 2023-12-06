package co.edu.poli.users;

import co.edu.poli.users.persistence.entity.User;
import co.edu.poli.users.persistence.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class UserApplicationTests {

    @Mock
    private  UserRepository userRepository;

    private User user;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        user = new User();

        user.setId(Long.valueOf(1));
        user.setName("Juan");
        user.setLastName("Grisales");

    }

    @Test
    void save(){

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userRepository.save(user);
        System.out.println( "save: "+ savedUser);
        assertNotNull(savedUser);

        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getLastName(), savedUser.getLastName());
    }

    @Test
    void findAll(){
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        assertNotNull(userRepository.findAll());
        System.out.println("findAll:" +userRepository.findAll());
    }
}
