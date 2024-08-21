package com.acme.core.rules;

import java.time.LocalDateTime;
import java.time.Month;

public class ChristmasPromotionRule implements BasketRule {
    @Override
    public boolean matches(Basket basket) {
        return Month.DECEMBER == LocalDateTime.now().getMonth() &&
                Month.DECEMBER == basket.getCreated().getMonth() &&
                20 < basket.getCreated().getDayOfMonth();
    }

    @Override
    public void apply(Basket basket) {
        System.out.println("Applying " + this.getClass().getSimpleName() + " promotion -10.00");
        basket.addItem(new Item("Promo - Santa Hat", 0.00));
        basket.decreaseTotal(10.00);
    }
}
