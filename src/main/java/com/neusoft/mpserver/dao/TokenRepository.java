package com.neusoft.mpserver.dao;

import com.neusoft.mpserver.domain.Mp_User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * token 操作数据库层
 */
public interface TokenRepository   extends JpaRepository<Mp_User,String> {

}
