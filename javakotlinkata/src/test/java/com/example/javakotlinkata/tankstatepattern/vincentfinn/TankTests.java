package com.example.javakotlinkata.tankstatepattern.vincentfinn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TankTests {
    private static final int NORMAL_DAMAGE = 10;
    private static final int SIEGE_DAMAGE = 20;

    private MockMovementSystem mockMovementSystem;
    private MockHealthSystem mockHealthSystem;
    private Tank tank;

    @BeforeEach
    void setup() {
        mockHealthSystem = new MockHealthSystem();
        mockMovementSystem = new MockMovementSystem();
        tank = new Tank(NORMAL_DAMAGE, SIEGE_DAMAGE, mockMovementSystem);
    }

    @Nested
    class GivenTankMode {
        @Test
        void should_deal_10_damage() {
            tank.attack(mockHealthSystem);

            assertThat(mockHealthSystem.damageTaken).isEqualTo(NORMAL_DAMAGE);
        }

        @Test
        void should_move_tank_to_coordinates() {
            tank.move(7, 11);

            assertThat(mockMovementSystem.objectThatMoved).isEqualTo(tank);
            assertThat(mockMovementSystem.coordinatesMovedTo).isEqualTo(new Coordinate(7, 11));
        }
    }

    @Nested
    class GivenSiegeMode {

        @BeforeEach
        void setup() {
            tank.setState(TankState.SIEGE_MODE);
        }

        @Test
        void should_switch_to_siege_mode() {
            assertThat(tank.getState()).isEqualTo(TankState.SIEGE_MODE);
        }

        @Test
        void should_deal_20_damage_in_siege_mode() {
            tank.attack(mockHealthSystem);

            assertThat(mockHealthSystem.damageTaken).isEqualTo(SIEGE_DAMAGE);
        }
    }

    static class MockHealthSystem implements HealthSystem {
        private int damageTaken = 0;

        @Override
        public void dealDamage(int damageDealt) {
            this.damageTaken = damageDealt;
        }
    }

    static class MockMovementSystem implements MovementSystem {
        private Coordinate coordinatesMovedTo = null;
        private Object objectThatMoved = null;

        @Override
        public void moveTo(Object objectToMove, Coordinate moveToCoordinate) {
            this.objectThatMoved = objectToMove;
            this.coordinatesMovedTo = moveToCoordinate;
        }
    }
}
