package jzOffer.chap3;

/**
 * 输入数字n，按顺序打印处1到最大的n位十进制数，比如输入3，则打印1~999之间的数
 */
public class PrintFrom1ToNDigit {
    /**
     * 边界
     * 这种情况可能存在大数问题，通过字符串去解决大数问题
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
     *用数组表示大数
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
            //超过10
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
     *用字符串表示大数
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
            //将字符-'0'转换为字符串,再转换为整数
            int sum = sb.charAt(i)-'0' + Take;
            if (sum >= 10){
                if (i==0){
                    isOverFlow = true;
                }else {
                    sum-=10;
                    sb.setCharAt(i,'0');
                }
            }else {
                //将整数转换为字符串，在转换为字符
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
        //递归计算从-1开始，因为递归过程是从index+1正式开始
        printFrom1ToMaxOfNDigitRecursive(number,n,-1);
    }

    private static void printFrom1ToMaxOfNDigitRecursive(int[] number, int length, int index) {
        //终止条件到最后一位
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
