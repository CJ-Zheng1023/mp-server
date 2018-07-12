package com.neusoft.mpserver.dao;

import com.neusoft.mpserver.domain.Mp_Token;
import com.neusoft.mpserver.domain.Mp_User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * token 操作数据库层
 * @name fandp
 * @email fandp@neusoft.com
 */
public interface TokenRepository   extends JpaRepository<Mp_Token,String> {

}
