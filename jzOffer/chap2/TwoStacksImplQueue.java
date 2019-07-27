package jzOffer.chap2;


import java.util.Stack;

/**
 * 两个栈实现队列
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
     *出栈，将一个栈用来接元素，然后通过另一个栈来改变顺序
     * 如果另一栈存在元素，则直接退出
     * 不存在则将第一个栈元素退到第二栈
     * @return
     */
    public int pop(){
        if (a.isEmpty() && b.isEmpty()){
            throw new RuntimeException("队列为空");
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
