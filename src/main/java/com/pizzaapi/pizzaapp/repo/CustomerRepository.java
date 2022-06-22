package com.pizzaapi.pizzaapp.repo;

import com.pizzaapi.pizzaapp.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
