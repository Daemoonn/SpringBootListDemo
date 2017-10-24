package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserDao extends CrudRepository<User, Integer> {
    List<User> findAll();
}
