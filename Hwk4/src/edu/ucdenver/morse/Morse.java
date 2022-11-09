package edu.ucdenver.morse;

import java.util.ArrayList;
import java.util.HashMap;

public class Morse {

    private static HashMap<String, String> morseToNormal;
    private static HashMap<String, String> normalToMorse;
    private final String[] normalCharacters =
            {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                    "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                    "U", "V", "W", "X", "Y", "Z",
                    "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private final String[] morseCharacters =
            {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                    "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                    "..-", "...-", ".--", "-..-", "-.--", "--..",
                    ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};


    // constructors
    public Morse() {

        morseToNormal = new HashMap<>();
        normalToMorse = new HashMap<>();
        for (int i = 0; i < normalCharacters.length; i++) {
            morseToNormal.put(morseCharacters[i], normalCharacters[i]); //creates map of 'morse:normal' key:value pairs, eg. [".-":"A"]
            normalToMorse.put(normalCharacters[i], morseCharacters[i]); //creates map of 'normal:morse' key:value pairs, eg. ["A":".-"]
        }
    }


    // class methods
    /*
    Implement the encode(String)method, that given a clean string (normal text) will return the Morse Code encoded representation
    Example:
    Input String: "Hello World"
    Output String: "....=.=.-..=.-..=---= .--=---=.-.=.-..=-..="
    After each encoded character add an equal sign (=). This will delimiter encoded characters.
    After each word, add a space. Do not add space after the last word (at the end of the sentence).
     */
    public String encode(String message) {

        message = message.toUpperCase(); //make each character in message uppercase to match the keys in our map
        String[] formattedMessage = message.split("");
        StringBuilder encodedMessage = new StringBuilder();

        // takes string of normal chars and finds matching morse string in normalToMorse map
        for (int i = 0; i < formattedMessage.length; i++) {
            if (normalToMorse.containsKey(formattedMessage[i])) {
                encodedMessage.append(normalToMorse.get(formattedMessage[i])).append("="); //delimit each character with (=)
            }
        }
        return encodedMessage.toString();
    }

    /*
    Implement the decode(String)method, which given the encoded string (Morse Code) will return the clean text representation.
    Example:
    Input String: "....=.=.-..=.-..=---= .--=---=.-.=.-..=-..="
    Output String: "HELLO WORLD"
     */
    public String decode(String message) {

        StringBuilder decodedMessage = new StringBuilder();

        //split into separate words delimited by spaces
        String[] words = message.split("\\s+");

        //create dynamic array for strings of chars that make up words(need dynamic list since num of words to decode changes)
        ArrayList<String> chars = new ArrayList<>();


        //iterate over words list, add each word into ArrayList
        for (int i = 0; i < words.length; i++) {
            chars.add(words[i]);
        }
        for (String s : chars) {
            // for each word in ArrayList chars, separate chars delimited by (=)
            String[] splitStrings = s.split("=");

            //iterate over each char to match with key in morseToNormal map
            for (int j = 0; j < splitStrings.length; j++) {
                if (morseToNormal.containsKey(splitStrings[j])) {
                    decodedMessage.append(morseToNormal.get(splitStrings[j]));
                }
            }
            // add a space after each iteration of enhanced for loop (which will produce one word each time)
            decodedMessage.append(" ");
        }
        //trim the leading and trailing spaces, if any
        return decodedMessage.toString().trim();
    }


    // getters
    public String[] getNormalCharacters() {
        return normalCharacters;
    }

    public String[] getMorseCharacters() {
        return morseCharacters;
    }
}
