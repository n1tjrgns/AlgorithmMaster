package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        /* 1
        * 1 1
        *1 2 1
        1 3 3 1
        * */

            for(int i=0;i<numRows;i++)
            {
                row.add(0, 1);
                for(int j=1;j<row.size()-1;j++) {
                    System.out.println(row);
                    row.set(j, row.get(j) + row.get(j + 1));

                    System.out.println( " row.get(j)+row.get(j+1) : " + row.get(j)+ "+" + +row.get(j+1));
                }
                allrows.add(new ArrayList<Integer>(row));
            }


        return allrows;
    }

    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        System.out.println(p.generate(4));
    }
}
