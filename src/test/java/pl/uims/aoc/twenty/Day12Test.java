package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Day12Test {

    private static final List<String> EXAMPLE1_DATA = Stream.of(
            "F10",
            "N3",
            "F7",
            "R90",
            "F11").collect(Collectors.toList());

    @Test
    public void testPart1Example1() {

        //given
        Day12 day12 = new Day12();

        //when
        int result = day12.solvePart1(EXAMPLE1_DATA);

        //then
        Assertions.assertEquals(25, result);

    }

    @Test
    public void testPart1Solution() {

        //given
        Day12 day12 = new Day12();

        //when
        int result = day12.solvePart1(ResourcesService.getDay12PuzzleInput());

        //then
        Assertions.assertTrue(result > 0);

        //correct: 1838
        System.out.printf("Day12 Part1 result is %d%n", result);

    }

    @Test
    public void testPart1SolutionPostGraduate() {

        //given
        Day12 day12 = new Day12();

        //when
        int result = day12.solvePart1(ResourcesService.getDay12PuzzleInput());

        //then
        Assertions.assertEquals(1838, result);
    }

    @Test
    public void testPart2Example1() {

        //given
        Day12 day12 = new Day12();

        //when
        int result = day12.solvePart2(EXAMPLE1_DATA);

        //then
        Assertions.assertEquals(286, result);

    }

    @Test
    public void testPart2Solution() {

        //given
        Day12 day12 = new Day12();

        //when
        int result = day12.solvePart2(ResourcesService.getDay12PuzzleInput());

        //then
        Assertions.assertTrue(result > 0);

        //correct: 89936
        //to high: 183548
        System.out.printf("Day12 Part1 result is %d%n", result);

    }

    @Test
    public void testPart2SolutionPostGraduate() {

        //given
        Day12 day12 = new Day12();

        //when
        int result = day12.solvePart2(ResourcesService.getDay12PuzzleInput());

        //then
        Assertions.assertEquals(89936, result);
    }
}