import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Test
        public void passesWithOnePair() {
            String testString = "()";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOnlyOpening() {
            String testString = "(";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOnlyClosing() {
            String testString = ")";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void passesIfNested() {
            String testString = "(())";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOnePairLeftOpen() {
            String testString = "(()";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOnePairNotOpened() {
            String testString = "())";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void passesForMatchedParenthesesInText() {
            String testString = "test (for parentheses)";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfNoClosingBracketInText() {
            String testString = "test (for unclosed parentheses ";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfNoOpeningBracketInText() {
            String testString = "test for unopened parenthesis)";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void passesForMultipleParenthesesInText() {
            String testString = "test (for multiple) opening (and closing) brackets";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOneBracketLeftOpen() {
            String testString = "test (for multiple) opening (and closing brackets";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void failsIfOneBracketNotOpened() {
            String testString = "test (for multiple) opening and closing) brackets";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Test
        public void passesForNestedBracketsInText() {
            String testString = "test for (lots of (nested)) brackets";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForBraces() {
            String testString = "test {braces}";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleOpeningBrace() {
            String testString = "test {braces";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleClosingBrace() {
            String testString = "test braces}";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForMultipleBraces() {
            String testString = "test {multiple} {braces}";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForNestedBraces() {
            String testString = "test { nested {braces}}";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForBrackets() {
            String testString = "test [brackets]";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleOpeningBracket() {
            String testString = "test [brackets";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleClosingBracket() {
            String testString = "test brackets]";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForMultipleBrackets() {
            String testString = "test [multiple] [brackets]";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForNestedBrackets() {
            String testString = "test [ nested [brackets]]";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForAngleBrackets() {
            String testString = "test <angle brackets>";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleAngleBracket() {
            String testString = "test <angle brackets";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForSingleClosingAngleBracket() {
            String testString = "test angle brackets>";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForMultipleAngleBrackets() {
            String testString = "test <multiple> <angle brackets>";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForNestedAngleBrackets() {
            String testString = "test < nested <angle brackets>>";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void passesForCheckNestedMixedBrackets() {
            String testString = "(nested {mixture})";
            Assertions.assertTrue(this.checker.checkParentheses(testString));
        }

        @Disabled
        @Test
        public void failsForWronglyOrderedMixedBrackets() {
            String testString = "(nested {mixture)}";
            Assertions.assertFalse(this.checker.checkParentheses(testString));
        }
    }

