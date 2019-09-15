package Example;

import java.util.Scanner;

/**
 * @program: algorithmDemo
 * @description: Example.Example1
 * @author: cxr
 * @create: 2019-09-14 15:10
 **/
public class Example1 {
    //在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，四种方向的直线连续D个数字的和里面最大的值
    public static void main1() {
        Scanner scanner=new Scanner(System.in);
        int range=0;
        String firstLine=scanner.nextLine();
        String[] firstLineParam=firstLine.split(" ");
        int arrSize=Integer.parseInt(firstLineParam[0]);
        int allCount=Integer.parseInt(firstLineParam[1]);
        int[][] arr=new int[arrSize][arrSize];
        for (int i=0;i<arrSize;i++){
            String hang=scanner.nextLine();
            String[] lie=hang.split(" ");
            for (int j=0;j<arrSize;j++){
                arr[i][j]=Integer.parseInt(lie[j]);
            }
        }
        int sum=0;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                //横,先往左扫描
                int count=0;
                int index=0;
                int sumUnit=0;
                int point1 = i;
                int point2 = j;
                while (count<allCount){
                    int temp=count;
                    if (point2-count>=0){
                        sumUnit+=arr[i][j-index];
                        count++;
                        index++;
                        if (point2-count<0){
                            index=1;
                        }
                    }else if (point2+index<arrSize){
                        sumUnit+=arr[i][j+index];
                        count++;
                        index++;
                    }
                    if (temp==count){
                        break;
                    }
                }
                if (sumUnit>sum){
                    sum=sumUnit;
                }
                //竖,先往上扫描
                count=0;
                index=0;
                sumUnit=0;
                point1 = i;
                point2 = j;
                while (count<allCount){
                    int temp=count;
                    if (point1-count>=0){
                        sumUnit+=arr[i-index][j];
                        count++;
                        index++;
                        if (point1-count<0){
                            index=1;
                        }
                    }else if (point1+index<arrSize){
                        sumUnit+=arr[i+index][j];
                        count++;
                        index++;
                    }
                    if (temp==count){
                        break;
                    }
                }
                if (sumUnit>sum){
                    sum=sumUnit;
                } //左上,先往左上扫描
                count=0;
                sumUnit=0;
                index=0;
                point1 = i;
                point2 = j;
                while (count<allCount){
                    int temp=count;
                    if (point1-count>=0&&point2-count>=0){
                        sumUnit+=arr[i-index][j-index];
                        count++;
                        index++;
                        if (point1-count<0||point2-count<0){
                            index=1;
                        }
                    }else if (point1+index<arrSize&&point2+index<arrSize){
                        sumUnit+=arr[i+index][j+index];
                        count++;
                        index++;
                    }
                    if (temp==count){
                        break;
                    }
                }
                if (sumUnit>sum){
                    sum=sumUnit;
                } //右上,先往右上扫描
                count=0;
                index=0;
                sumUnit=0;
                point1 = i;
                point2 = j;
                while (count<allCount){
                    int temp=count;
                    if (point1-count>=0&&point2+count<arrSize){
                        sumUnit+=arr[i-index][j+index];
                        count++;
                        index++;
                        if (point1-count<0||point2+count>=arrSize){
                            index=1;
                        }
                    }else if (point1+index<arrSize&&point2-index>=0){
                        sumUnit+=arr[i+index][j-index];
                        count++;
                        index++;
                    }
                    if (temp==count){
                        break;
                    }
                }
                if (sumUnit>sum){
                    sum=sumUnit;
                }
            }
        }
        System.out.println(sum);
    }
}
