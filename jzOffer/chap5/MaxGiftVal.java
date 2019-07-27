package jzOffer.chap5;

/**
 * ��һ��mxn�����̵�ÿһ�񶷷���һ�����ÿ�����ﶼ��һ���ļ�ֵ������0��
 * �����̵����Ͻǿ�ʼ��ÿ�ο������ұ߻����±��ƶ�һ��֪���������̵����½ǡ�
 * ����һ�����̺������������������������õ����ټ�ֵ������
 */
public class MaxGiftVal {
    /**
     * ���ݷ����ݹ����ÿ�������ֵ���������ֵ
     * @param gifts
     * @param rows
     * @param cols
     * @return
     */
    //ȫ�ֱ�����¼���ֵ������ʹ������
    private int max = 0;
    public int getMax(int[] gifts, int rows, int cols) {
         if (gifts == null || gifts.length == 0) return -1;
//         int[] max = {0};
         select(gifts, 0, 0, rows, cols, 0);
         return max;
    }

    private void select(int[] gifts, int row, int col, int rows, int cols, int value) {
        if (row >= rows || col>=cols) return;
        value += gifts[row*cols + col];
        if (row == rows-1 && col == cols-1){
            if (value > max) max = value;
        }
        select(gifts, row+1, col, rows, cols, value);
        select(gifts, row, col+1, rows, cols, value);

    }

    /**
     * ��̬�滮
     * /**
     *      * ����2����̬�滮������f(i,j)��ӵ�е������ֵ�������������
     *      * 1�������������f(i, j) = f(i, j -1) + gift(i, j)
     *      * 2�����ϱ�������f(i, j) = f(i -1, j) + gift(i, j)
     *      *
     *      * ��֤����ÿһ�����ӵõ��������ֵ֮�Ͷ������ģ�Ҳ����ȡmax[f(i, j-1), f(i-1, j)] +gift(i, j)
     *      * ���Է��֣�Ҫ֪����ǰ�����ܻ����������ֵ����Ҫ�õ���ǰ�������һ��������һ�����ӵ���������ֵ��
     *
     * @param gifts
     * @param rows
     * @param cols
     * @return
     */
    public int getMaxVal(int[] gifts, int rows, int cols) {
       if (gifts == null || gifts.length == 0) return 0;
       //����һ����¼���ֵ�Ķ�ά����
       int[][] maxVal = new int[rows][cols];
       for (int row=0;row<rows;row++){
           for (int col=0;col<cols;col++){
               //����������
               int up = 0;
               int left = 0;
               //���뱣֤������ʼλ����
               if (row > 0) up = maxVal[row-1][col];
               if (col > 0) left = maxVal[row][col-1];
               maxVal[row][col] = Math.max(up,left) + gifts[row*cols + col];

           }
       }
       return maxVal[rows-1][cols-1];
    }

    /**
     * һά����Զ�̬�滮���Ż�
     *
     *
     */
    public int getBetterMaxVal(int[] gifts, int rows, int cols) {
        if (gifts == null || gifts.length == 0) return 0;

        int[] maxVal = new int[cols];
        for (int row=0;row<rows;row++){
            for (int col=0;col<cols;col++){
                int left = 0;
                int up = 0;
                if (row > 0) up = maxVal[col];
                if (col > 0) left = maxVal[col-1];
                maxVal[col] = Math.max(up,left) + gifts[row*cols + col];
            }
        }
        //���ֻ����������һ�е���������ֵ
        return maxVal[cols-1];
    }
    public static void main(String[] args) {
        MaxGiftVal m = new MaxGiftVal();
        int[] gifts = {1, 10, 43, 23, 12, 2, 9, 6, 15, 7, 14, 1, 3, 7, 6, 5};
        System.out.println(m.getMax(gifts, 4, 4));
        System.out.println(m.getMaxVal(gifts, 4, 4));
        System.out.println(m.getBetterMaxVal(gifts, 4, 4));

    }
}
