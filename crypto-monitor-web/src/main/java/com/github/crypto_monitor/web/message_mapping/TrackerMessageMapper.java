package com.github.crypto_monitor.web.message_mapping;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TrackerMessageMapper {

    @MessageMapping("/update")
    @SendTo("topic/tracker")
    String updateTracker(@Payload String message) {
        return message;
    }

}
