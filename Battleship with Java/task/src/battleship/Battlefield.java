package battleship;

public class Battlefield {

    private final Cell[][] field;

    // 1. Konstruktor und Initialisierung:
    //Der Konstruktor Battlefield() initialisiert das Spielfeld durch Aufruf der Methode createBattlefield().
    public Battlefield() {
        this.field = createBattlefield();
    }

    // Die Methode createBattlefield() erstellt ein 10x10 Feld
    // und initialisiert jede Zelle mit einem neuen Cell-Objekt.
    private Cell[][] createBattlefield() {
        Cell[][] field = new Cell[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field[i][j] = new Cell();
            }
        }
        return field;
    }

    // 2. Validierungs- und Aktualisierungsmethoden:
    // Überprüft, ob sich in den angrenzenden Zellen ein Schiff befindet.
    private boolean isValidIndex(int i, int j) {
        return i>= 0 && i < 10 && j >= 0 && j < 10;
    }

    private boolean isAround(int i, int j) {
        if (isValidIndex(i, j - 1) && field[i][j - 1].isShip()) return true;
        if (isValidIndex(i - 1, j) && field[i - 1][j].isShip()) return true;
        if (isValidIndex(i, j + 1) && field[i][j + 1].isShip()) return true;
        if (isValidIndex(i + 1, j) && field[i + 1][j].isShip()) return true;
        return false;
    }

    // Überprüft, ob das Schiff korrekt platziert werden kann, ohne zu nah an anderen Schiffen zu sein.
    public boolean checkValidPosition(int x1, int y1, int x2, int y2, boolean isHorizontalShip) {
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);

        if (isHorizontalShip) {
            for (int i = minY; i <= maxY; i++) {
                if (isAround(x1, i)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    return false;
                }
            }
        } else {
            for (int i = minX; i <= maxX; i++) {
                if (isAround(i, y1)) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    return false;
                }
            }
        }
        return true;
    }

    // Aktualisiert das Spielfeld und setzt die entsprechenden Zellen auf Ship.
    public void updateBattlefield(int x1, int y1, int x2, int y2, boolean isHorizontalShip) {
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);

        if (isHorizontalShip) {
            for (int i = minY; i <= maxY; i++) {
                field[x1][i].setShip(true);
            }
        } else {
            for (int i = minX; i <= maxX; i++) {
                field[i][y1].setShip(true);
            }
        }
    }

    // 3. Spielzustandsmethoden:
    // Druckt das Spielfeld im Nebel des Krieges, wobei nur getroffene und fehlende Zellen angezeigt werden.
    public void printFogOfWarField() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("  1 2 3 4 5 6 7 8 9 10\n");
        for (int i = 0; i < 10; i++) {
            toPrint.append((char) (i + 65)).append(" ");
            for (int j = 0; j < 10; j++) {
                if (!field[i][j].isMissed() && !field[i][j].isWasHit()) {
                    toPrint.append("~ ");
                } else {
                    toPrint.append(field[i][j]).append(" ");
                }
            }
            toPrint.append("\n");
        }
        System.out.println(toPrint);
    }

    public void printBattlefield() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("  1 2 3 4 5 6 7 8 9 10\n");
        for (int i = 0; i < 10; i++) {
            toPrint.append((char) (i + 65)).append(" ");
            for (int j = 0; j < 10; j++) {
                toPrint.append(field[i][j]).append(" ");
            }
            toPrint.append("\n");
        }
        System.out.println(toPrint);
    }

    // Überprüft, ob ein Schuss ein Schiff trifft oder nicht, und aktualisiert das Spielfeld entsprechend.
    // Es gibt auch Rückmeldungen an den Spieler.
    public void checkForHit(String shot) {
        int x = shot.charAt(0) - 65;
        int y = Integer.parseInt(shot.substring(1)) - 1;

        if (field[x][y].isShip()) {
            field[x][y].setWasHit(true);
            field[x][y].setShip(false);
            printFogOfWarField();
            if (isAround(x, y)) {
                System.out.println("You hit a ship! Try again:");
            } else {
                System.out.println("You sank a ship! Specify a new target:");
            }
        } else {
            field[x][y].setMissed(true);
            printFogOfWarField();
            System.out.println("You missed! Try again:");
        }
    }

//    public boolean checkIfShipSank(int x1, int y1, int x2, int y2, boolean isHorizontalShip) {
//        if (isHorizontalShip) {
//            for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i ++) {
//                if (field[x1][i].isShip()) {
//                    return false;
//                }
//            }
//        } else {
//            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2) ; i++) {
//                if (field[x1][i].isShip()) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    // Überprüft, ob alle Schiffe versenkt wurden, und bestimmt so, ob das Spiel gewonnen wurde.
    public boolean checkWin() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.field[i][j].isShip()) {
                    return false;
                }
            }
        }
        return true;
    }


    // 4. Hilfsmethoden:
    // Gibt eine textuelle Darstellung des Spielfelds zurück.
    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("  1 2 3 4 5 6 7 8 9 10\n");
        for (int i = 0; i < 10; i++) {
            toPrint.append((char) (i + 65)).append(" ");
            for (int j = 0; j < 10; j++) {
                toPrint.append(field[i][j]).append(" ");
            }
            toPrint.append("\n");
        }
        return toPrint.toString();
    }
}