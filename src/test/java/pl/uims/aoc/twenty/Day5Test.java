package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.*;


class Day5Test {

    private Day5 day5 = new Day5();

    @Test
    public void testPart1Examples() {

        Assertions.assertEquals(567, day5.passToSeatID("BFFFBBFRRR"));
        Assertions.assertEquals(119, day5.passToSeatID("FFFBBBFRRR"));
        Assertions.assertEquals(820, day5.passToSeatID("BBFFBBFRLL"));
    }

    @Test
    public void testPart1Solution() {

        //given
        List<String> boardingPasses = ResourcesService.getDay5PuzzleInput();

        //when
        long result = boardingPasses.stream().map( day5::passToSeatID ).max(Long::compare).get();

        //then
        Assertions.assertTrue(result > 0);

        //correct: 996
        System.out.printf("Day5 Part1 result is %d%n", result);
    }

    @Test
    public void testPart2Solution() {

        //given
        List<String> boardingPasses = ResourcesService.getDay5PuzzleInput();

        //when
        long result = day5.findEmptySeatID(boardingPasses);

        //then
        Assertions.assertTrue(result > 0);

        //correct: 671
        System.out.printf("Day5 Part2 result is %d%n", result);
    }



}