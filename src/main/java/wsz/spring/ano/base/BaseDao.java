package wsz.spring.ano.base;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *基础dao类
 *@author  wsz
 *@createdTime 2018年3月29日
*/
public class BaseDao extends JdbcDaoSupport{
	
	public BaseDao() {}
	
	/**
	 * 注入DataSource后，可以直接使用jdbcTemplate
	 * @param dataSource
	 */
	public BaseDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
}
