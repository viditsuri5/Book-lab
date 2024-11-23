import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PigLatinProcessor {
  public static DigitalText convert(DigitalText inputText) {
    DigitalText convertedText = new DigitalText();
    convertedText.setBookTitle(inputText.getBookTitle());
        String outputFilePath = "ConvertedToPigLatin.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
          for (int i = 0; i < inputText.getTotalLines(); i++) {
            String originalLine = inputText.fetchLine(i);
            if (originalLine == null || originalLine.trim().isEmpty()) {
              convertedText.addLine(originalLine);
              writer.write(originalLine);
                    writer.newLine();
                  } else {
                    String pigLatinLine = processLine(originalLine);
                    convertedText.addLine(pigLatinLine);
                    writer.write(pigLatinLine);
                    writer.newLine();
                  }
                }
              } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
              }

              return convertedText;
            }

            public static String processLine(String line) {
              StringBuilder processedLine = new StringBuilder();
              if (line == null || line.isEmpty()) return line;

              String[] words = line.split(" ", -1);
              if (!line.isEmpty()) {
                for (int i = 0; i < words.length; i++) {
                  if (!words[i].isEmpty()) {
                      processedLine.append(processWord(words[i]));
                    }
                    if (i < words.length - 1) {
                      processedLine.append(" "); // Add spaces between words
                    }
                  }
              }

              return processedLine.toString();
            }

            private static String processWord(String word) {
              if (word == null || word.trim().isEmpty()) {
                return word; // Return empty or whitespace strings as-is
              }

              // Handle punctuation at the end of the word
      String punctuation = "";
      while (!word.isEmpty() && !Character.isLetterOrDigit(word.charAt(word.length() - 1))) {
        punctuation = word.charAt(word.length() - 1) + punctuation;
        word = word.substring(0, word.length() - 1);
      }
      if (word.isEmpty()) return punctuation; // Handle cases like "." or "..."

      if (word.contains("-")) {
        String[] segments = word.split("-");
        StringBuilder processedWord = new StringBuilder();
            for (int i = 0; i < segments.length; i++) {
              processedWord.append(processWord(segments[i]));
                if (i < segments.length - 1) {
                  processedWord.append("-");
                }
              }
              return processedWord + punctuation;
          }

          char firstCharacter = word.charAt(0);
          boolean isCapitalized = Character.isUpperCase(firstCharacter);

          if (isVowel(Character.toLowerCase(firstCharacter))) {
            String result = word + "yay";
            return isCapitalized ? capitalize(result) + punctuation : result + punctuation;
          } else {
            int vowelPosition = -1;
            for (int i = 0; i < word.length(); i++) {
              if (isVowel(word.charAt(i))) {
                  vowelPosition = i;
                  break;
                }
            }

            if (vowelPosition == -1) {
              return word + punctuation; // Return original word if no vowel
            }

            String result = word.substring(vowelPosition) + word.substring(0, vowelPosition) + "ay";
            return isCapitalized ? capitalize(result) + punctuation : result + punctuation;
          }
        }
        
        private static boolean isVowel(char c) {
          return "aeiouAEIOU".indexOf(c) >= 0;
        }

        private static String capitalize(String word) {
          if (word.isEmpty()) return word;

          char first = Character.toUpperCase(word.charAt(0));
          String remaining = word.substring(1).toLowerCase();
          return first + remaining;
      }
  }