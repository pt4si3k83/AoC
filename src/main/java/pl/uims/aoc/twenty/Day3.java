package pl.uims.aoc.twenty;

public class Day3 {

    private final char[][] data;

    public Day3(char[][] data) {
        this.data = data;
    }

    public int countTrees(final int right, final int down) {

        int x = 0;
        int m = data[0].length;
        int t = 0;

        for (int iy = 0; iy < data.length; iy += down) {

            if(iy!=0 && x < data[iy].length ) {
                if(data[iy][x] == '#'){
                    t++;
                }
               // data[iy][x] = data[iy][x] == '.' ? 'O' : 'X';
            }
            x+=right;
            x%=m;

            //System.out.println(data[iy]);
        }

        return t;
    }
}
