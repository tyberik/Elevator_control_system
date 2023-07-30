package ru.elevator.passenger;

import ru.elevator.control.Elevator;
import ru.elevator.control.Floor;

public class Passenger {
    private Floor floor;
    private final String name;

    public String getName() {
        return name;
    }

    public Passenger(Floor floor, String name) {
        this.floor = floor;
        this.name = name;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public void pressButtonResolveElevator(Integer floorNumber) throws InterruptedException {
        Elevator elevator = floor.resolveElevator();
        elevator.getInElevator(this);
        elevator.pressFloorButton(floorNumber);
        setFloor(elevator.getOutElevator(this));
    }

}
