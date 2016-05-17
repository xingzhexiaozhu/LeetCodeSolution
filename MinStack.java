import java.util.Scanner;
import java.util.Stack;

//题意描述：设计一个栈，该栈支持push,pop,top,getMin方法，要求实现一个常量时间内检索出最小值的方法

public class MinStack {

	//解题思路：借用两个栈，一个存放进栈数据，另一个存放最小元素
	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public MinStack() {}
    
    public void push(int x) {
        dataStack.push(x);
        //如果minStack()为空或者新元素比mniStack()当前栈顶元素小，则新元素进栈
        if(minStack.empty() || ((!minStack.empty())&&x<=minStack.peek()))
        	minStack.push(x);
    }
    
    public void pop() {
        if(!dataStack.empty()){
        	if(minStack.peek().equals(dataStack.peek()))
        		minStack.pop();
        	dataStack.pop();
        }
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
	
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(-2);
		ms.push(0);
		ms.push(-3);
		System.out.println(ms.getMin());
		
		ms.pop();
		System.out.println(ms.top());
		System.out.println(ms.getMin());
	}

}
