package application;

public class Notation {

    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
    	MyStack<Character> operatorStack = new MyStack<>();
        MyQueue<Character> outputQueue = new MyQueue<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                continue;
            }
            else if (Character.isDigit(currentChar)) {
                outputQueue.enqueue(currentChar);
            }
            else if (currentChar == '(') {
                operatorStack.push(currentChar);
            }         
            else if (currentChar == ')') {
                while (!operatorStack.isEmpty() && operatorStack.top() != '(') {
                    outputQueue.enqueue(operatorStack.pop());
                }
                if (operatorStack.isEmpty()) {
                    throw new InvalidNotationFormatException("Mismatched parentheses in expression");
                }
                operatorStack.pop(); 
            }
           
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                
                if (i == 0 || i == infix.length() - 1) { 
                    throw new InvalidNotationFormatException("Operator cannot be at the start or end of the expression.");
                }
                char prevChar = infix.charAt(i - 1);
                if (!Character.isDigit(prevChar) && prevChar != ')') {
                    throw new InvalidNotationFormatException("Invalid operator placement: " + prevChar + currentChar);
                }
                
                int currentPrecedence;
                if (currentChar == '+' || currentChar == '-') {
                    currentPrecedence = 1;
                } else {
                    currentPrecedence = 2; 
                }

                while (!operatorStack.isEmpty()) {
                    char topOperator = operatorStack.top();
                    int topPrecedence;

                    if (topOperator == '+' || topOperator == '-') {
                        topPrecedence = 1;
                    } else if (topOperator == '*' || topOperator == '/') {
                        topPrecedence = 2;
                    } else {
                        topPrecedence = 0;
                    }

                    if (topPrecedence >= currentPrecedence) {
                        outputQueue.enqueue(operatorStack.pop());
                    } else {
                        break;
                    }
                }
                operatorStack.push(currentChar);
            }
            else {
                throw new InvalidNotationFormatException("Invalid character in expression: " + currentChar);
            }
        }

        while (!operatorStack.isEmpty()) {
            if (operatorStack.top() == '(') {
                throw new InvalidNotationFormatException("Mismatched parentheses in expression");
            }
            outputQueue.enqueue(operatorStack.pop());
        }

        return outputQueue.toString();
    }
    
    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
        MyStack<String> stack = new MyStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char currentChar = postfix.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                continue;
            }
            else if (Character.isLetterOrDigit(currentChar)) {
                stack.push(String.valueOf(currentChar));
            }
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException("Invalid postfix notation: Not enough operands for operator " + currentChar);
                }

                String operand2 = stack.pop(); 
                String operand1 = stack.pop(); 
                String newExpression = "(" + operand1 + currentChar + operand2 + ")";

                stack.push(newExpression); 
            }
            else {
                throw new InvalidNotationFormatException("Invalid character in expression: " + currentChar);
            }
        }

        if (stack.size() != 1) {
            throw new InvalidNotationFormatException("Invalid postfix notation: More than one value remains in the stack.");
        }

        return stack.pop();
    }
    
    public static double evaluatePostfixExpression(String postfix) throws InvalidNotationFormatException {
        MyStack<Double> stack = new MyStack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char currentChar = postfix.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                continue;
            }
            else if (Character.isDigit(currentChar)) {
                stack.push((double) (currentChar - '0'));
            }
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                if (stack.isEmpty()) {
                    throw new InvalidNotationFormatException("Invalid postfix notation: Operator without operands.");
                }
                if (stack.size() < 2) { 
                    throw new InvalidNotationFormatException("Not enough operands for operator " + currentChar);
                }

                double rightOperand = stack.pop(); 
                double leftOperand = stack.pop();  
                double result = 0;

                switch (currentChar) {
                    case '+': result = leftOperand + rightOperand; break;
                    case '-': result = leftOperand - rightOperand; break;  
                    case '*': result = leftOperand * rightOperand; break;
                    case '/': 
                        if (rightOperand == 0) { 
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        result = leftOperand / rightOperand;  
                        break;
                }
                stack.push(result);
            }
            else {
                throw new InvalidNotationFormatException("Invalid character in expression: " + currentChar);
            }
        }

        if (stack.isEmpty()) {
            throw new InvalidNotationFormatException("Invalid postfix notation: Stack is empty after evaluation.");
        }
        if (stack.size() > 1) {
            throw new InvalidNotationFormatException("Invalid postfix notation: More than one value remains in the stack.");
        }

        return stack.pop();
    }

}