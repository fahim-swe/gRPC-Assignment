package com.shopping.Service;

import com.shopping.db.User;
import com.shopping.db.UserDao;
import com.shopping.stubs.user.Gender;
import com.shopping.stubs.user.UserRequest;
import com.shopping.stubs.user.UserResponse;
import com.shopping.stubs.user.UserServiceGrpc;
import io.grpc.stub.StreamObserver;

public class UserSeviceImp extends UserServiceGrpc.UserServiceImplBase {


    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {


        UserDao userDao = new UserDao();
        User user = userDao.getDetails(request.getUsername());

        UserResponse.Builder builder = UserResponse.newBuilder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setName(user.getName())
                .setAge(user.getAge())
                .setGender(Gender.valueOf(user.getGender()));

        UserResponse userResponse = builder.build();

        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }
}
