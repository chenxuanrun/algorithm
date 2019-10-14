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
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                int num=matrix[i][j];
                int middle = matrix.length / 2 ;
                int x = middle - j;
                int y = middle - i;
                if (set.contains(point(x,y))){
                    continue;
                }else {
                    int[] array=new int[4];
                    int tempX=x;
                    int tempY=y;
                    for (int index=0;index<array.length;index++){
                        array[index] =  matrix[middle-tempX][middle-tempY];
                        String newPoint = Transformation(tempX,tempY);
                        tempX=getX(newPoint);
                        tempY=getY(newPoint);
                    }
                    set.add(point(x,y));
                }
            }
        }
    }

    public String point(int x,int y){
        return new StringBuilder().append("(").append(x).append(",").append(y).append(")").toString();
    }

    public String Transformation(int x,int y){
        if (x<=0&&y>=0){
            int tem = 0;
            tem = y;
            y = -x ;
            x = tem;
        }else if (x>=0&&y>=0){
            int tem = 0;
            tem = y;
            y = -x;
            x = tem;
        }else if (x>=0&&y<=0){
            int tem = 0;
            tem = x;
            x = y;
            y = -tem;
        }else if (x<=0&&y<=0){
            int tem = 0;
            tem = y;
            x = y;
            y = -tem;
        }
        return new StringBuilder().append("(").append(x).append(",").append(y).append(")").toString();
    }
    public int getX(String point){
        point.replace("(","");
        point.replace(")","");
        String[] stringArr = point.split(",");
        return Integer.parseInt(stringArr[0]);
    }
    public int getY(String point){
        point.replace("(","");
        point.replace(")","");
        String[] stringArr = point.split(",");
        return Integer.parseInt(stringArr[1]);
    }
    }
    