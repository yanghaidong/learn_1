package jzOffer.chap3;

/**
 * ��������n����˳���ӡ��1������nλʮ����������������3�����ӡ1~999֮�����
 */
public class PrintFrom1ToNDigit {
    /**
     * �߽�
     * ����������ܴ��ڴ������⣬ͨ���ַ���ȥ�����������
     * @param n
     */
    public static void printFrom1ToMaxOfNDigit(int n) {
        if (n <=0){
            return;
        }
        int max = (int) Math.pow(10,n)-1;
        for (int i=1;i <= max;i++){
            System.out.println(i);
        }

    }

    /**
     *�������ʾ����
     * @param n
     */
    public static void printFrom1ToMaxOfNDigit_1(int n) {
        if (n <=0){
            return;
        }
        int[] number = new int[n];
        while(!increment(number,n)){
            printNumber(number);
        }

    }

    private static void printNumber(int[] number) {
        int len = number.length;
        boolean isStart = false;
        for (int i=0;i<len;i++){
            if (!isStart && number[i] != 0){
                isStart = true;
            }
            if (isStart){
                System.out.print(number[i]);
            }

        }
        System.out.println();
    }

    private static boolean increment(int[] number, int n) {
        boolean isOverflow = false;
        int nTakeOver = 1;
        for (int i=n-1;i>=0;i--){
            int sum = number[i] + nTakeOver;
//            if (i == n-1){
//                sum++;
//            }
            //����10
            if (sum >= 10){
                 if (i == 0){
                     isOverflow = true;
                 }else{
                     sum-=10;
                     number[i] = sum;
                 }
            }else {
                number[i]++;
                break;
            }
        }

        return isOverflow;
    }
    /**
     *���ַ�����ʾ����
     * @param n
     */
    public static void printFrom1ToMaxOfNDigit_2(int n) {
        if (n <=0){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++){
            sb.append('0');
        }
        while(!increment1(sb,n)){
            printNumber1(sb);
        }

    }

    private static void printNumber1(StringBuilder sb) {
        boolean isStart = false;
        for (int i=0;i<sb.length();i++){
            if (sb.charAt(i) != '0' && !isStart){
                isStart = true;
            }
            if (isStart){
                System.out.print(sb.charAt(i));
            }
        }
        System.out.println();
    }

    private static boolean increment1(StringBuilder sb, int n) {
        boolean isOverFlow = false;
        int Take = 1;
        for (int i=n-1;i>=0;i--){
            //���ַ�-'0'ת��Ϊ�ַ���,��ת��Ϊ����
            int sum = sb.charAt(i)-'0' + Take;
            if (sum >= 10){
                if (i==0){
                    isOverFlow = true;
                }else {
                    sum-=10;
                    sb.setCharAt(i,'0');
                }
            }else {
                //������ת��Ϊ�ַ�������ת��Ϊ�ַ�
                sb.setCharAt(i, (char)(sum+'0'));
                break;
            }
        }
        return isOverFlow;
    }
    public static void printFrom1ToMaxOfNDigit_3(int n){
        if (n<=0){
            return;
        }
        int[] number = new int[n];
        //�ݹ�����-1��ʼ����Ϊ�ݹ�����Ǵ�index+1��ʽ��ʼ
        printFrom1ToMaxOfNDigitRecursive(number,n,-1);
    }

    private static void printFrom1ToMaxOfNDigitRecursive(int[] number, int length, int index) {
        //��ֹ���������һλ
        if (index == length-1){
            printNumber(number);
            return;
        }
        for (int i=0;i<10;i++){
            number[index+1] = i;
            printFrom1ToMaxOfNDigitRecursive(number,length,index+1);
        }
    }

    public static void main(String[] args) {
//        printFrom1ToMaxOfNDigit(3);
        printFrom1ToMaxOfNDigit_3(2);

    }
}
