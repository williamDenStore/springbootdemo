package com.example.springbootdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.assertj.core.api.Assertions.assertThat;
public class ResponseBodyMatchers {
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> ResultMatcher containsObjectAsJson(
            Object expectedObject,
            Class<T> targetClass) {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            T actualObject = objectMapper.readValue(json, targetClass);
            assertThat(actualObject).isEqualToComparingFieldByField(expectedObject);
        };
    }

    static ResponseBodyMatchers responseBody(){
        return new ResponseBodyMatchers();
    }

}