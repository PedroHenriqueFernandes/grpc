package org.example.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.grpc.services.HelloServiceImpl;

import java.io.IOException;

public class ServerMain {

        public static void main(String[] args) throws IOException, InterruptedException {
            Server server = ServerBuilder
                    .forPort (8089)
                    .addService(new HelloServiceImpl()).build();
            server.start();
            server.awaitTermination ();
        }
    }

