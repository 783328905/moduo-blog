package com.ctillnow.java8;


import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by caiping on 2019/12/26.
 */
public class Stream1 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        List<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int sum = 0;
        int sum1 = IntStream.of(nums).sum();
        LongStream longStream = IntStream.of(nums).mapToLong(Long :: new);
        longStream.forEach(System.out::println);


        IntStream.of(1,1,3,3).asDoubleStream();
        Map map  = new HashMap();
        List<User> users = new ArrayList<User>() ;
        users.add(new User(1,"cai"));
        users.add(new User(2,"ping"));
        Map<Integer, String> collect = users.stream().collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
        collect.forEach((x,y)->System.out.println(x+","+y));
        Optional<Integer> reduce = list.stream().reduce((x, y) -> (x * y));
        System.out.print(reduce.get());
        List<String> strings = new ArrayList<>();
        strings.add("fast one");
        strings.add("bad");
        strings.add("quick three");
        strings.stream().flatMap(x->Arrays.stream( x.split(" "))).forEach(System.out::println);
    }
}
class User{
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}