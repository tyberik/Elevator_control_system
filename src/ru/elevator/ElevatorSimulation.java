package ru.elevator;

import ru.elevator.control.ElevatorControl;
import ru.elevator.passenger.Passenger;

public class ElevatorSimulation {
    public static void main(String[] args) throws InterruptedException {

        ElevatorControl elevatorControl = new ElevatorControl(20);
        Passenger passenger1 = new Passenger(elevatorControl.getFloors().get(0), "1");
        Passenger passenger2 = new Passenger(elevatorControl.getFloors().get(14), "2");

        passenger1.pressButtonResolveElevator(13);
        passenger2.pressButtonResolveElevator(0);

    }
}
