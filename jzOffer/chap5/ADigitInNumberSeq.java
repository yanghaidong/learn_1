package jzOffer.chap5;

/**
 * ������0123456789101112131415....�ĸ�ʽ���л��õ�һ���ַ������У�����������У���5λ����0��ʼ��������5����13λ��1����19λ��4���ȵȡ�
 * ��дһ���������������nλ��Ӧ������
 */
public class ADigitInNumberSeq {

    public int numAtSeq(int index) {
        if (index < 0) return 0;
        int i = 0;
        int sum = 0;
        while (true){
            //ͳ�Ƶ������λ��
            sum += countDigits(i);
            //����Ҫ����index
            if (sum > index) break;
            i++;
        }
        //-1��ʾ������
        return digitAt(i,sum-index-1);
    }

    private int digitAt(int value, int x) {
        return (value/(int)Math.pow(10,x))%10;
    }

    //ͳ�����ֵ�λ��
    private int countDigits(int number) {
        //�ж��䲻��Ϊ0���������
        if (number == 0) return 1;
        int count =0;
        while (number != 0){
            number = number/10;
            count++;
        }
        return count;
    }

    /**
     * ���Ŀ��ֵ�ڶ���λ���У�Ȼ���ټ�������λ��λ����
     * @param index
     * @return
     */
    public int numAtSeq2(int index) {
        if (index < 0) return 0;
        //��ʾλ��
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
        //��λ����ʼʱ0
        if (digit == 1) return 0;
        return (int) Math.pow(10,digit-1);
    }

    /**
     * ����λ���õ���Χ�ڵĸ���������1λ��0~9��10��
     * 2λ��10~99��90��
     * 3λ��100~999��900��
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
