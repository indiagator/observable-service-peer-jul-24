package com.cbt.observableservicepeerjul24;

import io.micrometer.observation.annotation.Observed;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController
{
    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    @Observed(name = "handler.hello",
            contextualName = "handler-hello",
            lowCardinalityKeyValues = {"handlerType", "test"})
    @GetMapping("/hello")
    public String hello(HttpServletRequest request)
    {
        String traceId = request.getHeader("traceparent");
         log.info("traceparent: "+traceId);

        return "Hello for Observable-Peer";
    }

    @Observed(name = "handler.hello",
            contextualName = "handler-hello",
            lowCardinalityKeyValues = {"handlerType", "test"})
    @GetMapping("/async-hello")
    public String async_hello(HttpServletRequest request)
    {
        String traceId = request.getHeader("traceparent");
        log.info("traceparent: "+traceId);

        return "Hello for Observable-Peer";
    }
}
