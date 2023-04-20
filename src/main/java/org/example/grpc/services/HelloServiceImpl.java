package org.example.grpc.services;

import io.grpc.stub.StreamObserver;
import org.example.HelloRequest;
import org.example.HelloResponse;
import org.example.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(
            HelloRequest request , StreamObserver<HelloResponse> responseObserver) {
        String greeting = new StringBuilder ()
                .append("Hello , ")
                .append(request.getFirstName ())
                .append(" ")
                .append(request.getLastName ()).toString ();
        HelloResponse response = HelloResponse.newBuilder ()
                .setGreeting(greeting)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
