/*
 * 負責將電影類型從英文翻譯成中文，這是一種策略。
 */
package com.movieinfo.strategy;

import java.util.HashMap;
import java.util.Map;

public class GenreTranslator {
    private final Map<String, String> translations;

    public GenreTranslator() {
        translations = new HashMap<>();
        initializeTranslations();
    }

    private void initializeTranslations() {
        translations.put("Action", "動作");
        translations.put("Adventure", "冒險");
        translations.put("Animation", "動畫");
        translations.put("Biography", "傳記");
        translations.put("Comedy", "喜劇");
        translations.put("Crime", "犯罪");
        translations.put("Documentary", "紀錄片");
        translations.put("Drama", "劇情");
        translations.put("Family", "家庭");
        translations.put("Fantasy", "奇幻");
        translations.put("Film-Noir", "黑色電影");
        translations.put("Game-Show", "遊戲節目");
        translations.put("History", "歷史");
        translations.put("Horror", "恐怖");
        translations.put("Mystery", "懸疑");
        translations.put("News", "新聞");
        translations.put("Reality-TV", "真人秀");
        translations.put("Romance", "愛情");
        translations.put("Sci-Fi", "科幻");
        translations.put("Short", "短片");
        translations.put("Sport", "運動");
        translations.put("Talk-Show", "脫口秀");
        translations.put("Thriller", "驚悚");
        translations.put("War", "戰爭");
        translations.put("Western", "西部");
        translations.put("Adult", "成人");
        translations.put("Music", "音樂");
        translations.put("Musical", "音樂劇");
        translations.put("Superhero", "超級英雄");
        translations.put("Disaster", "災難");
        translations.put("Martial-Arts", "武術");
        translations.put("Psychological", "心理");
        translations.put("Supernatural", "超自然");
        translations.put("Spy", "間諜");
        translations.put("Teen", "青少年");
        translations.put("War-Comedy", "戰爭喜劇");
        translations.put("Historical-Fiction", "歷史虛構");
        translations.put("Dark-Comedy", "黑色喜劇");
        translations.put("Epic", "史詩");
        translations.put("Crime-Comedy", "犯罪喜劇");
        translations.put("Family-Drama", "家庭劇");
        translations.put("Romantic-Comedy", "浪漫喜劇");
        translations.put("Science-Fantasy", "科幻奇幻");
        translations.put("Mystery-Thriller", "懸疑驚悚");
        translations.put("Experimental", "實驗電影");
        translations.put("Anthology", "選集");
        translations.put("Cyberpunk", "賽博朋克");
        translations.put("Steampunk", "蒸汽朋克");
        translations.put("Post-Apocalyptic", "末日後");
        translations.put("Found-Footage", "偽紀錄片");
        translations.put("Mockumentary", "假紀錄片");
        translations.put("Political", "政治片");
        translations.put("Legal", "法律片");
        translations.put("Military", "軍事片");
        translations.put("Period-Drama", "時代劇");
        translations.put("Nature", "自然片");
        translations.put("Silent", "無聲電影");
        translations.put("Slasher", "血腥驚悚");
        translations.put("Satire", "諷刺片");
        translations.put("Biography-Drama", "傳記劇情");
        translations.put("Road-Movie", "公路電影");
        translations.put("Coming-of-Age", "成長電影");
        translations.put("Cult", "邪典電影");
        translations.put("Parody", "惡搞");
        translations.put("Heist", "劫案片");
        translations.put("Gothic", "哥特風");
        translations.put("Tragedy", "悲劇");
        translations.put("Fantasy-Comedy", "奇幻喜劇");
        translations.put("Space-Opera", "太空歌劇");
        translations.put("Body-Horror", "身體恐怖");
        translations.put("Time-Travel", "時間旅行");
        translations.put("Sports-Comedy", "運動喜劇");
        translations.put("Fantasy-Adventure", "奇幻冒險");
        translations.put("Alien-Invasion", "外星人入侵");
        translations.put("Zombie", "殭屍片");
        translations.put("Vampire", "吸血鬼片");
        translations.put("Werewolf", "狼人片");
        translations.put("Fairy-Tale", "童話片");
        translations.put("Espionage", "諜報片");
        translations.put("Underwater", "水下冒險");
        translations.put("Caper", "輕鬆劫案");
        translations.put("Prison", "監獄片");
        translations.put("Survival", "生存片");
        translations.put("Religious", "宗教片");
        translations.put("Courtroom", "法庭片");
        translations.put("Spy-Comedy", "間諜喜劇");
        translations.put("Techno-Thriller", "科技驚悚");
        translations.put("Monster", "怪獸片");
        translations.put("Kaiju", "怪獸大戰");
        translations.put("Artificial-Intelligence", "人工智慧");
        translations.put("Robotics", "機器人片");
        translations.put("Mythology", "神話片");
        translations.put("Ninja", "忍者片");
        translations.put("Samurai", "武士片");
        translations.put("Historical-Drama", "歷史劇情");
        translations.put("Detective", "偵探片");
        translations.put("Film-Essay", "電影隨筆");
        translations.put("Eco-Terror", "環保恐怖");
        translations.put("Underworld", "黑幫片");
        translations.put("Drug-Cartel", "毒梟片");
        translations.put("Gangster", "幫派片");
        translations.put("Street-Racing", "街頭賽車");
        translations.put("Car-Chase", "車追逐片");
        translations.put("Rockumentary", "搖滾紀錄片");
        translations.put("Food", "美食片");
        translations.put("Dance", "舞蹈片");
        translations.put("Wedding", "婚禮片");
        translations.put("Vacation", "假日片");
        translations.put("Alien-Friendship", "外星友誼");
        translations.put("Disaster-Comedy", "災難喜劇");
        translations.put("Romantic-Thriller", "浪漫驚悚");
        translations.put("Medical", "醫療片");
        translations.put("Space-Exploration", "太空探險");
        translations.put("War-Epic", "戰爭史詩");
        translations.put("Sword-and-Sorcery", "劍與魔法");
        translations.put("Historical-War", "歷史戰爭");
        translations.put("Supernatural-Thriller", "超自然驚悚");
        translations.put("Haunted-House", "鬼屋片");
        translations.put("Psychological-Horror", "心理恐怖");
        translations.put("Surreal", "超現實片");
        translations.put("Musical-Comedy", "音樂喜劇");
        translations.put("Musical-Drama", "音樂劇情");
        translations.put("Neo-Noir", "新黑色電影");
        translations.put("LGBTQ+", "同志電影");
        translations.put("Drag", "變裝片");
        translations.put("Erotic-Thriller", "情色驚悚");
        translations.put("Wuxia", "武俠片");
        translations.put("Travel", "旅行片");
        translations.put("War-Documentary", "戰爭紀錄片");
        translations.put("Fitness", "健身片");
        translations.put("Biography-Musical", "傳記音樂片");
        translations.put("Docudrama", "紀實劇");
        translations.put("Spy-Thriller", "間諜驚悚");
        translations.put("Mock-Spiritual", "偽靈性片");
        translations.put("Skiing", "滑雪片");
        translations.put("Murder-Mystery", "謀殺懸疑");
        translations.put("Serial-Killer", "連環殺手");
        translations.put("Oceanic", "海洋片");
        translations.put("Alien-Horror", "外星恐怖片");
        translations.put("Film-Poem", "電影詩");

        // 新增的類型持續增加至300個...
    }

    public String translate(String englishGenre) {
        return translations.getOrDefault(englishGenre, englishGenre);
    }
}
