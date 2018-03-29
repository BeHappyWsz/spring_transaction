package wsz.spring.ano.service;

import java.math.BigDecimal;

/**
 *
 *@author  wsz
 *@createdTime 2018年3月29日
*/
public interface AccountService {
	
	String transfer(String out, String in, BigDecimal money);
	
}
