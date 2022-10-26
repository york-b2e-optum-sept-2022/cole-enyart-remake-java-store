package net.yorksolutions.remakejavastore;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class ProductService {

    ArrayList<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
    }

    public HashMap getAll() {
        HashMap display = new HashMap();

        display.put("product list", this.products);

        return display;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(UUID id) {

        for (Product product : products) {
            if (product.id.equals(id)) {
                this.products.remove(product);
            }
        }
    }

    public void replaceProduct(UUID id, Product updatedProduct) {
        for (Product p : products) {
            if (p.id.equals(id)) {
                updatedProduct.id = id;
                this.products.set(products.indexOf(p), updatedProduct);
            }
        }
    }

    public HashMap filterProduct(Double price) {

        HashMap filteredDisplay = new HashMap();
        for (Product p : products) {
            if (p.getPrice() > price) {
                filteredDisplay.put(p.id, p);
            }
        }
        return filteredDisplay;
    }
}
