package wsz.spring.program.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import wsz.spring.program.base.BaseService;
import wsz.spring.program.dao.AccountDao;

/**
 *service层
 *@author  wsz
 *@createdTime 2018年3月29日
*/
@Service
public class AccountServiceImpl extends BaseService implements AccountService{

	@Autowired
	public AccountServiceImpl(TransactionTemplate transactionTemplate) {
		super(transactionTemplate);
	}

	@Autowired
	private AccountDao accountDao;
	
	/**
	 * 在配置文件中,使用aspectj进行事务控制,不需要注解
	 */
	public String transfer(final String out, final String in, final BigDecimal money) {
		
		Object execute = this.getTransactionTemplate().execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				accountDao.outMoney(out, money);
//				System.out.println(1/0);
				accountDao.inMoney(in, money);
			}
		});
		System.out.println(execute);
		return "转账成功";
	}
	
	public String noTransaction(String out, String in, BigDecimal money) {
		accountDao.outMoney(out, money);
//		System.out.println(1/0);
		accountDao.inMoney(in, money);
		return "转账成功";
	}
}
