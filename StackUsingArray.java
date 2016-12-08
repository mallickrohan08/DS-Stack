class Stack {
	private int size = 0;
	private int top = -1;
	private int stackArr[];
	
	public Stack(int size) {
		this.size = size;
		stackArr = new int[size];
	}
	public int getSize() {
		return size;
	}
	public int getTop() {
		return top;
	}
	public void push(int data) {
		if(top == size - 1) {
			System.out.println("Stack is full. Can't add : " + data);
			return;
		}
		top++;	
		stackArr[top] = data;
	}
	
	public int peek() {
		if(top == -1) {
			System.out.println("Stack is empty.");
			return top;
		}
		return stackArr[top];
	}
	
	public int pop() {
		if(top == -1) {
			System.out.println("Stack is empty.");
			return -1;
		}
		int data = stackArr[top];
		top--;
		return data;
	}
	
	public boolean isFull() {
		return (top == size - 1);
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	public void printStack() {
		if(top == -1) {
			System.out.println("Stack is empty");
			return;
		}
		for (int i=0; i < top + 1; i++) {
			System.out.println(stackArr[i]);
		}
	}
}
public class StackUsingArray{
	public static void main(String args[]) {
		Stack obj = new Stack(4);
		obj.printStack();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.printStack();
		System.out.println(obj.peek());
		System.out.println(obj.isFull());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.isEmpty());
		obj.printStack();
	}
}