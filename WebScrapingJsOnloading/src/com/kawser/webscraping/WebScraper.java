package com.kawser.webscraping;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class WebScraper {
    public static void main(String[] args) throws IOException {
    	
    	String queryString = "https://www.walmart.ca/en/electronics/N-32+103/page-13?sortBy=newest&orderBy=DESC";
    	
    	WebDriver driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get(queryString);
    	
    	Document doc = Jsoup.parse(driver.getPageSource());
    	
        Elements newsHeadlines = doc.select(".title");
        for (Element headline : newsHeadlines) {
            log("Log: %s",headline.html());
        }
        
    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}
