package jzOffer.chap6;
/**
 * дһ������������������֮�ͣ�
 * Ҫ���ں������ڲ���ʹ��"+"��"-"��"x"��"��"����������š�
 */
public class Add {
    public int Add(int num1,int num2) {
        //num2��ʾ��λ��Ϊ0 �������λ
        while (num2 != 0){
            int temp = num1 ^ num2;  //��ʾ����λ��ӣ��ҳ�ֻ��һ��1�����
            num2 = (num1 & num2) << 1;  //��ʾ��λ������ҳ�����1�����
            num1 = temp;    //ѭ������
        }

        return num1;
    }

    /**
     * ��ʹ���µı�����������������ֵ
     * �Ӽ���
     * a = a + b;
     * b = a - b;
     * a = a - b;
     * ���
     * a = a ^ b;
     * b = a ^ b;
     * a = a ^ b;
     */


}
