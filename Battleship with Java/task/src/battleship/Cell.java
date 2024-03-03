package battleship;

public class Cell {

    private boolean isShip;
    private boolean wasHit;

    public Cell() {
        this.isShip = false;
        this.wasHit = false;
    }

    public boolean isShip() {
        return isShip;
    }

    public boolean isWasHit() {
        return wasHit;
    }

    public void setShip(boolean isShip) {
        this.isShip = isShip;
    }

    public void setWasHit(boolean wasHit) {
        this.wasHit = wasHit;
    }

    @Override
    public String toString() {
        if (!isShip && !wasHit) {
            return "~";
        } else if (isShip && !wasHit) {
            return "O";
        } else if (isShip) {
            return "X";
        } else {
            return "M";
        }
    }
}
