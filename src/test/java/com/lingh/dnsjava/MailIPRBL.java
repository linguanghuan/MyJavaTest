package com.lingh.dnsjava;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xbill.DNS.ARecord;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;

public class MailIPRBL {
    private static String getIpReverse(String ip) {
        String[] split = ip.split("\\.");
        StringBuffer reverseIP = new StringBuffer();
        for (int i = split.length; i > 0; i--) {
            reverseIP.append(split[i - 1]);
            if (i != 1) {
                reverseIP.append(".");
            }
        }
        return reverseIP.toString();
    }

    public static void main(String[] args)  {
        String rblListStr = "blip.rbl.35.com,cbl.anti-spam.org.cn,zen.spamhaus.org,bl.spamcop.net,dnsbl.njabl.org";
        List<String> rblList = new ArrayList<>();
        String[] split = rblListStr.split(",");
        for (String rbl : split) {
            rblList.add(rbl);
        }
        System.out.println(rblList);
        String testIP = "123.1.2.3";
        String ipReverse = getIpReverse(testIP);
        System.out.println("ip reverse:" + ipReverse);
        System.out.println(new Date());
        for (String rbl : rblList) {
            String queryStr = ipReverse.concat(".").concat(rbl);
            System.out.println(queryStr);
            // http://www.dnsjava.org/dnsjava-current/examples.html

            // maven
            // http://blog.csdn.net/zhu_tianwei/article/details/45128537
            Record[] records;
            try {
                Lookup lookup= new Lookup(queryStr, Type.A);
                Lookup.getDefaultResolver().setTimeout(0, 500);// 500ms
                records = lookup.run();
            } catch (TextParseException e) {
                e.printStackTrace();
                continue;
            }
            if (records == null) {
                continue;
            }
            for (Record record : records) {
                ARecord a = (ARecord) record;
                String hostAddress = a.getAddress().getHostAddress();
                if (hostAddress.startsWith("127.")) {
                    System.out.println("in rbl list:" + rbl);
                }
            }
        }
        System.out.println(new Date());
    }
}
