package battleship;

public class Field {

    String fog = " ~";
    String ship = " O";
    String hit = " X";
    String miss = " M";
    char letter = 'A';

    void printField() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < 10; i++) {
            System.out.print(letter);
            for (int j = 0; j < 10; j++) {
                System.out.print(fog);
            }
            System.out.println();
            letter++;
        }
    }
}