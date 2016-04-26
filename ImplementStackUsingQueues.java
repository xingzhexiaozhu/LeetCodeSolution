import java.util.LinkedList;
import java.util.Queue;

//题意描述：用队列实现栈

//解题思路：用两个队列模拟一个堆栈：
//队列a和b
//（1）取栈顶元素： 返回有元素的队列的首元素
//（2）判栈空：若队列a和b均为空则栈空
//（3）入栈：a队列当前有元素，b为空（倒过来也一样）则将需要入栈的元素先放b中，然后将a中的元素依次出列并入列倒b中。（保证有一个队列是空的）
//（4）出栈：将有元素的队列出列即可。

//比如先将1插入队a中 ，现在要将2入栈，则将2插入b总然后将a中的1出列入到b中，b中的元素变为 2 ，1
//a为空，现在要压入3 则将3插入a中 ，依次将b中的2 ，1 出列并加入倒a中 ，a中的元素变为 3，2，1 b为空
//算法保证在任何时候都有一队列为空

public class ImplementStackUsingQueues {
	// Push element x onto stack.  
    Queue<Integer> q1 = new LinkedList<Integer>();  
    Queue<Integer> q2 = new LinkedList<Integer>();  
      
    public void push(int x) {  
        q1.offer(x);  
    }  
  
    // Removes the element on top of the stack.  
    public void pop() {  
        while(q1.size()>1) q2.offer(q1.poll());  
        q1.poll();  
        Queue<Integer> q = q1;  
        q1 = q2;  
        q2 = q;  
    }  
  
    // Get the top element.  
    public int top() {  
        while(q1.size()>1) q2.offer(q1.poll());  
        int x = q1.poll();  
        q2.offer(x);  
        Queue<Integer> q = q1;  
        q1 = q2;  
        q2 = q;  
        return x;  
    }  
  
    // Return whether the stack is empty.  
    public boolean empty() {  
        return q1.isEmpty();  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
