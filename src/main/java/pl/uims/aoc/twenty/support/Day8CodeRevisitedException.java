package pl.uims.aoc.twenty.support;

public class Day8CodeRevisitedException extends Exception {

    private final Day8CodeContext ctx;
    private final Day8CodeLine codeLine;

    public Day8CodeRevisitedException(Day8CodeContext ctx, Day8CodeLine codeLine) {
        this.ctx = ctx;
        this.codeLine = codeLine;
    }

    @Override
    public String toString() {
        return "Day8CodeRevisitedException{" +
                "ctx=" + ctx +
                ", codeLine=" + codeLine +
                '}';
    }
}
