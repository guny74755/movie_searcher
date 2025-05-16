/*核心類別
 * 整合了兩個服務：MovieSearchService和MovieInfoService。
 * 使用者只需調用IMDBFacade.getMovieInfo()，就能完成電影搜索和詳細資訊的提取，而不需要直接與複雜的底層邏輯交互。
 * 簡化接口：對於外部使用者，只需要關注IMDBFacade提供的方法，無需了解內部的細節實現。
 * 減少耦合：外部使用者與子系統之間的耦合性降低，子系統的修改不會直接影響使用者。
 * [IMDBFacade]
    |
    +--> [MovieSearchService] -- 搜尋電影
    |
    +--> [MovieInfoService]
            |
            +--> [IMDBDataExtractor] -- 策略
            +--> [GenreTranslator] -- 策略
            +--> [DateFormatter] -- 策略
 */

package com.movieinfo;

import java.io.IOException;

public class IMDBFacade {
    private final MovieSearchService searchService;
    private final MovieInfoService infoService;

    public IMDBFacade() {
        this.searchService = new MovieSearchService();
        this.infoService = new MovieInfoService();
    }

    public MovieInfo getMovieInfo(String movieTitle) throws IOException {
        // 1. 搜索電影
        String movieUrl = searchService.searchMovie(movieTitle);
        if (movieUrl == null) {
            throw new IOException("找不到該電影");
        }

        // 2. 獲取電影詳細信息
        return infoService.getMovieDetails(movieUrl);
    }
} 