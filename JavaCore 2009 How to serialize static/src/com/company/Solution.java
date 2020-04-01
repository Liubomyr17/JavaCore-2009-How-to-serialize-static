package com.company;

/*

2009 How to serialize static
Make ClassWithStatic serialization possible.

Requirements:
1. The ClassWithStatic class must exist within the Solution class.
2. ClassWithStatic must be static.
3. ClassWithStatic must be public.
4. ClassWithStatic must support Serializable interface.


 */


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "e:\\6.txt";
        ClassWithStatic cws = new ClassWithStatic();
        cws.i = 10;
        cws.j = 20;

        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName));

        writer.writeObject(cws);

        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileName));
        ClassWithStatic cws2 = (ClassWithStatic) reader.readObject();

        System.out.println("i="+cws2.i+" "+cws2.j+" "+cws2.staticString);
    }
}

