package org.jana.aws;

import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.RegionUtils;

import javax.jms.*;

public class SQSConsumer {

    static final String ACCESS_KEY = "AKIARTYJ4YQ3PVGQARHM";
    static final String SECRET_KEY = "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";
    static final String REGION = "us-east-1";
    static final String QUEUE = "PublisherQueue";

    public static void main(String[] args) {

        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(credentials);


        SQSConnectionFactory connectionFactory = SQSConnectionFactory.builder()
                .withRegion(RegionUtils.getRegion(REGION))
                .withAWSCredentialsProvider(awsStaticCredentialsProvider)
                .build();

        try {

            SQSConnection connection = connectionFactory.createConnection();
            System.out.println("--------------------------ReadyToStartConnection--------------------------");


            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = session.createQueue(QUEUE);

            System.out.println("--------------------------ReadyToCreateConsumer--------------------------");
            MessageConsumer consumer = session.createConsumer(queue);

            consumer.setMessageListener(new SQSAsyncListener());

            connection.start();

            Thread.sleep(1000);

        } catch (JMSException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}
