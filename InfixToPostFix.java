import java.util.*;
class Stack {
	int top = -1;
	int size = 0;
	char stackArr[];
	
	Stack(int s) {
		size = s;
		stackArr = new char[size];
	}
	
	//print stack
	
	public void printstack() {
		if(top == -1) {
			System.out.println("Stack is Empty.");
		}
		for (int i =0; i <= top; i++) {
			System.out.println(stackArr[i]);
		}
	}
	
	//Push
	public void push(char data) {
		if(top == size - 1) {
			System.out.println("Stack is Full. Can't add" + data);
			return;
		}
		top++;
		stackArr[top] = data;
	}
	
	//Pop
	public char pop() {
		if(top == -1) {
			System.out.println("Stack is Empty. Can't Pop any data");
			return 'N';
		}
		return stackArr[top--];
	}
	
	//isEmpty
	
	public boolean empty() {
		return (top == -1);
	}
	
}
class InfixToPostFix {
	
	private Stack oprStack;
	private String infixExp;
	private String postfixExp = "";
	//Constructor for Infix to Postfix conversion.
	InfixToPostFix(String exp) {
		infixExp = exp;
		int expSize = infixExp.length();
		oprStack = new Stack(expSize);
	}
	
	//Method for Transformation.
	
	public String IntoPostTrans() {
		for(int i =0; i<infixExp.length(); i++) {
			char ch = infixExp.charAt(i);
			switch (ch) {
				case '+':
				case '-':
					gotOperator(ch, 1);
					break;
				case '*':
				case '/':
					gotOperator(ch, 2);
					break;
				case '(':
					oprStack.push(ch);
					break;
				case ')':
					gotParenthesis(ch);
					break;
				default:
					postfixExp = postfixExp + ch;
			}
		}
		
		while(!oprStack.empty()) {
			postfixExp = postfixExp + oprStack.pop();
		}
		return postfixExp;
	}
	
	//gotOperator
	public void gotOperator(char opr, int precedence1) {
		/*
			If we got the the operator do the following step.
			If Stack is not empty push the operator into the stack.
			If pooped operator is '(' then again add that into stack and break.
			If Stack is not empty and current scanned operator having precedence more than pooped operator
			then push the current operator into stack.
			If Stack is not empty and current scanned operator having precedence less than pooped operator
			then push the current operator into stack and add pooped operator to postfix String.
			
		*/
		while(!oprStack.empty()) {
			char currOpr = oprStack.pop();
			if(currOpr == '(') {
				oprStack.push(currOpr);
				break;
			}
			else {
				int precedence2;
				if(currOpr == '+' || currOpr == '-') {
					precedence2 = 1;
				}
				else {
					precedence2 = 2;
				}
				//If precedence2(pooped operator) having more precedence than precedence1(current operator)
				if(precedence1 > precedence2) {
					oprStack.push(currOpr);
					break;
				}
				else {
					postfixExp = postfixExp + currOpr;
				}
			}
		}
		oprStack.push(opr);
		
	}
	
	public void gotParenthesis(char ch) {
		//If we got ')' then pop all the operator upto '('. ann add all other operator other than "("
		//add to postfix String.
		while(!oprStack.empty()) {
			char opr = oprStack.pop();
			if(opr == '(') {
				break;
			}
			else {
				postfixExp = postfixExp + opr;
			}
		}
	}
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		String exp = scan.nextLine();
		System.out.println(exp);
		String trimmedexp = exp.replaceAll("\\s+","");
		System.out.println(trimmedexp);
		InfixToPostFix itp = new InfixToPostFix(trimmedexp);
		String output = itp.IntoPostTrans();
		System.out.println(output);
		
	}
	
}