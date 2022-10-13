package com.snsimplem.sns.config;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/SNS")
public class controller {
    @Autowired
    public AmazonSNSClient SnsClient;
    String TOPIC_ARN="arn:aws:sns:ap-south-1:328400827861:SNSImplementation";

    @GetMapping("/addSubscription/{email}")
    public String addSubscription(@PathVariable String email){
        SubscribeRequest request=new SubscribeRequest(TOPIC_ARN,"email",email);
        SnsClient.subscribe(request);
        return "subscribe: "+email;
    }

    @GetMapping("/sendMessage/{message}")
    public String publishMessage(@PathVariable(value = "message")String message){
        PublishRequest publishRequest= new PublishRequest(TOPIC_ARN,message,"message");
        SnsClient.publish(publishRequest);
        return "Mohnish This Side";
    }

    @GetMapping("/subsReq")
    public String subscribeToSqs(){
        SubscribeRequest subscribeRequest=new SubscribeRequest(TOPIC_ARN,
                "sqs","arn:aws:sqs:ap-northeast-1:093821042948:firstqueue");
        SnsClient.subscribe(subscribeRequest);
        return "SQS Subscription Successful";
    }
}
