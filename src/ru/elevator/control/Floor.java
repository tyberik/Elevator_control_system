package ru.elevator.control;

public class Floor {
    private final ElevatorControl elevatorControl;
    private final Integer floorNumber;

    public Floor(ElevatorControl elevatorControl, Integer floorNumber) {
        this.elevatorControl = elevatorControl;
        this.floorNumber = floorNumber;
    }

    public Elevator resolveElevator() throws InterruptedException {
        return elevatorControl.resolveElevator(floorNumber);
    }

    public void getSmallElevatorFloor(){
        System.out.println(elevatorControl.getSmallElevator().getName() + "находится на " + elevatorControl.getSmallElevator().getCurrentFloor() + " этаже");
    }

    public void getSmallElevatorFloorStatus(){
        System.out.println(elevatorControl.getSmallElevator().getName() + " " + elevatorControl.getSmallElevator().getStatus());
    }

    public void getBigElevatorFloor(){
        System.out.println(elevatorControl.getBigElevator().getName() + "находится на " + elevatorControl.getSmallElevator().getCurrentFloor() + " этаже");
    }

    public void getBigElevatorFloorStatus(){
        System.out.println(elevatorControl.getBigElevator().getName() + " " + elevatorControl.getSmallElevator().getStatus());
    }
}