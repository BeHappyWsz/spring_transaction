package wsz.spring.proxy.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wsz.spring.proxy.dao.AccountDao;

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
	 * 在配置文件中,
	 */
	public String transfer(String out, String in, BigDecimal money) {
		accountDao.outMoney(out, money);
		System.out.println(1/0);
		accountDao.inMoney(in, money);
		return "转账成功";
	}
	
	/**
	 * proxy代理方法针对类级别进行控制事务
	 */
	public String noTransaction(String out, String in, BigDecimal money) {
		accountDao.outMoney(out, money);
		System.out.println(1/0);
		accountDao.inMoney(in, money);
		return "转账成功";
	}
}
