import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Task1 {
    public static void main(String[] args) throws IOException {
        File file = new File("file1.txt");
        Scanner scanner = new Scanner(file);
        String str = "";
        while (scanner.hasNextLine()){
            str += scanner.nextLine() + "\n";
        }

        String valid1 ="\\d{3}-\\d{3}-\\d{4}";
        String valid2 = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}";
        String result = "";

        String[] strSplit = str.split("\n");

        for (int i = 0; i < strSplit.length; i++) {
            Pattern pt1 = Pattern.compile(valid1);
            Matcher mt1 = pt1.matcher(strSplit[i]);
            Pattern pt2 = Pattern.compile(valid2);
            Matcher mt2 = pt2.matcher(strSplit[i]);

            if(mt1.matches() || mt2.matches()){
                result += strSplit[i] + "\n";
            }
        }
        result.strip();
        System.out.println(result);
    }
}
