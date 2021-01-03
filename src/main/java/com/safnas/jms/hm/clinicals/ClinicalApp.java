package com.safnas.jms.hm.clinicals;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.safnas.jms.hm.model.Patient;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class ClinicalApp {

    public static void main(String[] args) throws JMSException, NamingException {
        
        InitialContext initialContext = new InitialContext();
        Queue requestQueue = (Queue) initialContext.lookup("queue/requestQueue");

        Queue replyQueue = (Queue) initialContext.lookup("queue/replyQueue");

        try(ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
            JMSContext jmsContext = cf.createContext()){

                JMSProducer producer = jmsContext.createProducer();

                ObjectMessage objectMessage = jmsContext.createObjectMessage();
                Patient patient = new Patient();
                patient.setId(123);
                patient.setName("Bob");
                patient.setInsuraceProvider("Blue Cross Blue Shield");
                patient.setCopay(30d);
                patient.setAmountToBePayed(500d);
                
                objectMessage.setObject(patient);

                producer.send(requestQueue, objectMessage);

                JMSConsumer consumer = jmsContext.createConsumer(replyQueue);
                MapMessage replyMessage = (MapMessage) consumer.receive(3000);
                System.out.println("Patient eligibility is :"+replyMessage.getBoolean("eligible"));
            }
    }
    
}
