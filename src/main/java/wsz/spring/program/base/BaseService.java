package wsz.spring.program.base;
/**
 *
 *@author  wsz
 *@createdTime 2018年3月29日
*/

import org.springframework.transaction.support.TransactionTemplate;
/**
 * 使用TransactionTemplate
 * @author wsz
 * @date 2018年3月29日
 */
public class BaseService {

	private TransactionTemplate transactionTemplate;
	
	public BaseService(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}
}
