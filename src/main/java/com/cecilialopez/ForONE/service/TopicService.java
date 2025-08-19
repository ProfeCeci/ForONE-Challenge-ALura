package com.cecilialopez.ForONE.service;

import com.cecilialopez.ForONE.domain.Topic;
import com.cecilialopez.ForONE.domain.topic.DataRegisterTopic;
import com.cecilialopez.ForONE.domain.topic.DataUpdateTopic;
import com.cecilialopez.ForONE.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(DataRegisterTopic dataRegisterTopic) {
        // Here you can add logic to find the user by idUser and set it to the topic
        Topic topic = new Topic(null, dataRegisterTopic.title(), dataRegisterTopic.message(), java.time.LocalDateTime.now().toString(), true, "user" + dataRegisterTopic.idUser(), dataRegisterTopic.course());
        return topicRepository.save(topic);
    }

    public Topic updateTopic(DataUpdateTopic dataUpdateTopic) {
        Topic topic = topicRepository.getReferenceById(dataUpdateTopic.id());
        if (dataUpdateTopic.title() != null) {
            topic.setTitle(dataUpdateTopic.title());
        }
        if (dataUpdateTopic.message() != null) {
            topic.setMessage(dataUpdateTopic.message());
        }
        if (dataUpdateTopic.course() != null) {
            topic.setCourse(dataUpdateTopic.course());
        }
        return topic; // The transaction will commit the changes
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
