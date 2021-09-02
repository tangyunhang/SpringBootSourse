package com.abc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test1 {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("aaa",23));
        list.add(new User("4444",21));
        list.forEach(o-> {
            o.setAge(o.getAge() + 2);
            o.setName(te(o.getName()));

        });
        System.out.println(list.toString());
    }

    static String te (String dd){

        return dd+"2211";
    }

  @Data
  @NoArgsConstructor
  static class User {
        String name;
        int age;

        User(String name,int age){
            this.age=age;
            this.name=name;
        }
  }
}
