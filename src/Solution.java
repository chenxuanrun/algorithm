import java.util.HashSet;

/**
 * @program: algorithmDemo
 * @description: Solution
 * @author: cxr
 * @create: 2019-08-25 00:11
 **/
public class Solution {
    public void rotate(int[][] matrix) {
        HashSet set = new HashSet();
        for (int y=0;y<matrix.length;y++){
            for (int x=0;x<matrix.length;x++){
                if (set.contains(point(x,y))){
                    continue;
                }else {
                    int[] array=new int[4];
                    for (int i=0;i<array.length;i++){

                    }
                    set.add(point(x,y));
                }
            }
        }
    }
    public String point(int x,int y){
        return new StringBuilder().append("(").append(x).append(",").append(y).append(")").toString();
    }
    }
    