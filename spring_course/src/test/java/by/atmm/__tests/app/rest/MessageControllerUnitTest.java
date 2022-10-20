package by.atmm.__tests.app.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import by.atmm.__tests.domain.util.MessageMatcher;
import by.atmm.java.__tests.app.rest.MessageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import by.atmm.java.__tests.app.api.MessageDTO;
import by.atmm.java.__tests.domain.model.Message;
import by.atmm.java.__tests.domain.service.MessageService;


@RunWith(MockitoJUnitRunner.class)
public class MessageControllerUnitTest {

        @InjectMocks
        private MessageController messageController;
    
	@Mock
	private MessageService messageService;

	@Test
	public void givenMsg_whenVerifyUsingAnyMatcher_thenOk() {
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setFrom("me");
		messageDTO.setTo("you");
		messageDTO.setText("Hello, you!");

		messageController.createMessage(messageDTO);

		Mockito.verify(messageService, Mockito.times(1)).deliverMessage(ArgumentMatchers.any(Message.class));
	}

	@Test
	public void givenMsg_whenVerifyUsingMessageMatcher_thenOk() {
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setFrom("me");
		messageDTO.setTo("you");
		messageDTO.setText("Hello, you!");

		messageController.createMessage(messageDTO);

		Message message = new Message();
		message.setFrom("me");
		message.setTo("you");
		message.setText("Hello, you!");

		Mockito.verify(messageService, Mockito.times(1)).deliverMessage(ArgumentMatchers.argThat(new MessageMatcher(message)));
	}
}
