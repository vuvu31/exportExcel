package project.apicapstone.common.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class ResponseHandler {
    public static ResponseEntity<Object> getResponse(Object content, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        map.put("errors", "");
        map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> getResponseLogin(Object token, Object object, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("content", object);
//        map.put("content2", object2);
        map.put("errors", "");
        map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> getResponse(BindingResult errors, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", "");
        map.put("errors", ErrorUtils.getErrorMessages(errors));
        map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }

    public static Object getResponse(HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", "");
        map.put("errors", "");
        map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }

    public static Object getErrors(Object errors, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", "");
        map.put("errors", errors);
        map.put("timestamp", DateUtils.toString(LocalDateTime.now()));
        map.put("status", status.value());

        return new ResponseEntity<Object>(map, status);
    }
}
