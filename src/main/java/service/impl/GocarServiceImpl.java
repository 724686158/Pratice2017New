package service.impl;

import dao.GocarDao;
import model.Gocar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.GocarService;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */
@Service("gocarService")
public class GocarServiceImpl implements GocarService{

    @Autowired
    private GocarDao gocarDao;

    @Override
    public Gocar load(Integer id) {
        return gocarDao.load(id);
    }

    @Override
    public Gocar get(Integer id) {
        return gocarDao.get(id);
    }

    @Override
    public List<Gocar> findAll() {
        return gocarDao.findAll();
    }

    @Override
    public void persist(Gocar entity) {
        gocarDao.persist(entity);
    }

    @Override
    public Integer save(Gocar entity) {
        return gocarDao.save(entity);
    }

    @Override
    public void saveOrUpdate(Gocar entity) {
        gocarDao.saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        gocarDao.delete(id);
    }

    @Override
    public void flush() {
        gocarDao.flush();
    }
}
