//package com.example.order.connector;
//
//import feign.Contract;
//import feign.auth.BasicAuthRequestInterceptor;
//import org.springframework.context.annotation.Bean;
//
//public class OrderConfiguration {
//     @Bean
//        public Contract feignContract() {
//            return new feign.Contract.Default();
//        }
//
//        @Bean
//        public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//            return new BasicAuthRequestInterceptor("user", "password");
//        }
//    }
