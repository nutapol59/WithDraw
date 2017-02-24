package com.ss.repository;


import com.ss.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser,Long> ,JpaRepository<AppUser, Long> {

    @Query(value = "select a from AppUser a where a.ldapUserName = ?1 and a.password = ?2")
    List<AppUser> findByUserNameAndPasswordEquals(String username,String password);

}
