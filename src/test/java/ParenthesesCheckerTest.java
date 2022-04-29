import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParenthesesCheckerTest {
        private ParenthesesChecker checker;

        public ParenthesesCheckerTest() {
        }

        @BeforeEach
        public void before() {
            this.checker = new ParenthesesChecker();
        }

        @Test
        public void passesForEmptyString() {
            String testString = "";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Test
        public void passesWithOnePair() {
            String testString = "()";
            assertTrue(this.checker.checkParentheses(testString));
        }
        @Test
        public void failsForIncorrectOrder(){
            String testString = ")(";
            assertFalse(checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOnlyOpening() {
            String testString = "(";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOnlyClosing() {
            String testString = ")";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void passesIfNested() {
            String testString = "(())";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOnePairLeftOpen() {
            String testString = "(()";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOnePairNotOpened() {
            String testString = "())";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void passesForMatchedParenthesesInText() {
            String testString = "test (for parentheses)";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfNoClosingBracketInText() {
            String testString = "test (for unclosed parentheses ";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfNoOpeningBracketInText() {
            String testString = "test for unopened parenthesis)";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void passesForMultipleParenthesesInText() {
            String testString = "test (for multiple) opening (and closing) brackets";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOneBracketLeftOpen() {
            String testString = "test (for multiple) opening (and closing brackets";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOneBracketNotOpened() {
            String testString = "test (for multiple) opening and closing) brackets";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void passesForNestedBracketsInText() {
            String testString = "test for (lots of (nested)) brackets";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForBraces() {
            String testString = "test {braces}";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleOpeningBrace() {
            String testString = "test {braces";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleClosingBrace() {
            String testString = "test braces}";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForMultipleBraces() {
            String testString = "test {multiple} {braces}";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForNestedBraces() {
            String testString = "test { nested {braces}}";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForBrackets() {
            String testString = "test [brackets]";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleOpeningBracket() {
            String testString = "test [brackets";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleClosingBracket() {
            String testString = "test brackets]";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForMultipleBrackets() {
            String testString = "test [multiple] [brackets]";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForNestedBrackets() {
            String testString = "test [ nested [brackets]]";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForAngleBrackets() {
            String testString = "test <angle brackets>";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleAngleBracket() {
            String testString = "test <angle brackets";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleClosingAngleBracket() {
            String testString = "test angle brackets>";
            assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForMultipleAngleBrackets() {
            String testString = "test <multiple> <angle brackets>";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForNestedAngleBrackets() {
            String testString = "test < nested <angle brackets>>";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForCheckNestedMixedBrackets() {
            String testString = "(nested {mixture})";
            assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForWronglyOrderedMixedBrackets() {
            String testString = "(nested {mixture)}";
            assertFalse(this.checker.checkParentheses(testString));
        }
    }

