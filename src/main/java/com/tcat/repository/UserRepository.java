package com.tcat.repository;

/**
 * Created by mengzicheng on 2017/7/17.
 */

import com.tcat.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByid(int id);
}