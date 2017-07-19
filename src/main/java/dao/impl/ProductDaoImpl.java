package dao.impl;

import dao.ProductDao;
import model.Gocar;
import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */
@Repository("ProductDao")
public class ProductDaoImpl implements ProductDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Product load(Integer id) {
        return (Product) this.getCurrentSession().load(Product.class, id);
    }

    @Override
    public Product get(Integer id) {
        return (Product) this.getCurrentSession().get(Product.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> findAll() {
        List<Product> products = this.getCurrentSession().createQuery("from Product").setCacheable(true).list();
        return products;
    }

    @Override
    public void persist(Product entity) {
        this.getCurrentSession().persist(entity);
    }

    @Override
    public Integer save(Product entity) {
        return (Integer) this.getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Product entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        Product entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    @Override
    public void flush() {
        this.getCurrentSession().flush();
    }
}
