public class Floor {
/*    private ElevatorControl smallElevatorFloor;
    private ElevatorControl smallElevatorFloorStatus;
    private ElevatorControl bigElevatorFloor;
    private ElevatorControl bigElevatorFloorStatus;*/
    private final ElevatorControl elevatorControl;
    private final Integer floorNumber;

    public Floor(ElevatorControl elevatorControl, Integer floorNumber) {
        this.elevatorControl = elevatorControl;
        this.floorNumber = floorNumber;
    }

    public Elevator resolveElevator() throws InterruptedException {
        return elevatorControl.resolveElevator(floorNumber);
    }


/*    public ElevatorControl getSmallElevatorFloor() {
        System.out.println("1 лифт на ходится на " + (elevatorControl.getSmallElevator().getCurrentFloor() + 1) +  " этаже");
        return smallElevatorFloor;
    }

    public ElevatorControl getSmallElevatorFloorStatus() {
        return smallElevatorFloorStatus;
    }

    public ElevatorControl getBigElevatorFloor() {
        System.out.println("2 лифт на ходится на " + (elevatorControl.getBigElevator().getCurrentFloor() + 1) +  " этаже");
        return bigElevatorFloor;
    }

    public ElevatorControl getBigElevatorFloorStatus() {
        return bigElevatorFloorStatus;
    }*/




}