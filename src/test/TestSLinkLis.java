package test;

import singlelinkedlist.SLinkLis;

import java.util.Iterator;

public class TestSLinkLis {
    public static void main(String[] args) {
        SLinkLis<String> strings = new SLinkLis<>();
        strings.add("南京");
        strings.add("苏州");
        strings.add("无锡");
        int nj = strings.firstExit("南京");
//        System.out.println(nj);
//        strings.reverse();
//        Iterator iterator = strings.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        strings.deleteById(1);
        strings.insert(1,"上海");
        Iterator iterator1 = strings.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        String byIndex = strings.getByIndex(2);
        System.out.println(byIndex);
    }
}

