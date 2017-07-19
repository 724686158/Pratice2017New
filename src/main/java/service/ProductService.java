package service;

import model.Product;

import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 */
public interface ProductService {
    Product load(Integer id);

    Product get(Integer id);

    List<Product> findAll();

    void persist(Product entity);

    Integer save(Product entity);

    void saveOrUpdate(Product entity);

    void delete(Integer id);

    void flush();
}
