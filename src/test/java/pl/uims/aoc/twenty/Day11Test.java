package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.stream.Stream;


class Day11Test {

    private char[][] EXAMPLE1_PUZZLE = Stream.of(
    "L.LL.LL.LL",
    "LLLLLLL.LL",
    "L.L.L..L..",
    "LLLL.LL.LL",
    "L.LL.LL.LL",
    "L.LLLLL.LL",
    "..L.L.....",
    "LLLLLLLLLL",
    "L.LLLLLL.L",
    "L.LLLLL.LL").map(String::toCharArray).toArray(char[][]::new);


    private char[][] EXAMPLE2_PUZZLE = Stream.of(
    ".......#.",
    "...#.....",
    ".#.......",
    ".........",
    "..#L....#",
    "....#....",
    ".........",
    "#........",
    "...#.....").map(String::toCharArray).toArray(char[][]::new);

    private char[][] EXAMPLE3_PUZZLE = Stream.of(
    ".##.##.",
    "#.#.#.#",
    "##...##",
    "...L...",
    "##...##",
    "#.#.#.#",
    ".##.##.").map(String::toCharArray).toArray(char[][]::new);


    @Test
    public void testPart1Example1() {

        //given
        int roundCount = 5;
        Day11 day11 = new Day11();

        //when
        int result = day11.doRounds(EXAMPLE1_PUZZLE, roundCount);

        //then
        Assertions.assertEquals(37, result);
    }

    @Test
    public void testPart1Example1Approach2() {

        //given
        Day11 day11 = new Day11();

        //when
        int result = day11.solvePart1(EXAMPLE1_PUZZLE);

        //then
        Assertions.assertEquals(37, result);
    }

    @Test
    public void testPart1Solution() {

        //given
        Day11 day11 = new Day11();

        //when
        int result = day11.solvePart1(ResourcesService.getDay11PuzzleInput());

        //then
        Assertions.assertTrue(result > 0);

        //correct: 2386
        System.out.printf("Day11 Part1 result is %d%n", result);
    }

    @Test
    public void testPart1SolutionPostGraduate() {

        //given
        Day11 day11 = new Day11();

        //when
        int result = day11.solvePart1(ResourcesService.getDay11PuzzleInput());

        //then
        Assertions.assertEquals(2386, result);
    }

    @Test
    public void testPart2Example1() {

        //given
        Day11.Part2LookupStrategy strategy = new Day11.Part2LookupStrategy();

        //when
        int result = strategy.count(EXAMPLE2_PUZZLE, 4, 3);

        //then
        Assertions.assertEquals(8, result);
    }

    @Test
    public void testPart2Example2() {

        //given
        Day11.Part2LookupStrategy strategy = new Day11.Part2LookupStrategy();

        //when
        int result = strategy.count(EXAMPLE3_PUZZLE, 3, 3);

        //then
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testPart2Example3() {

        //given
        Day11 day11 = new Day11();

        //when
        int result = day11.solvePart2(EXAMPLE1_PUZZLE);

        //then
        Assertions.assertEquals(26, result);
    }

    @Test
    public void testPart2Solution() {

        //given
        Day11 day11 = new Day11();

        //when
        int result = day11.solvePart2(ResourcesService.getDay11PuzzleInput());

        //then
        Assertions.assertTrue(result > 0);

        //correct: 2091
        System.out.printf("Day11 Part2 result is %d%n", result);
    }

    @Test
    public void testPart2SolutionPostGraduate() {

        //given
        Day11 day11 = new Day11();

        //when
        int result = day11.solvePart2(ResourcesService.getDay11PuzzleInput());

        //then
        Assertions.assertEquals(2091, result);
    }


}