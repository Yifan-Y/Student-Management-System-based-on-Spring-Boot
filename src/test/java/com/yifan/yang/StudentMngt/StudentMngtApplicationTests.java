package com.yifan.yang.StudentMngt;

import com.yifan.yang.StudentMngt.StudentMngtApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class StudentMngtApplicationTests {

    @Autowired
    private StudentMngtApplication studentMngtApplication;

    @MockBean
    private SpringApplication springApplication;

    @Test
    void contextLoads() {

    }

    @Test
	void applicationContextIsLoaded() {

}
}