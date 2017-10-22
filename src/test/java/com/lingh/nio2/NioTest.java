package com.lingh.nio2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class NioTest {
	public static void test1() {
		Path listing = Paths.get("D:/james/mailbox/3");
		System.out.println("FileName:" + listing.getFileName());
		System.out.println("number of name elements:" + listing.getNameCount());
		System.out.println("parent path:" + listing.getParent());
		System.out.println("root path:" + listing.getRoot());
		System.out.println("subpath from root, 2 elements deep:" + listing.subpath(0, 2));
	}

	public static void testCreate() {
		System.out.println("create file");
		Path path = Paths.get("D:\\run\\test", "1.txt");
		try {
			Files.createFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("create dir");
		Path dir = Paths.get("D:\\run\\test\\subdir");
		try {
			Files.createDirectories(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void testDelete() {
		Path path = Paths.get("D:\\run\\test", "1.txt");
		try {
			Files.delete(path);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Path dir = Paths.get("D:\\run\\test\\subdir");
		try {
			Files.delete(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testDirectoryStream() {
		Path parent = Paths.get("D:\\run\\test");
		try {
			DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(parent);
			for (Path path : newDirectoryStream) {
				System.out.println(path);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void testCopy() {
		Path source = Paths.get("D:\\run\\test");
		Path target = Paths.get("D:\\run\\test2");
		try {
			// 只是拷贝文件夹自己, 文件下的文件以及子文件夹都没有拷贝
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testMove() {
		Path source = Paths.get("D:\\run\\test2");
		Path target = Paths.get("D:\\run\\test3");
		try {
			// 重命名后的目录下, 还是存在原来的子文件或者文件夹
			Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testReadBytes() {
		Path path = Paths.get("D:\\run\\test\\1.txt");
		byte[] readAllBytes;
		try {
			readAllBytes = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		for (byte b : readAllBytes) {
			System.out.print(Integer.toHexString(b) + " ");
		}
	}

	private static void testReadLines() {
		Path path = Paths.get("D:\\run\\test\\1.txt");
		try {
			List<String> allLines = Files.readAllLines(path);
			for (String line : allLines) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	public static void main(String[] args) {
		// test1();
		// testCreate();
		// testDelete();
		// testDirectoryStream();
		// testCopy();
		// testMove();
		// testReadBytes();
		// testReadLines();
//		testWriteBytes();
		testWriteLines();
	}

	private static void testWriteLines() {
		String line1 = "Easy read and write";
		String line2 = "with java.nio.file.Files";
		List<String> lines = Arrays.asList(line1, line2);
		Path path = Paths.get("D:\\run\\test\\3.txt");
		try {
			Files.write(path, lines, Charset.forName("utf-8"), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testWriteBytes() {
		String testStr = new String("aaaaaaaaaaaaa");
		Path path = Paths.get("D:\\run\\test\\2.txt");
		try {
			Files.write(path, testStr.getBytes(), StandardOpenOption.APPEND);  // java.nio.file.NoSuchFileException: D:\run\test\2.txt
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Files.write(path, testStr.getBytes(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
