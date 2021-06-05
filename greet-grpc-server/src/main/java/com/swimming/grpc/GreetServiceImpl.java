package com.swimming.grpc;

import com.swimming.grpc.generated.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {
    @Override
    public void hello(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        String reply = request.getMsg() + " > Hi, " + request.getName();
        log.info(reply);
        GreetResponse response = GreetResponse.newBuilder().setReply(reply).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void bye(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        String reply = request.getMsg() + " > Bye, " + request.getName();
        log.info(reply);
        GreetResponse response = GreetResponse.newBuilder().setReply(reply).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}