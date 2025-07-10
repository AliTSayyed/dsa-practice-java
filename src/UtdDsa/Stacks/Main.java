package UtdDsa.Stacks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create a scanner for users to input expressions, terminates with an empty
        // string;
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter your expression: ");
            String expression = input.nextLine();
            while (!expression.isEmpty()) {

                // create stacks for evaluating expression
                // forcing size to be 10 and 20 be really I should parse out how many digits I
                // have and how many operators I have
                // and create the most accurate size
                Stacks<Character> operatorStack = new Stacks<Character>(10);
                Stacks<Integer> operandStack = new Stacks<Integer>(20);

                for (int i = 0; i < expression.length(); i++) {
                    // parse string, need to convert multi digit strings to ints
                    int j = 0;
                    if (Character.isDigit(expression.charAt(i))) {
                        for (j = i; j < expression.length(); j++) {
                            if (Character.isDigit(expression.charAt(j))) {
                                continue;
                            } else {
                                break;
                            }
                        }
                        // parse out digit with i value and look ahead
                        String stringDigit = expression.substring(i, j);
                        int digit = Integer.parseInt(stringDigit);

                        // then store digit to stack
                        operandStack.push(digit);
                        // then increment i by look ahead to go to the non digit element (do -1 since we
                        // increment after)
                        i = j - 1;

                    } else {
                        // if it is not a digit then it is an operator

                        // if the operator stack is empty push the operator
                        if (operatorStack.isEmpty()) {
                            operatorStack.push(expression.charAt(i));
                        } else {
                            // if the stack is not empty evaluate the priority
                            // if the peek is a * or / and we are pushing a + or -, then we first caluclate
                            // the * or / of the top 2 int stack vars
                            // also need to use this to check for left to right priority
                            // - and then - should have the top stack work on the operands first and same
                            // for divison
                            char topOperator = operatorStack.peek();
                            if ((expression.charAt(i) == '+' || expression.charAt(i) == '-')
                                    && (topOperator == '*' || topOperator == '/') ||
                                    (expression.charAt(i) == '+' || expression.charAt(i) == '-')
                                            && (topOperator == '+' || topOperator == '-')
                                    ||
                                    (expression.charAt(i) == '*' || expression.charAt(i) == '/')
                                            && (topOperator == '*' || topOperator == '/')) {
                                int digit1 = operandStack.pop();
                                int digit2 = operandStack.pop();
                                char operator = operatorStack.pop();
                                switch (operator) {
                                    case '*':
                                        operandStack.push(digit1 * digit2);
                                        break;
                                    case '/':
                                        operandStack.push(digit2 / digit1); // digit 2 comes before digit 1 in order
                                        break;
                                    case '+':
                                        operandStack.push(digit1 + digit2);
                                        break;
                                    case '-':
                                        operandStack.push(digit2 - digit1); // digit 2 comes before digit 1 in order
                                        break;
                                }
                                // now we can push the operator on the stack
                                operatorStack.push(expression.charAt(i));
                            } else {
                                // else priority does not matter so we just push the operator to the stack
                                operatorStack.push(expression.charAt(i));
                            }
                        }

                    }
                }

                // now we take the top 2 values of the operand stack and use the top value of
                // the operator stack to calculate
                // until the operator stack is empty
                while (!operatorStack.isEmpty()) {
                    int digit1 = operandStack.pop();
                    int digit2 = operandStack.pop();
                    char operator = operatorStack.pop();
                    switch (operator) {
                        case '*':
                            operandStack.push(digit1 * digit2);
                            break;
                        case '/':
                            operandStack.push(digit2 / digit1);
                            break;
                        case '+':
                            operandStack.push(digit1 + digit2);
                            break;
                        case '-':
                            operandStack.push(digit2 - digit1);
                            break;
                    }
                }

                // print out the value of the final value in the operand stack
                int finalValue = operandStack.pop();
                System.out.println("The final value of your expression is: " + finalValue);
                System.out.print("Enter your expression: ");
                expression = input.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        input.close();
    }
}
