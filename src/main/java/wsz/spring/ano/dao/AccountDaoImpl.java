package wsz.spring.ano.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wsz.spring.ano.base.BaseDao;

/**
 *
 *@author  wsz
 *@createdTime 2018年3月29日
*/
@Repository
public class AccountDaoImpl extends BaseDao implements AccountDao{

	@Autowired
	public AccountDaoImpl(DataSource dataSource) {
		super(dataSource);
	}
	
	/**
	 * 转出
	 * @param account 转出账户
	 * @param money 转出金额
	 */
	public void outMoney(String account, BigDecimal money) {
		String sql = "update t_account set money = money-? where account=?";
		Object[] params = {money, account};
		this.getJdbcTemplate().update(sql, params);
	}
	
	/**
	 * 转入
	 * @param account 转入账户
	 * @param money 转入金额
	 */
	public void inMoney(String account, BigDecimal money) {
		String sql ="update t_account set money = money+? where account=?";
		Object[] params = {money, account};
		this.getJdbcTemplate().update(sql, params);
	}
	
	/**
	 * 根据账户获取账户金额
	 * @param account
	 * @return
	 */
	public BigDecimal getMoney(String account) {
		String sql = "select money from t_account where account=?";
		Map<String, Object> map = this.getJdbcTemplate().queryForMap(sql, account);
		return new BigDecimal(map.get("money").toString());
	}

	/**
	 * 判断账户是否存在
	 */
	public boolean getAccount(String account) {
		String sql = "select id, account, money from t_account where account=?";
		List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql, account);
		return list.isEmpty() ? false : true;
	}
}
