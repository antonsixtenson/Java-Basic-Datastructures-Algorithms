public class Exponent{
    /*
    bas^exponent; bas*bas*bas....(exponent antal gånger)
    */

    public static int exp(int b, int e){
        if(e == 0){
            return 1;
        }
        else{
            return b*exp(b, e-1);
        }

    }
    public static void main(String[] args){
        int b = 7;
        int e = 2;
        //exp(b, e);
        System.out.println(b + "^"+e + " : " + exp(b, e));
    }

}
