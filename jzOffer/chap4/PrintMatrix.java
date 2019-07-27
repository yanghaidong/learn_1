package jzOffer.chap4;


import java.util.ArrayList;


/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ������
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
         if (matrix == null || matrix.length <= 0){
             return null;
         }
         //�����ĸ���������Ϊ�߽磬����任
         int left = 0;
         int right = matrix[0].length - 1;
         int top = 0;
         int bottem = matrix.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (left <= right && top <= bottem){
            // �������Ҵ�ӡ��һ��
            for (int col = left;col <= right;col++) {
                list.add(matrix[top][col]);
            }
            //������������У������϶��´�ӡ���ϵ���
            if (top < bottem){
                for (int row = top+1;row <= bottem;row++){
                    list.add(matrix[row][right]);
                }
            }
            //����������������У������¶��ϴ�ӡ�����һ��
            if (left < right && top < bottem){
               for (int col = right-1;col >= left;col--){
                list.add(matrix[bottem][col]);
               }
            }
            //���������������У���������Ҵ�ӡ�ڶ���
            if (left < right && top < bottem-1){
                //ѭ����ʱֹͣ�����ܰ�����ʼ��
                for (int row = bottem - 1;row > top;row--){
                    list.add(matrix[row][left]);
                }
            }
            //��СһȦ
            left++;
            right--;
            top++;
            bottem--;

        }
        return list;
    }
}
