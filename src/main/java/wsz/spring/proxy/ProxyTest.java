package wsz.spring.proxy;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import wsz.spring.proxy.service.AccountService;


/**
 *声明式事务：代理类方法实现
 *1.需要javax.annotation-api包中的@Resource注解
 *@author  wsz
 *@createdTime 2018年3月29日
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("resource/spring-proxy.xml")
public class ProxyTest {

	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void test() {
//		String flag = accountService.transfer("a", "b", new BigDecimal(30000));
//		System.out.println(flag);
		
		String no = accountService.noTransaction("a", "b", new BigDecimal(30000));
		System.out.println(no);
	}
}
