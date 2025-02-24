package com.shilpi.app.module;

public class Registration {

    Owner owner;
    Vehicle vehicle;

    public Owner getowner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Registration(Vehicle vehicle ,Owner owner) {
        this.owner = owner;
        this.vehicle = vehicle;
    }

    public Registration() {
    }

    @Override
    public String toString() {
        return "Registration{" +
                "owner=" + owner +
                ", vehicle=" + vehicle +
                '}';
    }
}
