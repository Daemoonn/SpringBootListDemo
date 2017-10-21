package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserDao extends CrudRepository<User, Integer> {
    List<User> findAll();
}
