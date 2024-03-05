package battleship;

import java.util.InputMismatchException;

public class Game {
    Battlefield battlefield = new Battlefield();
    PlayerInput playerInput = new PlayerInput();


    void start() {
        printBattlefield();
        try {
            placeAllShips();
            startGame();
            theShooting();
        } catch (InputMismatchException e) {
            System.out.println("Error! Invalid input! Valid input is: \"[A-J][1-10] [A-J][1-10]\"");
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Wrong ship location!");
        }
    }


    private void theShooting() {
        System.out.println("Take a shot!");
        boolean sankAllShips = false;
        while (!sankAllShips) {
            battlefield.checkForHits(playerInput.shot());
            sankAllShips = battlefield.checkWin();
            if (!sankAllShips) {
                printFogOfWar();
            } else {
                System.out.println("You sank the last ship. You won. Congratulations!");
            }
        }
    }

    private void startGame() {
        System.out.print("The game starts!\n\n");
        printFogOfWar();
    }
    private void printBattlefield() {
        System.out.println(battlefield);
    }

    private void printFogOfWar() {
        battlefield.printFogOfWarField();
    }

    private void placeAllShips() {
        Ship aircraftCarrier = placeShip("Aircraft Carrier", 5);
        Ship battleship = placeShip("Battleship", 4);
        Ship submarine = placeShip("Submarine", 3);
        Ship cruiser = placeShip("Cruiser", 3);
        Ship destroyer = placeShip("Destroyer", 2);
    }

    private Ship placeShip(String shipName, int shipLengthShall) {
        System.out.printf("Enter the coordinates of the %s (%d cells):\n", shipName, shipLengthShall);
        Ship ship = new Ship(shipName);
        boolean validShipLength = false;
        boolean positionOk = false;
        while (!validShipLength || !positionOk) {
            playerInput.inputShipCoordinates();
            int x1 = playerInput.getX1();
            int x2 = playerInput.getX2();
            int y1 = playerInput.getY1();
            int y2 = playerInput.getY2();
            int shipLengthIs = ship.calculateShipLength(x1, y1, x2, y2);
            validShipLength = ship.checkLength(shipLengthShall, shipLengthIs);
            positionOk = battlefield.checkValidPosition(x1, y1, x2, y2, ship.isHorizontalShip());
        }
        ship.setLength(shipLengthShall);
        battlefield.updateBattlefield(playerInput.getX1(), playerInput.getY1(), playerInput.getX2(), playerInput.getY2(), ship.isHorizontalShip());
        printBattlefield();
        return ship;
    }
}