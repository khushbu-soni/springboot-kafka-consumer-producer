package com.kafka.api.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.api.constant.ApplicationConstant;
import com.kafka.api.dao.DataDaoImplementation;
import com.kafka.api.model.Data;
import com.kafka.api.service.DataService;

@RestController
@RequestMapping("/consume")
public class KafkaConsumer {

	 @Autowired
	    private DataService service;
	 
	@Autowired
	private ConcurrentKafkaListenerContainerFactory<String, Data> factory;

	@GetMapping("/message")
	public List<Data> receiveMessage() {
		List<Data> data = new ArrayList<>();
		ConsumerFactory<String, Data> consumerFactory = (ConsumerFactory<String, Data>) factory.getConsumerFactory();
		Consumer<String, Data> consumer = consumerFactory.createConsumer();
		try {
			consumer.subscribe(Arrays.asList(ApplicationConstant.TOPIC_NAME));
			ConsumerRecords<String, Data> consumerRecords = consumer.poll(10000);
			Iterable<ConsumerRecord<String, Data>> records = consumerRecords.records(ApplicationConstant.TOPIC_NAME);
			Iterator<ConsumerRecord<String, Data>> iterator = records.iterator();

			while (iterator.hasNext()) {
				data.add(iterator.next().value());

			}
			
			
			System.out.println("size "+data.size());
			for (int i = 0; i < data.size(); i++) {
				service.save(data.get(i));
				
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}