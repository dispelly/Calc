import java.util.StringTokenizer;


public class Calculator {

    public double calculate(String str) {
        double num1, num2, answer = 0;
        char operand;
        StringTokenizer st = new StringTokenizer(str, "+-*/",true);
        while (st.hasMoreTokens()) {
            num1 = Double.parseDouble(st.nextToken());
            operand = st.nextToken().charAt(0);
            num2 = Double.parseDouble(st.nextToken());
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
        }
        return answer;
    }

}