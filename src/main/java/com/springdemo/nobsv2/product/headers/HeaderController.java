package com.springdemo.nobsv2.product.headers;

import com.springdemo.nobsv2.product.model.Product;
import com.springdemo.nobsv2.product.model.ProductDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {

    @GetMapping("/header")
    public String getRegionalResponse(@RequestHeader(required = false,defaultValue = "US")String region){
        //normally abstract this out into a service class -> skipping that for simplicity
        if(region.equals("US")) return  "BALD EAGLE FREEDOM";

        if(region.equals("PL")) return "POLSKA GUROM";

        return "Country not supported";
    }
    @GetMapping(value = "/header/product", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Product> getProduct(){
        Product product = new Product();
        product.setId(1);
        product.setName("Super great product");
        product.setDescription("best product u coudl ever see or buy");

        return ResponseEntity.ok(product);
    }

}