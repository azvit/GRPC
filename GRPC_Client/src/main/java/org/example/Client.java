package org.example;


import com.example.grpc.GreatingService;
import com.example.grpc.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080").usePlaintext().build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);

        GreatingService.HelloRequest request = GreatingService.HelloRequest.newBuilder().setName("Victor").build();

        GreatingService.HelloResponse response = stub.greeting(request);
        System.out.println(response);
        channel.shutdownNow();
    }
}
