package com.gateway;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@EnableHystrix
public class FallbackController {

    @RequestMapping("/bookingFallBack")
    public Mono<String> bookingDetailsFallBack(){
        return Mono.just("Booking details is taking to long to respond. please try again after some time");
    }
    @RequestMapping("/flightFallBack")
    public Mono<String> flightDetailsFallBack(){
        return Mono.just("Flight details is taking to long to respond. please try again after some time");
    }
    @RequestMapping("/reviewFallBack")
    public Mono<String> reviewDetailsFallBack(){
        return Mono.just("Review service is taking to long to respond. please try again after some time");
    }
    @RequestMapping("/loginFallBack")
    public Mono<String> loginDetailsFallBack(){
        return Mono.just("login service is taking to long to respond. please try again after some time");
    }
}
