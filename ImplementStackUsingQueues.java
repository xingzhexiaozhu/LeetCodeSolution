import java.util.LinkedList;
import java.util.Queue;

//�����������ö���ʵ��ջ

//����˼·������������ģ��һ����ջ��
//����a��b
//��1��ȡջ��Ԫ�أ� ������Ԫ�صĶ��е���Ԫ��
//��2����ջ�գ�������a��b��Ϊ����ջ��
//��3����ջ��a���е�ǰ��Ԫ�أ�bΪ�գ�������Ҳһ��������Ҫ��ջ��Ԫ���ȷ�b�У�Ȼ��a�е�Ԫ�����γ��в����е�b�С�����֤��һ�������ǿյģ�
//��4����ջ������Ԫ�صĶ��г��м��ɡ�

//�����Ƚ�1�����a�� ������Ҫ��2��ջ����2����b��Ȼ��a�е�1�����뵽b�У�b�е�Ԫ�ر�Ϊ 2 ��1
//aΪ�գ�����Ҫѹ��3 ��3����a�� �����ν�b�е�2 ��1 ���в����뵹a�� ��a�е�Ԫ�ر�Ϊ 3��2��1 bΪ��
//�㷨��֤���κ�ʱ����һ����Ϊ��

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
