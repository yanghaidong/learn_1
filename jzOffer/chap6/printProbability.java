package jzOffer.chap6;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为S。输入n，打印出S的所有可能的值出现的概率。
 */
public class printProbability {
    //常变量，扩展方便
    private int sideNum = 6;
    /**
     * 递归
     * 由于和最小为n，设置一个大小为6n - n + 1的数组（从n到6n），相对应的位置记录出现次数
     * 通过递归从最后的骰子开始往前推，所以第n个骰子点数为1的话，f(n,s)=f(n-1,s-1)，当第n个骰子点数为2的话，f(n,s)=f(n-1,s-2)，…，依次类推。在n-1个骰子的基础上，再增加一个骰子出现点数和为s的结果只有这6种情况！那么有：

     递归每个骰子的6种可能性，最后递归结束统计
     */
    public void printProbability(int n) {
        if (n < 1) return;
        //最大值
        int maxVal = n*sideNum;
        //最小为n
        int[] countOfSum = new int[maxVal - n +1];
        //从第n个骰子开始，和初始值为0，传递进去数组参数
        getProbabilities(n, n, 0, countOfSum);
        //计算概率
        int totalCount = (int) Math.pow(sideNum,n);
        for (int i=0;i<=maxVal-n;i++){
            System.out.println("s="+ (i+n) + ": " + countOfSum[i] +"/"+totalCount);
        }
    }

    private void getProbabilities(int n, int cur, int sum, int[] p) {
        //递归终止，骰子统计结束
       if (cur == 0) p[sum-n]++;
       else for (int i=1;i<=sideNum;i++){
           getProbabilities(n, cur-1, sum+i, p);
       }
    }

    /**
     * 动态规划
     * * f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6) ，0< n<=6n
     *      * f(n,s)=0, s< n or s>6n
     * @param n
     */
    public void printProbabilityDP(int n) {
        if (n<1) return;
        int maxVal = n * sideNum;
        //设置一个二维数组，表示骰子和和的并列，表示个数
        int[][] f = new int[n+1][maxVal+1];
        //初始化一个骰子所能出现的相应点数次数
        for (int i=1;i<=sideNum;i++){
            f[1][i] = 1;
        }
        //骰子从二开始，n结束
        for (int k=2;k<=n;k++){
            //骰子和大小为k-6k,上限是k不是n
            for (int sum=k;sum<=k*sideNum;sum++){
                //要保证sum大小要大于i，才能进行循环
                for (int i=1; sum>i&&i<=sideNum;i++){
                    f[k][sum] += f[k-1][sum-i];
                }
            }
        }
        int total = (int) Math.pow(sideNum,n);
        for (int i=n;i<=maxVal;i++){
            System.out.println("s=" + i + ":" + f[n][i] + "/" + total);
        }
    }
    /**
     * 更省空间的动态规划
     * 因为规划只与相近的前者有关，所以只需要记录前面一个的累计个数即可
     * 通过flag与1-flag切换相近行，最后结果也是经历最后一个骰子的结果
     */
    public void printProbabilityBetterDP(int n) {
        if (n < 1) return;
        int maxVal = n*sideNum;
        //只需要两行
        int[][] f = new int[2][maxVal+1];
        int flag = 0;
        for (int i=1;i<=sideNum;i++){
            f[flag][i] = 1;
        }
        for (int k=2;k<=n;k++){
            for (int sum=k;sum<=k*sideNum;sum++){
                int s = 0;
                for (int i=1;i<=sideNum&&sum>i;i++){
                    s += f[flag][sum-i];
                }
                //最后结果赋值
                f[1-flag][sum] = s;
            }
            //控制flag行的切换
            flag = 1 - flag;
        }
        int total = (int) Math.pow(sideNum, n);
        for (int sum = n; sum <= maxVal; sum++) {
            // f(k, s)也就是f[1-flag][sum], 但之后flag = 1 -flag,所以调用f[flag]才能得到f(k, s)
            System.out.println("s=" + sum + ": " + f[flag][sum] + "/" + total);
        }
    }
    public static void main(String[] args) {
        printProbability p = new printProbability();
//        p.printProbability(3);
//        System.out.println();
        p.printProbabilityDP(3);
        System.out.println();
        p.printProbabilityBetterDP(3);
    }
}
