package com.in28minutes.microservices.camelmsb.ebook;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EbookRoute extends RouteBuilder {

    @Autowired
    EbookGetterBean ebookGetterBean;

    @Autowired
    EbookGetterByIdBean ebookGetterByIdBean;

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("netty-http")
                .host("127.0.0.1").port(8082);

        rest("/api/v2/ebooks")
                .get().consumes("application/json")
                    .route().routeId("ebooksRestRoute")
                    .bean(ebookGetterBean)
                    .marshal().json(JsonLibrary.Jackson);
        rest("/api/v2/ebooks")
                .get("{id}")
                    .route().routeId("ebookRestRouteById")
                    .to("bean:ebookGetterByIdBean?method=getEbookById(${header.id})")
                    .marshal().json(JsonLibrary.Jackson);
    }
}
