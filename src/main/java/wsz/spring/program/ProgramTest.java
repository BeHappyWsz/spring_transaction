package wsz.spring.program;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wsz.spring.program.service.AccountService;


/**
 *编程式事务测试
 *@author  wsz
 *@createdTime 2018年3月29日
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("resource/spring-program.xml")
public class ProgramTest {
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void test() {
		//事务控制
		String re = accountService.transfer("a", "b", new BigDecimal(20000));
		System.out.println(re);
		
		//没有事务控制
		String flag = accountService.noTransaction("a", "b", new BigDecimal(30000));
		System.out.println(flag);
		
	}
}
