package com.philip.study.guava;

import com.google.common.base.Optional;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

/**
 * Created by Philip on 2017/9/18.
 */
public class Found {

    private void collects() {

        // FIXME basic

        List<Object> arrayList = Lists.newArrayList(); //Lists.newArrayListWithExpectedSize(5);

        Map<String, List<String>> hashMap = Maps.newHashMap();

        Set<String> hashSet = newHashSet();

        // FIXME func


    }

    public static void main(String[] args) {

//        ImmutableList<String> words = ImmutableList.of("the", "athe", "bthe");
//        words.add("cthe"); //FIXME throw UnsupportedOperationException
//        System.out.println(words);

//        List<String> words2 = Lists.newArrayList("the", "the", "the", "as the time to the sky and the sun");
//
//        List<String> list = Lists.newArrayList("a", "b", "c", "d");


//        count1(words2);

//        count2(words2);

//        Preconditions.checkNotNull(words2, "参数不能为空");
//        Preconditions.checkState(words2.size() > 1, "参数值个数须大于1");

//        Multiset<String> multiset = HashMultiset.create();
//
//        HashSet setA = newHashSet(1, 2, 3, 4, 5);
//        HashSet setB = newHashSet(4, 5, 6, 7, 8);
//
//        //并集
//        Sets.SetView union = Sets.union(setA, setB);
//        System.out.println("union:" + union);
//
//        //交集
//        Sets.SetView intersection = Sets.intersection(setA, setB);
//        System.out.println("intersection:" + intersection);


//        mset();

        Optional<Integer> pos = Optional.of(null);
        System.out.println(pos.isPresent());
        System.out.println(pos.get());

    }

    //一个 List 里面有各种字符串，然后你要统计每个字符串在 List 里面出现的次数:
    private static void count1(List<String> words2) {
        Map<String, Integer> map = Maps.newHashMap();
        for(String word : words2){
            Integer count = map.get(word);
            map.put(word, (count == null) ? 1 : count + 1);
        }
        //count word “the”
        Integer count = map.get("the");
        System.out.println(count);
    }

    //用 Multiset 就可以这样 :
    private static void count2(List<String> words2) {
        HashMultiset<String> multiSet = HashMultiset.create();
        multiSet.addAll(words2);
        //count word “the”
        Integer count = multiSet.count("the");
        System.out.println(count);
    }

    private static void sort1() {
        Ordering<String> byLengthOrdering = new Ordering<String>() {
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };
    }

    private static void mset() {
        List<String> wordList = Lists.newArrayList("abc","abc","bbc","bbc","cbc","cbc","cbc");
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);
        System.out.println(wordsMultiset);

//        for(String key : wordsMultiset.elementSet()){
//            System.out.println(key+" count：" + wordsMultiset.count(key));
//        }
    }
}
