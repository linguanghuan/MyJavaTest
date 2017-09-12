package com.lingh.html2text;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * http://www.cnblogs.com/macula/archive/2011/07/27/2118003.html
 */
public class Dom4j {
    public static void main(String[] args) throws IOException, DocumentException {
        String htmlStr = FileUtils.readFileToString(new File("src/test/resources/test.html"), StandardCharsets.UTF_8);
        System.out.println(htmlStr);
        Document doc = DocumentHelper.parseText(htmlStr);
        String text = doc.getText();
        System.out.println("======================");
        System.out.println(text);
        //        Exception in thread "main" org.dom4j.DocumentException: Error on line 28 of document  : 与元素类型 "scrollAmount" 相关联的属性 "{1}" 应有左引号。
    }
}
