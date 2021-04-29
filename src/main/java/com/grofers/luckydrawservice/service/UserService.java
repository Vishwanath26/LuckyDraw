package com.grofers.luckydrawservice.service;

import com.grofers.luckydrawservice.models.User;
import com.grofers.luckydrawservice.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserService {

    /**
     * Service for Events handling - creating, finding users, finding user by Id
     */

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long userId) {
        return Optional.ofNullable(userRepository.findByUserId(userId));
    }
}
