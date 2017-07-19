package service.impl;

import dao.ProductDao;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProductService;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product load(Integer id) {
        return productDao.load(id);
    }

    @Override
    public Product get(Integer id) {
        return productDao.get(id);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void persist(Product entity) {
        productDao.persist(entity);
    }

    @Override
    public Integer save(Product entity) {
        return productDao.save(entity);
    }

    @Override
    public void saveOrUpdate(Product entity) {
        productDao.saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }

    @Override
    public void flush() {
        productDao.flush();
    }
}
