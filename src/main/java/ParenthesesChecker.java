import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParenthesesChecker {

    public ParenthesesChecker() {

    }

    public boolean checkParentheses(String input) {
        // separate input into individual characters
        // - want to distinguish between a-z and brackets
        //-loop through the string to separate characters
        // - split
        // - toCharArray()
        String[] letters = input.split("");

        // Filter out the brackets - discard a-z and numbers
        // create new empty ArrayList
        Stack<String> foundBrackets = new Stack<>();
        // loop through letters
        // - if letter is a bracket, add to the array
        for (String letter : letters) {
            if (letter.equals("(")) {
                if (letter.equals("(")) {
                    foundBrackets.add(letter);
                } else if (letter.equals(")")) {
                    if (foundBrackets.isEmpty() || !foundBrackets.pop().equals("(")) {
                        return false;
                    }
                }
            }
        }
        return foundBrackets.isEmpty();


            //need to check if opening bracket comes first
            // next bracket needs to be closing
            // ... or nest pair
            // no trailing opening bracket



    }

}
