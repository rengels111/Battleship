package battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private final Battlefield player1Field = new Battlefield();
    private final Battlefield player2Field = new Battlefield();
    private final PlayerInput playerInput = new PlayerInput();

    public void start() {
        System.out.println("Player 1, place your ships on the game field");
        player1Field.printBattlefield();
        setupBattlefield(player1Field);
        promptEnterKey();

        System.out.println("Player 2, place your ships on the game field");
        player2Field.printBattlefield();
        setupBattlefield(player2Field);
        promptEnterKey();

        startGame();
    }

    private void startGame() {
        boolean gameOver = false;
        boolean player1Turn = true;

        while (!gameOver) {
            if (player1Turn) {
                System.out.println("Player 1, it's your turn:");
                printGameState(player2Field, player1Field);
                player2Field.checkForHit(playerInput.shot());
                gameOver = player2Field.checkWin();
            } else {
                System.out.println("Player 2, it's your turn:");
                printGameState(player1Field, player2Field);
                player1Field.checkForHit(playerInput.shot());
                gameOver = player1Field.checkWin();
            }

            if (!gameOver) {
                promptEnterKey();
                player1Turn = !player1Turn;
            }
        }

        System.out.println("You sank the last ship. You won. Congratulations!");
    }

    private void setupBattlefield(Battlefield battlefield) {
        placeShip(battlefield, "Aircraft Carrier", 5);
        placeShip(battlefield, "Battleship", 4);
        placeShip(battlefield, "Submarine", 3);
        placeShip(battlefield, "Cruiser", 3);
        placeShip(battlefield, "Destroyer", 2);
    }

    private void placeShip(Battlefield battlefield, String shipName, int shipLengthShall) {
        boolean shipPlaced = false;
        while (!shipPlaced) {
            System.out.printf("Enter the coordinates of the %s (%d cells):\n", shipName, shipLengthShall);
            playerInput.inputShipCoordinates();
            int x1 = playerInput.getX1();
            int x2 = playerInput.getX2();
            int y1 = playerInput.getY1();
            int y2 = playerInput.getY2();

            try {
                Ship ship = new Ship(shipName, x1, y1, x2, y2);

                if (!ship.checkLength(shipLengthShall)) {
                    continue;
                }

                if (!battlefield.checkValidPosition(x1, y1, x2, y2, ship.isHorizontal())) {
                    continue;
                }

                battlefield.updateBattlefield(x1, y1, x2, y2, ship.isHorizontal());
                battlefield.printBattlefield();
                shipPlaced = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printGameState(Battlefield opponentField, Battlefield playerField) {
        System.out.println("Opponent's field:");
        opponentField.printFogOfWarField();
        System.out.println("---------------------");
        System.out.println("Your field:");
        playerField.printBattlefield();
    }

    private void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}