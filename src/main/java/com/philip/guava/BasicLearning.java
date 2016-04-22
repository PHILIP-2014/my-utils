package com.philip.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * basic data type
 * Created by Philip on 2016/4/22.
 */
public class BasicLearning {

  public static void main(String[] args) {
    //TODO
//    System.out.println(stringJoiner(" ", ""));
    System.out.println(stringSplitter());
  }

  /**
   * 连接器Joiner
   * 1. skip null
   * 2. replace null to '-'
   * 3. join obj
   */
  public static String stringJoiner(String joinon, String joinon1) {
    Joiner joiner = Joiner.on(joinon).skipNulls();
    Joiner joiner1 = Joiner.on(joinon1).useForNull("-");
    return joiner.join("Hello", null, "world", "!")
            + joiner1.join(" I'm", null, "Philip! ")
            + joiner1.join(Arrays.asList("@", 2016, null, 04, null, 22));
    //return "Hello world ! I'm-Philip! @2016-4-22"
  }

  /**
   * 拆分器Splitter
   *  前情：jdk下的string.split悄悄地丢弃了尾部的分隔符
   *  转机：Splitter使用令人放心的、直白的流畅API模式对这些混乱的特性作了完全的掌控
     *  omitEmptyStrings()	从结果中自动忽略空字符串
     *  trimResults()	移除结果字符串的前导空白和尾部空白
     *  trimResults(CharMatcher)	给定匹配器，移除结果字符串的前导匹配字符和尾部匹配字符
     *  limit(int)	限制拆分出的字符串数量
   */
  public static String stringSplitter() {
    System.out.println("start");
    Iterable<String> a = Splitter.on(',').trimResults().omitEmptyStrings().split("a,b,, c");
//    Iterable<String> a1 = Splitter.on(CharMatcher.BREAKING_WHITESPACE).trimResults().omitEmptyStrings().split("a,b,, c");
    List<String> alist = Lists.newArrayList(a);
    for (int i = 0; i < alist.size(); i++) {
      System.out.println(alist.get(i));
    }
    return "end";
  }

  /**
   *
   */

}
