package jzOffer.chap2;

/**
 * ����һ������Ϊn�����ӣ������Ӽ���m�Σ�m��n����������m > 1, n > 1��,m�����ӵĳ�����Ȼ����������m�����ӵĳ��ȳ˻����Ϊ���٣�
 * �������ӳ���Ϊ8�����ǿ��Էֳ�2�Ρ�3�Ρ�4��...8�Σ�ֻ�зֳ�3���ҳ��ȷֱ���2��3��3ʱ�ܵõ����˻�18
 */
public class CutString {
    /**
      * ��̬�滮����
      * ��̬�滮���������ĸ�������?
      ����һ����������Ž⣻?
      ���������������Ž��������ڸ�������������Ž⣻?
      ��С����֮�仹���໥�ص��ĸ�С�������⣻?
      �ܴ������·������⣬��������������⣻
      * ��̬�滮��
     ��һ�γ���Ϊn�����ӣ���������Ҫ����һ�����ҿ���ѡ���µ�һ���ĵط���1~n-1��Щ�ط������糤��Ϊ10�����ӣ��ҵ�һ��������1~9��Щ�ط��µ�����9�ַ�ʽ��
     ��һ����ȥ�����ӷֳ������֣�������i���µ������������־ͷֱ�Ϊ��[0~i]��[i~n]�����ȷ�Ϊ��ʾΪi��n-i����ô�ҳ���һ������ʵ�λ�ã���ʵ������i�����µ�������ʹ��[0~i]��[i~n]�ĳ˻���󣬺�����ʾΪ��f(n)=max(f(i)��f(n?i))f(n)=max(f(i)��f(n?i))��
     ��ô����ж�i��������أ����ʱ�����Ǿ�Ҫ֪����[0~i]������ȵ����ӣ����ⷽʽ�У����ĳ˻��Ƕ��٣�����˵��������Ҫ��һ������Ϊ10�����ӣ��г�1��9��4��6�����ַ�ʽ���ĸ��˻�����
     �ش𣺲���Ҫ���ǵ�һ�����������ӵĴ�С����Ҫ���ǵ�9��4��6�������������Ϊ��һ���г������ӳ����Ƿ�������еڶ�����ʹ���и���ĳ˻������罫9���г� 3��3��33��3��3��6�г� 4��24��2���ĸ�����
     ��������£����ǿ��Է��֣���������ô�У�һ����Խ��Խ�̣���ô�����Ƿ���Խ�С�ڸ������ȵ����ӵ�ÿһ�����ȵ����˻����������
     ��������Ϊ10�����ӣ����Ǿͼ����������1~9��9�ֳ��ȵ����ӣ�ÿ�ֳ��ȵ����˻��Ƕ��١�?
     Ҫ�󳤶�9�����ӵ����˻�������Ҫ֪��1~8�������ȵ����˻���Ҫ֪������8�����˻�����Ҫ֪��1~7���ȵĸ������˻����Դ����ơ�
      *
      * ��̬�滮�汾
      * f(n)����Ϊ������Ϊn�����ӷֳ����ɶκ�ĸ��γ��ȵ����˻������Ž⣩���ڼ���һ��ʱ��n-1�ּ�������ѡ����0 < i < n���µ�
      * ��i���µ����ֳɳ���Ϊi��������Ӻͳ���Ϊn-i���Ұ����ӣ��������������ӣ��������Ž�Ϊf(i)��f(n-i)������f(n) = max(f(i) * f(n-i))�������������˿����е����ֵ����f(n)�����Ž�
     * ���������ϵ��µķ���ȥ����������Ľ�����µ��ϡ��������f(2)��f(3)�����Ž⣬Ȼ�����������ֵ���f(4)��f(5)...ֱ��f(n)
     * f(2) = 1����Ϊֻ�ֳܷ�����
     * f(3) = 2����Ϊ�ֳ�����2*1 ���ڷֳ����ε�1*1*1
     * ...
     */
    public static int maxProductAfterCutting(int length) {
        if (length<2){
            return 0;
        }
        if (length==2){
            return 1;
        }
        if (length==3){
            return 2;
        }
        /**
         * ���һ�����ȣ���Ϊ��ʼ�Ǵ�1��ʼ
         * 123λ����ֱ�����ó��ȣ�4�Ժ�ѡ���������ֵ����֤���ֵ��Ψһ��
         */
        int[] products = new int[length+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i=4;i<=length;i++){
            int max = 0;
            //һ����Ч
            for (int j=1;j<=i/2;j++){
                //�õ�max{f(i)*f(n-i)}
                int product = products[j]*products[i-j];
                if (product > max){
                    max = product;
                }
            }
            //����f(n)���ֵ
            products[i] = max;
        }
        return products[length];

    }

    /**
     * ��ѧ֤����
     * 1����n<5ʱ�����ǻᷢ�֣�������ô���У��˻�product <= n��nΪ4ʱ��product���Ϊ2*2=4��
     * 2����n>=5ʱ������֤��2(n-2)>n����3(n-3)>n������3(n-3)>=2(n-2)����������Ӧ�þ����ܵض������Ϊ3�����ӶΡ�
     * ���ɾ����ܶ�ĳ���Ϊ3�ĶΣ�������������1��������һ��3�ṩ��1�����4��������˻�
     * @param length
     * @return
     */
    public static int maxProductAfterCutting2(int length) {
        if (length<2){
            return 0;
        }
        if (length==2){
            return 1;
        }
        if (length==3){
            return 2;
        }
        //�����ܵ��ҵ����Է�Ϊ���ٸ�����Ϊ3�Ķ�
        int countof3 = length/3;
        if (length%3 == 1){
            countof3--;
        }
        int countof2 = (length-countof3*3)/2;
        return (int)Math.pow(3,countof3)*(int)Math.pow(2,countof2);
    }
    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(8));
        System.out.println(maxProductAfterCutting2(8));
    }
}