package com.crm;

import com.crm.biz.dynamic.dao.SysDynamicMapper;
import com.crm.entity.UserTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrmApplicationTests {

	@Autowired
	private SysDynamicMapper sysDynamicMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		UserTask userTask = new UserTask();
		userTask.setChId((long)1);
		userTask.setTaskContent("shuij hsuiji huishauidhuai");
		userTask.setTaskStatus(1);
		userTask.setTaskDate(new Date());
		userTask.setUserId((long)1);
		sysDynamicMapper.insertTaskTest(userTask);
		System.out.println("id ::" + userTask.getTaskId());
	}

}
