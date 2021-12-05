package com.example.spottyv2.api.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.junit.Test;

public class JsonSerializerJacksonTest() {
    @Test
    public void testSerializingWithJsonRootName() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE)
                .writeValueAsString(new RootNameDemoBean());
        System.out.println(jsonString);
        assert (jsonString.contains("James Clark"));
        assert (jsonString.contains("user"));
    }

    @JsonRootName(value = "user")
    public class RootNameDemoBean {
        public long personId = 0;
        public String name = "James Clark";
    }
}
