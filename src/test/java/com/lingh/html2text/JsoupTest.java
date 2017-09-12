package com.lingh.html2text;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;

/**
 * http://yangfuchao418.iteye.com/blog/763069
 */
public class JsoupTest {

    public static void main(String[] args) throws IOException {
        String htmlStr = FileUtils.readFileToString(new File("src/test/resources/test.html"), StandardCharsets.UTF_8);
        String text = Jsoup.parse(htmlStr).text();
        System.out.println(text);
    }

}
