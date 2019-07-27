package jzOffer.chap2;


import java.util.Stack;

/**
 * ����ջʵ�ֶ���
 */
public class TwoStacksImplQueue {
    private Stack<Integer> a;
    private Stack<Integer> b;

    public TwoStacksImplQueue(){
        a = new Stack<Integer>();
        b = new Stack<Integer>();
    }

    public void push(int node){
        a.add(node);
    }

    /**
     *��ջ����һ��ջ������Ԫ�أ�Ȼ��ͨ����һ��ջ���ı�˳��
     * �����һջ����Ԫ�أ���ֱ���˳�
     * �������򽫵�һ��ջԪ���˵��ڶ�ջ
     * @return
     */
    public int pop(){
        if (a.isEmpty() && b.isEmpty()){
            throw new RuntimeException("����Ϊ��");
        }
        if (b.isEmpty()){
            while (!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }
    public static void main(String[] args) {
        TwoStacksImplQueue a = new TwoStacksImplQueue();
        a.push(54);
        a.push(55);
        a.push(56);
        System.out.println(a.pop());
        System.out.println(a.pop());
        a.push(53);
        System.out.println(a.pop());
        a.push(52);
        System.out.println(a.pop());
        System.out.println(a.pop());
    }
}
