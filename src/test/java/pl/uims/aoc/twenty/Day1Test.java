package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.List;


class Day1Test {

    final List<Integer> EXAMPLE_DATA = List.of(1721, 979, 366, 299, 675, 1456);
    final List<Integer> PUZZLE_DATA = ResourcesService.getDay1PuzzleInput();

    @Test
    public void testPart1Example1() {

        //when
        Integer result = new Day1(EXAMPLE_DATA).calculatePart1();

        //then
        Assertions.assertEquals(514579, result);
    }

    @Test
    public void testPart2Example1() {

        //when
        Integer result = new Day1(EXAMPLE_DATA).calculatePart2();

        //then
        Assertions.assertEquals(241861950, result);
    }

    @Test
    public void testPart1Solution() {

        //when
        Integer result = new Day1(PUZZLE_DATA).calculatePart1();

        //then
        Assertions.assertNotEquals(0, result);

        //expected: 877971
        System.out.printf("Day1 Part1 result is %d%n", result);
    }

    @Test
    public void testPart2Solution() {

        //when
        Integer result = new Day1(PUZZLE_DATA).calculatePart2();

        //then
        Assertions.assertNotEquals(0, result);

        //expected: 203481432
        System.out.printf("Day1 Part2 result is %d%n", result);
    }

}