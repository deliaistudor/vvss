package pizzashop.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PaymentRepositoryTest {

    @Spy
    private PaymentRepository repo;

    @BeforeEach
    void beforeEach(){
        repo = new PaymentRepository();
    }
    @Test
    void clear(){
        repo.clear();
        assertEquals(0, repo.getAll().size());
    }

    @Test
    void add(){
        int size = repo.getAll().size();
        repo.add(new Payment(4, PaymentType.Card, 12.89));
        assertEquals(size + 1, repo.getAll().size());
    }
}