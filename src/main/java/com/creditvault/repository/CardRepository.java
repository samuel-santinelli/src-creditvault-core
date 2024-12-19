package com.creditvault.repository;

import com.creditvault.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<Card, Long> {
    Card findByCardNumber(String cardNumber);
}
