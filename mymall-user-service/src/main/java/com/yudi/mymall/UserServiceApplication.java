package com.yudi.mymall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author yudi
 * @date 2020-02-07 8:43
 */
@SpringBootApplication
@MapperScan(basePackages = "com.yudi.mymall")
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class);
    }
}
