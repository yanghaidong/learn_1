package jzOffer.chap6;

/**
 * ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��ΪS������n����ӡ��S�����п��ܵ�ֵ���ֵĸ��ʡ�
 */
public class printProbability {
    //����������չ����
    private int sideNum = 6;
    /**
     * �ݹ�
     * ���ں���СΪn������һ����СΪ6n - n + 1�����飨��n��6n�������Ӧ��λ�ü�¼���ִ���
     * ͨ���ݹ���������ӿ�ʼ��ǰ�ƣ����Ե�n�����ӵ���Ϊ1�Ļ���f(n,s)=f(n-1,s-1)������n�����ӵ���Ϊ2�Ļ���f(n,s)=f(n-1,s-2)�������������ơ���n-1�����ӵĻ����ϣ�������һ�����ӳ��ֵ�����Ϊs�Ľ��ֻ����6���������ô�У�

     �ݹ�ÿ�����ӵ�6�ֿ����ԣ����ݹ����ͳ��
     */
    public void printProbability(int n) {
        if (n < 1) return;
        //���ֵ
        int maxVal = n*sideNum;
        //��СΪn
        int[] countOfSum = new int[maxVal - n +1];
        //�ӵ�n�����ӿ�ʼ���ͳ�ʼֵΪ0�����ݽ�ȥ�������
        getProbabilities(n, n, 0, countOfSum);
        //�������
        int totalCount = (int) Math.pow(sideNum,n);
        for (int i=0;i<=maxVal-n;i++){
            System.out.println("s="+ (i+n) + ": " + countOfSum[i] +"/"+totalCount);
        }
    }

    private void getProbabilities(int n, int cur, int sum, int[] p) {
        //�ݹ���ֹ������ͳ�ƽ���
       if (cur == 0) p[sum-n]++;
       else for (int i=1;i<=sideNum;i++){
           getProbabilities(n, cur-1, sum+i, p);
       }
    }

    /**
     * ��̬�滮
     * * f(n,s)=f(n-1,s-1)+f(n-1,s-2)+f(n-1,s-3)+f(n-1,s-4)+f(n-1,s-5)+f(n-1,s-6) ��0< n<=6n
     *      * f(n,s)=0, s< n or s>6n
     * @param n
     */
    public void printProbabilityDP(int n) {
        if (n<1) return;
        int maxVal = n * sideNum;
        //����һ����ά���飬��ʾ���Ӻͺ͵Ĳ��У���ʾ����
        int[][] f = new int[n+1][maxVal+1];
        //��ʼ��һ���������ܳ��ֵ���Ӧ��������
        for (int i=1;i<=sideNum;i++){
            f[1][i] = 1;
        }
        //���ӴӶ���ʼ��n����
        for (int k=2;k<=n;k++){
            //���Ӻʹ�СΪk-6k,������k����n
            for (int sum=k;sum<=k*sideNum;sum++){
                //Ҫ��֤sum��СҪ����i�����ܽ���ѭ��
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
     * ��ʡ�ռ�Ķ�̬�滮
     * ��Ϊ�滮ֻ�������ǰ���йأ�����ֻ��Ҫ��¼ǰ��һ�����ۼƸ�������
     * ͨ��flag��1-flag�л�����У������Ҳ�Ǿ������һ�����ӵĽ��
     */
    public void printProbabilityBetterDP(int n) {
        if (n < 1) return;
        int maxVal = n*sideNum;
        //ֻ��Ҫ����
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
                //�������ֵ
                f[1-flag][sum] = s;
            }
            //����flag�е��л�
            flag = 1 - flag;
        }
        int total = (int) Math.pow(sideNum, n);
        for (int sum = n; sum <= maxVal; sum++) {
            // f(k, s)Ҳ����f[1-flag][sum], ��֮��flag = 1 -flag,���Ե���f[flag]���ܵõ�f(k, s)
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
