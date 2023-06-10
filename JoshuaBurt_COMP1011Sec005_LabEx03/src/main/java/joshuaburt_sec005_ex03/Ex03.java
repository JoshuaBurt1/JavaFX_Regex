package joshuaburt_sec005_ex03;

import java.util.*;

public class Ex03 {
    //Ex-03: (Duplicate Elimination) Write a program that reads in a series of first names and eliminates duplicates by storing them in a Set.
    // Allow the user to search for a first name. [5 marks]
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>(); //original names list
        //names.add("Bobb");
        //TODO: scanner: how many names to generate?
        for(int i = 0; i<10000; i++) {
            names.add(randomNameGen()); //generates 10 random characters
        }
        Collections.sort(names);   //Sort the array in alphabetical order
        System.out.println("Series of " +names.size()+ " first names:%n");
        System.out.println(names); //prints ArrayList object tenChar

        ArrayList<String> duplicates = new ArrayList<String>(); //duplicate names list
        //Searches for duplicate element
        for(int i = 0; i < names.size(); i++) {
            String dup = ""; //accounts for 2+ versions of same name
            for(int j = i + 1; j < names.size(); j++) {
                if(names.get(i).equals(names.get(j)) && !dup.equals(names.get(j))) {
                    dup = names.get(i);
                    duplicates.add(names.get(j));
                }
            }
        }
        System.out.printf("Series of " +duplicates.size()+ " duplicate first names:%n");
        System.out.println(duplicates);

        Set<String> nameSet = new HashSet<String>(); //duplicate removed names list
        //names.add("Bobo");
        for(int i = 0; i<names.size(); i++) {
            nameSet.add(names.get(i)); //generates 10 random characters
        }
        ArrayList<String> names2 = new ArrayList<String>(nameSet);
        Collections.sort(names2); //Sort the array in alphabetical order
        System.out.printf("Series of " +names2.size()+ " duplicate eliminated first names:%n");
        System.out.println(names2);  //Display the array
        System.out.printf("%n");

        matchMaker(names2); //name match function
    }

    public static String matchMaker(ArrayList<String> names2){
        Scanner scanner = new Scanner(System.in); // create scanner
        System.out.println("Search for a name:"); // prompt for user input
        String input = scanner.nextLine();
        boolean match = false;
        for(int i = 0; i<names2.size(); i++) {
            if(input.equalsIgnoreCase(names2.get(i))){ //ignores case in search
                System.out.println("Matched detected for: " +input);
                match = true;
            }
        }
        if(match == false){
            System.out.println("No match for: "+input);
        }
        Scanner yesOrNo = new Scanner(System.in); // create scanner
        System.out.println("Search again? Yes or No"); // prompt for user input
        String yn = yesOrNo.nextLine();
        if(yn.equalsIgnoreCase("yes")){
            matchMaker(names2);
        }
        return input;
    }

    public static String randomNameGen()
    {
        String[] randomName = {"","","",""};
        String[] vowels = {"a", "e", "i","o","u","y"};
        String[] consonants ={"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","z"};

        Random num = new Random();
        int vowelIndex;
        int consonantIndex;
        int vowelOrCon;

        vowelOrCon=num.nextInt(2); //random number 0-1 (determines if name starts with vowel or consonant
        for(int i = 0; i <4; i++) //create a 4 letter name
        {
            vowelIndex=num.nextInt(6); //random number 0-5 (random vowel index)
            consonantIndex=num.nextInt(20); //random number 0-20 (random consonant index)

            if(vowelOrCon==0){ //vowel, then consonant
                randomName[i] = vowels[vowelIndex];
                vowelOrCon = 1;
            }
            else{ //consonant, then vowel
                randomName[i] = consonants[consonantIndex];
                vowelOrCon = 0;
            }
        }

        StringJoiner joiner = new StringJoiner("");
        for(int i = 0; i < randomName.length; i++) {
            joiner.add(randomName[i]); //converts string array into a single string
        }
        String randomNameJoined = joiner.toString();
        String name = randomNameJoined.substring(0,1).toUpperCase() + randomNameJoined.substring(1).toLowerCase(); // Index 0 to uppercase
        return name;
    }
}
