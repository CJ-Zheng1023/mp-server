package com.neusoft.mpserver.dao;

import com.neusoft.mpserver.domain.Mp_User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * user操作数据库层
 * @name fandp
 * @email fandp@neusoft.com
 */
public interface UserRepository   extends JpaRepository<Mp_User,String> {

    public List<Mp_User> findByUsername(String username);

    public Mp_User findByUsernameAndPassword(String username,String password);




}
