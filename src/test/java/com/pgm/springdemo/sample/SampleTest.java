package com.pgm.springdemo.sample;

import com.pgm.springdemo.config.AppConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@Log4j2
@ExtendWith({SpringExtension.class})
//@ContextConfiguration(classes = AppConfig.class)
@ContextConfiguration(locations={"/test-context.xml","file:src/main/webapp/WEB-INF/root-context.xml"})
//@RequiredArgsConstructor
public class SampleTest {
    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private SampleService sampleService;

    /*@Autowired
    @Qualifier("myDto1")
    private SampleDTO sampleDTO1;*/

    @Test
    public void ConnectionTest() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
    }

    @Test
    public void setSampleServiceTest(){
        log.info(sampleService);
    }

    @Test
    public void testSample1() {
        //log.info(sampleDTO1);
    }

    @Test
    public void testSample() {
        SampleDTO dto = new SampleDTO();
        dto.setAge(20);
        dto.setName("박경미");
        String[] hobbys={"수영","영화감상"};
        dto.setHobby(hobbys);
        log.info(dto);
    }

    @Test
    public void testSample2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/test-context.xml");
        SampleDTO dto1 = (SampleDTO) context.getBean("sample1");
        log.info(dto1);
        SampleDTO dto2 = (SampleDTO) context.getBean("sample2");
        log.info(dto2);
    }

    @Test
    public void testSample3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SampleDTO dto1 = (SampleDTO) context.getBean("myDto1");
        log.info(dto1);
        SampleDTO dto2 = (SampleDTO) context.getBean("myDto2");
        log.info(dto2);
    }
}
