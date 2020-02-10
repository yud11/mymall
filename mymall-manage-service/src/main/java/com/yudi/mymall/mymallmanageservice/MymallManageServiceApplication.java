package com.yudi.mymall.mymallmanageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.yudi.mymall.mymallmanageservice")
public class MymallManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymallManageServiceApplication.class, args);
    }

}
