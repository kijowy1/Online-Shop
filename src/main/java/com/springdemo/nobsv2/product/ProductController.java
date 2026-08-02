package com.springdemo.nobsv2.product;

import com.springdemo.nobsv2.exceptions.ProductNotFoundException;
import com.springdemo.nobsv2.product.model.ErrorResponse;
import com.springdemo.nobsv2.product.model.Product;
import com.springdemo.nobsv2.product.model.ProductDTO;
import com.springdemo.nobsv2.product.model.UpdateProductCommand;
import com.springdemo.nobsv2.product.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//To sa endpointy
//tutaj pokazuje link pod jakim mozna cos uzyskac strona.com/product
//Tutaj jest wykonywanie odpowiednio create delete etc
//tutaj tez jest dependecy injection
@RestController
public class ProductController {

    private final CreateProductService createProductService;

    private final GetAllProductService getAllProductService;

    private final DeleteProductService deleteProductService;

    private final UpdateProductService updateProductService;

    private final GetProductService getProductService;

    private final SearchProductService searchProductService;

    public ProductController(CreateProductService createProductService,
                             GetAllProductService getAllProductService,
                             UpdateProductService updateProductService,
                             DeleteProductService deleteProductService,
                             GetProductService getProductService, SearchProductService searchProductService) {
        this.createProductService = createProductService;
        this.getAllProductService = getAllProductService;
        this.updateProductService = updateProductService;
        this.deleteProductService = deleteProductService;
        this.getProductService = getProductService;
        this.searchProductService = searchProductService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product){
        return createProductService.execute(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        return getAllProductService.execute(null);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        return getProductService.execute(id);
    }
    @GetMapping("product/search")
    public ResponseEntity<List<ProductDTO>> searchProductByName(@RequestParam String name){
        return searchProductService.execute(name);
    }
    //tutaj jest update product, wykonujemy updateProductService z services w linku ponizej
    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product){
        return updateProductService.execute(new UpdateProductCommand(product, id));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        return  deleteProductService.execute(id);
    }
}
