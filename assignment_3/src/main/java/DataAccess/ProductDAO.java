package DataAccess;

import Models.Product;

import java.util.List;

public class ProductDAO extends AbstractDAO<Product> {

    public List<Product> findAll() {
        List<Product> products = super.findAll();

        return products;
    }

    public Product findById(int id) {
        Product product = super.findById(id);

        return product;
    }

    public Product insert(Product product) {
        Product insertedProduct = super.insert(product);

        return insertedProduct;
    }

    public Product update(int id, Product product) {
        Product updatedProduct = super.update(id, product);

        return updatedProduct;
    }

    public boolean delete(int id) {
        boolean deletedProduct = super.delete(id);

        return deletedProduct;
    }
}
