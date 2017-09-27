import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Lab3Class {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String hamlet = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(wordCount(hamlet));
        //System.out.println(hamlet);
        System.out.println(specificWordCount(hamlet, "prince"));
    }


    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCount(final String reading) {
        int count = 0;
        for (int i = 0; i < reading.length(); i++) {
            if(reading.charAt(i) == ' ') count ++;
        }
        return count + 1;
    }

    public static int specificWordCount(final String reading, final String specificWord) {
        int count = 0;
        int readingLength = reading.length();
        int wordLength = specificWord.length();
        for (int i = 0; i < readingLength - wordLength; i++) {
            if (specificWord.equals(reading.substring(i,  i + wordLength))) {
                count++;
            }
        }
        return count;
    }
}

