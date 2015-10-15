package io.spring.cloud.samples.guestbook.controller;

import io.spring.cloud.samples.guestbook.domain.Message;
import io.spring.cloud.samples.guestbook.repositories.MessageRepository;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/message/**", produces = "application/json")
public class GuestbookController {
  public static final Logger LOGGER = Logger.getLogger(GuestbookController.class.getName());

  @Autowired
  private MessageRepository messageRepository;

  @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<Message> getAllMessages() {
    LOGGER.info("message repo is: " + messageRepository);
    List<Message> messages = new LinkedList<>();
    Iterable<Message> messageIterable = messageRepository.findAll();
    for (Message message : messageIterable) {
      messages.add(message);
    }
    return messages;
  }

  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  @ResponseBody
  public Message putMessage(@RequestBody Message message) {
    LOGGER.info("message repo is: " + messageRepository);

    return messageRepository.save(message);
  }
}