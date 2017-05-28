package com.lingh.jmx;

import java.lang.management.ManagementFactory;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import com.sun.jdmk.comm.HtmlAdaptorServer;

// JMX超详细解读: http://www.cnblogs.com/dongguacai/p/5900507.html
// JConsole本地连接失败: http://www.cnblogs.com/xdouby/p/6270129.html
// HtmlAdaptorServer: http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-java-plat-419418.html
public class JmxTest {
	public static void main(String[] args) throws JMException, InterruptedException {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		ObjectName helloName = new ObjectName("jmxBean:name=hello");
		server.registerMBean(new Hello(), helloName);
		
		// HtmlAdaptorServer needs jmxri.jar jmxtools.jar
		ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		server.registerMBean(adapter, adapterName);
		adapter.start();
		
		Thread.sleep(60*60*1000);
	}
}
