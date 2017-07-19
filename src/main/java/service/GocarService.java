package service;

import model.Gocar;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */
public interface GocarService {
    Gocar load(Integer id);

    Gocar get(Integer id);

    List<Gocar> findAll();

    void persist(Gocar entity);

    Integer save(Gocar entity);

    void saveOrUpdate(Gocar entity);

    void delete(Integer id);

    void flush();
}
