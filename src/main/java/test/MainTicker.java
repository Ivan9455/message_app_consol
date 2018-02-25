package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTicker {
    public static void main(String[] args) {
        //пример использования потоков и одновременное выполнение 2 потоков (паралельное)
        Ticker first = new Ticker("first");
        Ticker second = new Ticker("second");

        ExecutorService executorService =  Executors.newFixedThreadPool(2);
        executorService.submit(first);
        executorService.submit(second);
    }
}
