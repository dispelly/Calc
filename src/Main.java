import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws Exception {
        System.out.println("Введите арифметическое выражение(можно испольновать знаки '+' '-' '*' '/' и знаки скобок '(' ')'");
        String str;
        double rez;
        try {
            Scanner sc = new Scanner(System.in);
            str = sc.nextLine();
            Calculator calc = new Calculator();
            rez = calc.calculate(str);
            System.out.println(rez);
        } catch (Exception e) {
            System.out.println("Неверный формат");
        }
    }
}


