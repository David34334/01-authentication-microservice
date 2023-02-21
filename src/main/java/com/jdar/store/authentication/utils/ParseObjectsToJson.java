package com.jdar.store.authentication.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdar.store.exceptions.clasification.servererror.TechnicalException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParseObjectsToJson {

    private ParseObjectsToJson() {super();}

    @SneakyThrows(TechnicalException.class)
    public static String convertObjectToJson(Object object) {
        String objectJson;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectJson = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException exception) {
            log.error("Error getting JSON value for object {}", object);
            throw new TechnicalException(exception.getMessage());
        }
        return objectJson;
    }

}