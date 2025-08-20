package org.example;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class WebCrawler {
    private static Phaser phaser;
    private static ExecutorService executorService;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter url");
        String url=sc.nextLine();

        System.out.println("Enter depth");
        final int MAX_DEPTH=sc.nextInt();

        System.out.println("Enter number of workers");
        final int MAX_THREADS=sc.nextInt();

        URLFetcher urlFetcher = new URLFetcher();
        URLStore urlStore=new URLStore();
        phaser=new Phaser(1);

        executorService= Executors.newFixedThreadPool(MAX_THREADS);
        urlStore.addURL(url);
        long start=System.currentTimeMillis();

        submitTask(urlStore,urlFetcher,0,MAX_DEPTH);
        phaser.awaitAdvance(phaser.getPhase());

        executorService.shutdown();
        System.out.println("Time taken " + (System.currentTimeMillis()-start));
    }

    public static void submitTask(URLStore urlStore, URLFetcher urlFetcher, int currentDepth, int maxDepth) {
        executorService.submit(new CrawlerTask(urlStore,urlFetcher,currentDepth,maxDepth,phaser));
    }
}
