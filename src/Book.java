import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList; 

public class DigitalText {
    private String bookTitle;
    private ArrayList<String> content = new ArrayList<>();

    public DigitalText() {
        // Constructor for an empty digital text

    }

    public void displayLines(int startIndex, int numberOfLines) {
        System.out.println("Showing lines " + startIndex + " to " + (startIndex + numberOfLines) + " from: " + bookTitle);
        for (int i = startIndex; i < startIndex + numberOfLines; i++) {
            if (i < content.size()) {
                System.out.println("Line " + (i + 1) + ": " + content.get(i));
            } else {
                System.out.println("Line " + (i + 1) + ": Not available in the text.");
            }
        }
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String fetchLine(int lineNumber) {
        return content.get(lineNumber);
    }

    public int getTotalLines() {
        return content.size();
    }

    public void addLine(String line) {
        content.add(line);
    }

    public void loadFromString(String title, String inputText) {
        // Load text content from a string input
        this.bookTitle = title;
        Scanner scanner = new Scanner(inputText);
        while (scanner.hasNext()) {
            content.add(scanner.nextLine());
        }
        scanner.close();
    }

    public void loadFromWeb(String title, String urlString) {
        // Load text content from a web URL
        this.bookTitle = title;

        try {
            URL sourceUrl = new URL(urlString);
            Scanner scanner = new Scanner(sourceUrl.openStream());
            while (scanner.hasNext()) {
                content.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("Error loading text from URL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void saveToFile(String fileName) {
        // Save text content to a specified file
        if (content.isEmpty()) {
            System.out.println("No text available to save.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : content) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Content successfully saved to: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

    public void saveToFileWithTitle() {
        // Save text content using the book title as the file name
        if (content.isEmpty()) {
            System.out.println("No text available to save.");
            return;
        }

        String fileName = bookTitle.replace(" ", "_") + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Saving content to file: " + fileName);
            for (String line : content) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
}

    

   

    int getLineCount()
    {
        return text.size();
    }

    void appendLine(String line)
    {
        text.add(line);
    }

    public void readFromString(String title, String string)
    {
        // load a book from an input string.
        this.title = title;
        Scanner scanner = new Scanner(string);
        while (scanner.hasNext()) 
        {
            String line = scanner.nextLine();
            text.add(line);
        }
        scanner.close();
    }

    public void readFromUrl(String title, String url)
    {
        // load a book from a URL.
        // https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html
        this.title = title;

        try {
            URL bookUrl = new URL(url);
            Scanner scanner = new Scanner(bookUrl.openStream());
            while (scanner.hasNext()) 
            {
                text.add(scanner.nextLine());
            }
            scanner.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    void writeToFile()
    {
        // Add code here to write the contents of the book to a file.
    }
}