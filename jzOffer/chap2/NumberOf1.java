package jzOffer.chap2;


/**
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
public class NumberOf1 {
    /**
     * ����������������1������������1������λ��1������һλ�����Ƚ�
     * �������⣺��������ֵ����ͬ���ܻ������ѭ��
     * java����������λ�����
     *
     * <<      :     �����������num << 1,�൱��num����2
     *
     * >>      :     �����������num >> 1,�൱��num����2
     *
     * >>>    :     �޷������ƣ����Է���λ����λ����0����
     * �����������ƣ�Ч�ʸ��ڳ˳�
     * ����ʹ���޷������ƽ����ѭ������
     */
    public int numberOf1_1(int n) {
        int count = 0;
        while (n !=0){
          if ((n & 1) == 1){
             count++;

          }
            n = n >>> 1;
        }
        return count;
    }

    /**
     * ����ⷨ
     * �ֱ���ÿ��λ���ϵķ���λ���룬ÿ�γ���2����ζ������һλ
     * @param n
     * @return
     */
    public int numberOf1_2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((flag & n) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;

    }

    public int numberOf1_3(int n) {
        int count = 0;
        String binaryN = Integer.toBinaryString(n);
        char[] chars = binaryN.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i] == '1'){
                count++;
            }
        }
        return count;

    }
    /**
     * ���Žⷨ
     * ���һ������������1�����һ��Ϊ1�Ķ�����λ��Ϊ0����������0�Ļ�����ȫ����Ϊ1
     * ��������������������Ϊ0����һ����Ϊ1����������ͬ���Ĳ�����һֱ����Ϊ0ֹͣ
     * ��ôһ�������Ķ������ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ���
     * @param n
     * @return
     */
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = (n-1) & n;
        }
        return count;
    }
    /**
     * �ж�һ�������ǲ���2���������η���
     * ֱ��ͳ��1�ĸ����������Ƿ����1
     */
    public boolean isExponOf2(int n) {
        return numberOf1(n) == 1;
    }

    /**
     * ������������m��n��������Ҫ�ı�m�Ķ����Ʊ�ʾ�еļ�λ���ܵõ�n��
     * ����10�Ķ�������1010��13�Ķ�������1101������Ҫ�ı�3�Ρ�
     * @param m һ������
     * @param n ��һ������
     * @return ��Ҫ�ı��λ��
     */
    public int bitNumNeedsToBeChanged(int m, int n) {
        /**
         * �ؼ�����������������
         * �����ͬ��Ϊ1����ͬΪ0
         * & ���������Ϊ1��Ϊ1
         * | ���������Ϊ0ʱ��Ϊ0
         */

        return numberOf1(m ^ n);
    }
    public static void main(String[] args) {
        NumberOf1 n = new NumberOf1();
        System.out.println(n.numberOf1_1(9));
        System.out.println(n.numberOf1_2(9));
        System.out.println(n.numberOf1_3(9));
    }

    /**
     * �ܽ᣺
     * �������棺������ԣ����ݽṹ���㷨
     * ���ݽṹ
     * {�������������ַ�����Ƶ�ʸߣ�����ջ�Ͷ��У��ݹ���ã�
     * ���ң�������hash���ҺͶ��ֲ��ң������򣨿������򣩣��Ӵ��Ѷȣ�������}
     * ���Ը��Ը�ϰ��ʱ��Ӧ��ȥ������Щ֪ʶ��
     * ��������:�����⣬Ӧ���⣬�����
     */
}
