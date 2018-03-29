package wsz.spring.ano;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wsz.spring.ano.service.AccountService;

/**
 * 声明式-注解方式
 *@author  wsz
 *@createdTime 2018年3月29日
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("resource/spring-ano.xml")
public class AnoTest {

	@Autowired
	private AccountService accountService;
	
	@Test
	public void test() {
		String re = accountService.transfer("a", "b", new BigDecimal(400000));
		System.out.println(re);
	}
	
}
