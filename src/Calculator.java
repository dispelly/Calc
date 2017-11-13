import java.util.Scanner;

public class Calculator {

    public void readline() {
        System.out.println("Введите арифметическое выражение(можно испольновать знаки '+' '-' '*' '/' и знаки скобок '(' ')'");
        String str;
        int x;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        x = result(str);
        System.out.println(x);
    }
    static int result(String str)
    {
        int rez=0;
        rez= Integer.parseInt(str);
        return rez;
    }
}
