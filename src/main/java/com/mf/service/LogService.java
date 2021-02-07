package com.mf.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j(topic = "detail")
public class LogService {

    public void printLog(String msg){
        log.info(msg);
    }
}
