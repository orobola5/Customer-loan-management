package com.interviewku.userloan.Repository;

import com.interviewku.userloan.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(nativeQuery = true,value = "select * from user where email =:email ")
    User findByEmail(String email);

    @Query(nativeQuery = true,value = "select * from user where email =:email ")
    List<User> findAllByEmail(String email);

    Optional<User>findUserByFirstName(String username);
}
