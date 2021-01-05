package com.learning.fred.design.principle.prototype;

/**
 * @author fred
 * @date 2020/12/18 17:27
 * @description todo
 */
public class SearchWord {

    private long lastUpdateTime;
    private String keyWord;

    private long count;

    public SearchWord() {
    }

    public SearchWord(long lastUpdateTime, String keyWord, long count) {
        this.lastUpdateTime = lastUpdateTime;
        this.keyWord = keyWord;
        this.count = count;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getKeyWord() {

        return this.keyWord;
    }
}
