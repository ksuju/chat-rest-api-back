package com.ll.chat_rest_api.global.notProd;

import com.ll.chat_rest_api.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chat_rest_api.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chat_rest_api.domain.chat.chatRoom.service.ChatRoomService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;


/**
 * packageName    : com.ll.chatAi.global.notProd
 * fileName       : NotProd
 * author         : sungjun
 * date           : 2025-01-06
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-01-06        kyd54       최초 생성
 */
@Configuration
@Profile("!prod")
public class NotProd {
    @Bean
    public ApplicationRunner initNotProd(ChatRoomService chatRoomService,
                                         ChatMessageService chatMessageService) {
        return  new ApplicationRunner() {
            @Override
            @Transactional
            public void run(ApplicationArguments args) throws Exception {
                // 저장된 모든 데이터 삭제 후 더미 데이터 생성
                // application.yml jpa 설정에서 ddl-auto: create로 설정해서 데이터 쌓이는 문제 해결
//            chatMessageService.deleteAll();
//            chatRoomService.deleteAll();

                ChatRoom chatRoom1 = chatRoomService.create("공부");
                ChatRoom chatRoom2 = chatRoomService.create("식사");
                ChatRoom chatRoom3 = chatRoomService.create("휴식");

                System.out.println("Not Prod");
            }
        };
    }

}
