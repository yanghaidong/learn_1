package jzOffer.chap2;

public class Fibonacci {

    /**
     * ��Ч�ݹ鷨
     */
    public int Fibonacci1(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return Fibonacci1(n-1) + Fibonacci1(n-2);
    }

    /**
     * �������ϵݹ飬��Ը�Ч
     */
    public int Fibonacci(int n) {
       int[] result = {0,1};
       if (n<2){
           return result[n];
       }
       int fn1 = 0,fn2 = 1,current = 0;
       for (int i=2;i<=n;i++){
           current = fn1+fn2;
           fn1 = fn2;
           fn2 = current;
       }
       return current;
    }

    /**
     * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
     * �����������һ��n����̨���ܹ��ж�����������
     * ���������ǿ�����Ϊn��̨�ף����һ������ѡ����һ�׻��������ף�
     * �����һ�ף����൱��ǰ��n-1��̨�׵������������ף����൱��ǰ��n-2��̨�׵�����
     * ��˵�n���൱��n-1����������n-2������
     * ����һ��̨��ֻ��һ������������̨������������
     * ������ȥ
     */
    public int JumpFloor(int target) {
       if (target <=0){return 0;}
       if (target ==1){return 1;}
       if (target ==2){return 2;}
       int fn1=1,fn2=2,current=0;
       for (int i=3;i<=target;i++){
           current = fn1 + fn2;
           fn1 = fn2;
           fn2 = current;

       }
       return current;
    }

    /**
     * ���ڱ��⣬ǰ����n��̨�׻���һ��n�׵���������������:
     *
     * f(1) = 1
     *
     * f(2) = f(2-1) + f(2-2)         //f(2-2) ��ʾ2��һ����2�׵Ĵ�����
     *
     * f(3) = f(3-1) + f(3-2) + f(3-3)
     *
     * ...
     *
     * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)
     *
     *
     *
     * ˵����
     *
     * 1�������f(n) �������n��̨����һ��1,2,...n�׵� ��������
     *
     * 2��n = 1ʱ��ֻ��1��������f(1) = 1
     *
     * 3) n = 2ʱ�������������÷�ʽ��һ��1�׻���2�ף���ع鵽�����⣨1�� ��f(2) = f(2-1) + f(2-2)
     *
     * 4) n = 3ʱ�������������÷�ʽ��1�ס�2�ס�3�ף�
     *
     *     ��ô���ǵ�һ������1�׺���ʣ�£�f(3-1);��һ������2�ף�ʣ��f(3-2)����һ��3�ף���ôʣ��f(3-3)
     *
     *     ��˽�����f(3) = f(3-1)+f(3-2)+f(3-3)
     *
     * 5) n = nʱ������n�����ķ�ʽ��1�ס�2��...n�ף��ó����ۣ�
     *
     *     f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
     *
     *
     *
     * 6) �������Ѿ���һ�ֽ��ۣ�����Ϊ�˼򵥣����ǿ��Լ����򻯣�
     *
     *     f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     *
     *     f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     *
     *     ���Եó���
     *
     *     f(n) = 2*f(n-1)
     *
     *
     *
     * 7) �ó����ս���,��n��̨�ף�һ����1��2��...n�׵����ķ�ʽʱ���ܵ�����Ϊ��
     *
     *               | 1       ,(n=0 )
     *
     * f(n) =     | 1       ,(n=1 )
     *
     *               | 2*f(n-1),(n>=2)
     */

    public int JumpFloorII(int target) {
        if (target <=0){return 0;}
        if (target == 1){return 1;}
        int fn = 0,fn1=1;
        for (int i=2;i<=target;i++){
            fn = 2*fn1;
            fn1 = fn;
        }
        return fn;
    }

    /**
     * fn=2^n-1
     * @param target
     * @return
     */

    public int JumpFloorII0(int target) {
        if (target <=0){return 0;}
        return (int)Math.pow(2,target-1);
    }

    /**
     * ���ϵ��µĵݹ�
     * @param target
     * @return
     */
    public int JumpFloorII1(int target) {
        if (target <=0){return 0;}
        if (target == 1){return 1;}
        return 2*JumpFloorII1(target-1);
    }

    /**
     * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
     * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
     * @param target
     * @return
     */
    public int RectCover(int target) {
       if (target <= 0){return 0;}
       if (target == 1){return 1;}
       if (target == 2){return 2;}
       int current=0,fn1=1,fn2=2;
       for (int i=3;i<=target;i++){
           current = fn1 + fn2;
           fn1 = fn2;
           fn2 = current;
       }
       return current;
    }

    /**
     * ͨ���������ԭ���ĸı��ĺͣ�����һ������
     * @param target
     * @return
     */
    public int RectCover0(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }

        int a = 1;
        int b = 2;
        while (target > 1) {
            b = a + b;
            a = b - a;
            target--;
        }
        return a;
    }
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.Fibonacci(10));
        System.out.println(fibonacci.Fibonacci1(10));
        System.out.println(fibonacci.JumpFloor(10));
        System.out.println(fibonacci.JumpFloorII(10));
        System.out.println(fibonacci.JumpFloorII0(10));
        System.out.println(fibonacci.JumpFloorII1(10));
        System.out.println(fibonacci.RectCover(10));
        System.out.println(fibonacci.RectCover0(10));
    }
}
