package jzOffer.chap2;

public class Fibonacci {

    /**
     * 低效递归法
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
     * 从下往上递归，相对高效
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
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 分析：我们可以认为n级台阶，最后一跳可以选择跳一阶或者跳两阶，
     * 如果跳一阶，则相当于前面n-1级台阶的跳法，跳两阶，则相当于前面n-2阶台阶的跳法
     * 因此第n阶相当于n-1的跳法加上n-2的跳法
     * 由于一个台阶只有一种跳法，两个台阶有两种跳法
     * 类推下去
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
     * 关于本题，前提是n个台阶会有一次n阶的跳法。分析如下:
     *
     * f(1) = 1
     *
     * f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
     *
     * f(3) = f(3-1) + f(3-2) + f(3-3)
     *
     * ...
     *
     * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)
     *
     *
     *
     * 说明：
     *
     * 1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。
     *
     * 2）n = 1时，只有1种跳法，f(1) = 1
     *
     * 3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)
     *
     * 4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，
     *
     *     那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)
     *
     *     因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)
     *
     * 5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：
     *
     *     f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)
     *
     *
     *
     * 6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：
     *
     *     f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
     *
     *     f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
     *
     *     可以得出：
     *
     *     f(n) = 2*f(n-1)
     *
     *
     *
     * 7) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：
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
     * 由上到下的递归
     * @param target
     * @return
     */
    public int JumpFloorII1(int target) {
        if (target <=0){return 0;}
        if (target == 1){return 1;}
        return 2*JumpFloorII1(target-1);
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
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
     * 通过减法获得原来的改变后的和，少用一个变量
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
