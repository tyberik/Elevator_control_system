public class ElevatorSimulation {
    public static void main(String[] args) throws InterruptedException {

        ElevatorControl elevatorControl = new ElevatorControl(20);

        elevatorControl.goToFloor(4);
        Elevator elevator1 = elevatorControl.getFloors().get(9).resolveElevator();
        Elevator elevator = elevatorControl.getFloors().get(2).resolveElevator();
//        elevator.pressFloorButton(0);
//        elevator1.pressFloorButton(0);

        System.out.println();
    }
}
