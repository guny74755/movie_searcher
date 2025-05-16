package com.movieinfo;

import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IMDBMovieInfo {
    public static void main(String[] args) {
        try {
            System.setProperty("file.encoding", "UTF-8");
            
            // 獲取用戶輸入
            String movieTitle = getUserInput();
            
            // 使用外觀類
            IMDBFacade imdbFacade = new IMDBFacade();
            MovieInfo movieInfo = imdbFacade.getMovieInfo(movieTitle);
            
            // 顯示結果
            displayMovieInfo(movieInfo);
            
        } catch (IOException e) {
            System.err.println("網路錯誤：" + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("輸入錯誤：" + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("執行錯誤：" + e.getMessage());
        }
    }

    private static String getUserInput() throws IOException {
        Console console = System.console();
        System.out.println("請輸入影視作品名稱：");
        String movieTitle;
        
        if (console != null) {
            movieTitle = console.readLine();
        } else {
            try (Scanner scanner = new Scanner(new InputStreamReader(System.in, "UTF-8"))) {
                movieTitle = scanner.nextLine();
            }
        }
        
        return new String(movieTitle.getBytes("UTF-8"), "UTF-8");
    }

    private static void displayMovieInfo(MovieInfo movieInfo) {
        System.out.println("\n電影資訊：");
        System.out.println("標題: " + movieInfo.getTitle());
        System.out.println("原始標題: " + movieInfo.getOriginalTitle());
        System.out.println("導演: " + movieInfo.getDirector());
        System.out.println("評分: " + movieInfo.getRating());
        System.out.println("上映日期: " + movieInfo.getReleaseDate());
        System.out.println("類型: " + String.join(", ", movieInfo.getGenres()));
        System.out.println("主要演員: " + String.join(", ", movieInfo.getCast()));
        System.out.println("IMDB頁面: " + movieInfo.getUrl());
    }
} 