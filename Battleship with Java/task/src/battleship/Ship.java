package battleship;

public class Ship {
    private final String name;
    private int x1, y1, x2, y2;
    private int length;
    private boolean horizontal;

    public Ship(String name) {
        this.name = name;
    }

    public Ship(String name, int x1, int y1, int x2, int y2) {
        this.name = name;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.length = calculateShipLength();
    }

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

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public int calculateShipLength() {
        if (x1 == x2) {
            horizontal = true;
            return Math.abs(y1 - y2) + 1;
        } else if (y1 == y2) {
            horizontal = false;
            return Math.abs(x1 - x2) + 1;
        } else {
            throw new IllegalArgumentException("Error! Wrong ship location! Ships must be placed either horizontally or vertically.");
        }
    }

    public boolean checkLength(int expectedLength) {
        if (expectedLength == length) {
            return true;
        } else {
            System.out.printf("Error! Wrong length of the %s! Try again:%n", name);
            return false;
        }
    }
}
