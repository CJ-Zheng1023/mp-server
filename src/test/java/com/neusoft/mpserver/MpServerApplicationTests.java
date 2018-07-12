package com.neusoft.mpserver;

import com.eprobiti.trs.TRSException;
import com.neusoft.mpserver.common.domain.Condition;
import com.neusoft.mpserver.common.domain.TrsResult;
import com.neusoft.mpserver.common.engine.TrsEngine;
import com.neusoft.mpserver.domain.Constant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MpServerApplicationTests {
	@Autowired
	private TrsEngine trsEngine;
	@Test
	public void trsTest() throws TRSException {
		Condition condition = new Condition();
		condition.setExp("IC='G21F5/015'");
		condition.setDbName(Constant.CNABS_DB);
		condition.setDisplayFields(Constant.PATENT_LIST_DISPLAY_FIELDS);
		TrsResult tr = trsEngine.search(condition);
		System.out.println(tr);
	}
}
