package org.example;

import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutt
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter url");
        String url=sc.nextLine();

        System.out.println("Enter depth of crawling");
        final int MAX_DEPTH=sc.nextInt();

        System.out.println("Enter max no. of threads");
        final int MAX_THREADS=sc.nextInt();

        WebCrawler.startCrawl(url, MAX_DEPTH, MAX_THREADS);
    }
}