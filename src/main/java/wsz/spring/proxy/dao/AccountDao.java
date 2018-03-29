package wsz.spring.proxy.dao;

import java.math.BigDecimal;

/**
 *账号dao
 *@author  wsz
 *@createdTime 2018年3月29日
*/
public interface AccountDao {

	/**
	 * 转出操作
	 * @param account
	 * @param money
	 */
	void outMoney(String account, BigDecimal money);
	
	/**
	 * 转入操作
	 * @param account
	 * @param money
	 */
	void inMoney(String account, BigDecimal money);
	
	/**
	 * 是否存在账号信息
	 * @param account
	 * @return
	 */
	boolean getAccount(String account);
	
	/**
	 * 获取账号金额
	 * @param account
	 * @return
	 */
	BigDecimal getAccountMoney(String account);
}
