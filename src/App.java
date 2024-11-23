public class BookTranslator {
    public static void main(String[] args){

        UtilityTests.runTests();
        translateAndSave(
            "Romeo & Juliet",
            "https://www.gutenberg.org/cache/epub/1513/pg1513.txt",
            "Romeo_Juliet_PigLatinOutput.txt"
         );
        translateAndSave(
            "Jane Eyre",
            "https://www.gutenberg.org/cache/epub/1260/pg1260.txt",
            "JaneEyre_PigLatinOutput.txt"
        );
    }

    private static void translateAndSave(String title, String fileUrl, String outputFile) {
        DigitalBook sourceBook = new DigitalBook();
        sourceBook.fetchFromWeb(title, fileUrl);
        System.out.println("Extracted Content from (" + title + "):");
        sourceBook.previewLines(1, 4);

        DigitalBook pigLatinBook = PigLatinProcessor.process(sourceBook);
        System.out.println("Pig Latin Translation for (" + title + "):");
        pigLatinBook.exportToFile(outputFile);
        System.out.println("Translation successfully saved at: " + outputFile);

    }
}

