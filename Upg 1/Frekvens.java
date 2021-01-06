import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.text.DecimalFormat;

public class Frekvens{
    //private String content;

    public static String ReadData() throws IOException {
        String input = "input.txt";
        String content = Files.lines(Paths.get(input)).collect(Collectors.joining("\n"));
        return content;
    }

    public static void Frequency()throws IOException {
        String content = Files.lines(Paths.get("input.txt")).collect(Collectors.joining("\n"));
        char [] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        DecimalFormat dec = new DecimalFormat("#.##");
        char[] contentChar = content.toCharArray();
        int[] freq = new int[127];
        for(int i = 0; i < contentChar.length; i++){
          char token = content.charAt(i);
          freq[(int)token] ++;
        }
        for(int i = 0; i < alphabet.length;i++){
          double percent = (double)(freq [(int)alphabet[i]])/contentChar.length*100;
          if(freq [(int)alphabet[i]] == 0 ){}
          else {
              System.out.println(alphabet[i] + "    "+ freq [(int)alphabet[i]] + "    " +dec.format(percent) +"%");
          }

        }

    }


    public static void main(String[] CmdLn){
        try {
            Frequency();
        }

        catch (IOException ioe){
            System.out.println("I/O ERROR");
        }


    }
}
