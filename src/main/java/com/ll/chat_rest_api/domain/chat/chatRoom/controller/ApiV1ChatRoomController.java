package com.ll.chat_rest_api.domain.chat.chatRoom.controller;

import com.ll.chat_rest_api.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_rest_api.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * packageName    : com.ll.chatAi.domain.chat.chatRoom.controller
 * fileName       : ApiV1ChatRoomController
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
public class ApiV1ChatRoomController {

    private final ChatRoomService chatRoomService;

    // 채팅방 목록 조회
    @GetMapping("")
    public List<ChatRoom> chatRoomList() {
        return chatRoomService.list();
    }

    // 단건 채팅방 조회
    @GetMapping("/{roomId}")
    public ChatRoom chatRoom(@PathVariable Long roomId) {
        return chatRoomService.findRoom(roomId);
    }

    // 채팅방 생성
    @PostMapping("")
    public ChatRoom createChatRoom(@RequestBody HashMap<String, String> name) {
        return chatRoomService.create(name.get("name"));
    }
}
