package battleship;

import java.util.InputMismatchException;

public class Game {

    Field field = new Field();
    Player player = new Player();
    GameLogic logic = new GameLogic();

    void start() {
        field.printField();
        try {
            player.inputShipCoordinates();
            int shipLength = logic.calculateShipLength(
                    player.getFirstLetter(),
                    player.getSecondLetter(),
                    player.getFirstNum(),
                    player.getSecondNum()
            );
            logic.outputShipData(
                    shipLength,
                    player.getFirstLetter(),
                    player.getSecondLetter(),
                    player.getFirstNum(),
                    player.getSecondNum());
        } catch (InputMismatchException e) {
            System.out.println("Error! Invalid input! Valid input is: \"[A-J][1-10] [A-J][1-10]\"");
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Ship position not possible!");
        }


    }
}
