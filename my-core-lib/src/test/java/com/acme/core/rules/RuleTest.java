package com.acme.core.rules;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

public class RuleTest {
    @Test
    public void simpleRuleTest() {
        BasketRule rule = new ChristmasPromotionRule();
        Basket basket = new Basket();
        if(rule.matches(basket)) {
            rule.apply(basket);
        }

        Assert.notEmpty(basket.items,"聖誕節會有東西");
    }

    @Test
    public void engineTest() {
        PromotionEngine engine = new PromotionEngine();
        engine.addRule(new ChristmasPromotionRule());

        Basket basket = new Basket();
        engine.process(basket);

        Assert.notEmpty(basket.items,"聖誕節會有東西");
    }
}
