/*
 * 從IMDB網頁中提取電影資訊
 */

package com.movieinfo.strategy;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IMDBDataExtractor implements MovieDataExtractor {
    private final GenreTranslator genreTranslator;

    // 常量選擇器
    private static final String TITLE_SELECTOR = "h1";
    private static final String ORIGINAL_TITLE_SELECTOR = "div.sc-103e4e3c-1:contains(Original title:)";
    private static final String RATING_SELECTOR = "[data-testid=hero-rating-bar__aggregate-rating__score]";
    private static final String RELEASE_DATE_SELECTOR = "[data-testid=title-details-releasedate]";
    private static final String GENRE_SELECTOR = ".ipc-chip.ipc-chip--on-baseAlt .ipc-chip__text";
    private static final String CAST_SECTION_SELECTOR = "section[data-testid='title-cast']";
    private static final String CAST_ITEM_SELECTOR = "a[data-testid='title-cast-item__actor']";
    private static final String DIRECTOR_SELECTOR = "a.ipc-metadata-list-item__list-content-item--link"; // 導演選擇器

    public IMDBDataExtractor(GenreTranslator genreTranslator) {
        this.genreTranslator = genreTranslator;
    }

    @Override
    public String extractTitle(Document doc) {
        return extractText(doc, TITLE_SELECTOR, "無標題");
    }

    @Override
    public String extractOriginalTitle(Document doc) {
        String originalTitle = extractText(doc, ORIGINAL_TITLE_SELECTOR, null);
        return originalTitle != null ? originalTitle.replace("Original title: ", "") : "無原始標題";
    }

    @Override
    public String extractRating(Document doc) {
        return extractText(doc, RATING_SELECTOR, "暫無評分");
    }

    @Override
    public String extractReleaseDate(Document doc) {
        return extractText(doc, RELEASE_DATE_SELECTOR, "暫無日期");
    }

    @Override
    public List<String> extractGenres(Document doc) {
        return extractElementsText(doc, GENRE_SELECTOR, genreTranslator::translate);
    }

    @Override
    public List<String> extractCast(Document doc) {
        Element castSection = doc.selectFirst(CAST_SECTION_SELECTOR);
        if (castSection != null) {
            return extractElementsText(castSection, CAST_ITEM_SELECTOR, text -> text);
        }
        return new ArrayList<>();
    }

    @Override
    public String extractUrl(Document doc) {
        return doc.location();
    }

    // 新增方法：提取導演
    public String extractDirector(Document doc) {
        Element directorElement = doc.selectFirst(DIRECTOR_SELECTOR);
        return directorElement != null ? directorElement.text() : "未知導演";
    }

    // 輔助方法：提取單個元素的文本
    private String extractText(Document doc, String selector, String defaultValue) {
        Element element = doc.selectFirst(selector);
        return element != null ? element.text() : defaultValue;
    }

    // 輔助方法：提取多個元素的文本並應用轉換器
    private List<String> extractElementsText(Element parent, String selector, TextConverter converter) {
        List<String> texts = new ArrayList<>();
        Elements elements = parent.select(selector);
        for (Element element : elements) {
            texts.add(converter.convert(element.text()));
        }
        return texts;
    }

    // 函數式接口，用於文本轉換
    @FunctionalInterface
    private interface TextConverter {
        String convert(String text);
    }
}
