package Algorithm;

import java.util.LinkedList;

/**
 * @program: algorithmLearning
 * @description: 广度优先算法(BFS)
 * @author: cxr
 * @create: 2019-09-15 00:29
 **/
public class GuangDuYouXian {
    /*****重要组成-方向******/
    int[][] direct={{0,1},{0,-1},{-1,0},{1,0}};//四个方向，上下左右
    /*****重要组成-标记******/
    int[][] arc=new int[4][4];//辅助标记数组
    /******输入数组*****/
    int[][] array={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };
    public static void main(String[] args) throws InterruptedException {
        new GuangDuYouXian().BFS();
    }
    /*****重要组成-封装数组点，用坐标表示位置******/
    class Node{
        int row;
        int column;
        int round;
        Node(int row,int column,int round) {
            this.row=row;
            this.column=column;
            this.round=round;
        }
    }
    public void BFS(){//广度搜索算法
        Node start=new Node(0,0,0);
        /*****重要组成-待搜索队列的每个对象都是接下来要所搜的值******/
        LinkedList<Node> queue=new LinkedList<>();//待搜索队列
        queue.offer(start);
        arc[0][0]=1;
        /*****重要组成-持续搜索的标志。待搜索队列里有东西******/
        while(!queue.isEmpty()){
            Node temp=queue.poll();
            for(int i=0;i<4;i++){//尝试搜索四个方向的点，如果满足就加入待搜索队列中
                int new_row=temp.row+direct[i][0];
                int new_column=temp.column+direct[i][1];
                if(new_row<0||new_column<0||new_row>=4||new_column>=4)
                    continue;//该方向上出界，考虑下一方向
                if(arc[new_row][new_column]==1)continue;
                arc[new_row][new_column]=1;
                Node next=new Node(new_row, new_column,temp.round+1);
                queue.offer(next);
                System.out.println("数值："+array[new_row][new_column]+",轮次："+(temp.round+1));
            }
        }
    }
}
