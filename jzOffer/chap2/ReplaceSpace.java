package jzOffer.chap2;

public class ReplaceSpace {
    /**
     * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
     * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
     */

    /**
     * ������һ�滻
     * @param str
     * @return
     */
    public String replaceSpace2(StringBuffer str) {
        if (str == null || str.length() ==0){
            return null;
        }
        for (int i=0;i < str.length();i++){
            if (str.charAt(i) == ' '){
                str.replace(i,i+1,"%20");
            }
        }
        return str.toString();
    }

    /**
     * ����stringbuffer����ԭ���޸ĵ�����
     * �ȹ�����Ͽո�λ�õ��³���
     * Ȼ������һλ��ʼ������
     * �����ո���ʼ�������ַ�
     * ֱ���ַ�����
     * @param str
     * @return
     */
    public String replaceSpace4(StringBuffer str) {
        if (str == null || str.length() ==0){
            return null;
        }
        int oldP = str.length()-1;
        int spaceNumber = 0;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                spaceNumber++;
            }
        }
        int newP = oldP + 2*spaceNumber;
        str.setLength(newP+1);
        //��֤���ַ���ָ����ڵ��ھ�ָ��
        while (oldP >= 0 && newP > oldP ){
            if (str.charAt(oldP) != ' '){
                str.setCharAt(newP,str.charAt(oldP));
                oldP--;
                newP--;

            }else {
                str.setCharAt(newP--,'0');
                str.setCharAt(newP--,'2');
                str.setCharAt(newP--,'%');
                oldP--;
            }
        }
        return str.toString();
    }
    /**
     * �⺯��
     * @param str
     * @return
     */
    public String replaceSpace3(String str) {
        return str.replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        ReplaceSpace rs = new ReplaceSpace();
        System.out.println(rs.replaceSpace2(new StringBuffer("We Are Happy")));
        System.out.println(rs.replaceSpace3("We Are Happy"));
        System.out.println(rs.replaceSpace4(new StringBuffer("We Are Happy")));

    }
}
