package com.example.javakotlinkata.tankstatepattern.vincentfinn;

enum TankState {
    TANK_MODE,
    SIEGE_MODE
}


public class Tank {
    private TankState state = TankState.TANK_MODE;
    private int damage;
    private final MovementSystem movementSystem;

    public Tank(int damage, MovementSystem movementSystem) {
        this.damage = damage;
        this.movementSystem = movementSystem;
    }

    public TankState getState() {
        return state;
    }

    public void setState(TankState state) {
        this.state = state;
    }

    public void attack(HealthSystem healthSystem) {
        healthSystem.dealDamage(damage);
    }

    public void move(int x, int y) {
        movementSystem.moveTo(this, new Coordinate(x, y));
    }
}
