package com.rwh.smcu.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 时间序列测试
 *
 * @author <a href="mailto:simling82@gmail.com">Simling</a>
 * @version v1.0 on 2017/8/15
 */
public class ThreadStateModel extends TimerTask {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<Long, Thread> threads = new ConcurrentHashMap<>();

    private Timer timer = new Timer();

    private static ThreadStateModel instance;

    public void put(Thread thread){
        threads.put(thread.getId(), thread);
    }

    public void dump(){
        if(threads.keySet().size() >= 3) {
            logger.info("dump start...");
            for (Long key : threads.keySet()) {
                Thread thread = threads.get(key);
                logger.info(thread.getName() + "-" + thread.getId() + ":" + thread.getState());
            }
            logger.info("dump end...");
        }
    }

    public static synchronized ThreadStateModel getInstance(){
        if(instance == null){
            instance = new ThreadStateModel();
        }
        return instance;
    }

    @Override
    public void run(){
        try {
            dump();
        }catch (Exception e){
            logger.error("dump error", e);
        }
    }

    public void start(){
        timer.schedule(this, 0, 10);
    }
}
