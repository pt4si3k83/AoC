package pl.uims.aoc.twenty;

import pl.uims.aoc.twenty.support.Vector;

import java.util.List;

public class Day12 {

    private static final Vector VECTOR_N = new Vector(0,1);
    private static final Vector VECTOR_S = new Vector(0,-1);
    private static final Vector VECTOR_E = new Vector(1,0);
    private static final Vector VECTOR_W = new Vector(-1,0);

    public int solvePart1(final List<String> data) {

        Vector poz = new Vector(0,0);

        int rotation = 0;

        for(String inst : data){

            char command = inst.charAt(0);
            int operand = Integer.parseInt(inst.substring(1));

            switch(command){
                case 'N':
                    poz.add(new Vector(VECTOR_N, operand));
                    break;
                case 'S':
                    poz.add(new Vector(VECTOR_S, operand));
                    break;
                case 'W':
                    poz.add(new Vector(VECTOR_W, operand));
                    break;
                case 'E':
                    poz.add(new Vector(VECTOR_E, operand));
                    break;
                case 'R':
                    rotation -= operand;
                    rotation %= 360;
                    break;
                case 'L':
                    rotation += operand;
                    rotation %= 360;
                    break;
                case 'F':
                    Vector offset = new Vector(rotation);
                    offset.multiply(operand);
                    poz.add(offset);
                    break;

                default:
                    break;
            }

           // System.out.printf("%s -> %s %s %n", inst, poz, rotation);

        }

        return poz.getManhattanDistance();
    }

    public int solvePart2(final List<String> data) {

        Vector wp = new Vector(10,1);
        Vector poz = new Vector(0,0);

        for(String inst : data){

            char command = inst.charAt(0);
            int operand = Integer.parseInt(inst.substring(1));

            switch(command){
                case 'N':
                    wp.add(new Vector(VECTOR_N, operand));
                    break;
                case 'S':
                    wp.add(new Vector(VECTOR_S, operand));
                    break;
                case 'W':
                    wp.add(new Vector(VECTOR_W, operand));
                    break;
                case 'E':
                    wp.add(new Vector(VECTOR_E, operand));
                    break;
                case 'R':
                    wp.rotate(operand);
                    break;
                case 'L':
                    wp.rotate(-operand);
                    break;
                case 'F':
                    poz.add(new Vector(wp, operand));
                    break;

                default:
                    break;
            }

           // System.out.printf("%s -> pos: %s   wp: %s %n", inst, poz, wp);

        }

        return poz.getManhattanDistance();
    }
}
