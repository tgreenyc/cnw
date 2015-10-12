package io.spring.cloud.samples.guestbook.repositories;

import org.springframework.data.repository.CrudRepository;

import io.spring.cloud.samples.guestbook.domain.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
