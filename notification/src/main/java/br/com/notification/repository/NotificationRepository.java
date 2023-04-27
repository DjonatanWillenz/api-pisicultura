package br.com.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.notification.models.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {

}
