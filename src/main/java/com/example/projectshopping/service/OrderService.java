
package com.example.projectshopping.service;

        import com.example.projectshopping.model.entities.order.Order;

        import com.example.projectshopping.model.repository.OrderRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;


        import java.time.LocalDate;
        import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrdersByCustomerId(Long customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }



    public List<Order> findAllOrdersByDateCreatedBetween(LocalDate fromDate, LocalDate toDate) {
        return orderRepository.findAllByDateCreatedBetween(fromDate, toDate);
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }


}