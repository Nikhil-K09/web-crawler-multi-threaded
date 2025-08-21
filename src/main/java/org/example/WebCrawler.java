package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class WebCrawler {
    private static Phaser phaser;
    private static ExecutorService executorService;

    public static void startCrawl(String url, int MAX_DEPTH, int MAX_THREADS){
        URLFetcher urlFetcher = new URLFetcher();
        URLStore urlStore=new URLStore();
        phaser=new Phaser(1);

        executorService= Executors.newFixedThreadPool(MAX_THREADS);

        urlStore.addUrl(url);

        long start=System.currentTimeMillis();

        submitTask(urlStore,urlFetcher,0,MAX_DEPTH);

        phaser.awaitAdvance(phaser.getPhase());

        executorService.shutdown();
        System.out.println("Time taken " + (System.currentTimeMillis()-start)+" ms");
    }

    public static void submitTask(URLStore urlStore, URLFetcher urlFetcher, int currentDepth, int maxDepth) {
        executorService.submit(new CrawlerTask(urlStore,urlFetcher,currentDepth,maxDepth,phaser));
    }
}