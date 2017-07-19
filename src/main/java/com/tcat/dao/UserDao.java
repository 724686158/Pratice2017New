package com.tcat.dao;

import com.tcat.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by mengzicheng on 2017/7/17.
 */@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    public User findByEmail(String email);
}
