package pizzashop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceTestMock {

    @Mock
    private MenuRepository repoMenu;

    @Mock
    private PaymentRepository repoPayment;

    @InjectMocks
    private PizzaService service;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addPayment_Valid() throws Exception {
        int table = 1;
        PaymentType type = PaymentType.Cash;
        double amount = 10.5;
        Payment p = new Payment(table, type, amount);
        Mockito.when(repoPayment.getAll()).thenReturn(Arrays.asList(p));
        Mockito.doNothing().when(repoPayment).add(p);
        service.addPayment(table, type, amount);
    }

    @Test()
    public void addPayment_Invalid() throws Exception {
        int table = 100;
        PaymentType type = PaymentType.Card;
        double amount = 30.5;
        Payment p = new Payment(table, type, amount);
        Mockito.doThrow(RuntimeException.class).when(repoPayment).add(p);
        Assertions.assertThrows(Exception.class, ()->service.addPayment(table, type, amount));

    }

}