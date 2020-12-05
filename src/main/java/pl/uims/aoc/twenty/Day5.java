package pl.uims.aoc.twenty;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day5 {

    private static final Long NOT_FOUND = -1L;

    private String intToStr(final int i){
        //B or R
        return i == 66 || i == 82 ? "1" : "0";
    }

    public long passToSeatID(final String boardingPass) {

        String boardingPassBinary = boardingPass.chars().mapToObj( this::intToStr ).collect(Collectors.joining());

        long row = Integer.parseInt(boardingPassBinary.substring(0, 7), 2);
        long col = Integer.parseInt(boardingPassBinary.substring(7), 2);

        return row * 8 + col;
    }

    public long findEmptySeatID(final List<String> boardingPasses){
        Set<Long> fullPlaneSeatIDs = Stream.iterate(0L, n -> n + 1L).limit(1023).collect(Collectors.toSet());

        boardingPasses.forEach(bp -> fullPlaneSeatIDs.remove(passToSeatID(bp)) );

        return fullPlaneSeatIDs.stream().filter(id -> !fullPlaneSeatIDs.contains(id-1) && !fullPlaneSeatIDs.contains(id+1)).findFirst().orElse(NOT_FOUND);
    }
}
