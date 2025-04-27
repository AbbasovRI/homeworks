package jpademo;

import jakarta.annotation.PostConstruct;
import jpademo.model.Orders;
import jpademo.model.Users;
import jpademo.service.OrdersService;
import jpademo.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class Main {

    private final UsersService usersService;
    private final OrdersService ordersService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    @Transactional  // вылетала ошибка из-за ленивой загрузкой
    public void init() {
        Users user = new Users();
        user.setFio("Иван Иванов");
        usersService.saveUser(user);

        Orders order = new Orders();
        order.setCustomer(user);
        order.setOrderDate(new Date());
        order.setTotalOrders(5L);
        order.setDiscount(10.0);
        ordersService.saveOrder(order);

        Users savedUser = usersService.getUser(user.getId());
        log.info("Создан пользователь: ID={}, FIO={}", savedUser.getId(), savedUser.getFio());

        Orders savedOrder = ordersService.getOrder(order.getId());
        log.info("Создан заказ: ID={}, Дата={}", savedOrder.getId(), savedOrder.getOrderDate());
    }
}