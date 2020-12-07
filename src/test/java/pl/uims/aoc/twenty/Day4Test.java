package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.uims.aoc.ResourcesService;

import java.util.List;
import java.util.Map;

class Day4Test {

    private List<Map<String,String>> PUZZLE_DATA = ResourcesService.getDay4PuzzleInput();
    private final Day4 day4 = new Day4();

    @Test
    public void testPart1Example() {

        //given
        List<Map<String,String>> data = ResourcesService.getDay4PuzzleExampleInput();

        //when
        boolean isPassport1Valid = day4.hasValidFields(data.get(0));
        boolean isPassport2Valid = day4.hasValidFields(data.get(1));
        boolean isPassport3Valid = day4.hasValidFields(data.get(2));
        boolean isPassport4Valid = day4.hasValidFields(data.get(3));

        //then
        Assertions.assertTrue(isPassport1Valid);
        Assertions.assertFalse(isPassport2Valid);
        Assertions.assertTrue(isPassport3Valid);
        Assertions.assertFalse(isPassport4Valid);

    }

    @Test
    public void testPart1Solution() {

        //when
        long result = PUZZLE_DATA.stream().filter(day4::hasValidFields).count();

        //then
        Assertions.assertTrue(result > 0);

        //correct: 264
        System.out.printf("Day4 Part1 result is %d%n", result);

    }

    @Test
    public void testPart2InvalidExamples() {

        //given
        List<Map<String,String>> data = ResourcesService.getDay4PuzzleExampleInvalidInput();

        //when
        boolean isPassport1Valid = day4.hasValidFieldsAndValues(data.get(0));
        boolean isPassport2Valid = day4.hasValidFieldsAndValues(data.get(1));
        boolean isPassport3Valid = day4.hasValidFieldsAndValues(data.get(2));
        boolean isPassport4Valid = day4.hasValidFieldsAndValues(data.get(3));

        //then
        Assertions.assertFalse(isPassport1Valid);
        Assertions.assertFalse(isPassport2Valid);
        Assertions.assertFalse(isPassport3Valid);
        Assertions.assertFalse(isPassport4Valid);

    }

    @Test
    public void testPart2ValidExamples() {

        //given
        List<Map<String,String>> data = ResourcesService.getDay4PuzzleExampleValidInput();

        //when
        boolean isPassport1Valid = day4.hasValidFieldsAndValues(data.get(0));
        boolean isPassport2Valid = day4.hasValidFieldsAndValues(data.get(1));
        boolean isPassport3Valid = day4.hasValidFieldsAndValues(data.get(2));
        boolean isPassport4Valid = day4.hasValidFieldsAndValues(data.get(3));

        //then
        Assertions.assertTrue(isPassport1Valid);
        Assertions.assertTrue(isPassport2Valid);
        Assertions.assertTrue(isPassport3Valid);
        Assertions.assertTrue(isPassport4Valid);

    }

    @Test
    public void testPart2Solution() {

        //when
        long result = PUZZLE_DATA.stream().filter(day4::hasValidFieldsAndValues).count();

        //then
        Assertions.assertTrue(result > 0);

        //correct: 224
        System.out.printf("Day4 Part2 result is %d%n", result);

    }



}