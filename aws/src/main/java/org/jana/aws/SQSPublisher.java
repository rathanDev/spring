package org.jana.aws;

import com.amazon.sqs.javamessaging.AmazonSQSMessagingClientWrapper;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.RegionUtils;

import javax.jms.*;

public class SQSPublisher {

    static final String ACCESS_KEY = "AKIARTYJ4YQ3PVGQARHM";
    static final String SECRET_KEY = "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";
    static final String REGION = "us-east-1";
    static final String QUEUE_NAME = "PublisherQueue";

    public static void main(String[] args) {

        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(credentials);


        SQSConnectionFactory connectionFactory = SQSConnectionFactory.builder()
                .withRegion(RegionUtils.getRegion(REGION))
                .withAWSCredentialsProvider(awsStaticCredentialsProvider)
                .build();

        try {

            SQSConnection connection = connectionFactory.createConnection();

            AmazonSQSMessagingClientWrapper client = connection.getWrappedAmazonSQSClient();
            if (!client.queueExists(QUEUE_NAME)) {
                client.createQueue(QUEUE_NAME);
            }

            // Create the nontransacted session with AUTO_ACKNOWLEDGE mode
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = session.createQueue(QUEUE_NAME);

            createProducer(session, queue);

            //createConsumer(connection, session, queue);


        } catch (Exception e) {
            System.out.println("e = " + e);
        }

    }

    private static void createConsumer(SQSConnection connection, Session session, Queue queue) throws JMSException {
        MessageConsumer consumer = session.createConsumer(queue);
        connection.start();
        Message message = consumer.receive(1000);

        if (message != null) {
            System.out.println("Received: " + ((TextMessage) message).getText());
        }

        connection.close();
    }

    private static void createProducer(Session session, Queue queue) throws JMSException {
        MessageProducer producer = session.createProducer(queue);

        TextMessage message = session.createTextMessage("HelloJMS");

        producer.send(message);
        System.out.println("JMS Message " + message.getJMSMessageID());
    }



}
