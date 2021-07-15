package com.in28minutes.microservices.camelmsb.ebook;

import com.in28minutes.microservices.camelmsb.ebook.input.EbookMQMessage;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiveRouter extends RouteBuilder {

    @Autowired
    EbookJPAProcessor ebookJPAProcessor;

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
                .unmarshal().json(JsonLibrary.Jackson, EbookMQMessage.class)
                .bean(ebookJPAProcessor)
                .to("log:received-message-from-activemq");


//        from("activemq:my-activemq-xml-queue")
//                .unmarshal()
//                .jacksonxml(Ebook.class)
////                .json(JsonLibrary.Jackson, Ebook.class)
//                .bean(bookValueTransformer)
//                .to("log:received-message-from-activemq");
    }
}



