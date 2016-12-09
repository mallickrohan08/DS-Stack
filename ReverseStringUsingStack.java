/*
*@Author Rohan
*Basic Program to Reverse String using Stack.
*/
import java.util.*;
class Stack {
	private int top = -1;
	private int size = 0;
	char stkArr[];
	
	Stack(int size) {
		this.size = size;
		stkArr = new char[size];
	}
	
	public void push(char data) {
		if(top == size - 1) {
			System.out.println("Stack is full.");
			return;
		}
		
		top++;
		stkArr[top] = data;
	}
	
	public char pop() {
		if(top == -1) {
			System.out.println("Stack is empty.");
			return '$';
		}
		return stkArr[top--];
	}
	
	public boolean empty() {
		return (top == -1);
	}
}
class ReverseStringUsingStack {
	
	public String reverseString(String str) {
		String revString = "";
		int size = str.length();
		Stack stk = new Stack(size);
		//First push all char of String on stack;
		for(int i = 0; i < str.length(); i++) {
			stk.push(str.charAt(i));
		}
		//Now pop all char and add to reverse String.
		while(!stk.empty()) {
			revString = revString + stk.pop();
		}
		return revString;
	}
	public static void main(String args[]) {
		System.out.println("Please any String : ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		ReverseStringUsingStack obj = new ReverseStringUsingStack();
		String output = obj.reverseString(str);
		System.out.println(output);
		
	}
}