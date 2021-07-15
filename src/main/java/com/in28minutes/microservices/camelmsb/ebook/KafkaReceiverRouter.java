package com.in28minutes.microservices.camelmsb.ebook;

import com.in28minutes.microservices.camelmsb.ebook.input.EbookMQMessage;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

//@Component
public class KafkaReceiverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:myKafkaTopic")
                .log("${body}")
                .unmarshal().json(JsonLibrary.Jackson, EbookMQMessage.class)
                .log("${body}")
                .to("log:received-message-from-kafka");

    }
}
