package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class AbstractRepository {
	
	//그 오브젝트의 저장장소를 하나로 운영하겠다.
	//오브젝트만 있으면 바로 들어가겠다. 
	private SqlSessionFactory sqlSessionFactory;
	String resource = "mybatis/mybatis-config.xml";

	private void setSqlSessionFactory() {
		InputStream inputStream;

		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	protected SqlSessionFactory getSqlSessionFactory() {
		setSqlSessionFactory();
		return sqlSessionFactory;
	}

	public void setDbname(String dbname) {
		resource = "mybatis/mybatis-" + dbname + ".xml";
		System.out.println(resource);
	}
}