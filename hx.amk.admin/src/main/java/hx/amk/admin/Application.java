package hx.amk.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("hx.amk.admin.mapper")
@EnableTransactionManagement
public class Application {

//    @Autowired
//    DataSource dataSource;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
//
//    public void run(String...args) throws Exception{
//        System.out.println("data source:"+dataSource);
//    }
}
