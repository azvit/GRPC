package org.example;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends com.example.grpc.GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(com.example.grpc.GreatingService.HelloRequest request,
                         StreamObserver<com.example.grpc.GreatingService.HelloResponse> responseObserver) {

        System.out.println(request);

        com.example.grpc.GreatingService.HelloResponse response = com.example.grpc.GreatingService.
                HelloResponse.newBuilder().setGreeting("Hello from server, " + request.getName())
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
