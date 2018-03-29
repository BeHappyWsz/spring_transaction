package wsz.spring.ano.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import wsz.spring.ano.dao.AccountDaoImpl;

/**
 *@author  wsz
 *@createdTime 2018年3月29日
*/
@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountDaoImpl accountDao;
	
	/**
	 * Propagation事务传播行为
	 * 1.REQUIRED(嵌套事务方法调用):如果当前已经存在事务，那么加入该事务；否则创建一个新的事务.(默认该行为)
	 * 2.SUPPORTS:如果当前已经存在事务，那么加入该事务；否则创建一个空事务
	 * 3.MANDATORY:当前必须存在一个事务，否则抛出异常
	 * 4.REQUIRES_NEW:暂停当前事务（如果有），创建一个新的事务
	 * 5.NOT_SUPPORTED:如果当前存在事务，挂起当前事务，然后新的方法在没有事务的环境中执行
	 * 6.NEVER:如果单房当前存在事务，则抛出异常，否则在无事务环境上执行代码
	 * 7.NESTED:
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
	public String transfer(String out, String in, BigDecimal money) {
		boolean account = accountDao.getAccount(out);
		if(!account)
			return "转出账户:"+out+"不存在";
		account = accountDao.getAccount(in);
		if(!account)
			return "转入账户:"+out+"不存在";
		
		BigDecimal left = accountDao.getMoney(out);
		if(left.compareTo(money) == -1)
			return "账户"+out+"余额不足:"+left;
		
		accountDao.outMoney(out, money);
//		System.out.println(1/0);
		accountDao.inMoney(in, money);
		
		left = accountDao.getMoney(out);
		return "转账成功,余额:"+left;
	}
	
}
