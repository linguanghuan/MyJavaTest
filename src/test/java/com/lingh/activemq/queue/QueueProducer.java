package com.lingh.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class QueueProducer {
    private static final String url = "tcp://127.0.0.1:61616";
    private static final String queueName = "queue-test";

    public static void main(String[] args) throws JMSException {

        // 1. 创建ConnectionFactory
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
        // 2. 创建Connection
        Connection connection = activeMQConnectionFactory.createConnection();
        // 3. 启动连接
        connection.start();
        // 4. 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 5. 创建一个目标
        Queue destination = session.createQueue(queueName);
        // 6. 创建生产者
        MessageProducer producer = session.createProducer(destination);
        for(int i=0; i<100; i++) {
            // 7. 创建消息
            TextMessage textMessage = session.createTextMessage("test" + i);
            // 8. 发布消息
            producer.send(textMessage);
            System.out.println("发送消息: " + textMessage.getText());
        }
        // 9. 关闭连接
        connection.close();
    }
}
