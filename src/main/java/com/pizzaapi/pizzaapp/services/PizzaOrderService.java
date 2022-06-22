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

public class PizzaOrderService {
    @Autowired
    PizzaOrderRepository pizzaOrderRepository;

    public void saveOrder(PizzaOrder pizzaOrder) {
        pizzaOrderRepository.save(pizzaOrder);
    }

    public List<PizzaOrder> getAllOrders(){
        List<PizzaOrder> orders = new ArrayList<>();
        pizzaOrderRepository.findAll().forEach(orders::add);
        return orders;
    }

    public List<PizzaOrder> getAllOrdersByCrust(String crust){
        List<PizzaOrder> orders = new ArrayList<>();
        for(PizzaOrder order:getAllOrders()){
            if(order.getCrust().equals(crust)){
                orders.add(order);
            }
        }
        return orders;
    }

    public PizzaOrder findOrderById(Long id) {
        PizzaOrder pizzaOrder = null;
        for(PizzaOrder order:getAllOrders()){
            if(order.getId().equals(id)){
                pizzaOrder = order;
            }
        }
        return pizzaOrder;
    }

    public Customer findCustomerByOrderId(Long id) {
        Customer customer = null;
        for(PizzaOrder order:getAllOrders()){
            if(order.getId().equals(id)){
                customer = order.getCustomer();
            }
        }
        return customer;
    }

    public List<PizzaOrder> getAllOrdersByCustomerId(Long id) {
        List<PizzaOrder> orders = new ArrayList<>();
        for(PizzaOrder order:getAllOrders()){
            if(order.getCustomer().getId().equals(id)){
                orders.add(order);
            }
        }
        return orders;
    }

    public PizzaOrder updateOrder(Long id, PizzaOrder order) {
        for(PizzaOrder o:getAllOrders()){
            if(o.getId().equals(id)){
                pizzaOrderRepository.save(order);
            }
        }
        return order;
    }

    public void deleteOrder(Long id) {
        for(PizzaOrder order:getAllOrders()){
            if(order.getId().equals(id)){
                pizzaOrderRepository.deleteById(id);
            }
        }
    }


}
