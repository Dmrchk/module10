import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws IOException {
        File file = new File("file3.txt");
        Scanner scanner = new Scanner(file);
        String words = "";
        while (scanner.hasNextLine()) {
            words += scanner.nextLine() + " ";
        }
        System.out.println(wordsSorter(wordsFrequency(words)));
    }

        public static Map<String, Integer> wordsFrequency(String words) {
            Map<String, Integer> wordsMap = new HashMap<>();
            String[] wordsArray = words.split(" ");

            for (String word : wordsArray) {
                wordsMap.merge(word, 1, Integer::sum);
            }
            return wordsMap;
        }

  
        public static String wordsSorter(Map<String, Integer> wordsMap){
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordsMap.entrySet());
            entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

            StringBuilder stringBuilder = new StringBuilder();

            for (Map.Entry<String, Integer> entry : entries){
                stringBuilder.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
            return stringBuilder.toString();
        }
    }