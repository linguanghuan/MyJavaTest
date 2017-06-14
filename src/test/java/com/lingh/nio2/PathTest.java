package com.lingh.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void test1(){
        Path listing = Paths.get("D:/james/mailbox/3");
        System.out.println("FileName:" + listing.getFileName());
        System.out.println("number of name elements:" + listing.getNameCount());
        System.out.println("parent path:" + listing.getParent());
        System.out.println("root path:" + listing.getRoot());
        System.out.println("subpath from root, 2 elements deep:" + listing.subpath(0,2));
    }
}
