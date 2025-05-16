/*
 * 內部子系統
 * 負責根據IMDB網址提取詳細資訊。
 */

 package com.movieinfo;

 import java.io.IOException;
 
 import org.jsoup.nodes.Document;
 
 import com.movieinfo.strategy.DateFormatter;
 import com.movieinfo.strategy.GenreTranslator;
 import com.movieinfo.strategy.IMDBDataExtractor;
 import com.movieinfo.strategy.MovieDataExtractor;
 
 public class MovieInfoService {
     private final WebConnector webConnector;
     private final MovieDataExtractor dataExtractor;
     private final DateFormatter dateFormatter;
 
     public MovieInfoService() {
         this(new IMDBDataExtractor(new GenreTranslator()));
     }
 
     public MovieInfoService(MovieDataExtractor extractor) {
         this.webConnector = new WebConnector();
         this.dataExtractor = extractor;
         this.dateFormatter = new DateFormatter();
     }
 
     public MovieInfo getMovieDetails(String movieUrl) throws IOException {
         Document movieDoc = webConnector.getDocument(movieUrl);
         MovieInfo movieInfo = new MovieInfo();
 
         movieInfo.setTitle(dataExtractor.extractTitle(movieDoc));
         movieInfo.setOriginalTitle(dataExtractor.extractOriginalTitle(movieDoc));
         movieInfo.setRating(dataExtractor.extractRating(movieDoc));
         movieInfo.setReleaseDate(dateFormatter.format(dataExtractor.extractReleaseDate(movieDoc)));
         movieInfo.setGenres(dataExtractor.extractGenres(movieDoc));
         movieInfo.setCast(dataExtractor.extractCast(movieDoc));
         movieInfo.setDirector(((IMDBDataExtractor) dataExtractor).extractDirector(movieDoc)); // 設置導演
         movieInfo.setUrl(movieUrl);
 
         return movieInfo;
     }
 }
 