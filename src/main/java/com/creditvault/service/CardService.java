package com.creditvault.service;

import com.creditvault.model.Card;
import com.creditvault.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    // Método para salvar o cartão
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    // Método para encontrar o cartão pelo ID
    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    // Método para buscar um cartão pelo número
    public Optional<Card> getCardByNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }
}
