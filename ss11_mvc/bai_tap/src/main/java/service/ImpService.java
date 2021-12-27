package service;

import model.Product;
import repository.ImpRepository;
import repository.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImpService implements Service {

    Repository repo = new ImpRepository();
//        private static Map<Integer, Product> products;
//
//        static {
//            products = new HashMap<>();
//            products.put(1, new Product(1, "iphone 13 pro max", "Apple", "1024"));
//            products.put(2, new Product(2, "iPhone 13 pro", "Apple", "799"));
//            products.put(3, new Product(3, "iPhone 13", "Apple", "699"));
//            products.put(4, new Product(4, "iPHone13 mini", "Apple", "599"));
//            products.put(5, new Product(5, "Galaxy Note 20 Ultra", "Samsung", "1024"));
//            products.put(6, new Product(6, "Galaxy S20", "Samsung", "899"));
//        }

        @Override
        public List<Product> findAll() {
            return repo.findAll();
        }

        @Override
        public void save(Product product) {
//            products.put(product.getId(), product);
            repo.save(product);
        }

        @Override
        public Product findById(int id) {
//            return products.get(id);
            return repo.findById(id);
        }

        @Override
        public void update(int id, Product product) {
//            products.put(id, product);
            repo.update(id, product);
        }

        @Override
        public void remove(int id) {
//            products.remove(id);
            repo.remove(id);
        }
}
