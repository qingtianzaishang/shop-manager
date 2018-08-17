package cn.edu.jxufe;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by 74132 on 2018/8/2.
 */
@SpringBootApplication
@MapperScan("cn.edu.jxufe.dao")
public class StartWebApp {
    public static void main(String[] args) {
        SpringApplication.run(StartWebApp.class);
        System.out.println("开始启动！                                                                                                                                                                                                                                                                                          ");
    }

}
