package pl.uims.aoc.twenty;

import java.util.List;

public class Day1 {

    private final List<Integer> data;

    public Day1(List<Integer> data) {
        this.data = data;
    }

    public Integer calculatePart1(){

        int rx = 0;
        int ry = 0;
        int rw = 0;

        int size = data.size();

        for(int x = 0; x< size; x++){
            for(int y=x;y<size;y++){
                if(data.get(x) + data.get(y) == 2020){
                    rx = data.get(x);
                    ry = data.get(y);
                    rw = data.get(x) * data.get(y);
                    break;
                }
            }
        }

        System.out.println(String.format("DAY1: %d + %d = 2020  -> %d * %d = %d", rx, ry, rx, ry, rw));

        return rw;
    }

    public Integer calculatePart2(){

        int rx = 0;
        int ry = 0;
        int rz = 0;
        int rw = 0;

        int size = data.size();

        for(int x = 0; x< size; x++){
            for(int y=x;y<size;y++){
                for(int z = 0; z< size; z++) {
                    if (data.get(x) + data.get(y) + data.get(z) == 2020) {
                        rx = data.get(x);
                        ry = data.get(y);
                        rz = data.get(z);
                        rw = data.get(x) * data.get(y) * data.get(z);
                        break;
                    }
                }
            }
        }

        System.out.println(String.format("DAY1.2: %d + %d + %d = 2020  -> %d * %d * %d = %d", rx, ry, rz, rx, ry, rz, rw));

        return rw;
    }

}
