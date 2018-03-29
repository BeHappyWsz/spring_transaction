package wsz.spring.ano.dao;

import java.math.BigDecimal;

/**
 *
 *@author  wsz
 *@createdTime 2018年3月29日
*/
public interface AccountDao {

	void outMoney(String account, BigDecimal money);
	
	void inMoney(String account, BigDecimal money);
	
	BigDecimal getMoney(String account);
	
	boolean getAccount(String account);
}
