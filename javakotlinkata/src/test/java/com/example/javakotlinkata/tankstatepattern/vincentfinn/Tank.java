package com.example.javakotlinkata.tankstatepattern.vincentfinn;

enum TankState {
    TANK_MODE,
    SIEGE_MODE,
    SPEED_MODE
}

interface State {
    void attack(HealthSystem healthSystem);

    void moveTo(Object objectToMove, Coordinate coordinate);
}

class SpeedMode implements State {
    private final MovementSystem movementSystem;

    public SpeedMode(MovementSystem movementSystem) {
        this.movementSystem = movementSystem;
    }

    @Override
    public void attack(HealthSystem healthSystem) {
        //log stuff
        return;
    }

    @Override
    public void moveTo(Object objectToMove, Coordinate coordinate) {
        movementSystem.moveTo(objectToMove, coordinate);
    }
}

class TankMode implements State {
    private final int damage;
    private final MovementSystem movementSystem;

    public TankMode(int damage, MovementSystem movementSystem) {
        this.damage = damage;
        this.movementSystem = movementSystem;
    }

    @Override
    public void attack(HealthSystem healthSystem) {
        healthSystem.dealDamage(damage);
    }

    @Override
    public void moveTo(Object objectToMove, Coordinate coordinate) {
        movementSystem.moveTo(objectToMove, coordinate);
    }
}

class SiegeMode implements State {
    private final int damage;

    public SiegeMode(int damage) {
        this.damage = damage;
    }

    @Override
    public void attack(HealthSystem healthSystem) {
        healthSystem.dealDamage(damage);
    }

    @Override
    public void moveTo(Object objectToMove, Coordinate coordinate) {
        //log here
        return;
    }
}


public class Tank {
    private TankState tankState = TankState.TANK_MODE;
    private State state;
    private int normalDamage;
    private int siegeDamage;
    private final MovementSystem movementSystem;

    public Tank(int normalDamage, int siegeDamage, MovementSystem movementSystem) {
        this.normalDamage = normalDamage;
        this.siegeDamage = siegeDamage;
        this.movementSystem = movementSystem;
        state = new TankMode(normalDamage, movementSystem);
    }

    public TankState getState() {
        return tankState;
    }

    public void setState(TankState state) {
        this.tankState = state;
        switch (state) {
            case TANK_MODE:
                this.state = new TankMode(normalDamage, movementSystem);
                break;
            case SIEGE_MODE:
                this.state = new SiegeMode(siegeDamage);
                break;
            case SPEED_MODE:
                this.state = new SpeedMode(movementSystem);
                break;
        }
    }

    public void attack(HealthSystem healthSystem) {
        state.attack(healthSystem);
    }

    public void move(int x, int y) {
        state.moveTo(this, new Coordinate(x, y));
    }
}
