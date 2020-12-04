package pl.uims.aoc.twenty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


class Day4Test {

    private List<Map<String,String>> PUZZLE_DATA = readInput("D:/Programowanie/Java/Workspace/AoC2020Java/src/test/resources/2020_day4_input.txt");
    private final Day4 day4 = new Day4();

    @Test
    public void testPart1Example() {

        //given
        List<Map<String,String>> data = readInput("D:/Programowanie/Java/Workspace/AoC2020Java/src/test/resources/2020_day4_example_input.txt");

        //when
        boolean isPassport1Valid = day4.hasValidFields(data.get(0));
        boolean isPassport2Valid = day4.hasValidFields(data.get(1));
        boolean isPassport3Valid = day4.hasValidFields(data.get(2));
        boolean isPassport4Valid = day4.hasValidFields(data.get(3));

        //then
        Assertions.assertTrue(isPassport1Valid);
        Assertions.assertTrue(!isPassport2Valid);
        Assertions.assertTrue(isPassport3Valid);
        Assertions.assertTrue(!isPassport4Valid);

    }

    @Test
    public void testPart1Solution() {

        //when
        long result = PUZZLE_DATA.stream().filter( passport -> day4.hasValidFields(passport) ).count();

        //then
        Assertions.assertTrue(result > 0);

        //correct: 264
        System.out.println(String.format("Day4 Part1 result is %d", result));

    }

    @Test
    public void testPart2InvalidExamples() {

        //given
        List<Map<String,String>> data = readInput("D:/Programowanie/Java/Workspace/AoC2020Java/src/test/resources/2020_day4_example_inv_input.txt");

        //when
        boolean isPassport1Valid = day4.hasValidFieldsAndValues(data.get(0));
        boolean isPassport2Valid = day4.hasValidFieldsAndValues(data.get(1));
        boolean isPassport3Valid = day4.hasValidFieldsAndValues(data.get(2));
        boolean isPassport4Valid = day4.hasValidFieldsAndValues(data.get(3));

        //then
        Assertions.assertTrue(!isPassport1Valid);
        Assertions.assertTrue(!isPassport2Valid);
        Assertions.assertTrue(!isPassport3Valid);
        Assertions.assertTrue(!isPassport4Valid);

    }

    @Test
    public void testPart2ValidExamples() {

        //given
        List<Map<String,String>> data = readInput("D:/Programowanie/Java/Workspace/AoC2020Java/src/test/resources/2020_day4_example_val_input.txt");

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
        long result = PUZZLE_DATA.stream().filter( passport -> day4.hasValidFieldsAndValues(passport) ).count();

        //then
        Assertions.assertTrue(result > 0);

        //correct: 224
        System.out.println(String.format("Day4 Part2 result is %d", result));

    }

    private List<Map<String,String>> readInput(final String filePath) {
        final List<Map<String,String>> passports = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            Map<String,String> map = new HashMap<>();

            while (line != null) {
                if(line.length() == 0){
                    passports.add(map);
                    map = new HashMap<>();
                } else {
                    map.putAll(Arrays.stream(line.split(" ")).map( entry -> entry.split(":")).collect(Collectors.toMap( entry -> entry[0], entry -> entry[1])));
                }

                line = reader.readLine();
            }
            reader.close();

            if(!map.isEmpty()){
                passports.add(map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return  passports;
    }

}