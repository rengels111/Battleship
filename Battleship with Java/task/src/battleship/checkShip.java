package battleship;

public class checkShip {

    private boolean horizontalShip;

    public boolean isHorizontalShip() {
        return horizontalShip;
    }

    public int calculateShipLength(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            horizontalShip = true;
            return Math.abs(y1 - y2) + 1;
        } else if (y1 == y2) {
            horizontalShip = false;
            return Math.abs(x1 - x2) + 1;
        } else {
            System.out.println("Error! Wrong ship location! Try again:");
            return 0;
        }
    }

    public boolean checkLength(int shipLengthShall, int shipLengthIs) {
        boolean validShipLength;
        if (shipLengthShall == shipLengthIs) {
            validShipLength = true;
        } else {
            validShipLength = false;
            System.out.println("Error! Wrong length of the Submarine! Try again:");
        }
        return validShipLength;
    }
















//    public void outputShipData(int length, char firstLetter, char secondLetter,int firstNum, int secondNum) {
//        System.out.printf("Length: %d\n", length);
//        if (horizontalShip) {
//            System.out.print("Parts: ");
//            if (firstNum < secondNum) {
//                for (int i = firstNum; i <= secondNum ; i++) {
//                    System.out.printf("%c%d ", firstLetter, i);
//                }
//            } else if (firstNum > secondNum) {
//                for (int i = firstNum; i >= secondNum ; i--) {
//                    System.out.printf("%c%d ", firstLetter, i);
//                }
//            }
//        } else {
//            System.out.print("Parts: ");
//            if (firstLetter < secondLetter) {
//                for (int i = firstLetter; i <= secondLetter; i++) {
//                    System.out.printf("%c%d ", i, firstNum);
//                }
//            } else {
//                for (int i = firstLetter; i >= secondLetter; i--) {
//                    System.out.printf("%c%d ", i, firstNum);
//                }
//            }
//        }
//    }
}
