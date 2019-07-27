package jzOffer.chap2;

public class RobotMove {
    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     */



    /**
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        if (rows<=0 || cols<=0 || threshold<0){
            return 0;
        }
        //构造一个标志矩阵
        boolean[] marked = new boolean[rows*cols];
        // boolean [][] isState= new boolean [rows][cols];
        return move(0,0,threshold,rows,cols,marked);
    }

    /**
     * 统计符合条件的位置个数
     *判断该位置没有出界的情况下，验证是否符合总和小于k值
     * 小于改变标志位，并进行下沿判断，
     * 不符合则返回累加的个数
     * @param row
     * @param col
     * @param threshold
     * @param rows
     * @param cols
     * @param marked
     * @return
     */
    private int move(int row, int col, int threshold, int rows, int cols, boolean[] marked) {
        int count=0;
        int index=row*cols+col;
       if (check(row,col,threshold,rows,cols,marked,index)){
           marked[index] = true;
           count = move(row-1,col,threshold,rows,cols,marked) + move(row+1,col,threshold,rows,cols,marked) + move(row,col-1,threshold,rows,cols,marked) + move(row,col+1,threshold,rows,cols,marked) + 1;

       }
       return count;
    }

    /**
     * 验证出界和k值以及标志位
     * @param row
     * @param col
     * @param threshold
     * @param rows
     * @param cols
     * @param marked
     * @param index
     * @return
     */
    private boolean check(int row, int col, int threshold, int rows, int cols, boolean[] marked,int index) {
        return row>=0 && row<rows && col>=0 && col<cols && !marked[index] && digitSum(row)+digitSum(col)<=threshold;
    }

    /**
     * 计算该数的每一位的数字和
     * @param number
     * @return
     */
    private int digitSum(int number) {
         int sum=0;
         while (number>0){
             sum+=number%10;
             number/=10;
         }
         return sum;
    }

    public static void main(String[] args) {
        System.out.println(395/100);
    }
}
