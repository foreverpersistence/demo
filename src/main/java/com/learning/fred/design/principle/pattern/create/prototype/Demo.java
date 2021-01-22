package com.learning.fred.design.principle.pattern.create.prototype;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fred
 * @date 2020/12/18 17:26
 * @description todo
 */
public class Demo {

    private HashMap<String, SearchWord> currentKeyWords = new HashMap<>();

    private long lastUpdateTime = -1;

    public void refresh() {

        //实现 版本统一切换
        HashMap<String, SearchWord> newKeyWord = new LinkedHashMap<>();

        List<SearchWord> toBeUpdatedSearcheWords = getSearchWord(lastUpdateTime);
        long maxNewUpdateTime = lastUpdateTime;

        for (SearchWord searchWord : toBeUpdatedSearcheWords) {

            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }

            if (currentKeyWords.containsKey(searchWord.getKeyWord())) {
                currentKeyWords.replace(searchWord.getKeyWord(), searchWord);
            } else {
                currentKeyWords.put(searchWord.getKeyWord(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdateTime;

    }

    public void refresh2() {
        //原型模式, 减少 更新的数量 差值
        HashMap<String, SearchWord> newKeyWord = currentKeyWords;

        List<SearchWord> toBeUpdatedSearcheWords = getSearchWord(lastUpdateTime);
        long maxNewUpdateTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearcheWords) {

            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }

            // 浅拷贝， 存在中间状态
            if (newKeyWord.containsKey(searchWord.getKeyWord())) {
                SearchWord oldSearchWord = newKeyWord.get(searchWord.getKeyWord());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
                oldSearchWord.setCount(searchWord.getCount());

//                newKeyWord.replace(searchWord.getKeyWord(), searchWord);
            } else {
                newKeyWord.put(searchWord.getKeyWord(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdateTime;

        //replace

        currentKeyWords = newKeyWord;

    }

    //深拷贝

    public void refresh4() {
        HashMap<String, SearchWord> newKeyWord = new HashMap<>();

        // 循环新建
        for (Map.Entry<String, SearchWord> e : currentKeyWords.entrySet()) {
            SearchWord searchWord = e.getValue();

            SearchWord newSearchWord = new SearchWord(searchWord.getLastUpdateTime(),searchWord.getKeyWord(),searchWord.getCount());
            newKeyWord.put(e.getKey(),newSearchWord);

        }

        List<SearchWord> toBeUpdatedSearcheWords = getSearchWord(lastUpdateTime);
        long maxNewUpdateTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearcheWords) {

            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }

            // 浅拷贝， 存在中间状态
            if (newKeyWord.containsKey(searchWord.getKeyWord())) {
                SearchWord oldSearchWord = newKeyWord.get(searchWord.getKeyWord());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
                oldSearchWord.setCount(searchWord.getCount());

//                newKeyWord.replace(searchWord.getKeyWord(), searchWord);
            } else {
                newKeyWord.put(searchWord.getKeyWord(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdateTime;

        //replace

        currentKeyWords = newKeyWord;
    }

    /**
     * 序列化，反序列化
     */
    public Object deepCopy(Object obj) throws IOException, ClassNotFoundException {

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);

        return oi.readObject();

    }

    public void refresh6() {
        HashMap<String, SearchWord> newKeyWord = currentKeyWords;

        List<SearchWord> toBeUpdatedSearcheWords = getSearchWord(lastUpdateTime);
        long maxNewUpdateTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearcheWords) {

            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }

            // 浅拷贝， 存在中间状态
            if (newKeyWord.containsKey(searchWord.getKeyWord())) {
                //移除引用
                newKeyWord.remove(searchWord.getKeyWord());
            }

            newKeyWord.put(searchWord.getKeyWord(), searchWord);
        }

        lastUpdateTime = maxNewUpdateTime;

        //replace

        currentKeyWords = newKeyWord;

    }





    private List<SearchWord> getSearchWord(long lastUpdateTime) {
        return null;
    }


    public static void main(String[] args) {
        HashMap<String, Vo> map1 = new HashMap<>();
        map1.put("1", new Vo("1"));
        map1.put("2", new Vo("2"));
        map1.put("3",  new Vo("3"));

        HashMap<String, Vo> newMap = new HashMap<>(map1);

        Vo vo = newMap.get("1");
        vo.setName("5");

        System.out.println(map1);
        System.out.println(newMap);

         List<Vo> list = new ArrayList<>();
         list.add(new Vo("1"));
         list.add(new Vo("2"));

        List<Vo> vos = Collections.unmodifiableList(list);
        vos.get(0).setName("modify");//全部修改

        System.out.println(list);
        System.out.println(vos);

        list.stream()
                .collect(Collectors.toList());
    }

    private static class Vo {
        private String name;

        public Vo(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Vo{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
