package jzOffer.chap4;


import java.util.ArrayList;


/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
         if (matrix == null || matrix.length <= 0){
             return null;
         }
         //定义四个变量，作为边界，后面变换
         int left = 0;
         int right = matrix[0].length - 1;
         int top = 0;
         int bottem = matrix.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (left <= right && top <= bottem){
            // 从左向右打印第一行
            for (int col = left;col <= right;col++) {
                list.add(matrix[top][col]);
            }
            //如果至少有两行，则自上而下打印边上的列
            if (top < bottem){
                for (int row = top+1;row <= bottem;row++){
                    list.add(matrix[row][right]);
                }
            }
            //如果至少有两行两列，则自下而上打印最左边一行
            if (left < right && top < bottem){
               for (int col = right-1;col >= left;col--){
                list.add(matrix[bottem][col]);
               }
            }
            //若至少有三行两列，则从左向右打印第二行
            if (left < right && top < bottem-1){
                //循环及时停止，不能包括起始行
                for (int row = bottem - 1;row > top;row--){
                    list.add(matrix[row][left]);
                }
            }
            //缩小一圈
            left++;
            right--;
            top++;
            bottem--;

        }
        return list;
    }
}
