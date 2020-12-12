package pl.uims.aoc.twenty;

import pl.uims.aoc.twenty.support.AocConstants;

import java.util.Arrays;

public class Day11 {

    private static final char FREE_SEAT = 'L';
    private static final char OCCUPIED_SEAT = '#';

    interface LookupStrategy {
        int count(final char[][] data, final int x, final int y);
        int getFreeSeatThreshold();
    }

    private abstract static class AbstractLookupStrategy implements LookupStrategy {

        protected static final int[][] DIRECTIONS = new int[][] {{-1, -1},
                { 0, -1},
                { 1, -1},
                {-1,  0},
                { 1,  0},
                {-1,  1},
                { 0,  1},
                { 1,  1}};

        private final int freeSeatThreshold;

        public AbstractLookupStrategy(int freeSeatThreshold) {
            this.freeSeatThreshold = freeSeatThreshold;
        }

        @Override
        public int getFreeSeatThreshold() {
            return freeSeatThreshold;
        }

        @Override
        public int count(char[][] data, int x, int y) {
            return Arrays.stream(DIRECTIONS)
                    .map(direction -> doCount(data, x, y, direction[0],  direction[1]))
                    .reduce(Integer::sum).orElse(AocConstants.I_ZERO);
        }

        abstract int doCount(final char[][] data, final int x, final int y, final int vx, final int vy);
    }


    public static class Part1LookupStrategy extends AbstractLookupStrategy {

        public Part1LookupStrategy() {
            super(4);
        }

        int doCount(final char[][] data, final int x, final int y, final int vx, final int vy) {
            try {
                return data[x+vx][y+vy] == OCCUPIED_SEAT ? 1 : 0;
            } catch(IndexOutOfBoundsException e){
                //well
            }
            return 0;
        }
    }

    public static class Part2LookupStrategy extends AbstractLookupStrategy {

        public Part2LookupStrategy() {
            super(5);
        }

        int doCount(final char[][] data, final int x, final int y, final int vx, final int vy) {

            int cx = x;
            int cy = y;

            while(true) {

                cx += vx;
                cy += vy;

                char c;

                try {
                    c = data[cx][cy];
                } catch(IndexOutOfBoundsException e){
                    return 0;
                }

                if(c == OCCUPIED_SEAT){
                    return 1;
                }

                if(c == FREE_SEAT){
                    return 0;
                }
            }
        }

    }

    public int doRounds(final char[][] data, int roundCount){

        char[][] d = data;

        do {
            d = swapSeats(d, new Part1LookupStrategy());
            roundCount--;
        } while (roundCount>0);

        return countOccupiedSeats(d);
    }

    public int solvePart1(final char[][] data){
        return doRoundsTillItsStable(data, new Part1LookupStrategy());
    }

    public int solvePart2(final char[][] data){
        return doRoundsTillItsStable(data, new Part2LookupStrategy());
    }

    private int doRoundsTillItsStable(final char[][] data, final LookupStrategy strategy){

        char[][] d = data;

        int prevOccupiedCount;
        int occupiedCount = -1;
        int rounds = 0;

        do {
            rounds++;
            prevOccupiedCount = occupiedCount;
            d = swapSeats(d, strategy);
            occupiedCount = countOccupiedSeats(d);

        } while (occupiedCount!=prevOccupiedCount);

        System.out.printf("Finishing after '%d' round(s).%n", rounds );

        return occupiedCount;
    }

    private int countOccupiedSeats(final char[][] data){

        int count = 0;
        for (char[] dataRow : data) {
            for (char charAt : dataRow) {
                count += charAt == OCCUPIED_SEAT ? 1 : 0;
            }
        }
        return count;
    }

    private char[][] swapSeats(final char[][] inputArray, final LookupStrategy strategy){

        char[][] data = new char[inputArray.length][inputArray[0].length];

        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data[x].length; y++) {

                if(inputArray[x][y] == FREE_SEAT && strategy.count(inputArray, x, y) == 0){
                    data[x][y] = OCCUPIED_SEAT;
                } else
                if(inputArray[x][y] == OCCUPIED_SEAT && strategy.count(inputArray, x, y) >= strategy.getFreeSeatThreshold()){
                    data[x][y] = FREE_SEAT;
                } else {
                    data[x][y] = inputArray[x][y];
                }
            }
        }

        return data;
    }
}
