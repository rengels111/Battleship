package battleship;

public class Ship {

    private String name;
    private int length;

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Ship(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

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
}
