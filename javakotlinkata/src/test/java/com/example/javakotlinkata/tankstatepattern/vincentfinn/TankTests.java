package com.example.javakotlinkata.tankstatepattern.vincentfinn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TankTests {
    private static final int NORMAL_DAMAGE = 10;

    private MockHealthSystem mockHealthSystem;

    @BeforeEach
    void setup() {
        mockHealthSystem = new MockHealthSystem();
    }

    @Test
    void should_deal_10_damage() {
        var tank = new Tank(NORMAL_DAMAGE);

        tank.attack(mockHealthSystem);

        assertThat(mockHealthSystem.damageTaken).isEqualTo(NORMAL_DAMAGE);
    }

    class MockHealthSystem implements HealthSystem {
        private int damageTaken = 0;

        public int getDamageTaken() {
            return damageTaken;
        }

        @Override
        public void dealDamage(int damageDealt) {
            this.damageTaken = damageDealt;
        }
    }
}
