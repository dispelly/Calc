import java.util.StringTokenizer;
import java.util.Stack;

/**
 * Консольный калькулятор с поддержкой скобкок.
 * Поддерживаются операции сложения, вычитания, умножения, деления.
 */

public class Calculator {
    /**
     * Метод проверяет, является ли строка числом.
     * @param currSymb String - Строковое поле для проверки на число.
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
     * Метод проверяет, является ли символ оператором.
     * @param c char - Текущий символ проверяемый на математическую операцию.
     */
   private boolean isOp(char c) {
        if (c=='+' || c=='-' || c=='*' || c=='/')
            return true;
        else return false;
    }

    /**
     * Метод устанавливающий приоритет операции при рассчете.
     * @param op char - Переменная для установки приоритета от 0 до 2.
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
     * Главный метод подсчета выражения.
     * используется алгоритм обратной польской записи.
     * @param str String - Входная строка.
     * @return double - Результат вычислений.
     */
    public double calculate(String str) throws Exception {
        Stack<Double> stack = new Stack<Double>(); // Стэк для записи цифр.
        Stack<Character> op = new Stack<Character>(); // Стэк для записи опрераторов.
        String sN;
        //Разделяем строку, разделителем является операнд.
        StringTokenizer st = new StringTokenizer(str, "+-*/()", true);
        //Вычисляем результат выражения используя приоритеты операций и скобок.
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
        while (!op.empty())
            resultOp(stack, op.pop());
        // Возвращаем результат из стека.
        return stack.pop();
    }

    /**
     * Метод возвращающий результат подсчета двух чисел.
     *@param stack Stack<Double> - Передаем стэк чисел.
     *@param operator char - Передаем оператор.
     */
   private void resultOp(Stack<Double> stack, char operator)throws Exception {
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
            default:
                throw new Exception("Недопустимая операция " + operator);
            }
        //Записываем результат операции в стек.
        stack.push(answer);
    }
}