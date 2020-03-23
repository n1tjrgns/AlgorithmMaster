package leetcode.easy.stack;

import java.util.Stack;
//https://leetcode.com/problems/min-stack/
/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.*/
class MinStack {

    //초기 값을 설정하기 위한 MAX_VALUE
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {

        if( x <= min){
            stack.push(min); // 2147483647, -2
            min = x;    // -2, -3
        }
        stack.push(x);  //-2, 0, -3
        System.out.println(stack);
    }

    public void pop() {
        int peek = stack.pop();
        if(peek == min){
            min = stack.pop();
        }
    }

    public int top() {
        System.out.println(stack.peek());
        return stack.peek();
    }

    public int getMin() {
        System.out.println(min);
        return min;
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        m.getMin();
        m.pop();
        m.top();
        m.getMin();
    }
}

