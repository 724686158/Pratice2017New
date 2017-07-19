package service;
import model.User;

import java.util.List;
/**
 * Created by Administrator on 2017/7/11.
 */
public interface UserService {
    User load(Integer id);

    User get(Integer id);

    List<User> findAll();

    void persist(User entity);

    Integer save(User entity);

    void saveOrUpdate(User entity);

    void delete(Integer id);

    void flush();
}
