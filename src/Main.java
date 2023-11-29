import java.util.Scanner;

public class Main {
    static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Generate generate = new Generate(input);
        generate.start();
    }
}
