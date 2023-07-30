import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        this.smallElevator = new Elevator(this, "Малый лифт");
        this.bigElevator = new Elevator(this, "Большой лифт");
    }


    public List<Floor> getFloors() {
        return floors;
    }


    public void goToFloor(Integer floor) throws InterruptedException {
        int distSmall = floor - smallElevator.getCurrentFloor();
        int distBig = floor - bigElevator.getCurrentFloor();

        if (Math.abs(distSmall) < Math.abs(distBig) || Math.abs(distSmall) == Math.abs(distBig))
            smallElevator.pressFloorButton(floor);

        else bigElevator.pressFloorButton(floor);
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


}
