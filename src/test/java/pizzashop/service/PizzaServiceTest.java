package pizzashop.service;

import org.junit.jupiter.api.*;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PizzaServiceTest {
    private MenuRepository menuRepo;
    private PaymentRepository paymentRepo;
    private PizzaService pizzaService;

    @Test
    @Order(1)
    @DisplayName("addPayment_ECPValid1")
    void addPayment_ECPValid1() {
        int table = 1;
        PaymentType type = PaymentType.Cash;
        double amount = 10.5;
        Assertions.assertDoesNotThrow(() -> pizzaService.addPayment(table, type, amount));
    }
    @Test
    void addPayment_ECPValid2() {
        int table = 2;
        PaymentType type = PaymentType.Card;
        double amount = 30.75;
        Assertions.assertDoesNotThrow(() -> pizzaService.addPayment(table, type, amount));
    }
    @Test
    @Tag("addPayment_ECPInvalid1")
    void addPayment_ECPInvalid1() {
        int table = 100;
        PaymentType type = PaymentType.Card;
        double amount = 30.5;
        Assertions.assertThrows(Exception.class, ()->pizzaService.addPayment(table, type, amount));
    }
    @Test
    @Timeout(10)
    void addPayment_ECPInvalid2() {
        int table = 1;
        PaymentType type = PaymentType.Card;
        double amount = -12.6;
        Assertions.assertThrows(Exception.class, ()->pizzaService.addPayment(table, type, amount));
    }
    @Test
    void addPayment_BVAValid1() {
        int table = 1;
        PaymentType type = PaymentType.Card;
        double amount = 0.0;
        Assertions.assertDoesNotThrow(()->pizzaService.addPayment(table, type, amount));
    }
    @Test
    void addPayment_BVAValid2() {
        int table = 8;
        PaymentType type = PaymentType.Card;
        double amount = 0.0;
        Assertions.assertDoesNotThrow(()->pizzaService.addPayment(table, type, amount));
    }
    @Test
    void addPayment_BVAInvalid1() {
        int table = 1;
        PaymentType type = PaymentType.Card;
        double amount = -0.1;
        Assertions.assertThrows(Exception.class, ()->pizzaService.addPayment(table, type, amount));
    }
    @Test
    void addPayment_BVAInvalid2() {
        int table = 9;
        PaymentType type = PaymentType.Card;
        double amount = 0.0;
        Assertions.assertThrows(Exception.class, ()->pizzaService.addPayment(table, type, amount));
    }

    @BeforeEach
    void setUp() {
        menuRepo = new MenuRepository();
        paymentRepo = new PaymentRepository();
        pizzaService = new PizzaService(menuRepo,paymentRepo);

    }

}