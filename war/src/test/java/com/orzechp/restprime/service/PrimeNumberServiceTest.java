package com.orzechp.restprime.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberServiceTest {
    @InjectMocks
    private PrimeNumberService primeNumberService;
    private List primeDataAlgorithm1;

    @Before
    public void setUp() throws Exception {
       primeDataAlgorithm1 = primeNumberService.getPrimeNumbersAlgorithm1(10);
    }


    /**
     * Zero/unit number cannot be prime number
     * @throws Exception
     */
    @Test
    public void testPrimeNumbersUsingAlgorithm1NotZeroNotUnit() throws Exception {
        assertFalse(primeDataAlgorithm1.contains(0));
    }

    @Test
    public void testPrimeNumbersUsingAlgorithm1AreGreaterThanOne() throws Exception {
        assertTrue(primeDataAlgorithm1.stream().anyMatch(n -> (int) n > 1));
    }

    @Test
    public void testPrimeNumbersUsingAlgorithm1AreNotNegativeNumbers() throws Exception {
        assertTrue(primeDataAlgorithm1.stream().noneMatch(n -> (int) n < 0));
    }
    @Test
    public void testBoundaryNumbersUsingAlgorithm1IsNotPrimeNumber() throws Exception {
        assertFalse(primeDataAlgorithm1.contains(1));
        assertFalse(primeDataAlgorithm1.contains(10));
    }

    @Test
    public void testCompositeNumbersUsingAlgorithm1IsNotPrimeNumber() throws Exception {;
        assertFalse(primeDataAlgorithm1.contains(4));
        assertFalse(primeDataAlgorithm1.contains(8));
        assertFalse(primeDataAlgorithm1.contains(9));
    }

    @Test
    public void testPrimeNumbersUsingAlgorithm1AreTwoThreeFiveAndSeven() throws Exception {
        assertNotNull(primeDataAlgorithm1);
        assertTrue(primeDataAlgorithm1.contains(2));
        assertTrue(primeDataAlgorithm1.contains(3));
        assertTrue(primeDataAlgorithm1.contains(5));
        assertTrue(primeDataAlgorithm1.contains(7));
    }


}