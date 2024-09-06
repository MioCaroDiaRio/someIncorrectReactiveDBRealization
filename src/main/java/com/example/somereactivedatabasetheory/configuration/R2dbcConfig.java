//package com.example.somereactivedatabasetheory.configuration;
//
//import io.r2dbc.spi.ConnectionFactories;
//import io.r2dbc.spi.ConnectionFactory;
//import io.r2dbc.spi.ConnectionFactoryOptions;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//
//@Configuration
//@EnableR2dbcRepositories(basePackages = "com.example.somereactivedatabasetheory.repository.r2dbc")
//public class R2dbcConfig {
//
//    @Value("${spring.r2dbc.url}")
//    private String r2dbcUrl;
//
//    @Value("${spring.r2dbc.username}")
//    private String r2dbcUsername;
//
//    @Value("${spring.r2dbc.password}")
//    private String r2dbcPassword;
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        ConnectionFactoryOptions options = ConnectionFactoryOptions.parse(r2dbcUrl)
//                .mutate()
//                .option(ConnectionFactoryOptions.USER, r2dbcUsername)
//                .option(ConnectionFactoryOptions.PASSWORD, r2dbcPassword)
//                .build();
//
//        return ConnectionFactories.get(options);
//    }
//}
