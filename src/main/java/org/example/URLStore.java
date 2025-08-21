package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class URLStore {
    private final ConcurrentHashMap<String,Boolean> visitedURL=new ConcurrentHashMap<>();
    private final BlockingQueue<String> urlQueue=new LinkedBlockingQueue<>();

    public boolean addUrl(String url) {
        if(visitedURL.putIfAbsent(url,true)==null){
            urlQueue.offer(url);
            return true;
        }
        return false;
    }

    public String getNextUrl(){
        return urlQueue.poll();
    }

    public boolean isQueueEmpty(){
        return urlQueue.isEmpty();
    }
}
