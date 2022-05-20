package pizzashop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceWhiteboxTest {
    private MenuRepository menuRepo;
    private PaymentRepository paymentRepo;
    private PizzaService pizzaService;

    @BeforeEach
    void setUp() {
        menuRepo = new MenuRepository();
        paymentRepo = new PaymentRepository();
        pizzaService = new PizzaService(menuRepo,paymentRepo);
        paymentRepo.clear();
    }
    @Test
    void getTotalAmount_test1() {
        PaymentType type = PaymentType.Card;
        Assertions.assertEquals(0, pizzaService.getTotalAmount(type));
    }

    @Test
    void getTotalAmount_test2() {
        paymentRepo.add(new Payment(1, PaymentType.Card, 10));
        paymentRepo.add(new Payment(1, PaymentType.Cash, 10));
        paymentRepo.add(new Payment(1, PaymentType.Card, 10));
        PaymentType type = PaymentType.Card;
        Assertions.assertEquals(20, pizzaService.getTotalAmount(type));
    }

    @Test
    void getTotalAmount_test3() {
        paymentRepo.add(new Payment(1, PaymentType.Card, 10));
        Assertions.assertEquals(0, pizzaService.getTotalAmount(PaymentType.Cash));
    }

    @Test
    void getTotalAmount_test4() {
        paymentRepo.add(new Payment(1, PaymentType.Card, 10));
        paymentRepo.add(new Payment(1, PaymentType.Cash, 10));
        Assertions.assertEquals(10, pizzaService.getTotalAmount(PaymentType.Cash));
    }

    @Test
    void getTotalAmount_test5() {
//        Assertions.assertThrows(Exception.class, ()->pizzaService.getTotalAmount(null));
        Assertions.assertEquals(0, pizzaService.getTotalAmount(null));
    }

}