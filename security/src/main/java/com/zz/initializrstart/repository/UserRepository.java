package com.zz.initializrstart.repository;

import com.zz.initializrstart.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long>{
}
