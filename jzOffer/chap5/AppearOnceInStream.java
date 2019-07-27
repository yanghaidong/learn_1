package jzOffer.chap5;

/**
 * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ������磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"�����Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
 */
public class AppearOnceInStream {
    private int index;
    private int[] count;

    public AppearOnceInStream(){
        count = new int[256];
        for (int i=0;i<256;i++){
            count[i] = -1;
        }
    }
    public void Insert(char ch)
    {
       if (count[ch] == -1) count[ch] = index;
       else if (count[ch] >= 0) count[ch] = -2;
       index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        //�������2��31�η�-1
        int minIndex = Integer.MAX_VALUE;
        char c = '#';
        for (int i=0;i<count.length;i++){
            //ÿ��ѭ����������ʱ��Ϊ�˱�֤��һ�γ���(��ĸ˳��ǰ�Ĳ�һ����һ�γ���)�����뱣֤��ǰ������С��С�ڼ�¼�µĵ�ǰ�����ſ������¸�ֵ
            if (count[i] >=0 && count[i] < minIndex){
                minIndex = count[i];
                c = (char)i;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        AppearOnceInStream a = new AppearOnceInStream();
        a.Insert('g');
        a.Insert('o');
        System.out.println(a.FirstAppearingOnce());
        a.Insert('o');
        a.Insert('g');
        a.Insert('l');
        a.Insert('e');
        System.out.println(a.FirstAppearingOnce());
    }
}
