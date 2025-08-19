package com.cecilialopez.ForONE.domain.topic;

import com.cecilialopez.ForONE.domain.Topic;

public record DataResponseTopic(
        Long id,
        String title,
        String message,
        String creationDate,
        Boolean status,
        String author,
        String course
) {
    public DataResponseTopic(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(), topic.getStatus(), topic.getAuthor(), topic.getCourse());
    }
}
