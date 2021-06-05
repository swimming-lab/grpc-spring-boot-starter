package com.swimming.grpc;

import com.swimming.grpc.generated.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GreetService {
    @GrpcClient("greet-grpc-server")
    private GreetServiceGrpc.GreetServiceBlockingStub greetStub;

    public String hello(String name, String msg) {
        GreetRequest request = GreetRequest.newBuilder()
                .setName(name)
                .setMsg(msg)
                .build();
        return greetStub.hello(request).getReply();
    }

    public String bye(String name, String msg) {
        GreetRequest request = GreetRequest.newBuilder()
                .setName(name)
                .setMsg(msg)
                .build();
        return greetStub.bye(request).getReply();
    }
}
