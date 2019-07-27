package jzOffer.chap5;

/**
 * 数字以0123456789101112131415....的格式序列化得到一个字符序列中，在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字
 */
public class ADigitInNumberSeq {

    public int numAtSeq(int index) {
        if (index < 0) return 0;
        int i = 0;
        int sum = 0;
        while (true){
            //统计到达的总位数
            sum += countDigits(i);
            //必须要大于index
            if (sum > index) break;
            i++;
        }
        //-1表示是索引
        return digitAt(i,sum-index-1);
    }

    private int digitAt(int value, int x) {
        return (value/(int)Math.pow(10,x))%10;
    }

    //统计数字得位数
    private int countDigits(int number) {
        //判断其不能为0的特殊情况
        if (number == 0) return 1;
        int count =0;
        while (number != 0){
            number = number/10;
            count++;
        }
        return count;
    }

    /**
     * 算出目标值在多少位数中，然后再计算在三位数位置中
     * @param index
     * @return
     */
    public int numAtSeq2(int index) {
        if (index < 0) return 0;
        //表示位数
        int digit = 1;
        while (true){
            int numbers = digit*numOfRange(digit);
            if (index < numbers) {
                return digitAt1(index, digit);
            }
            index -= numbers;
            digit++;
        }
    }

    private int digitAt1(int index, int digit) {
        int number = beginNumber(digit) + index/digit;
        return digitAt(number, digit - index % digit -1);
    }

    private int beginNumber(int digit) {
        //个位数开始时0
        if (digit == 1) return 0;
        return (int) Math.pow(10,digit-1);
    }

    /**
     * 根据位数得到范围内的个数，比如1位，0~9共10个
     * 2位，10~99共90个
     * 3位，100~999共900个
     * ...
     */
    private int numOfRange(int digit) {
        if (digit == 1) return 10;
        return (int) (9*Math.pow(10,digit-1));
    }

    public static void main(String[] args) {
        ADigitInNumberSeq a = new ADigitInNumberSeq();
        System.out.println(a.numAtSeq(1001));
        System.out.println(a.numAtSeq2(1001));
    }
}
