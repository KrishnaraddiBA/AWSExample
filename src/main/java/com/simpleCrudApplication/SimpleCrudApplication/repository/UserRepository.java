package com.simpleCrudApplication.SimpleCrudApplication.repository;

import com.simpleCrudApplication.SimpleCrudApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
