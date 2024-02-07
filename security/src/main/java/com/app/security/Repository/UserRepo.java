package com.app.security.Repository;

import com.app.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
