package repository;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImpRepository implements Repository{
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iphone 13 pro max", "Apple", "1024"));
        products.put(2, new Product(2, "iPhone 13 pro", "Apple", "799"));
        products.put(3, new Product(3, "iPhone 13", "Apple", "699"));
        products.put(4, new Product(4, "iPHone13 mini", "Apple", "599"));
        products.put(5, new Product(5, "Galaxy Note 20 Ultra", "Samsung", "1024"));
        products.put(6, new Product(6, "Galaxy S20", "Samsung", "899"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> product = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
//            System.out.println(entry.getKey() + "/" + entry.getValue());
            if (entry.getValue().getProductName().contains(name)){
                product.add(entry.getValue()); }
        }
        return product;
    }



    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
