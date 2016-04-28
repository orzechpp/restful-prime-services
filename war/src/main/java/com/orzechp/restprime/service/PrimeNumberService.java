package com.orzechp.restprime.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;
import static java.util.stream.LongStream.rangeClosed;


@Component
@AllArgsConstructor
public class PrimeNumberService implements PrimeService {
    /**
     * It uses ForkJoinPools with max available processors
     */
    private final ExecutorService executor = Executors.newWorkStealingPool();

    @Override
    public List getPrimeNumbersAlgorithm1(int upperLimit) {


        final List candidates = IntStream.range(2, upperLimit).boxed().collect(Collectors.toList());

        List primeNumbers = null;
        try {
            primeNumbers = (List) executor.submit(() -> candidates.parallelStream().filter(isPrimeAlgorithm1()).collect(Collectors.toList())).get();
        } catch (InterruptedException e) {
            executor.shutdown();
        } catch (ExecutionException e) {
            throw new IllegalStateException(e);
        } finally {
            executor.shutdownNow();
        }

        return primeNumbers;
    }


    /**
     * Loop from 2 , increment by 1
     * Check if number > 1
     *
     * @return
     */
    protected Predicate isPrimeAlgorithm1() {
        return n -> (int) n > 1 && rangeClosed(2, (int) sqrt((int) n + 1)).noneMatch(divisor -> (int) n % divisor == 0);
    }


    /**
     * Loop from 3 , increment by 2
     * Prevent even number to be tested
     *
     * @return
     */
    protected Predicate isPrimeAlgorithm2() {
        return n -> rangeClosed(3, (int) sqrt((int) n + 2) + 1).noneMatch(divisor -> (int) n % divisor == 0);
    }


}
