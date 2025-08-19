package com.cecilialopez.ForONE.controller;

import com.cecilialopez.ForONE.domain.Topic;
import com.cecilialopez.ForONE.domain.topic.DataListTopic;
import com.cecilialopez.ForONE.domain.topic.DataRegisterTopic;
import com.cecilialopez.ForONE.domain.topic.DataResponseTopic;
import com.cecilialopez.ForONE.domain.topic.DataUpdateTopic;
import com.cecilialopez.ForONE.repository.TopicRepository;
import com.cecilialopez.ForONE.service.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity<DataResponseTopic> registerTopic(@RequestBody @Valid DataRegisterTopic dataRegisterTopic, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicService.createTopic(dataRegisterTopic);
        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(new DataResponseTopic(topic));
    }

    @GetMapping
    public ResponseEntity<Page<DataListTopic>> listTopics(@PageableDefault(size = 10, sort = {"creationDate"}) Pageable pageable) {
        return ResponseEntity.ok(topicRepository.findAll(pageable).map(DataListTopic::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseTopic> getTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataResponseTopic(topic));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DataResponseTopic> updateTopic(@RequestBody @Valid DataUpdateTopic dataUpdateTopic) {
        Topic topic = topicService.updateTopic(dataUpdateTopic);
        return ResponseEntity.ok(new DataResponseTopic(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}
