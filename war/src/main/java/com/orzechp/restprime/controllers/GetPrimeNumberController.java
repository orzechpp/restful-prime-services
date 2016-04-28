package com.orzechp.restprime.controllers;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orzechp.restprime.exceptions.NotFoundException;
import com.orzechp.restprime.service.PrimeService;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

import static com.orzechp.restprime.common.RESTResourceIdentifierConstants.*;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Log4j
@RestController
public class GetPrimeNumberController {
    @Resource
    private PrimeService primeService;


    @RequestMapping(value = REST_GET_PRIME_ALGORITHM1_URI, method = GET, produces = {DATA_FORMAT_PRESENTATION_MEDIA_TYPE})
    public ResponseEntity<String> getPrimeNumbersAlgorithm1(@PathVariable final int upperLimit) {
        StopWatch stopwatch = new StopWatch();
        String jsonResponse = null;
        List primeData;
        try {
            ObjectMapper mapper = new ObjectMapper();
            stopwatch.start();
            primeData = primeService.getPrimeNumbersAlgorithm1(upperLimit);
            log.info("Finish time " + stopwatch.getTotalTimeSeconds());
            if (primeData == null) {
                throw new NotFoundException("Primes Numbers Not Found");
            }
            jsonResponse = mapper.writeValueAsString(primeData);

        } catch (JsonGenerationException e) {
            log.error("Error:: Json Generation Exception "+ e, e);
        } catch (IOException e) {
            log.error("Error:: IO Exception "+ e, e);
        }

        return new ResponseEntity(jsonResponse, OK);

    }


}
