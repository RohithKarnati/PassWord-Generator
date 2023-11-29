public class checkPasswordStrength {

    private String str;
    private int length;

    checkPasswordStrength(String str){
        this.str = str;
        this.length = str.length();
    }


    public int checkType(char ch){
        if(ch >= 'a' && ch <= 'z'){
            return 1;
        }
        if(ch >= 'A' && ch <= 'Z'){
            return 2;
        }
        if(ch >= '0' && ch <= '9'){
            return 3;
        }
        if(ch >= '!' && ch <= '/'){
            return 4;
        }
        return 0;

    }

    public int passwordStrength(){
        boolean usedUpper = false;
        boolean usedLower = false;
        boolean usedNumber = false;
        boolean usedSymbol = false;
        int score = 0;
        char[] ch = str.toCharArray();
        for(char i: ch){
            int type = checkType(i);

            if(type == 1){usedLower = true;}
            if(type == 2){usedUpper = true;}
            if(type == 3){usedNumber = true;}
            if(type == 4){usedSymbol = true;}
        }
        if(usedLower){score+=10;}
        if(usedNumber){score+=10;}
        if(usedSymbol){score+=10;}
        if(usedUpper){score+=10;}

        if(length > 12){
            score+=10;
        }
        if(length > 16){
            score+=10;
        }
        return score;
    }

    public String calculateScore(){
        int score = this.passwordStrength();
        if (score == 60) {
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        } else if (score >= 40) {
            return "This is a good password :) but you can still do better";
        } else if (score >= 30) {
            return "This is a medium password :/ try making it better";
        } else {
            return "This is a weak password :( definitely find a new one";
        }
    }
}
