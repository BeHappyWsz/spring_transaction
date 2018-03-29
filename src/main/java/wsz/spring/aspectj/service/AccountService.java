package wsz.spring.aspectj.service;

import java.math.BigDecimal;

/**
 *
 *@author  wsz
 *@createdTime 2018年3月29日
*/
public interface AccountService {

	/**
	 * 转账操作
	 * @param out 转出账号
	 * @param in 转入账号
	 * @param money 转出金额
	 * @return
	 */
	String transfer(String out, String in, BigDecimal money);
	
}
