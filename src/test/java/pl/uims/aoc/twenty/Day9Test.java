package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.List;


class Day9Test {

    private final static List<Long> EXAMPLE_DATA = List.of(
            35L,
            20L,
            15L,
            25L,
            47L,
            40L,
            62L,
            55L,
            65L,
            95L,
            102L,
            117L,
            150L,
            182L,
            127L,
            219L,
            299L,
            277L,
            309L,
            576L
    );

    @Test
    public void testPart1Example1() {

        //given
        Day9 day9 = new Day9(EXAMPLE_DATA);

        //when
        Long result = day9.solvePart1(5);

        //then
        Assertions.assertEquals(127L, result);
    }

    @Test
    public void testPart1Solution() {

        //given
        Day9 day9 = new Day9(ResourcesService.getDay9PuzzleInput());

        //when
        Long result = day9.solvePart1(25);

        //then
        Assertions.assertTrue(result > 0);

        //correct: 3199139634
        System.out.printf("Day9 Part1 result is %d%n", result);
    }

    @Test
    public void testPart2Example1() {

        //given
        Long part1ExampleResult = 127L;
        Day9 day9 = new Day9(EXAMPLE_DATA);

        //when
        Long result = day9.solvePart2(5, part1ExampleResult);

        //then
        Assertions.assertEquals(62, result);
    }

    @Test
    public void testPart2Solution() {

        //given
        Long part1Result = 3199139634L;
        Day9 day9 = new Day9(ResourcesService.getDay9PuzzleInput());

        //when
        Long result = day9.solvePart2(25, part1Result);

        //then
        Assertions.assertTrue(result > 0);

        //correct: 438559930
        System.out.printf("Day9 Part2 result is %d%n", result);
    }

}