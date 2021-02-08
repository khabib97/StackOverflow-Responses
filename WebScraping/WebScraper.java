import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class WebScraper {
    public static void main(String[] args) throws IOException {
    	String query = "doctor";// take input
    	String queryString = "https://www.google.com/search?q=";
    	queryString += query;
    	
    	
        Document doc = Jsoup.connect(queryString).get();
        log(doc.title());

        Elements newsHeadlines = doc.select(".g h3 span");
        for (Element headline : newsHeadlines) {
            log("Log: %s",headline.html());
        }
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
