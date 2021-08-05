package com.in28minutes.microservices.camelmsb.ebook;

import com.in28minutes.microservices.camelmsb.ebook.input.EbookMQMessage;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KafkaReceiverRouter extends RouteBuilder {

    @Autowired
    EbookJPAProcessor ebookJPAProcessor;

    @Override
    public void configure() throws Exception {
        from("kafka:myKafkaTopic")
                .log("${body}")
                .unmarshal().json(JsonLibrary.Jackson, EbookMQMessage.class)
                .bean(ebookJPAProcessor)
                .log("${body}")
                .to("log:received-message-from-kafka");

    }
}
