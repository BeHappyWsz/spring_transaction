package wsz.spring.proxy.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import wsz.spring.proxy.base.BaseDao;

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

	public void outMoney(String account, BigDecimal money) {
		String sql = "update t_account set money = money-? where account=?";
		int update = this.getJdbcTemplate().update(sql, money,account);
		System.out.println("outMoney:"+update);
	}

	public void inMoney(String account, BigDecimal money) {
		String sql = "update t_account set money=money+? where account=?";
		int update = this.getJdbcTemplate().update(sql, money,account);
		System.out.println("inMoney:"+update);
	}

	public boolean getAccount(String account) {
		String sql = "select * from t_account where account =?";
		List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql,account);
		return !list.isEmpty();
	}

	public BigDecimal getAccountMoney(String account) {
		String sql ="select id,account,money from t_account where account =?";
		List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql, account);
		if(list.isEmpty())
			return BigDecimal.ZERO;
		
		return (BigDecimal) list.get(0).get("money");
	}

}
