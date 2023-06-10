package joshuaburt_sec005_ex01;

import java.util.*;

public class Ex01 {
//Ex-01: (Copying and Reversing LinkedLists) Write a program that creates a LinkedList object of 10 characters,
// then creates a second LinkedList object containing a copy of the first list, but in reverse order.
    public static void main(String[] args) {
        LinkedList<String> tenChar = new LinkedList<String>();
        for(int i = 0; i<10; i++) {
            tenChar.add(randomCharGen()); //generates 10 random characters
        }
        System.out.printf("Regular List:%n");
        System.out.println(tenChar); //prints LinkedList object tenChar
        printReversedList(tenChar); // print LinkedList object in reverse order
    }

    public static String randomCharGen()     // creates a random character
    {
        Random letter = new Random();
        char ch = (char)('a' + letter.nextInt(26));
        return String.valueOf(ch);
    }

    private static void printReversedList(List<String> tenChar) {    // print reversed list
        ListIterator<String> iterator = tenChar.listIterator(tenChar.size());
        LinkedList<String> reversedChar = new LinkedList<String>();
        //creates reversed character array
        while (iterator.hasPrevious()) {
            reversedChar.add(iterator.previous());
        }
        System.out.printf("%nReversed List:%n");
        System.out.printf("%s ", reversedChar);
    }
}
