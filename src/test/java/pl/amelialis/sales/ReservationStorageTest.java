package pl.amelialis.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
public class ReservationStorageTest {
    @Autowired
    ReservationRepository reservationRepository;
    @Test
    void insert() {
       Reservation r = new Reservation(
               UUID.randomUUID().toString(),
               BigDecimal.TEN,
               "payment");
       reservationRepository.save(r);
    }

    @Test
    void select() {
        String id = UUID.randomUUID().toString();
        Reservation r = new Reservation(
                id,
                BigDecimal.TEN,
                "payment");
        reservationRepository.save(r);

        Reservation loaded = reservationRepository.findById(id)
                .get();
    }
}
