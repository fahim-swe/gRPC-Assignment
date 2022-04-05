package com.shopping.Server;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.shopping.Service.UserSeviceImp;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class UserServer {

    private static final Logger logger = Logger.getLogger(UserServer.class.getName());


    private Server server;

    public void startServer() throws IOException {
        int port = 50051;

        server = ServerBuilder.forPort(port)
                .addService(new UserSeviceImp())
                .build()
                .start();


        Runtime.getRuntime().addShutdownHook(new Thread(){

            @Override
            public void run() {

                logger.info("Clean Server shutdown in case JVM was shutdown");

                try {
                    UserServer.this.stopServer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void stopServer() throws InterruptedException {
        if(server != null){
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntillShutdown() throws InterruptedException {
        if(server != null){
            server.awaitTermination();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Server is running.......");
        UserServer userServer = new UserServer();
        userServer.startServer();
        userServer.blockUntillShutdown();
    }

}
