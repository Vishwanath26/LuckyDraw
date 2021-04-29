package com.grofers.luckydrawservice.repos;

import com.grofers.luckydrawservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long userId);
}
