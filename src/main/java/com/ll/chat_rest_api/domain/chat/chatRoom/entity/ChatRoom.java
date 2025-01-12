package com.ll.chat_rest_api.domain.chat.chatRoom.entity;

import com.ll.chat_rest_api.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chat_rest_api.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * packageName    : com.ll.chatAi.entity
 * fileName       : chatEntity
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@ToString(callSuper = true)
public class ChatRoom extends BaseEntity {
    private String name;
    @OneToMany
    private List<ChatMessage> chatMessages;
}
