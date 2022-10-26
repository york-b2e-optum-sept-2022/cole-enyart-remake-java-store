package net.yorksolutions.remakejavastore;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class IndexController {
    ProductService productService;
    public IndexController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/getProducts")
    public HashMap getProducts(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product newProduct){
        this.productService.addProduct(newProduct);
        return newProduct;
    }

    @DeleteMapping("/remove/{id}")
    public void removeProduct(@PathVariable UUID id) {
        this.productService.removeProduct(id);
    }

    @PutMapping("/replace/{id}")
    public void replaceProduct(@PathVariable UUID id, @RequestBody Product product) {
        this.productService.replaceProduct(id, product);
    }

    @GetMapping("/filteredList/{price}")
    public HashMap filterProduct(@PathVariable Double price) {
        return this.productService.filterProduct(price);
    }
}
