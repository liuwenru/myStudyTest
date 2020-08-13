import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liuwenru on 2017/2/20.
 */
//@Controller
//
public class Apps {
    private static ApplicationContext context ;
    private static DataSource dataSource ;
    public static void main(String[] args) throws IOException, SQLException {
        context=new ClassPathXmlApplicationContext("src/main/resources/application-context.xml");
        dataSource=context.getBean("dataSource", DruidDataSource.class);
        Connection connection=dataSource.getConnection();
        connection.setAutoCommit(false);
        Statement statement=connection.createStatement();
        statement.setQueryTimeout(3);
        statement.executeQuery("update x set name='ffffff' where id=1");
        connection.commit();
        connection.close();
    }
}
