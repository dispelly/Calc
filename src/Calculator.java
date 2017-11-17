import java.util.StringTokenizer;
import java.util.Stack;


public class Calculator {
    /**
     * Метод проверяет, является ли строка числом
     * @param currSymb String
     */
    private boolean isNum(String currSymb) {
        try {
            Double.parseDouble(currSymb);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Метод проверяет, является ли символ оператором
     * @param c char
     */
   private boolean isOp(char c) {
        if (c=='+' || c=='-' || c=='*' || c=='/')
            return true;
        else return false;
    }

    /**
     * приоритет операции
     * @param op char
     * @return byte
     */
    private static byte opPrior(char op) {
        switch (op) {
            case '/':
            case '*':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    /**
     * главный метод подсчета выражения
     * используем обратную польскую запись
     * @param str String
     * @return String
     */
    public double calculate(String str) throws Exception {
        Stack<Double> stack = new Stack<Double>(); // записываем цифры
        Stack<Character> op = new Stack<Character>(); // записываем опрераторы
        String sN;
        StringTokenizer st = new StringTokenizer(str, "+-*/()", true);
        while (st.hasMoreTokens()) {
            sN = st.nextToken();
                if (sN.charAt(0) == '(')
                    op.push('(');
                else if (sN.charAt(0) == ')') {
                    while (op.peek() != '(')
                        resultOp(stack, op.pop());
                    op.pop();
                } else if (isOp(sN.charAt(0))) {
                    while (!op.empty() && opPrior(op.peek()) >= opPrior(sN.charAt(0)))
                        resultOp(stack, op.pop());
                    op.push(sN.charAt(0));
                } else {
                    if (isNum(sN))
                    stack.push(Double.parseDouble(sN));
                }

        }
        while (!op.isEmpty())
            resultOp(stack, op.pop());

        return stack.pop();
    }

    /**
     * метод подсчета двух чисел
     *@param stack Stack<Double> передаем стек чисел
     *@param operator char передаем оператор
     */
   private void resultOp(Stack<Double> stack, char operator) {
        double answer = 0;
        double num1 = stack.pop();
        double num2 = stack.pop();
        switch (operator) {
            case '+':
                answer = num1 + num2;
                break;
            case '-':
                answer = num1 - num2;
                break;
            case '/':
                answer = num1 / num2;
                break;
            case '*':
                answer = num1 * num2;
                break;

            }
        stack.push(answer);
    }
}