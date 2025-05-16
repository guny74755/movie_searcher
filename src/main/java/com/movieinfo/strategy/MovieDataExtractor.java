/*
核心接口，定義了提取電影數據的方法
如果需要從不同來源（例如爛番茄、豆瓣、Netflix）提取電影資訊，可以新增其他實現MovieDataExtractor的類別，無需修改現有程式碼。
將具體行為（如翻譯類型、格式化日期、提取數據） 分別封裝在不同的類中，方便修改和擴展。
更靈活：可以隨時替換或新增其他翻譯器、日期格式化工具等，而不影響主要程式。
*/

package com.movieinfo.strategy;

import java.util.List;

import org.jsoup.nodes.Document;

public interface MovieDataExtractor {
    String extractTitle(Document doc); //提取電影的主標題（標題名稱）
    String extractOriginalTitle(Document doc); //提取電影的原始標題（如果存在）
    String extractRating(Document doc); //提取電影的評分（例如IMDB評分）
    String extractReleaseDate(Document doc); //提取電影的上映日期。
    List<String> extractGenres(Document doc); //提取電影的類型（Genre），例如"動作"、"喜劇"。
    List<String> extractCast(Document doc); //提取主要演員列表。
    String extractUrl(Document doc); //提取電影的IMDB網址（或原始網頁URL）。
} 