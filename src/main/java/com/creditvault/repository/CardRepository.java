package com.creditvault.repository;

import com.creditvault.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    // Método para buscar cartão pelo número
    Optional<Card> findByCardNumber(String cardNumber);

}
