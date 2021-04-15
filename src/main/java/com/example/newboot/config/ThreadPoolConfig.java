package com.example.newboot.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

@Configuration
public class ThreadPoolConfig {
    @Value("${thread.pool.corePoolSize:5}")
    private int corePoolSize;
    @Value("${thread.pool.maxPoolSize:10}")
    private int maxPoolSize;
    @Value("${thread.pool.queueCapacity:200}")
    private int queueCapacity;
    @Value("${thread.pool.keepAliveSeconds:30}")
    private int keepAliveSeconds;
    @Value("${thread.pool.threadNamePerfix:ASYNC_")
    private String threadNamePerfix;

//    @Bean
//    public Executor getThreadPool() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(corePoolSize);
//        executor.setMaxPoolSize(maxPoolSize);
//        executor.setQueueCapacity(queueCapacity);
//        executor.setKeepAliveSeconds(keepAliveSeconds);
//        executor.setThreadNamePrefix(threadNamePerfix);
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.initialize();
//        return executor;
//    }

    @Value("${frms.checklist.threadSize:10}")
    private int checklistThreadSize;

    @Bean(destroyMethod="shutdown",name="checklistExecutor")
    public ThreadPoolExecutor checklistExecutor(){
        ThreadFactory tf = new ThreadFactoryBuilder().setNameFormat("核查单处理线程-%d").build();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(checklistThreadSize,checklistThreadSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                tf
        );
        return executor;
    }

}
