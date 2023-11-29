import java.util.Scanner;

public class Generate {
    private Scanner input;
    public Generate(Scanner input) {
        this.input = input;
    }
    

    public void start(){
        System.out.println("Hi there, Good Day here are some few options to select");
        String checkLoop = "-1";
        print();
        while(!checkLoop.equals("4")){
            checkLoop = input.next();
            switch (checkLoop) {
                case "1":
                    GenerateServicer generateServicer = new GenerateServicer(input);
                    System.out.println(generateServicer.startGenerate());
                    print();
                    break;

                case "2":
                    System.err.println("Enter password to check Strength");
                    String password = input.next();
                    checkPasswordStrength checkStrength = new checkPasswordStrength(password);
                    System.out.println(checkStrength.calculateScore());
                    System.out.println();
                    print();
                    break;

                case "3":
                    this.printGuidelines();
                    print();
                    break;

                case "4":
                    printQuitMessage();
                    break;
                default:
                    System.out.println("Please enter proper input");
                    break;
            }
        }

    }

    private void print(){
        System.out.println("Menu - ");
        System.out.println("Select option form here: ");
        System.out.println("1. Generate Password");
        System.out.println("2. Check Password Strength");
        System.out.println("3. Ideal Password Guidance");
        System.out.println("4. Quit");
    }

    private void printGuidelines(){
        System.out.println("Length: Passwords should be at least 12 characters long, but 14 or more is better");
        System.out.println("Complexity: Passwords should include a combination of uppercase letters, lowercase letters, numbers, and symbols.");
    }

    private void printQuitMessage() {
        System.out.println("Closing the program bye bye!");
    }

}
