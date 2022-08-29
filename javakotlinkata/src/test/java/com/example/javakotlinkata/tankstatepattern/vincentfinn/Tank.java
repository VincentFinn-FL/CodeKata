package com.example.javakotlinkata.tankstatepattern.vincentfinn;

public class Tank {
    private int damage;

    public Tank(int damage) {
        this.damage = damage;
    }

    public void attack(HealthSystem healthSystem) {
        healthSystem.dealDamage(damage);
    }
}
