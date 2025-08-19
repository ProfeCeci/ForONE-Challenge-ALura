package com.cecilialopez.ForONE.domain.topic;

import com.cecilialopez.ForONE.domain.Topic;

public record DataListTopic(
        Long id,
        String title,
        String message,
        String creationDate
) {
    public DataListTopic(Topic topic) {
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate());
    }
}
