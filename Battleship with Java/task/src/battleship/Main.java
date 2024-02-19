package battleship;

public class Main {



    public static void main(String[] args) {

        Field field = new Field();
        field.printField();
        Game game = new Game();
        game.inputCoordinates();
        System.out.println(game.shipStart);
        System.out.println(game.shipEnd);
        game.checkLength(game.shipStart, game.shipEnd);
        game.outputShip(game.shipLength);

    }
}
