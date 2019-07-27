package jzOffer.chap4;

import java.util.LinkedList;

/**
 * ʵ��ջ�����ݽṹ������min����������O(1)��ʱ�临�ӶȻ��ջ�е���Сֵ
 */
public class StackIncludeMin {

    /**
     * ÿ��ջһ�Σ����븨��ջ���Ƚϴ�С�����С����ջ����������ջ��ǰ�ĸ���ջ��
     * ����ջʱ������ջҲҪ��ջ
     * �����������Ա�֤����ջ��һ������ǰջ����Сֵ
     */
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> stackMin = new LinkedList<>();
    public void push(int node) {
        stack.push(node);
        //����ջΪ�գ���Ȼ���Ԫ��
        if (stackMin.isEmpty() || node < stackMin.peek()){
            stackMin.push(node);
        }else {
            stackMin.push(stackMin.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            throw new RuntimeException("ջΪ�գ�");
        }
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        if (stack.isEmpty()){
            throw new RuntimeException("ջΪ�գ�");
        }
        return stack.peek();
    }

    public int min() {
        if (stackMin.isEmpty()){
            throw new RuntimeException("ջΪ�գ�");
        }
       return stackMin.peek();
    }
}
