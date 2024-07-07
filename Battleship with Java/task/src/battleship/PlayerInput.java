package battleship;

import java.util.Scanner;

public class PlayerInput {

    // 1. Felder:
    // Scanner wird verwendet, um die Eingabe des Spielers zu lesen.
    private static final Scanner sc = new Scanner(System.in);

    // Enthält die Buchstaben A bis J zur Überprüfung der Zeilenkoordinaten.
    private static final String ROW_LETTERS = "ABCDEFGHIJ";

    // Speichern die konvertierten Koordinatenwerte.
    private int x1, x2, y1, y2;

    // 2. Methoden:
    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }


    // Liest und validiert die Eingaben für die Schiffkoordinaten.
    public void inputShipCoordinates() {
        boolean correctInput = false;
        while (!correctInput) {

            // Player input
            String input = sc.nextLine().trim();

            // split input
            if (!input.contains(" ")) {
                invalidShipInputMessage();
                continue;
            }

            String[] coordinates = input.split(" ");
            // check if valid coordinate length
            if (coordinates.length != 2) {
                invalidShipInputMessage();
                continue;
            }

            String coordinateA = coordinates[0];
            String coordinateB = coordinates[1];

            if (!isValidCoordinate(coordinateA) || !isValidCoordinate(coordinateB)) {
                invalidShipInputMessage();
                continue;
            }

            // extract chars from input
            char firstLetter = coordinateA.charAt(0);
            char secondLetter = coordinateB.charAt(0);

            x1 = ROW_LETTERS.indexOf(firstLetter);
            x2 = ROW_LETTERS.indexOf(secondLetter);

            // extract numeric values from input
            try {
                y1 = Integer.parseInt(coordinateA.substring(1)) - 1;
                y2 = Integer.parseInt(coordinateB.substring(1)) - 1;
            } catch (NumberFormatException  e) {
                invalidShipInputMessage();
                continue;
            }

            // check if valid numbers
            if (y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9) {
                invalidShipInputMessage();
                continue;
            }

            correctInput = true;
        }
    }

    //  Liest und validiert die Eingabe für das Ziel des Schusses.
    public String shot() {
        boolean correctInput = false;
        String target = null;
        while (!correctInput) {
            target = sc.nextLine().trim();
            if (target.length() < 2 || target.length() > 3) {
                invalidTargetInputMessage();
                continue;
            }

            char letter = target.charAt(0);
            if (ROW_LETTERS.indexOf(letter) == -1) {
                invalidTargetInputMessage();
                continue;
            }

            try {
                int number = Integer.parseInt(target.substring(1)) - 1;
                if (number < 0 || number > 9) {
                    invalidTargetInputMessage();
                } else {
                    correctInput = true;
                }
            } catch (NumberFormatException e) {
                invalidTargetInputMessage();
            }
        }
        return target;
    }

    // Koordinaten-Validierung
    private boolean isValidCoordinate(String coordinate) {
        if (coordinate.length() < 2 || coordinate.length() > 3) {
            return false;
        }
        char letter = coordinate.charAt(0);
        return ROW_LETTERS.indexOf(letter) != -1;
    }

    // Fehlermeldungen drucken für ungültige Eingaben.
    private void invalidShipInputMessage() {
        System.out.println("Error! Invalid input! Valid input is: \"[A-J][1-10] [A-J][1-10]\". Try again:");
    }

    private void invalidTargetInputMessage() {
        System.out.println("Error! Invalid input! Valid input is: \"[A-J][1-10]\". Try again:");
    }

}
