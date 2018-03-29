package wsz.spring.aspectj.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wsz.spring.aspectj.dao.AccountDao;

/**
 *service层
 *@author  wsz
 *@createdTime 2018年3月29日
*/
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	/**
	 * 在配置文件中,使用aspectj进行事务控制,不需要注解
	 */
	public String transfer(String out, String in, BigDecimal money) {
		
		accountDao.outMoney(out, money);
		System.out.println(1/0);
		accountDao.inMoney(in, money);
		
		return "转账成功";
	}
	
}
