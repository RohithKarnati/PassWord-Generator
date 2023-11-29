public class Alphabets {
    private boolean askCapital;
    private boolean askSmall;
    private boolean askNumber;
    private boolean askSymbol;

    private String capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String small = "abcdefghijklmnopqrstuvwxyz";
    private String numbers = "1234567890";
    private String symbol = "!@#$%^&*()-_=+\\/~?";

    public Alphabets(boolean askCapital, boolean askSmall, boolean askNumber, boolean askSymbol) {
        this.askCapital = askCapital;
        this.askSmall = askSmall;
        this.askNumber = askNumber;
        this.askSymbol = askSymbol;
    }

    public String generateString(){
        StringBuilder passwordString = new StringBuilder();

        if(askCapital){
            passwordString.append(capital);
        }
        if(askNumber){
            passwordString.append(numbers);
        }
        if(askSmall){
            passwordString.append(small);
        }
        if(askSymbol){
            passwordString.append(symbol);
        }
        return passwordString.toString();
    }

    
}
