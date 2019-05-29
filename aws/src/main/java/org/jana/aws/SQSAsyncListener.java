package org.jana.aws;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SQSAsyncListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Received: " + ((TextMessage) message).getText());

            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");

            Thread.sleep(5000);

        } catch (JMSException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
