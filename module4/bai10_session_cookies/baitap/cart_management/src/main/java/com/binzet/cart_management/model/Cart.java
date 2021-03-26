package com.binzet.cart_management.model;

import com.binzet.cart_management.service.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    @Autowired
    ProductService productService;
    private Map<Product,Integer> map;

    public Cart(){
        map = new HashMap<>();
    }

    public void add(Product product,int number){
        if (map.containsKey(product)){
            map.replace(product,map.get(product),map.get(product)+number);
        } else {
            map.put(product,number);
        }
    }

    public void delete(Product product){
        map.remove(product);
    }

    public void subtract(Product product,int number){
        if (number > map.get(product)){
            map.remove(product);
        } else {
            map.replace(product,map.get(product),map.get(product)-number);
        }
    }

    public Map<Product,Integer> getMap(){
        return map;
    }
}
