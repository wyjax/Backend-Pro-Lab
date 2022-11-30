package com.wyjax.springgateway.config;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.netty.SslServerCustomizer;
import org.springframework.boot.web.server.Http2;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

@CommonsLog
public class NettyServerConfig implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {
    @Override
    public void customize(NettyReactiveWebServerFactory factory) {
//        Ssl ssl = new Ssl();
//        ssl.setEnabled(true);
//        ssl.setKeyAlias("classpath:sample.jks");
//        ssl.setKeyAlias("alias");
//        ssl.setKeyPassword("password");
//        ssl.setKeyStorePassword("secret");
//        Http2 http2 = new Http2();
//        http2.setEnabled(false);
//        factory.addServerCustomizers(new SslServerCustomizer(ssl, http2, null));
//        factory.setPort(8443);
    }
}
