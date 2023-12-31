package com.example.dataProcessing;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.dataProcessing.model.ProcessedData;
import com.example.dataProcessing.repository.DataRepository;

@Component
public class KafkaListeners {

    private DataRepository repository;
    
    public KafkaListeners(DataRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "newTopic", groupId = "proccesed_Data", containerFactory = "exampleKafkaListenerContainerFactory"  )
    void listener(@Payload ProcessedData dataList){

        repository.save(dataList);

        System.out.println(dataList);

    }
}
