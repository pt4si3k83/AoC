package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.Arrays;
import java.util.List;


class Day6Test {

    private final List<String> EXAMPLE_LINES = Arrays.asList("abc", "", "a", "b", "c", "", "ab", "ac", "", "a", "a", "a", "a", "", "b");

    private final Day6 day6 = new Day6();

    @Test
    public void testPart1Example() {

        //when
        long result = day6.countGroups(EXAMPLE_LINES);

        //then
        Assertions.assertEquals(11, result);
    }


    @Test
    public void testPart1Solution() {

        //given
        final List<String> inputData = ResourcesService.getDay6PuzzleInput();

        //when
        long result = day6.countGroups(inputData);

        //then
        Assertions.assertTrue(result > 0);

        //correct: 6249
        System.out.printf("Day6 Part1 result is %d%n", result);
    }

    @Test
    public void testPart2Example() {

        //when
        long result = day6.countGroups2(EXAMPLE_LINES);

        //then
        Assertions.assertEquals(6, result);
    }

    @Test
    public void testPart2Solution() {

        //given
        final List<String> inputData = ResourcesService.getDay6PuzzleInput();

        //when
        long result = day6.countGroups2(inputData);

        //then
        Assertions.assertTrue(result > 0);

        //correct: 3103
        System.out.printf("Day6 Part2 result is %d%n", result);
    }

}