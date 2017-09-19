import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Arushi Agarwal
 * @version 09/19/2017
 *
 */

public class WebScraping {
    /**
     *
     * @param args parameter
     */
    public static void main(final String[] args) {
        System.out.println(urlToString("https://www.bls.gov/tus/charts/chart9.txt"));
        System.out.println(wordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(specificWord(urlToString("http://erdani.com/tdpl/hamlet.txt"),
                "sports"));
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
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

    /**
     *
     * @param str string parameter
     * @return int
     */

    public static int wordCount(final String str) {
        String url = str.trim();
        if (url.isEmpty()) {
            return 0;
        }
        return url.split(" ").length;
    }

    /**
     *
     * @param str url string
     * @param word string that we are looking for
     * @return amount of occurences of word in str
     */
    public static int specificWord(final String str, final String word) {
        String search = str;
        String fun = word.toUpperCase();
        search = search.toUpperCase();
        if (str.isEmpty()) {
            return 0;
        }
        return search.split(fun).length;
    }
}
