package Leatcode;

import java.util.HashSet;

/**
 * @program: algorithmLearning
 * @description: leEtcode_旋转图像
 * @author: cxr
 * @create: 2019-10-17 15:11
 **/
public class XuanZhuanTuXiang {
    public static void main(String[] args) {
        int[][] arr={{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
                if (j==arr.length-1){
                    System.out.println();
                }
            }
        }
        new XuanZhuanTuXiang().rotate(arr);
        System.out.println("----------------");
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
                if (j==arr.length-1){
                    System.out.println();
                }
            }
        }
    }
    public void rotate(int[][] matrix) {
        HashSet set = new HashSet();
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                int num=matrix[i][j];
                double middle = (matrix.length -1.0)/ 2.0 ;
                double x =  (j - middle);
                double y =  (middle - i);
                x=form(x);
                y=form(y);
                if (set.contains(point(x,y))){
                    continue;
                }else {
                    //维护值数组
                    int[] number=new int[4];
                    double tempX=x;
                    double tempY=y;
                    tempX=form(tempX);
                    tempY=form(tempY);
                    for (int index=0;index<number.length;index++){
                        number[index] =  matrix[(int) (middle-tempY)][(int) (middle+tempX)];
                        String newPoint = Transformation(tempX,tempY);
                        tempX=form(getX(newPoint));
                        tempY=form(getY(newPoint));
                    }
                    //维护位置数组
                    String[] position=new String[4];
                    tempX=x;
                    tempY=y;
                    tempX=form(tempX);
                    tempY=form(tempY);
                    for (int index=0;index<position.length;index++){
                        position[index]=new StringBuilder().append("(").append(tempX).append(",").append(tempY).append(")").toString();
                        String newPoint = Transformation(tempX,tempY);
                        tempX=form(getX(newPoint));
                        tempY=form(getY(newPoint));
                    }
                    //位置数组左移一位
                    String temp="";
                    for (int index=0;index<position.length;index++){
                        if (index==0){
                            temp=position[index];
                        }
                        if (index==position.length-1){
                            position[index]=temp;
                        }else {
                            position[index]=position[index+1];
                        }

                    }
                    //放入原数组
                    for (int index = 0;index<position.length ;index++){
                        String point = position[index];
                        double xPosition=  getX(point);
                        double yPosition= getY(point);
                        xPosition=form(xPosition);
                        yPosition=form(yPosition);
                        matrix[(int) (middle-yPosition)][(int) (middle+xPosition)]=number[index];
                        set.add(point);
                    }
                    for (int m=0;m<matrix.length;m++){
                        for (int n=0;n<matrix.length;n++){
                            System.out.print(matrix[m][n]+" ");
                            if (n==matrix.length-1){
                                System.out.println();
                            }
                        }
                    }
                    System.out.println("--------------");
                }
            }
        }
    }

    public String point(double x,double y){
        return new StringBuilder().append("(").append(x).append(",").append(y).append(")").toString();
    }

    public String Transformation(double x,double y){
        if (x<=0&&y>=0){
            double tem = 0;
            tem = y;
            y = -x ;
            x = tem;
        }else if (x>=0&&y>=0){
            double tem = 0;
            tem = y;
            y = -x;
            x = tem;
        }else if (x>=0&&y<=0){
            double tem = 0;
            tem = x;
            x = y;
            y = -tem;
        }else if (x<=0&&y<=0){
            double tem = 0;
            tem = y;
            x = y;
            y = -tem;
        }
        return new StringBuilder().append("(").append(x).append(",").append(y).append(")").toString();
    }
    public double getX(String point){
        point =point.replace("(","");
        point =point.replace(")","");
        String[] stringArr = point.split(",");
        return Double.parseDouble(stringArr[0]);
    }
    public double getY(String point){
        point= point.replace("(","");
        point=point.replace(")","");
        String[] stringArr = point.split(",");
        return Double.parseDouble(stringArr[1]);
    }
    //去0符号
    public double form(double num){
        String strNum=String.valueOf(num);
        strNum=strNum.replace("-0.0","0.0");
        return Double.parseDouble(strNum);
    }
    
}
