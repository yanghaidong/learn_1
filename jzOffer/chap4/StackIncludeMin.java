package jzOffer.chap4;

import java.util.LinkedList;

/**
 * 实现栈的数据结构，包含min方法可以以O(1)的时间复杂度获得栈中的最小值
 */
public class StackIncludeMin {

    /**
     * 每入栈一次，就与辅助栈顶比较大小，如果小就入栈，如果大就入栈当前的辅助栈顶
     * 当出栈时，辅助栈也要出栈
     * 这种做法可以保证辅助栈顶一定都当前栈的最小值
     */
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> stackMin = new LinkedList<>();
    public void push(int node) {
        stack.push(node);
        //辅助栈为空，必然添加元素
        if (stackMin.isEmpty() || node < stackMin.peek()){
            stackMin.push(node);
        }else {
            stackMin.push(stackMin.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        if (stack.isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        return stack.peek();
    }

    public int min() {
        if (stackMin.isEmpty()){
            throw new RuntimeException("栈为空！");
        }
       return stackMin.peek();
    }
}
