package battleship;

public class Battlefield {

    private final Cell[][] field;

    public Battlefield() {
        this.field = createBattlefield();
    }

    private Cell[][] createBattlefield() {
        Cell[][] field = new Cell[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = new Cell();
            }
        }
        return field;
    }

    public boolean isAround(int i, int j) {
        try {
            if (this.field[i][j - 1].isShip()) {
                return true;
            }
            if (this.field[i -1][j].isShip()) {
                return true;
            }
            if (this.field[i][j + 1].isShip()) {
                return true;
            }
            return this.field[i + 1][j].isShip();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkValidPosition(int x1, int y1, int x2, int y2, boolean isHorizontalShip) {
        if (isHorizontalShip) {
            for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                if (isAround(x1, i)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    return false;
                }
            }
        } else {
            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                if (isAround(i, y1)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    return false;
                }
            }
        }
        return true;
    }

    public void updateBattlefield(int x1, int y1, int x2, int y2, boolean isHorizontalShip) {
        if (isHorizontalShip) {
            for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i ++) {
                field[x1][i].setShip(true);
            }
        } else {
            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2) ; i++) {
                field[i][y1].setShip(true);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("  1 2 3 4 5 6 7 8 9 10\n");
        for (int i = 0; i < 10; i++) {
            toPrint.append((char) (i + 65));
            toPrint.append(" ");
            for (int j = 0; j < 10; j++) {
                toPrint.append(this.field[i][j]);
                toPrint.append(" ");
            }
            toPrint.append("\n");
        }
        return toPrint.toString();
    }
}