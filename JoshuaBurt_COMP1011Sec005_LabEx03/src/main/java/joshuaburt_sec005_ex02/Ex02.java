package joshuaburt_sec005_ex02;

import java.util.*;

public class Ex02 {
    //Ex-02: (Counting Letters) Modify the program of WordTypeCount.java to count the number of occurrences of each letter rather than of each word.
// For example, the string "HELLO THERE" contains two Hs, three Es, two Ls, one O, one T and one R. Display the results. [5 marks]

    public static void main(String[] args) {
        // create HashMap to store String keys and Integer values
        Map<String, Integer> myMap = new HashMap<>();

        createMap(myMap); // create map based on user input
        displayMap(myMap); // display map content
    }

    // create map from user input
    private static void createMap(Map<String, Integer> map) {
        Scanner scanner = new Scanner(System.in); // create scanner
        System.out.println("Enter a string:"); // prompt for user input
        String input = scanner.nextLine();


        System.out.println("Concatenated string:");
        input = input.replaceAll("(\s)+", ""); //Modified: replace any whitespace with no space
        System.out.println(input);

        // tokenize the input
        String[] tokens = input.split(""); //Modified: to split String input at each char

        for(int i =0; i< tokens.length; i++){
            if (tokens[i].isBlank() == false){
                tokens[i].replaceAll(" ","");
            }
        }

        // processing input text
        for (String token : tokens) {
            String word = token.toLowerCase(); // get lowercase character


            // if the map contains the word
            if (map.containsKey(word)) { // is character in map?
                int count = map.get(word); // get current count
                map.put(word, count + 1); // increment count
            }
            else {
                map.put(word, 1); // add new character with a count of 1 to map
            }
        }
    }

    // display map content
    private static void displayMap(Map<String, Integer> map) {
        Set<String> keys = map.keySet(); // get keys

        // sort keys
        TreeSet<String> sortedKeys = new TreeSet<>(keys);

        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        // generate output for each key in map
        for (String key : sortedKeys) {
            System.out.printf("%-10s%10s%n", key, map.get(key));
        }

        System.out.printf(
                "%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }
}
