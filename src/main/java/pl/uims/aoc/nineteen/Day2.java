package pl.uims.aoc.nineteen;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day2 {

   // private final static Integer OP_SUM = 1;


    public String compile(final String inputCode, final Integer noun, final Integer verb) {

        Integer[] code = Arrays.stream(inputCode.split(",")).map(arg -> Integer.valueOf(arg)).toArray(Integer[]::new);

        code[1] = noun;
        code[2] = verb;

        compile(code);

        return Arrays.stream(code).map(arg -> String.valueOf(arg)).collect(Collectors.joining(","));

    }

    private void compile(final Integer[] code) {

        int argCount = code.length;

        int pos = 0;

        while(pos < argCount){

            //  System.out.println("--> GOT CODE: " + Arrays.deepToString(code) + " pos: " + pos);
            switch(code[pos]){
                case 1: //sum
                    pos += compileSum(pos, code);
                    break;
                case 2: //multiplication
                    pos += compileMulti(pos, code);
                    break;
                default:
                    pos = argCount;
                    break;
            }
            // System.out.println("<-- GOT CODE: " + Arrays.deepToString(code) + " pos: " + pos);
            //  System.out.println("-----------------------------------------------------------------------------");

        }

    }


    public String compile(final String inputCode) {

        Integer[] code = Arrays.stream(inputCode.split(",")).map(arg -> Integer.valueOf(arg)).toArray(Integer[]::new);

        compile(code);

        return Arrays.stream(code).map(arg -> String.valueOf(arg)).collect(Collectors.joining(","));
    }

    //private void validate()

    private int compileSum(int pos, Integer[] code){

    //    System.out.println("GOT SUM: " + Arrays.deepToString(Arrays.stream(code, pos, pos+4).toArray()) + " pos: " + pos);

        code[code[pos+3]] = code[code[pos+1]] + code[code[pos+2]];

        return 4;
    }

    private int compileMulti(int pos, Integer[] code){

     //   System.out.println("GOT MULTI: " + Arrays.deepToString(Arrays.stream(code, pos, pos+4).toArray()) + " pos: " + pos);

        code[code[pos+3]] = code[code[pos+1]] * code[code[pos+2]];

        return 4;
    }

}
