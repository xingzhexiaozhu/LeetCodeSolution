import java.util.Stack;

//������������ջ��ʵ�ֶ��еĲ��롢ɾ������ȡ���пղ���

//����˼·��������stackʵ��һ��queue
//�㷨���£�
//��ջs1��s2��s1������ӣ�s2����
//��1���ж��������s1����s2��Ϊ�գ������
//��2���жӿգ����s1��s2��Ϊ�գ���ӿ�
//��3����ӣ������ж�����
//    ���Ӳ�����1)ջs1����������ֱ��ѹ��ջs1
//           2)��s1������s1�е�����Ԫ�ص�����ջs2�У�Ȼ���ٽ�Ԫ����ջs1
//��4�����ӣ�1)��s2�վͽ�s1�е�����Ԫ�ص�����ջs2�У�Ȼ���ջ
//        2)s2���վ�ֱ�Ӵ�s2�е���Ԫ��

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
