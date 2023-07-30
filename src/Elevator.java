public class Elevator {
    private Integer currentFloor = 0;
    private ElevatorControl elevatorControl;
    private StatusElevator status = StatusElevator.STANDING_WITH_OPEN_DOORS;
    private boolean openDoors = true;
    private final String name;

    public String getName() {
        return name;
    }

    public Elevator(ElevatorControl elevatorControl, String name) {
        this.elevatorControl = elevatorControl;
        this.name = name;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void pressFloorButton(Integer floorResult) throws InterruptedException {

        if (currentFloor.equals(floorResult)) {
            System.out.println("Вы уже находитесь на этом этаже");
            return;
        }

        if (floorResult > elevatorControl.getFloors().size() || floorResult < 0) {
            System.out.println("Неверный ввод");
            return;
        }

        pressCloseButton();

        int direction;
        if (currentFloor < floorResult) {
            direction = 1; // going up;
            System.out.println(getName() + " поднимается на этаж: " + (floorResult + 1));
            status = StatusElevator.GO_UP;
        } else {
            direction = -1; //going down;
            System.out.println(getName() + " опускается на этаж: " + (floorResult + 1));
            status = StatusElevator.GO_DOWN;
        }


        while (!currentFloor.equals(floorResult)) {
            currentFloor += direction;
            System.out.println("..." + (currentFloor + 1));
            Thread.sleep(1000);
        }
        System.out.println("Ding!");
        pressOpenButton();
    }

    private void pressCloseButton() throws InterruptedException {
        if (!cabinIdleDetected())
            return;
        System.out.println("Двери закрываются");
        status = StatusElevator.CLOSE_DOORS;
        Thread.sleep(1000);
        openDoors = false;
    }

    private void pressOpenButton() throws InterruptedException {
        System.out.println("Двери открываются");
        status = StatusElevator.OPEN_DOORS;
        Thread.sleep(1000);
        openDoors = true;
        status = StatusElevator.STANDING_WITH_OPEN_DOORS;
    }

    public void pressDispatcherButton() {
        System.out.println("Связь с диспетчером установлена");
    }

    public Boolean cabinMotionDetected() {
        System.out.println("Движение между дверьми обнаружено");
        //TODO
        return false;
    }

    public Boolean cabinIdleDetected() {
        System.out.println("Движение между дверьми не обнаружено");
        //TODO
        return true;
    }

}
