package com.pgm.springdemo.sample;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
public class SampleService {
    @Autowired
    private SampleDAO sampleDAO;
    @Autowired
    private ISampleDAO sampleDAOImpl;
    @Autowired
    @Qualifier("event")
    private ISampleDAO eventSampleDAO;
}
