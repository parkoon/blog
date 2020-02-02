package com.hhwaaaaa1.blog.api.repository.mem;

import com.hhwaaaaa1.blog.api.entity.mem.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
