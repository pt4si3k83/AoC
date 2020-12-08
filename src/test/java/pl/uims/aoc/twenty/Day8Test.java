package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.List;

class Day8Test {

    private final List<String> EXAMPLE_DATA = List.of(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6"
    );

    @Test
    public void testPart1Example(){

        //given
        Day8 day8 = new Day8(EXAMPLE_DATA);

        //when
        Integer result = day8.runCode();

        //then
        Assertions.assertEquals(5, result);

    }

    @Test
    public void testPart1Solution(){

        //given
        Day8 day8 = new Day8(ResourcesService.getDay8PuzzleInput());

        //when
        Integer result = day8.runCode();

        //then
        Assertions.assertTrue(result > 0);

        //correct: 1501
        System.out.printf("Day8 Part1 result is %d%n", result);

    }

    @Test
    public void testPart2Example(){

        //given
        Day8 day8 = new Day8(EXAMPLE_DATA);

        //when
        Integer result = day8.runCode(true);

        //then
        Assertions.assertEquals(8, result);

    }

    @Test
    public void testPart2Solution(){

        //given
        Day8 day8 = new Day8(ResourcesService.getDay8PuzzleInput());

        //when
        Integer result = day8.runCode(true);

        //then
        Assertions.assertTrue(result > 0);

        //correct: 509
        //too high: 826
        System.out.printf("Day8 Part2 result is %d%n", result);

    }
}