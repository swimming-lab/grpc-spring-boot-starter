package com.swimming.grpc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class GreetGrpcClientApplication implements CommandLineRunner {

    private final GreetService greetService;

    public static void main(String[] args) {
        SpringApplication.run(GreetGrpcClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(greetService.hello("Java", "Hello~!"));
        log.info(greetService.bye("Java", "Bye~!"));
    }
}
