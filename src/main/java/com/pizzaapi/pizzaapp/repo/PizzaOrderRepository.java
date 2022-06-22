package com.pizzaapi.pizzaapp.repo;

import com.pizzaapi.pizzaapp.model.PizzaOrder;
import org.springframework.data.repository.CrudRepository;

public interface PizzaOrderRepository extends CrudRepository<PizzaOrder,Long> {
}
