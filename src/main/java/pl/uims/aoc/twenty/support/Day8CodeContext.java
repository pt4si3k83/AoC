package pl.uims.aoc.twenty.support;

public class Day8CodeContext {

    private int accumulator;
    private int cursorPosition;
    private int prevCursorPosition = -1;
    private int maxCursorPosition = -1;
    private int lastSwitchedCursorPosition = -1;
    private int restartCount = 0;


    public Day8CodeContext() {
        this(0,0);
    }

    public Day8CodeContext(int accumulator, int cursorPosition) {
        this.accumulator = accumulator;
        this.cursorPosition = cursorPosition;
    }

    @Override
    public String toString() {
        return "Day8CodeContext{" +
                "accumulator=" + accumulator +
                ", cursorPosition=" + cursorPosition +
                ", prevCursorPosition=" + prevCursorPosition +
                ", maxCursorPosition=" + maxCursorPosition +
                ", lastSwitchedCursorPosition=" + lastSwitchedCursorPosition +
                ", restartCount=" + restartCount +
                '}';
    }

    public int getAccumulator() {
        return accumulator;
    }

    public void updateAccumulator(int accumulator) {
        this.accumulator += accumulator;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public void updateCursorPosition(int cursorPosition) {
        this.prevCursorPosition = this.cursorPosition;
        this.cursorPosition += cursorPosition;
        this.maxCursorPosition = Math.max(this.maxCursorPosition, this.cursorPosition);
    }

    public int getMaxCursorPosition() {
        return maxCursorPosition;
    }

    public void restart() {
        this.accumulator = 0;
        this.cursorPosition = 0;
        this.maxCursorPosition = -1;
        this.prevCursorPosition = -1;
        restartCount++;
    }

    public int getLastSwitchedCursorPosition() {
        return lastSwitchedCursorPosition;
    }

    public void setLastSwitchedCursorPosition(int lastSwitchedCursorPosition) {
        this.lastSwitchedCursorPosition = lastSwitchedCursorPosition;
    }

    public boolean wasRestarted(){
        return restartCount > 0;
    }
}
