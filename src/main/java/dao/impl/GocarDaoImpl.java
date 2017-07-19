package dao.impl;

import dao.GocarDao;
import model.Gocar;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */
@Repository("GocarDao")
public class GocarDaoImpl implements GocarDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public Gocar load(Integer id) {
        return (Gocar) this.getCurrentSession().load(Gocar.class, id);
    }

    @Override
    public Gocar get(Integer id) {
        return (Gocar)this.getCurrentSession().get(Gocar.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Gocar> findAll() {
        List<Gocar> gocars = this.getCurrentSession().createQuery("from Gocar").setCacheable(true).list();
        return gocars;
    }

    @Override
    public void persist(Gocar entity) {
        this.getCurrentSession().persist(entity);
    }

    @Override
    public Integer save(Gocar entity) {
        return (Integer) this.getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(Gocar entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        Gocar entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }

    @Override
    public void flush() {
        this.getCurrentSession().flush();
    }
}
