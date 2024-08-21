package com.acme.core.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class PromotionEngine {
    private List<BasketRule> promotionRules;

    public PromotionEngine() {
        promotionRules = new ArrayList<BasketRule>();
    }

    public void addRule(BasketRule rule) {
        promotionRules.add(rule);
    }

    public void process(Basket basket) {
        System.out.println("=== BEFORE Promotions ===");
        System.out.println(basket);

        System.out.println("\nApplying promotions");
        promotionRules.stream()
                .filter(rule -> rule.matches(basket))
                .forEach(rule -> rule.apply(basket));
        System.out.println("Promotions applies\n");

        System.out.println("=== AFTER Promotions ===");
        System.out.println(basket);
    }
}
