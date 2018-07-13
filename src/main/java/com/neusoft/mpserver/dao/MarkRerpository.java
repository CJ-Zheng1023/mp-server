package com.neusoft.mpserver.dao;
import com.neusoft.mpserver.domain.Mark;
import com.neusoft.mpserver.domain.Token;
import com.neusoft.mpserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * mark操作数据库层
 * @name fandp
 * @email fandp@neusoft.com
 */
public interface MarkRerpository  extends JpaRepository<Mark,String> {
    public List<Mark> findByUserIdAndAn(String userid, String an);
}
