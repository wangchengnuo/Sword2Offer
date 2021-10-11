package StackAndQueue;

import java.util.*;

public class CQueue {

    Deque<Integer> stackA;
    Deque<Integer> stackB;
    //剑指 Offer 09. 用两个栈实现队列
    public CQueue() {
        stackA = new LinkedList<>();
        stackB = new LinkedList<>();
    }

    public void appendTail(int value) {
        if (stackA.isEmpty()) {
            while(!stackB.isEmpty()){
                stackA.push(stackB.pop());
            }
            stackA.push(value);
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
            return;
        }
        while(!stackB.isEmpty()){
            stackA.push(stackB.pop());
        }
        stackA.push(value);
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public int deleteHead() {
        if (!stackA.isEmpty()) {
            return stackA.pop();
        }
        if (!stackB.isEmpty()) {
            return stackB.pop();
        }
        return -1;
    }
}
