package com.grofers.luckydrawservice.repos;

import com.grofers.luckydrawservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);
}
