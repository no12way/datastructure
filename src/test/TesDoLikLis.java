package test;

import doublylinkedlist.DouLikList;

import java.util.Iterator;

public class TesDoLikLis {
    public static void main(String[] args) {
        DouLikList<String> douLikLis = new DouLikList<>();
        douLikLis.add("南京");
        douLikLis.add("上海");
        douLikLis.add("苏州");
        douLikLis.add("无锡");
        douLikLis.add("常州");
        Iterator iterator = douLikLis.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=================================");
        douLikLis.clear();
        douLikLis.add("南京");
        douLikLis.add("上海");
        douLikLis.add("苏州");
        douLikLis.add("无锡");
        douLikLis.deleteIndex(1);
        douLikLis.insert(1,"扬州");
        Iterator iter = douLikLis.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("======================================");
        String first = douLikLis.getFirst();
        String last = douLikLis.getLast();
        String get = douLikLis.getIndex(2);
        System.out.println("first"+first+"last"+last+"index2="+get);
        System.out.println("====================================");
        System.out.println(douLikLis.getFirst());
        System.out.println(douLikLis.getLast());
        System.out.println(douLikLis.getLength());

    }
}
