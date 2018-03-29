package wsz.spring.aspectj;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wsz.spring.aspectj.service.AccountService;

/**
 *aspectj方法实现声明式事务,需要引入aspectjweaver包
 *@author  wsz
 *@createdTime 2018年3月29日
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("resource/spring-aspectj.xml")
public class AspectjTest {

	@Autowired
	private AccountService accountService;
	
	@Test
	public void test() {
		String re = accountService.transfer("a", "b", new BigDecimal(600000));
		System.out.println(re);
	}
}
