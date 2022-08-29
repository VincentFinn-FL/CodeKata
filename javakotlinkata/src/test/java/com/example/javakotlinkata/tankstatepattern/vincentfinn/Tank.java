package com.example.javakotlinkata.tankstatepattern.vincentfinn;

public class Tank {
    private int damage;
    private final MovementSystem movementSystem;

    public Tank(int damage, MovementSystem movementSystem) {
        this.damage = damage;
        this.movementSystem = movementSystem;
    }

    public void attack(HealthSystem healthSystem) {
        healthSystem.dealDamage(damage);
    }

    public void move(int x, int y) {
        movementSystem.moveTo(this, new Coordinate(x, y));
    }
}
