package com.njt.upkg.repository;

import com.njt.upkg.domain.Buyer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BuyerRepositoryTest {

    @Autowired
    private BuyerRepository buyerRepository;

    @Test
    public void testSaveBuyer() {
        Buyer buyer = new Buyer();
        buyer.setName("John Doe");
        buyer.setEmail("john@doe.com");
        buyer.setNumber("+381111222");

        Buyer savedBuyer = buyerRepository.save(buyer);

        Buyer retrievedBuyer = buyerRepository.findById(savedBuyer.getId()).orElse(null);

        assertNotNull(retrievedBuyer);
        assertEquals(buyer.getName(), retrievedBuyer.getName());
        assertEquals(buyer.getEmail(), retrievedBuyer.getEmail());
        assertEquals(buyer.getNumber(), retrievedBuyer.getNumber());
    }

    @Test
    public void testFindById() {
        Buyer buyer = new Buyer();
        buyer.setName("John Doe");
        buyer.setEmail("john@doe.com");
        buyer.setNumber("+381111222");


        Buyer savedBuyer = buyerRepository.save(buyer);

        Optional<Buyer> optionalBuyer = buyerRepository.findById(savedBuyer.getId());

        assertTrue(optionalBuyer.isPresent());

        Buyer retrievedBuyer = optionalBuyer.get();

        assertEquals(buyer.getName(), retrievedBuyer.getName());
        assertEquals(buyer.getEmail(), retrievedBuyer.getEmail());
        assertEquals(buyer.getNumber(), retrievedBuyer.getNumber());
    }
}
