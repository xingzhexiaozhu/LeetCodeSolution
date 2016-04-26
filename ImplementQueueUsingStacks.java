import java.util.Stack;

//题意描述：用栈来实现队列的插入、删除、获取和判空操作

//解题思路：用两个stack实现一个queue
//算法如下：
//堆栈s1和s2，s1用作入队，s2出队
//（1）判队满：如果s1满且s2不为空，则队满
//（2）判队空：如果s1和s2都为空，则队空
//（3）入队：首先判队满。
//    若队不满：1)栈s1若不满，则直接压入栈s1
//           2)若s1满，则将s1中的所有元素弹出到栈s2中，然后再将元素入栈s1
//（4）出队：1)若s2空就将s1中的所有元素弹出到栈s2中，然后出栈
//        2)s2不空就直接从s2中弹出元素

public class ImplementQueueUsingStacks {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!s2.isEmpty()) 
        	s2.pop();
        else{
        	while(!s1.isEmpty()) s2.push(s1.pop());
        	s2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!s2.isEmpty())
        	return s2.peek();
        else{
        	while(!s1.isEmpty())
        		s2.push(s1.pop());
        	return s2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
	
	public static void main(String[] args) {
		ImplementQueueUsingStacks s = new ImplementQueueUsingStacks();
		s.push(1);
		s.push(2);
		s.push(3);
		while(!s.empty()){
			System.out.println(s.peek());
			s.pop();
		}
	}

}
