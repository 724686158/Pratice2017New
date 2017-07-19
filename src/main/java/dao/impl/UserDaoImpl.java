package dao.impl;

/**
 * Created by Administrator on 2017/5/21.
 */
import java.util.List;

import model.User;
import dao.UserDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 创建时间：2015-2-6 下午2:45:14
 *
 * @author andy
 * @version 2.2
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public User load(Integer id) {
        return (User)this.getCurrentSession().load(User.class, id);
    }

    @Override
    public User get(Integer id) {
        return (User)this.getCurrentSession().get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        List<User> acctUsers = this.getCurrentSession().createQuery("from User").setCacheable(true).list();
        return acctUsers;
    }

    @Override
    public void persist(User entity) {
        this.getCurrentSession().persist(entity);

    }

    @Override
    public Integer save(User entity) {
        return (Integer) this.getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(User entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        User entity = this.load(id);
        this.getCurrentSession().delete(entity);
    }
    @Override
    public void flush() {
        this.getCurrentSession().flush();
    }

}
