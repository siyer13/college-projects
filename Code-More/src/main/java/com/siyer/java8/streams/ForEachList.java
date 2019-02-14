package com.siyer.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Sridhar");
        list.add("Swathi");
        list.add("Hari");
        list.add("Vaidya");
        list.add("Krishna");

        concat s = (str, str1) -> str + str1;
        System.out.println(s.scon("Hello", "world"));


        //list.forEach((name) -> System.out.println(name));
        //list.stream().collect(Collectors.toList());
        list.stream().filter(n -> n.contains("s")).collect(Collectors.toList()).forEach(nameWithS -> System.out.println(nameWithS));
    }
}
interface concat {
    String scon(String a, String b);
}