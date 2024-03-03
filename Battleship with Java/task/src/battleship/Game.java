package battleship;

import java.util.InputMismatchException;

public class Game {
    Battlefield battlefield = new Battlefield();
    PlayerInput playerInput = new PlayerInput();
    checkShip checkShip = new checkShip();

    void start() {
        printBattlefield();
        try {
            placeShip("Aircraft Carrier", 5);
            placeShip("Battleship", 4);
            placeShip("Submarine", 3);
            placeShip("Cruiser", 3);
            placeShip("Destroyer", 2);
        } catch (InputMismatchException e) {
            System.out.println("Error! Invalid input! Valid input is: \"[A-J][1-10] [A-J][1-10]\"");
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Wrong ship location!");
        }
    }


    private void printBattlefield() {
        System.out.println(battlefield);
    }

    private void placeShip(String ship, int shipLengthShall) {
        System.out.printf("Enter the coordinates of the %s (%d cells):\n", ship, shipLengthShall);
        boolean validShipLength = false;
        boolean positionOk = false;
        while (!validShipLength || !positionOk) {
            playerInput.inputShipCoordinates();
            int x1 = playerInput.getX1();
            int x2 = playerInput.getX2();
            int y1 = playerInput.getY1();
            int y2 = playerInput.getY2();
            int shipLengthIs = checkShip.calculateShipLength(x1, y1, x2, y2);
            validShipLength = checkShip.checkLength(shipLengthShall, shipLengthIs);
            positionOk = battlefield.checkValidPosition(x1, y1, x2, y2, checkShip.isHorizontalShip());
        }
        battlefield.updateBattlefield(playerInput.getX1(), playerInput.getY1(), playerInput.getX2(), playerInput.getY2(), checkShip.isHorizontalShip());
        printBattlefield();
    }
}