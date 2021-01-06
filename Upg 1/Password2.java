import java.util.Random;

public class Password2{
    //private static char[] pwd;
    //private static String password;
    //private static boolean evaluation;


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



    public static String getPwd(){
        String password = String.valueOf(generatePassword());
        return password;
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
        String pass = getPwd();
        String pass2 = "";
        boolean eval = passwordCheck(pass);
        boolean eval2 = false;
        while(eval2 == false){
            pass2 = getPwd();
            eval2 = passwordCheck(pass2);

        }
        System.out.println(pass + " evaluation: " + eval);
        System.out.println("Ex of passed pwd: " + pass2);
    }
}
