package com.pizzaapi.pizzaapp.controller;


import com.pizzaapi.pizzaapp.PizzaAppApplication;
import com.pizzaapi.pizzaapp.model.Customer;
import com.pizzaapi.pizzaapp.model.PizzaOrder;
import com.pizzaapi.pizzaapp.repo.PizzaOrderRepository;
import com.pizzaapi.pizzaapp.services.CustomerService;
import com.pizzaapi.pizzaapp.services.PizzaOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class PizzaOrderController {
    private static final Logger logger = LoggerFactory.getLogger(PizzaAppApplication.class);

    @Autowired
    private PizzaOrderService pizzaOrderService;
    private PizzaOrderRepository pizzaOrderRepository;
    private CustomerService customerService;

    @PostMapping("/orders")
    public ResponseEntity<?> addOrder(@RequestBody PizzaOrder pizzaOrder){
        logger.info("added order");
        pizzaOrderService.saveOrder(pizzaOrder);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<PizzaOrder>> getAllOrders(){
        logger.info("retrieved all orders");
        return new ResponseEntity<>(pizzaOrderService.getAllOrders(),HttpStatus.OK);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<PizzaOrder>> getAllOrdersByCrust(@RequestParam String crust){
        logger.info("retrieved all orders with "+crust+" crust");
        return new ResponseEntity<>(pizzaOrderService.getAllOrdersByCrust(crust),HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<PizzaOrder> findOrderById(@PathVariable Long id){
        logger.info("retrieved order with id: "+ id);
        return new ResponseEntity<>(pizzaOrderService.findOrderById(id),HttpStatus.OK);
    }

    @GetMapping("/customers/orders/{id}")
    public ResponseEntity<Customer> findCustomerByOrderId(@PathVariable Long id){
        logger.info("retrieved customer with order id: "+ id);
        return new ResponseEntity<>(pizzaOrderService.findCustomerByOrderId(id),HttpStatus.OK);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<PizzaOrder> updateOrder(@PathVariable Long id,@RequestBody PizzaOrder order){
        logger.info("updated order: "+ id);
        return new ResponseEntity<>(pizzaOrderService.updateOrder(id,order),HttpStatus.OK);
    }


    @RequestMapping(value="/orders/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        logger.info("deleted order:"+ id);
        pizzaOrderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllOrders/{id}")
    public ResponseEntity<List<PizzaOrder>> getAllOrdersByCustomerId(@PathVariable Long id){
        logger.info("retrieved all orders with customer Id "+id);
        return new ResponseEntity<>(pizzaOrderService.getAllOrdersByCustomerId(id),HttpStatus.OK);
    }
}
