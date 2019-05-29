package org.jana.aws;

import com.amazon.sqs.javamessaging.AmazonSQSMessagingClientWrapper;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;


import javax.jms.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQSListener {

    static final String ACCESS_KEY = "AKIARTYJ4YQ3PVGQARHM";
    static final String SECRET_KEY = "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";
    static final String REGION = "us-east-1";
    static final String QUEUE = "firstQueue";

    public static void main(String[] args) {

        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(credentials);

        AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard()
                .withRegion(REGION)
                .withCredentials(awsStaticCredentialsProvider)
                .build();

        SQSListener sqsListener = new SQSListener();
        sqsListener.createQueue(amazonSQS);
        sqsListener.readFromQueue(amazonSQS);
        sqsListener.listQueues(amazonSQS);
        sqsListener.createJms();

    }

    public void createQueue(AmazonSQS sqs) {
        //        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

        CreateQueueRequest create_request = new CreateQueueRequest("fourthQueue")
                .addAttributesEntry("DelaySeconds", "60")
                .addAttributesEntry("MessageRetentionPeriod", "86400");

        try {
            sqs.createQueue(create_request);
        } catch (AmazonSQSException e) {
            if (!e.getErrorCode().equals("QueueAlreadyExists")) {
                throw e;
            }
        }
    }

    public void readFromQueue(AmazonSQS sqs) {
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(QUEUE)
                .withWaitTimeSeconds(10)
                .withMaxNumberOfMessages(10);
        List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();

        System.out.println("messageReceived: " + messages.get(0));
    }

    public void listQueues(AmazonSQS sqs) {

        System.out.println("List all queues");
        for (String url : sqs.listQueues().getQueueUrls()) {
            System.out.println("queue url = " + url);
        }

    }

    public void createJms() {

        System.out.println("------------------------Create JMS--------------------------------------");

        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(credentials);

        SQSConnectionFactory connectionFactory = SQSConnectionFactory.builder()
                .withRegion(RegionUtils.getRegion(REGION))
                .withAWSCredentialsProvider(awsStaticCredentialsProvider)
                .build();


        try {
            SQSConnection connection = connectionFactory.createConnection();
//            AmazonSQSMessagingClientWrapper client = connection.getWrappedAmazonSQSClient();

//            if (!client.queueExists("FirstFifo.fifo")) {
//                Map<String, String> attributes = new HashMap<>();
//                attributes.put("FifoQueue", "true");
//                attributes.put("ContentBasedDeduplication", "true");
//                client.createQueue(new CreateQueueRequest().withQueueName("FirstFifo.fifo").withAttributes(attributes));
//            }

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = session.createQueue("firstQueue");

//            MessageProducer producer = session.createProducer(queue);
//            TextMessage message = session.createTextMessage("First text message");
//            message.setStringProperty("JMSXGroupID", "Default");
//            message.setStringProperty("MessageGroupId", "Default");
//            producer.send(message);
//            System.out.println("JMS Message " + message.getJMSMessageID());
//            System.out.println("JMS message seq no" + message.getStringProperty("JMS_SQS_SequenceNumber"));


            MessageConsumer consumer = session.createConsumer(queue);
            connection.start();

            System.out.println("----------------------------ReadyToReceiveMessage-------------------------------------");
            javax.jms.Message receivedMessage = consumer.receive(1000);
            if (receivedMessage != null) {
                System.out.println("ReceivedMessage: " + ((TextMessage) receivedMessage).getText());

//                System.out.println("Group id: " + receivedMessage.getStringProperty("JMSXGroupID"));
//                System.out.println("Message deduplication id: " + receivedMessage.getStringProperty("JMS_SQS_DeduplicationId"));
//                System.out.println("Message sequence number: " + receivedMessage.getStringProperty("JMS_SQS_SequenceNumber"));
            } else {
                System.out.println("ReceivedMessage:null");
            }

            System.out.println("----------------------------close connection------------------------------------------");
            connection.close();


        } catch (JMSException e) {
            e.printStackTrace();
            return;
        }


    }

}
