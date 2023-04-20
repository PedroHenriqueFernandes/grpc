package org.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.HelloRequest;
import org.example.HelloResponse;
import org.example.HelloServiceGrpc;

public class ClientMain {
        public static void main(String[] args) {
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",
                            8089)
                    .usePlaintext ()
                    .build();
            HelloServiceGrpc.HelloServiceBlockingStub stub
                    = HelloServiceGrpc.newBlockingStub(channel);
            HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder ()
                    .setFirstName("Distributed")
                    .setLastName("Systems")
                    .build());
            System.out.println(helloResponse.getGreeting ());
            channel.shutdown ();
        }
}
