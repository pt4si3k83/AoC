package pl.uims.aoc.nineteen;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day2Test {

    private final String PUZZLE_CODE =  "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,19,1,5,19,23,2,9,23,27,1,6,27,31,1,31,9,35,2,35,10,39,1,5,39,43,2,43,9,47,1,5,47,51,1,51,5,55,1,55,9,59,2,59,13,63,1,63,9,67,1,9,67,71,2,71,10,75,1,75,6,79,2,10,79,83,1,5,83,87,2,87,10,91,1,91,5,95,1,6,95,99,2,99,13,103,1,103,6,107,1,107,5,111,2,6,111,115,1,115,13,119,1,119,2,123,1,5,123,0,99,2,0,14,0";

    private Day2 day2 = new Day2();

    @Test
    public void testExampleSum1() {

        //given
        String testCode = "1,0,0,0,99";

        //when
        String compiledCode = day2.compile(testCode);

        //then
        Assertions.assertEquals("2,0,0,0,99", compiledCode);

    }

    @Test
    public void testExampleMultiplication1() {

        //given
        String testCode = "2,3,0,3,99";

        //when
        String compiledCode = day2.compile(testCode);

        //then
        Assertions.assertEquals("2,3,0,6,99", compiledCode);

    }

    @Test
    public void testExampleMultiplication2() {

        //given
        String testCode = "2,4,4,5,99,0";

        //when
        String compiledCode = day2.compile(testCode);

        //then
        Assertions.assertEquals("2,4,4,5,99,9801", compiledCode);

    }

    @Test
    public void testPart1Example1() {

        //given
        String testCode = "1,1,1,4,99,5,6,0,99";

        //when
        String compiledCode = day2.compile(testCode);

        //then
        Assertions.assertEquals("30,1,1,4,2,5,6,0,99", compiledCode);

    }

    @Test
    public void testPart1Example2() {

        //given
        String testCode = "1,9,10,3,2,3,11,0,99,30,40,50";

        //when
        String compiledCode = day2.compile(testCode);

        //then
        Assertions.assertEquals("3500,9,10,70,2,3,11,0,99,30,40,50", compiledCode);

    }

    @Test
    public void testPart1Solution() {

        //when
        String compiledCode = day2.compile(PUZZLE_CODE, 12, 2);

        //then
        Assertions.assertTrue(compiledCode != null);

        //correct: 3101844
        System.out.println(String.format("Day2 Part1 result is %s", compiledCode));

    }

    @Test
    public void testPart2BruteforceSolution() {

        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                String compiledCode = day2.compile(PUZZLE_CODE, noun, verb);

                if(compiledCode.split(",")[0].equals("19690720")){

                    System.out.println("NOUN: "+ noun+", VERB: " + verb + ", RESULT: " +  (100 * noun + verb));
                    return;
                }
            }

        }
        //NOUN: 84, VERB: 78, RESULT: 8478
        Assertions.fail("Couldn't find NOUN/VERB");


    }

}