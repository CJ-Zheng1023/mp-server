package com.neusoft.mpserver;

import com.eprobiti.trs.TRSException;
import com.neusoft.mpserver.common.domain.Pagination;
import com.neusoft.mpserver.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MpServerApplicationTests {
	@Autowired
	private SearchService searchService;
	@Test
	public void searchServiceSearchPatentListTest() throws TRSException {
		Pagination pagination = new Pagination();
        pagination.setSize(3);
		Map<String, Object> map = searchService.searchPatentList("G21F5/015", pagination);
		System.out.println(map);
	}
}
