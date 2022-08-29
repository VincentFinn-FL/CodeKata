package com.example.javakotlinkata.tankstatepattern.vincentfinn;

enum TankState {
    TANK_MODE,
    SIEGE_MODE
}


public class Tank {
    private TankState state = TankState.TANK_MODE;
    private int normalDamage;
    private int siegeDamage;
    private final MovementSystem movementSystem;

    public Tank(int normalDamage, int siegeDamage, MovementSystem movementSystem) {
        this.normalDamage = normalDamage;
        this.siegeDamage = siegeDamage;
        this.movementSystem = movementSystem;
    }

    public TankState getState() {
        return state;
    }

    public void setState(TankState state) {
        this.state = state;
    }

    public void attack(HealthSystem healthSystem) {
        var damageToDeal = normalDamage;
        if(state.equals(TankState.SIEGE_MODE)) {
            damageToDeal = siegeDamage;
        }
        healthSystem.dealDamage(damageToDeal);
    }

    public void move(int x, int y) {
        if (this.state == TankState.SIEGE_MODE) {
            return;
        }
        movementSystem.moveTo(this, new Coordinate(x, y));
    }
}
