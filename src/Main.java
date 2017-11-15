import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите арифметическое выражение(можно испольновать знаки '+' '-' '*' '/' и знаки скобок '(' ')'");
        String str;
        double rez;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

       Calculator calc=new Calculator();
        rez= calc.calculate(str);
        System.out.println(rez);
    }


}


