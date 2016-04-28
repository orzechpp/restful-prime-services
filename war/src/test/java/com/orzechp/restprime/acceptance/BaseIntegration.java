package com.orzechp.restprime.acceptance;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by root on 27/04/2016.
 */
public class BaseIntegration {

    protected ObjectMapper mapper;
    protected JsonFactory factory;
    protected JsonParser parser;
}
