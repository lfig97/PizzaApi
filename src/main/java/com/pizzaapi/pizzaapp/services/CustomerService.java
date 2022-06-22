package com.pizzaapi.pizzaapp.services;

import com.pizzaapi.pizzaapp.model.Customer;
import com.pizzaapi.pizzaapp.model.PizzaOrder;
import com.pizzaapi.pizzaapp.repo.CustomerRepository;
import com.pizzaapi.pizzaapp.repo.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    PizzaOrderService pizzaOrderService;

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public Customer findCustomerById(Long id) {
        Customer customer = null;
        for(Customer c:getAllCustomers()){
            if(c.getId().equals(id)){
                customer = c;
            }
        }
        return customer;
    }

    public Customer updateCustomer(Long id, Customer customer) {
        for(Customer c:getAllCustomers()){
            if(c.getId().equals(id)){
                customerRepository.save(customer);
            }
        }
        return customer;
    }

    public void deleteCustomer(Long id) {
        for(Customer customer:getAllCustomers()){
            if(customer.getId().equals(id)){
                customerRepository.deleteById(id);
            }
        }
    }
}


