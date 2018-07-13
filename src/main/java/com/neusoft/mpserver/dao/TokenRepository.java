package com.neusoft.mpserver.dao;
import com.neusoft.mpserver.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * token 操作数据库层
 * @name fandp
 * @email fandp@neusoft.com
 */

public interface TokenRepository   extends JpaRepository<Token,String> {
    public Token findByTokenId(String tokenId);
}
