import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class User {
    private String name;
    private String age;
    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}

class Task2 {

    public static List<User> fileRead() throws IOException, FileNotFoundException {
        List<User> users = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file2.txt"));
        String string;
        int i = 0;
        while ((string = bufferedReader.readLine()) != null) {
            String[] stringArr = string.split(" ");
            if (i != 0){
                users.add(new User(stringArr[0], stringArr[1]));
            }
            i++;
        }
        bufferedReader.close();
        return users;
    }


    public static String writeToJson(List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();
        Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        String json = gson.toJson(users);
        //System.out.println(json);
        return json;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(writeToJson(fileRead()));
    }
}
