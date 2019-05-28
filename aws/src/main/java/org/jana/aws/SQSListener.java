package org.jana.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;

public class SQSListener {

    static final String ACCESS_KEY = "AKIARTYJ4YQ3PVGQARHM";
    static final String SECRET_KEY = "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";
    static final String REGION = "us-east-1";

    public static void main(String[] args) {

        SQSListener sqsListener = new SQSListener();
        sqsListener.createQueue();

    }

    public void createQueue() {
        //        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
        AWSStaticCredentialsProvider awsStaticCredentialsProvider = new AWSStaticCredentialsProvider(credentials);

        AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard()
                .withRegion(REGION)
                .withCredentials(awsStaticCredentialsProvider)
                .build();

        CreateQueueRequest create_request = new CreateQueueRequest("thirdQueue")
                .addAttributesEntry("DelaySeconds", "60")
                .addAttributesEntry("MessageRetentionPeriod", "86400");

        try {
            amazonSQS.createQueue(create_request);
        } catch (AmazonSQSException e) {
            if (!e.getErrorCode().equals("QueueAlreadyExists")) {
                throw e;
            }
        }
    }

}
