import java.util.Random;

public class Password1{




    public static char[] generatePassword(){
        Random rand = new Random();
        char[] signs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        int randNum = rand.nextInt(12 - 8 + 1) + 8; //random nummer mellan 12 och 8
        int sel = 0;     //int för att "välja" char i signs
        char[] pwd = new char [randNum];    //initiera pwd
        for(int i = 0; i < randNum; i++){   //for-loop för att plocka ur char ur signs
            sel = rand.nextInt(signs.length  + 1);   // nytt nmr varje varv
            pwd[i] = signs[sel];
        }
        return pwd;


    }





    public static void main(String [] CmdLn){
        char[] pwd = generatePassword();
        //String pwdClear = "";
        for(int i = 0; i < pwd.length; i++){
            System.out.println(pwd[i]);
        }
    }
}
