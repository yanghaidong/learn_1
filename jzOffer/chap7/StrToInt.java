package jzOffer.chap7;

/**
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯����
 * ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 */
public class StrToInt {
    private static boolean valid;
    public static int StrToInt(String str) {
       if (str == null ||str.length() == 0 || str.trim().equals("")) return 0;
       boolean isNegitive = false;
       //����numberΪ�����ͣ���ֹ̫��
       long number = 0;
       for (int i=0;i<str.length();i++){
           //�����һ�������������ţ����Ÿı���������Ų��ù�
           if (i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')){
               if (str.charAt(i) == '-'){
                   isNegitive = true;
               }
               //ֻ��һ�����ţ�ʧЧ
               if (str.length() == 1){
                   return 0;
               }
               continue;
           }
           //�����һ�����Ų������֣�ֱ���˳�
           if (str.charAt(i) <'0' || str.charAt(i) > '9'){
               return 0;
           }
           //���÷���,�ó����
           int flag = isNegitive ? -1 : 1;
           //ע�⣺ֱ����ԭ�л����ϸ�ֵ,����������ֵļ���
           number = number*10 + flag*(str.charAt(i) - '0');
           //�жϳ��������½���
           if ((!isNegitive && number > Integer.MAX_VALUE) || (isNegitive && number < Integer.MIN_VALUE)){
               return 0;
           }

       }
        valid = true;
        return (int) number;
    }


    public static boolean flag;
    public static int StrToInt1(String str) {
        flag = false;
        //�ж������Ƿ�Ϸ�
        if (str == null || str.trim().equals("")) {
            flag = true;
            return 0;
        }
        // symbol=0,˵������Ϊ����;symbol=1������Ϊ����;start�������ֵ�һλ�Ƿ�Ϊ����λ
        int symbol = 0;
        int start = 0;
        char[] chars = str.trim().toCharArray();
        if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] == '-') {
            start = 1;
            symbol = 1;
        }
        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                flag = true;
                return 0;
            }
            int sum= result * 10 + (int) (chars[i] - '0');


            if((sum-(int) (chars[i] - '0'))/10!=result){
                flag=true;
                return 0;
            }

            result=result * 10 + (int) (chars[i] - '0');
            /*
             * ������Ϊjava���ŵ�һ�ж��Ƿ�����Ǵ���ģ��ٸ�����
             * ������Ϊvalue=2147483648ʱ���ڼ�����ڲ��ı�ʾӦ����-2147483648
             * ��Ȼvalue>Integer.MAX_VALUE�ǲ�������
             */
        }
        // ע�⣺java��-1��n�η������ã�(-1)^n .'^'�������
        // ע�⣬��value=-2147483648ʱ��value=-value
        result = (int) Math.pow(-1, symbol) * result;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(StrToInt("123"));
        System.out.println(StrToInt("-12"));
        System.out.println(StrToInt("+12"));
        System.out.println(StrToInt("+")+ " "+ StrToInt.valid);
        System.out.println(StrToInt("0")+ " "+ StrToInt.valid);
        System.out.println(StrToInt("12345678901112")+ " "+ StrToInt.valid);
    }
}
