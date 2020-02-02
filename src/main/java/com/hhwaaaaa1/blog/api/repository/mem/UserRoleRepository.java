package com.hhwaaaaa1.blog.api.repository.mem;

import com.hhwaaaaa1.blog.api.entity.mem.UserRole;
import com.hhwaaaaa1.blog.api.entity.mem.UserRoleCompositeKey;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, UserRoleCompositeKey> {
}
