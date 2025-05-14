package com.hzx.lesson.common.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author shenzh
 */
public class JacksonSingle {
    private JacksonSingle() {
    }

    public static ObjectMapper getInstance() {
        return Inner.OBJECT_MAPPER;
    }

    private static class Inner {
        private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
