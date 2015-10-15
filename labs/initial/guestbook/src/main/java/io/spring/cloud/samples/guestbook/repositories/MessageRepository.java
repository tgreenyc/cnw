package io.spring.cloud.samples.guestbook.repositories;

import io.spring.cloud.samples.guestbook.domain.Message;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

}