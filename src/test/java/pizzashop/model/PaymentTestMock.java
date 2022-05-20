package pizzashop.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;
import pizzashop.service.PizzaService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTestMock {

    private  Payment p;
    private Integer tableNumber;
    private PaymentType type;
    private Double amount;

    @BeforeEach
    public void setUp(){
        Integer table = 1;
        PaymentType type = PaymentType.Cash;
        Double amount = 10.5;
        p = new Payment(table, type, amount);
    }
    @Test
    void setTableNumber(){
        p.setTableNumber(3);
        assertEquals(3, p.getTableNumber());
    }
    @Test
    void setPaymentType(){
        p.setType(PaymentType.Card);
        assertEquals(PaymentType.Card, p.getType());
    }

}