import java.util.Random;

public class Password3{
    //private static char[] pwd;
    //private static String password;
    //private static boolean evaluation;
    //private static int passedPasses;


    public static char[] generatePassword(){
        Random rand = new Random();
        char[] signs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        int randNum = rand.nextInt(12 - 8 + 1) + 8;
        int picker = 0;
        char[] pwd = new char [randNum];
        for(int i = 0; i < randNum; i++){
            picker = rand.nextInt(signs.length);
            pwd[i] = signs[picker];
        }
        return pwd;
    }



    public static int getPwd(int amount){
        int n = amount;
        //boolean check = false;
        int passedPasses = 0;
        //int failedPasses = 0;
        for(int i = 0; i < n; i++){
            String password = String.valueOf(generatePassword());
            if(passwordCheck(password) == true){
                passedPasses = passedPasses + 1;
            }
        }
        return passedPasses;
    }



    public static boolean passwordCheck (String c){
        String password = c;
        boolean lenNdig = false;
        boolean cap = false;
        boolean small = false;
        boolean evaluation = false;
        if(8<=password.length() && password.length()<=12 && password.matches(".*\\d+.*")){
            lenNdig = true;
        }
        char ch;
        for(int i = 0; i < password.length(); i++){
            ch = password.charAt(i);
            if(Character.isUpperCase(ch)){
                cap = true;
            }
            else if(Character.isLowerCase(ch)){
                small = true;
            }
        }
        if(lenNdig && cap && small){
            evaluation = true;
        }

        return evaluation;

    }





    public static void main(String [] CmdLn){
        //char[] pwd = generatePassword();
        //String pass = getPwd();
        //boolean eval = passwordCheck(pass);
        //if(pass.){System.out.println("TRUE");}
        //for(int i = 0; i < pwd.length; i++){
            //System.out.println(pwd[i]);
        //}

        int cleared = getPwd(1000);
        System.out.println("Passed: " + cleared);
        
    }
}
