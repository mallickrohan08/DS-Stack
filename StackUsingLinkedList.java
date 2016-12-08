class Node {
	int data;
	Node next;
	Node(int d) {
		data = d;
		next = null;
	}
}

class Stack {
	int top = -1;
	int size = 0;
	Node head = null;
	
	Stack(int size) {
		this.size = size;
	}
	//Get Size;
	public int getSize() {
		return size;
	}
	
	//Get Top
	public int getTop() {
		return top;
	}
	
	//get Size;
	public int getsize() {
		return size;
	}
	
	//Push node Alway push at beginning;
	public void push(int d) {
		if(top == size - 1) {
			System.out.println("Stack is full. Can't add " + d);
			return;
		}
		Node obj = new Node(d);
		obj.next = head;
		head = obj;
		top++;
	}
	
	//Pop from the top of Stack
	public int pop() {
		if(top == -1) {
			System.out.println("Stack is empty");
			return 0;
		}
		int data = head.data;
		head = head.next;
		top--;
		return data;
		
	}
	
	//Peep from the top of stack
	public int peep() {
		if(top == -1) {
			System.out.println("Stack is empty");
			return 0;
		}
		return head.data;
	}
	
	//If stack is full
	public boolean isFull() {
		return (top == size-1);
	}
	
	//If Stack is empty
	public boolean isEmpty() {
		return (top == -1);
	}
	//Print stack data
	public void printStack() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		
	}
}
class StackUsingLinkedList {
	
	public static void main(String args[]) {
		//Node head = null;
		Stack stk = new Stack(3);
		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.push(40);
		stk.printStack();
		stk.pop();
		stk.printStack();
		System.out.println(stk.peep());
	}
}