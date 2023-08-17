package ru.em.tt.registration.service;

import org.springframework.stereotype.Service;
import ru.em.tt.registration.entity.User;
import ru.em.tt.registration.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        User savedUser = this.userRepository.save(user);
        return savedUser;
    }
}
