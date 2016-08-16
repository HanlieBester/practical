package calculator.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import calculator.domain.Result;

public class RPNDaoHibernate extends HibernateDaoSupport implements RPNDao {
	
	public void store(Result result){
		getHibernateTemplate().saveOrUpdate(result);
	}
}
