package pl.uims.aoc.twenty.support;

public class Day8CodeLine {

    private static final int DEFAULT_CURSOR_STEP = 1;

    private static final String OP_ACC = "acc";
    private static final String OP_JMP = "jmp";
    private static final String OP_NOP = "nop";

    private boolean visited = false;
    private String operation;
    private final int argument;
    private boolean switched = false;

    public Day8CodeLine(final String codeLine){
        this.operation = codeLine.split(AocConstants.SPACE)[0];
        this.argument = Integer.parseInt(codeLine.split(AocConstants.SPACE)[1]);
    }

    @Override
    public String toString() {
        return "Day8CodeLine{" +
                "visited=" + visited +
                ", operation='" + operation + '\'' +
                ", argument=" + argument +
                "}";
    }

    public Day8CodeContext calculate(final Day8CodeContext ctx) throws Day8CodeRevisitedException {

        if(visited){
            throw new Day8CodeRevisitedException(ctx, this);
        }

        visited = true;

        switch(operation){
            case OP_ACC:
                ctx.updateAccumulator(argument);
                ctx.updateCursorPosition(DEFAULT_CURSOR_STEP);
                break;
            case OP_JMP:
                ctx.updateCursorPosition(argument);
                break;
            case OP_NOP:
                ctx.updateCursorPosition(DEFAULT_CURSOR_STEP);
                break;
            default:
                throw new UnsupportedOperationException(String.format("Operation '%s' is not supported (yet?)", operation));
        }

        return ctx;
    }

    public boolean switchOperation() {

        if(operation.equals(OP_JMP)){
            operation = OP_NOP;
            switched = !switched;
            return true;
        } else
        if(operation.equals(OP_NOP)){
            operation = OP_JMP;
            switched = !switched;
            return true;
        }

        return false;

    }

    public void reset(){
        this.visited = false;
        if(switched){
            switchOperation();
        }
    }
}
