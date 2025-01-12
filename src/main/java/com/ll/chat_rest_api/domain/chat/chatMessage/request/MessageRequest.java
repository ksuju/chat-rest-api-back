package com.ll.chat_rest_api.domain.chat.chatMessage.request;

import lombok.Getter;
import lombok.Setter;

/**
 * packageName    : com.ll.chatAi.domain.chat.chatMessage.request
 * fileName       : MessageRequest
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@Getter
@Setter
public class MessageRequest {
    private String writerName;
    private String content;
}
