package ru.elevator.control;

import java.util.ArrayList;
import java.util.List;

public class ElevatorControl {
    private final List<Floor> floors = new ArrayList<>();
    private final Elevator smallElevator;
    private final Elevator bigElevator;

    public Elevator getSmallElevator() {
        return smallElevator;
    }

    public Elevator getBigElevator() {
        return bigElevator;
    }

    public ElevatorControl(Integer floorsSize) {
        for (int floorNumber = 0; floorNumber < floorsSize; floorNumber++) {
            floors.add(new Floor(this, floorNumber));
        }
        this.smallElevator = new Elevator(this, "Малый лифт", 5);
        this.bigElevator = new Elevator(this, "Большой лифт", 10);
    }


    public List<Floor> getFloors() {
        return floors;
    }

    public Elevator resolveElevator(Integer floor) throws InterruptedException {
        int distSmall = floor - smallElevator.getCurrentFloor();
        int distBig = floor - bigElevator.getCurrentFloor();

        if (Math.abs(distSmall) < Math.abs(distBig) || Math.abs(distSmall) == Math.abs(distBig)) {
            smallElevator.pressFloorButton(floor);
            return smallElevator;
        } else {
            bigElevator.pressFloorButton(floor);
            return bigElevator;
        }
    }

    public Floor getFloorById(Integer floorNumber){
        return floors.get(floorNumber);
    }


}
