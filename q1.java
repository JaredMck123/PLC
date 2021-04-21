package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class q4 {
    public static void main(String[] args) {

        // special symbol is the '_' character
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            HashMap<Integer, ArrayList<String>> map = new HashMap<>();
            HashMap<String, Integer> tokens = new HashMap<>();

            tokens.put("String", 1);
            tokens.put("Integer", 2);
            tokens.put("Character", 3);
            tokens.put("Float", 4);
            tokens.put("Void", 5);
            tokens.put("int", 6);
            tokens.put("char", 7);
            tokens.put("float", 8);
            tokens.put("string", 9);
            tokens.put("*", 10);
            tokens.put("=", 11);
            tokens.put("%", 12);
            tokens.put("(", 13);
            tokens.put(")", 14);
            tokens.put("{", 15);
            tokens.put("}", 16);
            tokens.put("||", 17);
            tokens.put("&", 18);
            tokens.put("!", 19);
            tokens.put("[", 20);
            tokens.put("]", 21);
            tokens.put("+", 22);
            tokens.put("-", 23);
            tokens.put("/", 14);
            tokens.put("scalar", 24);
            tokens.put("array", 25);
            tokens.put("hash", 26);

            ArrayList<String> result = new ArrayList<>();
            while (myReader.hasNextLine()) {
                // String[] data = myReader.nextLine().split("[
                // +-/*%=(){}\\[\\]||&]+");//((?<=;)|(?=;))"
                String[] data = myReader.nextLine().split(
                        " |_|((?<=\\+)|(?=\\+))|((?<=-)|(?=-))|((?<==)|(?==))|((?<=[)|(?=]))|((?<=\\{)|(?=\\}))|((?<=\\*)|(?=\\*))|((?<=\\()|(?=\\)))");
                for (String s : data) {

                    // System.out.println(s);

                    if (s.length() >= 3 && s.charAt(0) == '\"' && s.charAt(s.length() - 1) == '\"') {
                        if (!map.containsKey(tokens.get("string"))) {
                            map.put(tokens.get("string"), new ArrayList<String>());
                        }
                        map.get(tokens.get("string")).add(s);
                    }
                    if (s.length() > 1 && s.charAt(0) == '$') {
                        if (!map.containsKey(tokens.get("scalar"))) {
                            map.put(tokens.get("scalar"), new ArrayList<String>());
                        }
                        map.get(tokens.get("scalar")).add(s);
                    } else if (s.length() > 1 && s.charAt(0) == '%') {
                        if (!map.containsKey(tokens.get("hash"))) {
                            map.put(tokens.get("hash"), new ArrayList<String>());
                        }
                        map.get(tokens.get("hash")).add(s);
                    } else if (s.length() > 1 && s.charAt(0) == '@') {
                        if (!map.containsKey(tokens.get("array"))) {
                            map.put(tokens.get("array"), new ArrayList<String>());
                        }
                        map.get(tokens.get("array")).add(s);
                    }
                    if (tokens.containsKey(s)) {
                        if (!map.containsKey(tokens.get(s))) {
                            map.put(tokens.get(s), new ArrayList<String>());
                        }

                        map.get(tokens.get(s)).add(s);
                    }
                    if (s.length() == 3 && s.charAt(0) == '\'' && s.charAt(2) == '\'') {

                        if (!map.containsKey("char")) {
                            map.put(tokens.get("char"), new ArrayList<String>());
                        }

                        map.get(tokens.get("char")).add(s);
                    }

                    boolean num = true;

                    for (int i = 0; i < s.length(); i++) {
                        if (!Character.isDigit(s.charAt(i)) || Character.isWhitespace(s.charAt(i))) {
                            num = false;
                            break;
                        }
                    }

                    if (num) {
                        if (!map.containsKey(tokens.get("int"))) {
                            map.put(tokens.get("int"), new ArrayList<String>());
                        }
                        // System.out.println(tokens.get("int") + " " + s);

                        if (s.length() > 0)
                            map.get(tokens.get("int")).add(s);
                        // System.out.println(map.get(6).toString());
                    }

                    boolean dec = false;
                    num = true;
                    for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '.') {

                            if (dec) {
                                dec = false;
                                break;
                            } else {
                                dec = true;
                            }
                        } else if (!Character.isDigit(s.charAt(i))) {
                            num = false;
                            break;
                        }
                    }

                    if (dec && num) {
                        if (!map.containsKey(tokens.get("float"))) {
                            map.put(tokens.get("float"), new ArrayList<String>());
                        }

                        if (s.length() > 0)
                            map.get(tokens.get("float")).add(s);
                    }

                }

            }

            int start = 1;
            while (!map.isEmpty()) {
                if (map.containsKey(start)) {
                    result.addAll(map.get(start));
                    map.remove(start);
                }
                start++;
            }
            // Collections.sort(result);
            System.out.println(result.toString());
            myReader.close();
        } catch (

        FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}