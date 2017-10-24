package com.lingh.nio2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class OutputStreamTest {
	public void copyFiles(Path originPath, Path destinationPath) throws IOException {
		if (Files.notExists(originPath) || Files.exists(destinationPath)) {
			throw new IOException("Origin file must exist and " + "Destination file must not exist");
		}
		byte[] readData = new byte[1024];
		try (InputStream inputStream = Files.newInputStream(originPath, StandardOpenOption.READ);
				OutputStream outputStream = Files.newOutputStream(destinationPath, StandardOpenOption.CREATE)) {
			int i = inputStream.read(readData);
			while (i != -1) {
				outputStream.write(readData, 0, i);
				i = inputStream.read(readData);
			}
		} catch (IOException e) {
			throw e;
		}
	}

	public static void main(String[] args) {
		OutputStreamTest test = new OutputStreamTest();
		Path origin = Paths.get("D:\\run\\test\\1.txt");
		Path destination = Paths.get("D:\\run\\test\\4.txt");
		try {
			test.copyFiles(origin, destination);
			System.out.println("Copied Successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
