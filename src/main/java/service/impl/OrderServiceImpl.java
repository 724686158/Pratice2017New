package service.impl;

import dao.OrderDao;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderService;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order load(Integer id) {
        return orderDao.load(id);
    }

    @Override
    public Order get(Integer id) {
        return orderDao.get(id);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public void persist(Order entity) {
        orderDao.persist(entity);
    }

    @Override
    public Integer save(Order entity) {
        return orderDao.save(entity);
    }

    @Override
    public void saveOrUpdate(Order entity) {
        orderDao.saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        orderDao.delete(id);
    }

    @Override
    public void flush() {
        orderDao.flush();
    }
}
