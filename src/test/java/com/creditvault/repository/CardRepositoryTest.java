package com.creditvault.repository;

import com.creditvault.model.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CardRepositoryTest {

    @Autowired
    private CardRepository creditCardRepository;

    @Test
    public void testSaveCreditCard() {
        Card card = new Card();
        card.setCardNumber("1234-5678-9876-5432");
        card.setCardHolderName("John Doe");
        card.setExpirationDate(LocalDate.of(2028, 12, 31));
        card.setCvv("123");
        card.setCreditLimit(5000.00);
        card.setCurrentBalance(0.00);

        // Use a instância do repositório para chamar save()
        Card savedCard = creditCardRepository.save(card);

        // Verifique se o ID foi gerado, indicando que o cartão foi salvo no banco de dados
        assertNotNull(savedCard.getId());
    }
}