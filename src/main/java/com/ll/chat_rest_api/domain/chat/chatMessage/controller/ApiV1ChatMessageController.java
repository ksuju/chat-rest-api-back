package com.ll.chat_rest_api.domain.chat.chatMessage.controller;

import com.ll.chat_rest_api.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chat_rest_api.domain.chat.chatMessage.request.MessageRequest;
import com.ll.chat_rest_api.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chat_rest_api.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName    : com.ll.chatAi.domain.chat.chatMessage.controller
 * fileName       : ApiV1ChatMessageContoller
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@RestController
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
@CrossOrigin(
//        origins = "https://cdpn.io"
        origins = "http://localhost:5173/"
)
public class ApiV1ChatMessageController {

    private final ChatMessageService chatMessageService;
    private final com.ll.chat_rest_api.domain.chat.chatRoom.service.ChatRoomService chatRoomService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    // 채팅방 메시지 목록 가져오기
    @GetMapping("/{roomId}/messages")
    public List<ChatMessage> messages(@PathVariable Long roomId,
                                      @RequestParam(defaultValue = "-1") Long afterChatMessageId) {

        List<ChatMessage> chatMessages = chatMessageService.messages(roomId, afterChatMessageId);

        return chatMessages;
    }

    @PostMapping("/{roomId}/messages")
    public RsData<Void> sendMessage(@PathVariable Long roomId,
                                    @RequestBody MessageRequest messageRequest) {

        com.ll.chat_rest_api.domain.chat.chatRoom.entity.ChatRoom chatRoom = chatRoomService.findRoom(roomId);

        ChatMessage chatMessage = chatMessageService.add(chatRoom,
                messageRequest.getWriterName(),
                messageRequest.getContent());

        System.out.println("chatMessage : " + chatMessage);

        // 지정된 채팅방으로 메시지 전송
        simpMessagingTemplate.convertAndSend("/topic/chat/room/" + roomId, chatMessage);

        return new RsData<>("200", "메시지 전송 성공");
    }
}
