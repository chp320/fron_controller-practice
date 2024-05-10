package org.example.mvc.repository;

import org.example.mvc.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    // in-memory 로 자료를 저장
    private static Map<String, User> users = new HashMap<>();

    public static void save(User user) {
        users.put(user.getUserId(), user);      // userId 를 key 로 해서 저장
    }
}
