package dao.impl;

import dao.OrderDao;
import model.Gocar;
import model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */
@Repository("OrderDao")
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Order load(Integer id) {
        return (Order) this.getCurrentSession().load(Order.class, id);
    }

    @Override
    public Order get(Integer id) {
        return (Order)this.getCurrentSession().get(Order.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> findAll() {
        List<Order> orders = this.getCurrentSession().createQuery("from Order").setCacheable(true).list();
        return orders;
    }

    @Override
    public void persist(Order entity) {
        this.getCurrentSession().persist(entity);
    }

    @Override
    public Integer save(Order entity) {
        return (Integer) this.getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Order entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        Order entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    @Override
    public void flush() {
        this.getCurrentSession().flush();
    }
}
