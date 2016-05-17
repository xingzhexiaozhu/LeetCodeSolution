import java.util.Scanner;
import java.util.Stack;

//�������������һ��ջ����ջ֧��push,pop,top,getMin������Ҫ��ʵ��һ������ʱ���ڼ�������Сֵ�ķ���

public class MinStack {

	//����˼·����������ջ��һ����Ž�ջ���ݣ���һ�������СԪ��
	private Stack<Integer> dataStack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public MinStack() {}
    
    public void push(int x) {
        dataStack.push(x);
        //���minStack()Ϊ�ջ�����Ԫ�ر�mniStack()��ǰջ��Ԫ��С������Ԫ�ؽ�ջ
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
