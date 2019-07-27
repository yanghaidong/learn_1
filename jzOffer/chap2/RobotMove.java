package jzOffer.chap2;

public class RobotMove {
    /**
     * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ�񣬵��ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
     * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
        //����һ����־����
        boolean[] marked = new boolean[rows*cols];
        // boolean [][] isState= new boolean [rows][cols];
        return move(0,0,threshold,rows,cols,marked);
    }

    /**
     * ͳ�Ʒ���������λ�ø���
     *�жϸ�λ��û�г��������£���֤�Ƿ�����ܺ�С��kֵ
     * С�ڸı��־λ�������������жϣ�
     * �������򷵻��ۼӵĸ���
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
     * ��֤�����kֵ�Լ���־λ
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
     * ���������ÿһλ�����ֺ�
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
