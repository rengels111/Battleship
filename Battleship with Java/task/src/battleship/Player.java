package battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    String rowLetters = "ABCDEFGHIJ";
    private char firstLetter;
    private char secondLetter;
    private int firstNum;
    private int secondNum;

    private static final Scanner sc = new Scanner(System.in);

    public char getFirstLetter() {
        return firstLetter;
    }

    public char getSecondLetter() {
        return secondLetter;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void inputShipCoordinates() {
        System.out.println("Enter the coordinates of the ship:");
        String input = sc.nextLine();
        String[] coordinates = input.split(" ");
        String coordinateA = coordinates[0];
        String coordinateB = coordinates[1];

        if (coordinateA.length() < 2 || coordinateA.length() > 3 ||
                coordinateB.length() < 2 || coordinateB.length() > 3) {
            throw new InputMismatchException();
        }

        firstLetter = coordinateA.charAt(0);
        secondLetter = coordinateB.charAt(0);
        if (rowLetters.indexOf(firstLetter) == -1 || rowLetters.indexOf(secondLetter) == -1) {
            throw new InputMismatchException();
        }

        if (coordinateA.length() == 2) {
            firstNum = Character.getNumericValue(coordinateA.charAt(1));
        } else {
            firstNum = Integer.parseInt(coordinateA.substring(1));
        }
        if (coordinateB.length() == 2) {
            secondNum = Character.getNumericValue(coordinateB.charAt(1));
        } else {
            secondNum = Integer.parseInt(coordinateB.substring(1));
        }

        if (firstNum < 1 || firstNum > 10 || secondNum < 1 || secondNum > 10) {
            throw new InputMismatchException();
        }
    }

}
