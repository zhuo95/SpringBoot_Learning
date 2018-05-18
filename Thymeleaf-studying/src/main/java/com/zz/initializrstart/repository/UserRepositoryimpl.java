package com.zz.initializrstart.repository;

import com.zz.initializrstart.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryimpl implements UserRepository {
    //用于计数
    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long,User> userMap = new ConcurrentHashMap<>();

    public UserRepositoryimpl(){
        User user = new User();
        user.setAge(23);
        user.setName("ZZ");
        this.saveOrUpdateUser(user);
    }
    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if(id == null){
            id = counter.incrementAndGet();
            user.setId(id);
        }
        userMap.put(id,user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        if(userMap.containsKey(id)){
            return userMap.get(id);
        }
        return null;
    }

    @Override
    public List<User> listUser() {
        return new ArrayList<User>(userMap.values());
    }
}
