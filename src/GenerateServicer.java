import java.util.Random;
import java.util.Scanner;

public class GenerateServicer {
    private Scanner input;
    private boolean IncludeCapital = false;
    private boolean IncludeSmall = false;
    private boolean IncludeNumber = false;
    private boolean IncludeSymbol = false;
    private int length;

    public GenerateServicer(Scanner input) {
        this.input = input;
    }
    
    public String startGenerate(){
        System.out.println("Provide requirements for Password");
        requirements();
        Alphabets alphabets = new Alphabets(IncludeCapital, IncludeSmall, IncludeNumber, IncludeSymbol);
        String string = alphabets.generateString();
        System.out.println("Great! Now enter the length of the password");
        length = input.nextInt();
        StringBuilder password = new StringBuilder();
        int len = string.length();
        int min = 0;
        int max = len-1;
        int range = max - min + 1;
        Random randomNum = new Random();
        for(int i=0;i<length;i++){
            int randonval = (int)randomNum.nextInt(range);
            password.append(string.charAt(randonval));
        }
        return password.toString();
    }

    private void requirements(){
        boolean correctInput;
        do {
            String askInput;
            correctInput = false;
            do {
                System.out.println("Do you want Lowercase letters \'abcd...\' to be used? ");
                askInput = input.next();
                PasswordRequestError(askInput);
            } while (!askInput.equalsIgnoreCase("yes") && !askInput.equalsIgnoreCase("no"));
            IncludeSmall = askInput.equalsIgnoreCase("yes");
            do {
                System.out.println("Do you want UpperCase letters \'ABCD...\' to be used? ");
                askInput = input.next();
                PasswordRequestError(askInput);
            } while (!askInput.equalsIgnoreCase("yes") && !askInput.equalsIgnoreCase("no"));
            IncludeCapital = askInput.equalsIgnoreCase("yes");
            do {
                System.out.println("Do you want Numbers \'1234...\' to be used? ");
                askInput = input.next();
                PasswordRequestError(askInput);
            } while (!askInput.equalsIgnoreCase("yes") && !askInput.equalsIgnoreCase("no"));
            IncludeNumber = askInput.equalsIgnoreCase("yes");
            do {
                System.out.println("Do you want Symbloms \'!@#$%...\' to be used? ");
                askInput = input.next();
                PasswordRequestError(askInput);
            } while (!askInput.equalsIgnoreCase("yes") && !askInput.equalsIgnoreCase("no"));
            IncludeSymbol = askInput.equalsIgnoreCase("yes");
            if (!IncludeCapital && !IncludeNumber && !IncludeSmall && !IncludeSymbol) {
                System.out.println("You have selected no characters to generate your " +
                        "password, at least one of your answers should be Yes\n");
                correctInput = true;
            }
        } while (correctInput);

    }

    public void PasswordRequestError(String i){
        if(!i.equalsIgnoreCase("yes") && !i.equalsIgnoreCase("no")){
            System.out.println("Please provide correct input");
        }
    }
}
