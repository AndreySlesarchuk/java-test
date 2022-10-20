package by.atmm.java.__tests.domain.service;

import by.atmm.java.__tests.domain.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public Message deliverMessage (Message message) {

        return message;
    }
}
