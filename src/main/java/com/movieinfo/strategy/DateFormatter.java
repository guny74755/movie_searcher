/*
 * 負責將日期格式轉換成中文格式，這是一種策略。
 */

package com.movieinfo.strategy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatter {
    public String format(String originalDate) {
        // 原有的日期格式化邏輯
        String date = originalDate.replace("Release date", "").trim();
        Pattern pattern = Pattern.compile("(\\w+)\\s+(\\d{1,2}),?\\s+(\\d{4})");
        Matcher matcher = pattern.matcher(date);
        
        if (matcher.find()) {
            String month = convertMonth(matcher.group(1));
            String day = matcher.group(2);
            String year = matcher.group(3);
            return String.format("%s年%s月%s日", year, month, day);
        }
        return date;
    }

    private String convertMonth(String monthName) {
        switch (monthName.toLowerCase()) {
            case "january": return "1";
            case "february": return "2";
            case "march": return "3";
            case "april": return "4";
            case "may": return "5";
            case "june": return "6";
            case "july": return "7";
            case "august": return "8";
            case "september": return "9";
            case "october": return "10";
            case "november": return "11";
            case "december": return "12";
            default: return monthName;
        }
    }
} 