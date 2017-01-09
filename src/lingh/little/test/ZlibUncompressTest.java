package lingh.little.test;

import java.util.zip.Inflater;

import org.apache.commons.codec.binary.Base64;

/**
* @author linguanghuan
* @Time 2017-01-09 14:41:55
* @Desc 
*    linux c zlib�� ��java��ѹ��ʽ
*    base64��:commons-codec-1.10.jar http://commons.apache.org/
*/
public class ZlibUncompressTest {
	
    /**
     * @Desc
     *     ��Ϊzlib�Ľ���Ƕ����Ƶ���ʽ, ������������base64�������ַ���������
     *     base64�����Ķ����ƾ���zlibѹ���ĸ�ʽ
     */
    private static void zlibUncompressTest() throws Exception {
        System.out.println("linux zlib uncompress test");
        String base64Str="eJyFkTsSgzAMRHtOknRIMv5sGSZlaJwmd2DS5f6RgRQMQvHYQ7FPWqGtQH3V5/0BjMAEUCSAB+Dy/szztas7QC8lBgIw9JYmKui3N0QhboS+zN3t4NvroaV6czYQiqu3R0Qg+khSG/EIJp8oOqrKjTK3tNrIblaTKP+IkIHsE9qjLdZBBp0zukSLVM4jl/anLO3RUQ0ttmyFPm1iOVnluBSpyqms9VZcWTukX4cvUYWtUA==";
        byte[] base64DecodedResult = Base64.decodeBase64(base64Str);
        Inflater decompresser = new Inflater();
        decompresser.setInput(base64DecodedResult);
        byte[] decompressResult = new byte[10240];
        int resultLength = decompresser.inflate(decompressResult);
        decompresser.end();
        System.out.println(resultLength);
        String decompresserStr = new String(decompressResult, 0, resultLength, "UTF-8");
        System.out.println(decompresserStr);
    }
    
    public static void main(String[] args) {
        try {
            zlibUncompressTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
