package battleship;

public class Cell {

    public enum State {
        EMPTY, SHIP, HIT, MISS
    }

    private State state;

    private boolean isShip;
    private boolean wasHit;
    private boolean missed;

    public Cell() {
        this.state = State.EMPTY;
    }

    public boolean isShip() {
        return state == State.SHIP;
    }

    public boolean isWasHit() {
        return state == State.HIT;
    }

    public boolean isMissed() {
        return state == State.MISS;
    }

    public void setShip(boolean isShip) {
        if (isShip) {
            this.state = State.SHIP;
        } else if (this.state == State.SHIP) {
            this.state = State.EMPTY;
        }
    }

    public void setWasHit(boolean wasHit) {
        if (wasHit) {
            this.state = State.HIT;
        } else if (this.state == State.HIT) {
            this.state = State.EMPTY;
        }
    }

    public void setMissed(boolean missed) {
        if (missed) {
            this.state = State.MISS;
        } else if (this.state == State.MISS) {
            this.state = State.EMPTY;
        }
    }


    @Override
    public String toString() {
        return switch (state) {
            case SHIP -> "O";
            case HIT -> "X";
            case MISS -> "M";
            default -> "~";
        };
    }
}
