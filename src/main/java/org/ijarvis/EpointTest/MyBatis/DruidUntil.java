package org.ijarvis.EpointTest.MyBatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 * 
 * @author ijarvis
 * 单实例实现，获取的SqlSessionFactory
 */

public class DruidUntil {
	private static final SqlSessionFactory sqlsessionFactory=null;
	
	private DruidUntil(){}
	
	private SqlSessionFactory getInstence(){
		if (sqlsessionFactory ==null) {
			return null;
		}
		return null;
	}
}
