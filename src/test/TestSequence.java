package test;

import sequencelist.SequenceList;

import java.util.Iterator;

public class TestSequence {
    public static void main(String[] args) {
        SequenceList<String> strings = new SequenceList<String>(8);
        strings.add("first");
        strings.add("second");
        strings.add("江苏");
        strings.add("上海");
        strings.add("广州");
        strings.add("深圳");
        strings.add("浙江");
        strings.add("福建");
        strings.add("北京");
        strings.delete(4);
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(strings.firstExit("江苏"));
        strings.clear();
    }
}
