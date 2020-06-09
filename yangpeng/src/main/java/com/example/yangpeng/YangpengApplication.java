package com.example.yangpeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.example.yangpeng.mapper") //扫描的mapper
@SpringBootApplication
@EnableScheduling
public class YangpengApplication {

    public static void main(String[] args) {
        SpringApplication.run(YangpengApplication.class, args);
        System.out.println(11111);

        MyValue myVal;
        myVal = () -> 98.6;
        System.out.println("-------------------1------------------");
        System.out.println("A"+myVal.getValue());
        System.out.println("--------------------2-----------------");
        MyParamValue myPval = (n) -> 1.0 /n ;

        System.out.println("B4"+ myPval.getValue(4.0));
        System.out.println("B8"+ myPval.getValue(6.0));
        System.out.println("--------------------3-----------------");
       // myVal = () -> "three";
        //myPval - () -> Math.random();


        System.out.println("--------------------4-----------------");
        NumericTest isFoctor = (n,d) ->(n%d) == 0 ;

        if(isFoctor.test(10,2));



    }


    interface  MyValue{
        double getValue();
    }
    interface  MyParamValue {
        double getValue (double v);
    }
    interface  NumericTest{
        boolean test(int n ,int m);
    }






}
