package com.ll.chat_rest_api.domain.chat.chatRoom.repository;

import com.ll.chat_rest_api.domain.chat.chatRoom.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.ll.chatAi.domain.chat.chatRoom.repository
 * fileName       : ChatRoomRepository
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
