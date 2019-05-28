package util;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
public class DBUtils {
	private static BasicDataSource ds;
	
	static {
		//创建数据源对�?
		ds=new BasicDataSource();
		//读取配置文件
		Properties p=new Properties();
		InputStream ips=DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			p.load(ips);
			String driver=p.getProperty("driver");
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			//设置连接信息
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setInitialSize(3);//设置初始连接数量
			ds.setMaxActive(5);//设置�?大连接数�?
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws Exception {
		//获取连接对象，注意导包别导错，异常抛�?
		Connection conn=ds.getConnection();
		System.out.println(conn);
		return conn;
	}
}
