package jpademo.service;

import jpademo.model.Orders;
import jpademo.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public Orders getOrder(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public List<Orders> getOrdersByDate(Date date) {
        return ordersRepository.findByOrderDate(date);
    }

    @Transactional
    public Orders saveOrder(Orders order) {
        return ordersRepository.save(order);
    }

    @Transactional
    public void deleteAllOrders() {
        ordersRepository.deleteAll();
    }
}
