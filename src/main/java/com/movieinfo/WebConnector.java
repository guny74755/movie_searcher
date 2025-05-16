/*
 * 專門用來進行網頁連接和資料抓取的工具類別。它負責從指定的URL下載網頁內容並將其轉換為 Jsoup Document 對象，方便後續的資料提取。
 */

package com.movieinfo;

import java.io.IOException;
import java.util.concurrent.Callable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebConnector {
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 1500;
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36";
    private static final String ACCEPT_LANGUAGE = "zh-TW,zh;q=0.9,en-US;q=0.8,en;q=0.7";

    //獲取指定URL的Document對象。

    public Document getDocument(String url) throws IOException {
        return retry(() -> Jsoup.connect(url)
                .userAgent(USER_AGENT)
                .header("Accept-Language", ACCEPT_LANGUAGE)
                .timeout(30000)
                .get(), MAX_RETRIES);
    }

    //重試指定的任務，直到成功或超過最大重試次數。
     
    private <T> T retry(Callable<T> task, int maxRetries) throws IOException {
        int retries = 0;
        while (true) {
            try {
                return task.call();
            } catch (Exception e) {
                retries++;
                if (retries >= maxRetries) {
                    throw new IOException("重試 " + maxRetries + " 次後仍然失敗", e);
                }
                // 重試延遲
                try {
                    Thread.sleep(RETRY_DELAY_MS);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new IOException("重試過程中被中斷", ie);
                }
            }
        }
    }
}
