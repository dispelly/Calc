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
     * главный метод подсчета выражения
     * запись операторов в стек
     * @param str String
     * @return double
     */
    public double calculate(String str) throws Exception{
        Stack<Double> stack = new Stack<Double>();
        double num1 = 0, num2 = 0, answer = 0;
        char operand;
        String sN;
        StringTokenizer st = new StringTokenizer(str, "+-*/", true);
        while (st.hasMoreTokens()) {
            try {
                sN = st.nextToken();

                if (isNum(sN)) {
                    num1 = Double.parseDouble(sN);
                    stack.push(num1);
                } else if (isOp(sN.charAt(0))) {
                    if (stack.size() < 2) {
                        throw new Exception("Недостаточно операндов для операции " + sN);
                        }
                        num1 = stack.pop();
                        num2 = stack.pop();
                        operand = sN.charAt(0);
                        switch (operand) {
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
                    } /*else System.out.println("Неверные данные");*/
                } catch (Exception e) {
                throw new Exception("Неверные данные в выражении");
                }
            }

        return stack.pop();
    }
}