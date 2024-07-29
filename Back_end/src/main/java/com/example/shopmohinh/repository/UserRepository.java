package com.example.shopmohinh.repository;

import com.example.shopmohinh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByCode(String code);
    Optional<User> findByUsername(String username);
}
