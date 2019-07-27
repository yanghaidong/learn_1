package jzOffer.chap5;

/**
 * ����һ������n����1~n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
 * ��������12, 1~12�г���1����1��10��11��12��5��
 */
public class NumberOfOne {
    /**
     * ���淽��
     * ����ÿ��������1�ĸ��������Ӷ�O(nlgn)
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
       if (n == 0) return 0;
       int count = 0;
       for (int i=1;i<=n;i++){
          count += Numof1(i);
       }
       return count;
    }

    /**
     * ���Ӷ�O(lgn)
     * @param number
     * @return
     */
    private static int Numof1(int number) {
        int count = 0;
        while (number > 0){
            if (number%10 == 1){
                count++;
            }
            number = number/10;
        }
        return count;
    }

    /**
     * ���ַ���ƴ����������Ȼ����
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution1(int n) {
        if (n == 0) return 0;
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=n;i++){
            sb.append(i);
        }
        int count = 0;
        for (int j=0;j<sb.length();j++){
            if (sb.charAt(j) == '1'){
                count++;
            }
        }
        return count;
    }

    /**
     * ���������������⣬���ǿ���ͨ�������ܽ�����ȡ��صĶ�����
     *
     * ���ȿ����ȷ��ࣺ
     *
     * ��λ
     * ����֪���ڸ�λ���ϣ�1��ÿ��10����һ�Σ�����1��11��21�ȵȣ����Ƿ�����10Ϊһ�����ݵĻ���ÿһ�������Ľ������涼��һ��1����������22������10Ϊ��������������ݣ�����������0-9��10-19֮�ж���һ��1������19֮����һ���������Ľ��ݣ�������Ҫȥ�ж���������л᲻�����1�����ƶ�֪�����������¶�����Ĳ���С��1���򲻿��ܳ���1��������ɻ�����������Ҳ��������
     *
     * ���ǿ��Թ��ɸ�λ��1���ֵĸ���Ϊ��
     *
     * n/10 * 1+(n%10!=0 ? 1 : 0)
     *
     * ʮλ
     * ����˵ʮλ����ʮλ���ϳ���1�����Ӧ����10-19����Ȼ���÷�����λ��ʱ��Ľ������ۣ�����֪��10-19��������ÿ��100����һ�Σ�������ǵĽ�����100����������317�������н���0-99��100-199��200-299�����������ݣ�ÿһ�ν������涼�����10��1����10-19����������¶�������Ƕβ������Ľ��ݡ����ǿ������¶������������19����ôֱ����10��1�����ˣ���Ϊ10-19�϶�����֣����С��10����ô�϶��������ʮλ����1�������10-19֮��ģ����Ǽ�����Ӧ����k - 10 + 1���������Ƿ���300-317��17�����֣�1���ֵĸ���Ӧ����17-10+1=8����
     *
     * ��ô���ڿ��Թ��ɣ�ʮλ��1���ֵĸ���Ϊ��
     *
     * ��k = n % 100����Ϊ���������ݶε�����
     * ����ʽΪ��(n / 100) * 10 + (if(k > 19) 10 else if(k < 10) 0 else k - 10 + 1)
     * ��λ
     * ����˵��λ1������֪���ڰ�λ��100-199������ְ�λ1��һ������100�Σ����ݼ��Ϊ1000��100-199��������ÿ��1000�ͻ����һ�Ρ���μ������ǵ���Ϊ2139��������˼��һ�£���������� * ����������1�ڰ�λ���ֵĸ�������n/1000 * 100�õ�ǰ����������1�ĸ�������ô����©�����Ĳ���139����������˼�룬������������k199���õ�100����λ1��100<=k<=199��õ�k - 100 + 1����λ1��
     *
     * ��ô�������ɰ�λ�ϳ���1�ĸ�����
     *
     * ��k = n % 1000
     * ����ʽΪ��(n / 1000) * 100 + (if(k >199) 100 else if(k < 100) 0 else k - 100 + 1)
     * �������������....
     *
     * �ٴλع˸�λ
     * ���ǰѸ�λ������1�ĸ�����ʽ��Ҳ�������ʽ��
     *
     * k = n % 10
     * ��λ����1�ĸ���Ϊ��n / 10 * 1 + (if(k > 1) 1 else if(k < 1) 0 else k - 1 + 1)
     * ����������ʽ�������Ѿ��ܹ����ˡ� ��һ��������Ĺ��ɣ���iΪ����1���ڵ�λ����i=1��ʾ�����λ����1�ĸ�����10��ʾ����ʮλ����1�ĸ����ȵȡ�
     *
     * k = n % (i * 10)
     * count(i) = (n / (i * 10)) * i + (if(k > i * 2 - 1) i else if(k < i) 0 else k - i + 1)
     * ���ˣ�������10��10��n�η��Ĺ��ɾ�����ˡ�
     *
     * sum1 = sum(count(i))��i = Math.pow(10, j), 0<=j<=log10(n)
     * ������һ���ط�ֵ������ע��ģ����Ǵ���ļ�����������ж��ifelse��̫�ã��ܲ��ܽ�һ�����أ� ���ǿ��԰Ѻ��μ򻯳����������ǲ�ȥ����i * 2 - 1�ˣ�����ֻ�豣֤k - i + 1��[0, i]�����ھ����ˣ������ο���д������
     *
     * min(max((n mod (i*10))?i+1,0),i)
     *
     *
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution2(int n) {
        if (n == 0) return 0;
        int count = 0;
        //���ǵ�����n����ʮ������1��10�����Ա�ȻҪ�е���
        for (long i=1;i<=n;i=i*10){
            long diviver = i*10;
            count += n/diviver*i + Math.min(Math.max(n%diviver-i+1,0),i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(13));
        System.out.println(NumberOf1Between1AndN_Solution1(13));
        System.out.println(NumberOf1Between1AndN_Solution2(13));
    }
}