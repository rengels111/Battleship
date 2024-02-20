package battleship;

public class GameLogic {

    private boolean horizontalShip;


    public int calculateShipLength(char firstLetter, char secondLetter, int firstNum, int secondNum) {
        if (firstLetter == secondLetter) {
            horizontalShip = true;
            return Math.abs(firstNum - secondNum) + 1;
        } else if (firstNum == secondNum) {
            horizontalShip = false;
            return Math.abs((int)firstLetter - (int)secondLetter) + 1;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void outputShipData(int length, char firstLetter, char secondLetter,int firstNum, int secondNum) {
        System.out.printf("Length: %d\n", length);
        if (horizontalShip) {
            System.out.print("Parts: ");
            if (firstNum < secondNum) {
                for (int i = firstNum; i <= secondNum ; i++) {
                    System.out.printf("%c%d ", firstLetter, i);
                }
            } else if (firstNum > secondNum) {
                for (int i = firstNum; i >= secondNum ; i--) {
                    System.out.printf("%c%d ", firstLetter, i);
                }
            }
        } else {
            System.out.print("Parts: ");
            if (firstLetter < secondLetter) {
                for (int i = firstLetter; i <= secondLetter; i++) {
                    System.out.printf("%c%d ", i, firstNum);
                }
            } else {
                for (int i = firstLetter; i >= secondLetter; i--) {
                    System.out.printf("%c%d ", i, firstNum);
                }
            }
        }
    }
}
