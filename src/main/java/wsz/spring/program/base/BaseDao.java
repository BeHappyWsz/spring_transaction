package wsz.spring.program.base;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 *@author  wsz
 *@createdTime 2018年3月29日
*/
public class BaseDao extends JdbcDaoSupport{
	
	
	public BaseDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
}
