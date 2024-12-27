package com.creditvault.repository;

import com.creditvault.model.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @Test
    public void testSaveCreditCard() {
        Card card = new Card();
        card.setCardNumber("1234-5678-9876-5432");
        card.setCardHolderName("John Doe");
        card.setExpirationDate(LocalDate.of(2028, 12, 31));
        card.setCvv("123");
        card.setCreditLimit(new BigDecimal("5000.00"));
        card.setCurrentBalance(new BigDecimal("0.00"));

        Card savedCard = cardRepository.save(card);

        System.out.println("Card ID: " + savedCard.getId());  // Log do ID do cartão

        assertNotNull(savedCard.getId());

        Optional<Card> retrievedCard = cardRepository.findById(savedCard.getId());

        assertTrue(retrievedCard.isPresent(), "Cartão não encontrado após a inserção!");

        // Verificando os dados recuperados
        Card cardFromDb = retrievedCard.get();
        assertEquals("1234-5678-9876-5432", cardFromDb.getCardNumber());
        assertEquals("John Doe", cardFromDb.getCardHolderName());
        assertEquals(new BigDecimal("5000.00"), cardFromDb.getCreditLimit());
        assertEquals(new BigDecimal("0.00"), cardFromDb.getCurrentBalance());

        System.out.println("Retrieved Card: " + cardFromDb.getCardHolderName());
    }
}
