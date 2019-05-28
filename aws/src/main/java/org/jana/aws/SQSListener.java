package org.jana.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

import java.util.List;

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

        System.out.println("message = " + messages.get(0));
    }

}
