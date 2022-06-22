package com.pizzaapi.pizzaapp.controller;

import com.pizzaapi.pizzaapp.PizzaAppApplication;
import com.pizzaapi.pizzaapp.model.Customer;
import com.pizzaapi.pizzaapp.model.PizzaOrder;
import com.pizzaapi.pizzaapp.repo.CustomerRepository;
import com.pizzaapi.pizzaapp.repo.PizzaOrderRepository;
import com.pizzaapi.pizzaapp.services.CustomerService;
import com.pizzaapi.pizzaapp.services.PizzaOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(PizzaAppApplication.class);

    @Autowired
    private CustomerService customerService;
    private CustomerRepository customerRepository;

    @PostMapping("/customers")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        logger.info("added customer");
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        logger.info("retrieved all customers");
        return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id){
        logger.info("retrieved customer with id: "+ id);
        return new ResponseEntity<>(customerService.findCustomerById(id),HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer){
        logger.info("updated customer: "+ id);
        return new ResponseEntity<>(customerService.updateCustomer(id,customer),HttpStatus.OK);
    }

    @RequestMapping(value="/customers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        logger.info("deleted customer:"+ id);
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
