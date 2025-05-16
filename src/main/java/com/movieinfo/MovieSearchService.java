/*
 * 內部子系統
 * 負責搜尋電影並返回其IMDB網址。
 */

package com.movieinfo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieSearchService {
    private static final String SEARCH_BASE_URL = "https://www.imdb.com/find/?q=";
    private final WebConnector webConnector;

    public MovieSearchService() {
        this.webConnector = new WebConnector();
    }

    public String searchMovie(String movieTitle) throws IOException {
        String encodedTitle = encodeMovieTitle(movieTitle);
        Document searchDoc = webConnector.getDocument(SEARCH_BASE_URL + encodedTitle);
        
        Elements searchResults = searchDoc.select("a.ipc-metadata-list-summary-item__t");
        for (Element result : searchResults) {
            String href = result.attr("href");
            if (href.contains("/title/tt")) {
                return "https://www.imdb.com" + href;
            }
        }
        return null;
    }

    private String encodeMovieTitle(String title) throws UnsupportedEncodingException {
        return java.net.URLEncoder.encode(title, "UTF-8").replace("+", "%20");
    }
} 