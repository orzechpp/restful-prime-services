package com.orzechp.restprime.controllers;

import com.orzechp.restprime.model.PrimesResponse;
import com.orzechp.restprime.service.PrimeNumberService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static com.orzechp.restprime.common.RESTResourceIdentifierConstants.DATA_FORMAT_PRESENTATION_MEDIA_TYPE;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(MockitoJUnitRunner.class)
public class GetPrimeNumberControllerTest {
    public static final String REST_URI = "/algorithm1/primes/upperlimit/";
    @Mock
    PrimeNumberService primeService;
    private MockMvc mockMvc;

    @InjectMocks
    private GetPrimeNumberController getPrimeNumberController;

    @Before
    public void setUp() throws Exception {
        mockMvc = standaloneSetup(getPrimeNumberController).build();
    }

    @Test
    @Ignore
    public void testGetPrimeNumbers() throws Exception {
        // Given
        final int upperlimit = 10;

        List<PrimesResponse> primesResponse = Arrays.asList(createPrimeResponse(10));

        // When
        when(primeService.getPrimeNumbersAlgorithm1(upperlimit)).thenReturn(primesResponse);

        getPrimeNumberController.getPrimeNumbersAlgorithm1(upperlimit);

        mockMvc
                .perform(get(REST_URI + upperlimit).accept(APPLICATION_JSON))
                // Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(DATA_FORMAT_PRESENTATION_MEDIA_TYPE))
                .andExpect(content().string("{\"initial\":10,\"primes\":[2,3,5,7]}"));
    }


    private PrimesResponse createPrimeResponse(int upperlimit) {
        return new PrimesResponse(upperlimit, Arrays.asList(2, 3, 5, 7));
    }
}
