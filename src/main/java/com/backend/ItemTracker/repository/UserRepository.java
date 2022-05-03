package com.backend.ItemTracker.repository;

import com.backend.ItemTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
