package com.snsimplem.sns.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.*;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.AmazonSNSException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;


@Configuration
public class config {
//    @Primary
  //  @Bean
   //public AmazonSNSClient getSnsClient() {
     //   return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion("")
       //         .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("",
    //"")))
      //          .build();
    //}
/*
    @Value("${aws.access-key}")
    private String awsAccessKey;

    @Value("${aws.secret-key}")
    private String awsSecretKey;

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.sns-endpoint}")
    private String snsEndpoint;
    @Bean
    public AWSCredentials credentials() {
        return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
    }

    @Bean
    public AmazonSNS amazonSNS() {
        return AmazonSNSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials()))
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(snsEndpoint, awsRegion))
                .build();
    }*/
    /*private static ClientConfiguration getClientConfiguration() {
        ClientConfiguration cfg = new ClientConfiguration();
        cfg.setProtocol(Protocol.HTTPS);
        //cfg.setProxyHost(proxyHost);
       cfg.setProxyPort(8099);
        return cfg;
    }

    @Bean
    public AmazonSNSClient getAmazonSnsLocalClient(Regions region) {
    Regions regions = Regions.AP_SOUTH_1;
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard()
                .withRegion(region).build();
    }

    // This Client is configured for Non-Local Profile for Dev, QA, Perf and Prod Profiles on EC2 Instances.

    public AmazonSNSClient getAmazonSNSClient(Regions region) {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withClientConfiguration(getClientConfiguration()).withRegion(region).build();
    }*/

/*
public static void main(String[] args){
    final String usage = "\n" +
            "Usage: " +
            "   <topicName>\n\n" +
            "Where:\n" +
            "   topicName - The name of the topic to create (for example, mytopic).\n\n";

    if (args.length != 1) {
        System.out.println(usage);
        System.exit(1);
    }

    String topicName = args[0];
    System.out.println("Creating a topic with name: " + topicName);
    AmazonSNSClient snsClient = AmazonSNSClient.builder()
            .withRegion(Regions.AP_SOUTH_1)
            .withCredentials(ProfileCredentialsProvider.create())
            .build();

    String arnVal = createSNSTopic(snsClient, topicName) ;
    System.out.println("The topic ARN is" +arnVal);
    snsClient.close();
}

    //snippet-start:[sns.java2.CreateTopic.main]
    public static String createSNSTopic(AmazonSNSClient snsClient, String topicName ) {

        CreateTopicResponse result = null;
        try {
            CreateTopicRequest request = CreateTopicRequest.builder()
                    .name(topicName)
                    .build();

            result = snsClient.createTopic(request);
            return result.topicArn();

        } catch (AmazonSNSException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return "";
    }
*/

    @Bean
    public AmazonSNSClient amazonS3() {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }

    //    private static final DynamoDBMapperConfig.TableNameResolver TABLE_NAME_RESOLVER = (className, config) -> "Data";
    public ClientConfiguration getClientConfiguration() {
        ClientConfiguration cfg = new ClientConfiguration();
        cfg.setProtocol(Protocol.HTTPS);
        //cfg.setProxyHost(proxyHost);
        cfg.setProxyPort(8099);
        return cfg;
    }

    private AmazonSNSClient getAmazonDynamoDBLocalClient(Regions region) {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard()
                .withRegion(region).build();
    }

    // This Client is configured for Non-Local Profile for Dev, QA, Perf and Prod Profiles on EC2 Instances.
    private AmazonSNSClient getAmazonDynamoDBClient(Regions region) {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withClientConfiguration(getClientConfiguration()).withRegion(region).build();
    }




}



