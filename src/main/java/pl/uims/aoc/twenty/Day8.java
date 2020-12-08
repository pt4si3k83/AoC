package pl.uims.aoc.twenty;

import pl.uims.aoc.twenty.support.Day8CodeContext;
import pl.uims.aoc.twenty.support.Day8CodeLine;
import pl.uims.aoc.twenty.support.Day8CodeRevisitedException;

import java.util.List;
import java.util.stream.Collectors;

public class Day8 {

    private final List<Day8CodeLine> codeLines;

    public Day8(final List<String> inputData) {
        this.codeLines = inputData.stream().map(Day8CodeLine::new).collect(Collectors.toList());
    }

    public Integer runCode(){
        return runCode(false, null);
    }

    public Integer runCode(final boolean withAutoFix){
        return runCode(withAutoFix, null);
    }

    private Integer runCode(final boolean withAutoFix, final Day8CodeContext context){

        Day8CodeContext ctx = context != null ? context : new Day8CodeContext();

        while (ctx.getCursorPosition() < this.codeLines.size()) {

            try {
                ctx = codeLines.get(ctx.getCursorPosition()).calculate(ctx);
            } catch(Day8CodeRevisitedException ex) {
                return withAutoFix ? fixCodeAndRerun(ctx) : ctx.getAccumulator();
            }
        }

        return ctx.getAccumulator();
    }

    private Integer fixCodeAndRerun(final Day8CodeContext ctx) {

        this.codeLines.forEach(Day8CodeLine::reset);

        for (int i = ctx.wasRestarted() ? Math.min(ctx.getLastSwitchedCursorPosition()-1, ctx.getMaxCursorPosition()) : ctx.getMaxCursorPosition(); i >= 0; i--) {
            Day8CodeLine codeLine = codeLines.get(i);
            if(codeLine.switchOperation()){
                ctx.setLastSwitchedCursorPosition(i);
                ctx.restart();
                return runCode(true, ctx);
            }
        }

        return -1;

    }

}
