package com.lingh.compress;

import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class ZipTest {

	/**
	 * linux c zlib库 的java解压方式 因为zlib的结果是二进制的形式, 所以这里是用base64编码后的字符串做测试
	 * base64解码后的二进制就是zlib压缩的格式 base64用:commons-codec-1.10.jar
	 * http://commons.apache.org/
	 * 
	 * @throws DataFormatException
	 * @throws UnsupportedEncodingException
	 */
	@Test
	public void testDeCompress() throws DataFormatException,
			UnsupportedEncodingException {
		System.out.println("linux zlib uncompress test");
		String base64Str = "eJyFkTsSgzAMRHtOknRIMv5sGSZlaJwmd2DS5f6RgRQMQvHYQ7FPWqGtQH3V5/0BjMAEUCSAB+Dy/szztas7QC8lBgIw9JYmKui3N0QhboS+zN3t4NvroaV6czYQiqu3R0Qg+khSG/EIJp8oOqrKjTK3tNrIblaTKP+IkIHsE9qjLdZBBp0zukSLVM4jl/anLO3RUQ0ttmyFPm1iOVnluBSpyqms9VZcWTukX4cvUYWtUA==";
		byte[] base64DecodedResult = Base64.decodeBase64(base64Str);
		Inflater decompresser = new Inflater();
		decompresser.setInput(base64DecodedResult);
		byte[] decompressResult = new byte[10240];
		int resultLength = decompresser.inflate(decompressResult);
		decompresser.end();
		System.out.println(resultLength);
		String decompresserStr = new String(decompressResult, 0, resultLength,
				"UTF-8");
		System.out.println(decompresserStr);
	}
}
