package com.neusoft.mpserver.dao;

import com.neusoft.mpserver.domain.Token;
import com.neusoft.mpserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;


/**
 * token 操作数据库层
 * @name fandp
 * @email fandp@neusoft.com
 */
@Transactional
public interface TokenRepository   extends JpaRepository<Token,String> {
    public Token findByTokenId(String tokenId);
}
