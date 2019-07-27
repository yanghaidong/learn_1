package jzOffer.chap6;

/**
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 */
public class Multiply {
    /**
     * B[i] �ֳ���������
     * @param A
     * @return
     */
    //B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
    //�������� B[i]=A[0]*A[1]*...*A[i-1]
    //���ҵ�����B[i]*=A[i+1]*...*A[n-1]
    public int[] multiply(int[] A) {
      int len = A.length;
      int[] B = new int[len];
      B[0] = 1;
      //�����������˿��Ժ�����ã�
      for (int i=1;i<len;i++){
          B[i] = B[i-1] * A[i-1];
      }
      int temp = 1;
      //�����ǣ���������Ҳ������
      for (int j=len-2;j>=0;j--){
          temp*=A[j+1];
          B[j]*=temp;
      }

      return B;
    }
}
