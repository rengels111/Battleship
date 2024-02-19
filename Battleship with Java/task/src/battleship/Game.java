package battleship;

import java.util.Scanner;

public class Game {

    String shipStart;
    String shipEnd;
    int shipLength;

    private static final Scanner sc = new Scanner(System.in);

    void inputCoordinates() {
        System.out.println("Enter the coordinates of the ship:");
        shipStart = sc.next();
        shipEnd = sc.next();
    }

    void checkLength(String start, String end) {
        int first = Integer.parseInt(String.valueOf(start.charAt(1)));
        int second = Integer.parseInt(String.valueOf(end.charAt(1)));

        shipLength =  Math.abs(first - second);
    }

    void outputShip(int shipLength) {
        System.out.printf("Length: %d\n", shipLength);
        System.out.println("Parts: ");
    }
}
