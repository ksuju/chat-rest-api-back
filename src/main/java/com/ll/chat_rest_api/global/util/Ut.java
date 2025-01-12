package com.ll.chat_rest_api.global.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * packageName    : com.ll.chatAi.global.ut
 * fileName       : Ut
 * author         : sungjun
 * date           : 2025-01-08
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-08        kyd54       최초 생성
 */

public class Ut {
    // Map<String, Object>를 JSON 문자열로 변환
    public static class json {
        public static Object toStr(Map<String, Object> map) {
            try {
                return new ObjectMapper().writeValueAsString(map);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
    }
    // JSON 문자열을 Map<String, Object>로 변환
    public static Map<String, Object> toMap(String jsonStr) {
        try {
            return new ObjectMapper().readValue(jsonStr, LinkedHashMap.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
    public static class thread {
        @SneakyThrows
        public static void sleep(int milli) {
            Thread.sleep(milli);
        }
    }
}
