public class Palindrome{

    public static boolean isPalindrome(String s){
        int len = s.length();
        if(len == 0 || len == 1){
            return true;
        }
        if(s.charAt(0) == s.charAt(len-1)){
            return isPalindrome(s.substring(1, len-1));
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println("KAJAK is palindrome: " + isPalindrome("KAJAK"));
        System.out.println("MOTOR is palindrome: " + isPalindrome("MOTOR"));
    }



    /*
    public static boolean recPalin(String s){
    //om det bara är en "char"
    if(s == j){
    return true;
}
int len = s.length();
int i = 0;
if(s.charAt(i) == s.charAt(len-i-1)){
i++;
recPalin(s);
}
return false;
}
/*
public static boolean isPalin(String s){
int len = s.length();
if(len == 0 || len == 1){
return true;
}
return recPalin(s, 0, len-1);
}*/

}
