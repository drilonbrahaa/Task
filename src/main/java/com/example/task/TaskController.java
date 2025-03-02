package com.example.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.models.Order;
import com.example.task.models.Product;

@RestController
@RequestMapping("/api")
public class TaskController {
    
    @Autowired
    private Algorithm algorithm;

    @PostMapping("/generateInvoices")
    public Order generateInvoices(@RequestBody List<Product> products) {
        return algorithm.generateInvoices(products);
    }

}
