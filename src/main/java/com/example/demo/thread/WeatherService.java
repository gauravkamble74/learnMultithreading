package com.example.demo.thread;

import java.util.concurrent.*;

//using Callable and Future
public class WeatherService {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        Callable<String> fetchWeatherLogic = ()  -> {
//            System.out.println("thread name" + Thread.currentThread().getName());
//            Thread.sleep(2000);
//            return "Weather : Sunny";
//        };
        Callable<String> fetchWeatherLogic = fetchWeatherLogic();

        Future<String> result = executorService.submit(fetchWeatherLogic);
        System.out.println("Fetching weather report from Thread named: " + Thread.currentThread().getName());
        try {
            System.out.println("Result : "+result.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }

    private static Callable<String> fetchWeatherLogic() throws InterruptedException {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("thread name: " + Thread.currentThread().getName());
                Thread.sleep(2000);
                return "Weather : Sunny";
            }
        };
    }
}
