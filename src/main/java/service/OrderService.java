package service;

import model.Order;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */
public interface OrderService {
    Order load(Integer id);

    Order get(Integer id);

    List<Order> findAll();

    void persist(Order entity);

    Integer save(Order entity);

    void saveOrUpdate(Order entity);

    void delete(Integer id);

    void flush();
}
