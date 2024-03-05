package battleship;

public class Cell {

    private boolean isShip;
    private boolean wasHit;
    private boolean missed;

    public Cell() {
        this.isShip = false;
        this.wasHit = false;
        this.missed = false;
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

    public boolean isMissed() {
        return missed;
    }

    public void setMissed(boolean missed) {
        this.missed = missed;
    }



    @Override
    public String toString() {
        if (!isShip && !wasHit && !missed) {
            return "~";
        } else if (isShip && !wasHit) {
            return "O";
        } else if (isShip) {
            return "X";
        } else if (missed) {
            return "M";
        } else {
            return "?";
        }
    }
}
