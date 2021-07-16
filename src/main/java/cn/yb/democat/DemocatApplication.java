package cn.yb.democat;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("cn.yb.democat.mapper")
@Slf4j
public class DemocatApplication {
    public static void main(String[] args) {
        log.info("---------------------项目启动---------------------");
        SpringApplication.run(DemocatApplication.class, args);
        log.info("---------------------启动成功---------------------");
    }
}
