package com.example.javakotlinkata.tankstatepattern.vincentfinn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TankTests {
    private static final int NORMAL_DAMAGE = 10;

    private MockMovementSystem mockMovementSystem;
    private MockHealthSystem mockHealthSystem;
    private Tank tank;

    @BeforeEach
    void setup() {
        mockHealthSystem = new MockHealthSystem();
        mockMovementSystem = new MockMovementSystem();
        tank = new Tank(NORMAL_DAMAGE, mockMovementSystem);
    }

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

    @Test
    void should_switch_to_siege_mode() {
        tank.setState(TankState.SIEGE_MODE);

        assertThat(tank.getState()).isEqualTo(TankState.SIEGE_MODE);
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
