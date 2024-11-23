public class ValidationSuite {
    // Execute a series of basic validations on PigLatinProcessor
    public static void execute() {
        boolean allTestsPass = true;

        // Test for null input
        allTestsPass &= runTest("null", "ullnay");

        // Test for empty and whitespace-only strings
        allTestsPass &= runTest("", "");
        allTestsPass &= runTest("    ", "    ");

        // Words starting with vowels
        allTestsPass &= runTest("apple", "appleyay");

        // Single consonant
        allTestsPass &= runTest("cat", "atcay");

        // Words with multiple consonants at the start
        allTestsPass &= runTest("school", "oolschay");

       // Multiple words
       allTestsPass &= runTest("cats eat fish", "atscay eatyay ishfay");

       // Mixed-case words
       allTestsPass &= runTest("Table", "Abletay");
       allTestsPass &= runTest("TaBlE", "Abletay");

       // Words with punctuation
       allTestsPass &= runTest("Hello!", "Ellohay!");
       allTestsPass &= runTest("well-done", "ellway-oneday");

       // Special characters and edge cases
       allTestsPass &= runTest("M.C.", "M.C.");
       allTestsPass &= runTest("@hello", "@ellohay");

       if (allTestsPass) {
        System.out.println("--- ALL TESTS PASSED! Great job! ---");
    } else {
        System.out.println("--- SOME TESTS FAILED. Please review. ---");
    }
}

public static boolean runTest(String input, String expectedOutput) {
    String actualOutput = PigLatinProcessor.processLine(input);
    if (actualOutput.equals(expectedOutput)) {
        System.out.println(" PASS: Input: '" + input + "' -> Output: '" + expectedOutput + "'");
        return true;
    } else {
        System.out.println(" FAIL: Input: '" + input + "', Output: '" + actualOutput + "' != Expected: '" + expectedOutput + "'");
        return false;
    }
}
}