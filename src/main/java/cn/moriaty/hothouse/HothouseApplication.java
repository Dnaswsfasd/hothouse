package cn.moriaty.hothouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value="cn.moriaty.hothouse.mapper")
@SpringBootApplication
public class HothouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HothouseApplication.class, args);
    }

}
