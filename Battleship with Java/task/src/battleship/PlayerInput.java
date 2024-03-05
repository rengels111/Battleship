package battleship;

import java.util.Scanner;

public class PlayerInput {

    String rowLetters = "ABCDEFGHIJ";
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    private static final Scanner sc = new Scanner(System.in);


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


    public void inputShipCoordinates() {
        boolean correctInput = false;
        while (!correctInput) {

            // Player input
            String input = sc.nextLine();

            // split input
            if (!input.contains(" ")) {
                invalidShipInputMessage();
            } else {
                String[] coordinates = input.split(" ");
                String coordinateA = coordinates[0];
                String coordinateB = coordinates[1];

                // check if valid coordinate length
                if (coordinateA.length() < 2 || coordinateA.length() > 3 ||
                        coordinateB.length() < 2 || coordinateB.length() > 3) {
                    invalidShipInputMessage();
                } else {
                    // extract chars from input
                    char firstLetter = coordinateA.charAt(0);
                    char secondLetter = coordinateB.charAt(0);

                    // check if valid symbols
                    if (rowLetters.indexOf(firstLetter) == -1 || rowLetters.indexOf(secondLetter) == -1) {
                        invalidShipInputMessage();
                    } else {
                        x1 = firstLetter - 65;
                        x2 = secondLetter - 65;

                        // extract numeric values from input
                        try {
                            y1 = Integer.parseInt(coordinateA.substring(1)) - 1;
                            y2 = Integer.parseInt(coordinateB.substring(1)) - 1;
                        } catch (IllegalArgumentException e) {
                            invalidShipInputMessage();
                        }

                        // check if valid numbers
                        if (y1 < 0 || y1 > 9 || y2 < 0 || y2 > 9) {
                            invalidShipInputMessage();
                        } else {
                            correctInput = true;
                        }
                    }
                }
            }
        }
    }

    public String shot() {
        boolean correctInput = false;
        String target = null;
        while (!correctInput) {
            target = sc.nextLine().trim();
            char letter = target.charAt(0);
            int number = Integer.parseInt(target.substring(1)) - 1;
            if (rowLetters.indexOf(letter) == -1 || number < 0 || number > 9) {
                invalidTargetInputMessage();
            } else {
                correctInput = true;
            }
        }
        return target;
    }

    private void invalidShipInputMessage() {
        System.out.println("Error! Invalid input! Valid input is: \"[A-J][1-10] [A-J][1-10]\". Try again:");
    }

    private void invalidTargetInputMessage() {
        System.out.println("Error! Invalid input! Valid input is: \"[A-J][1-10]\". Try again:");
    }

}
