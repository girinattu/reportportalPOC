package io.springs.api.data.topic.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by giridharvasudevan on 05/10/2018.
 */

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

//	private List<Topic> topics = new ArrayList <>(Arrays.asList(
//				new Topic("spring", "Spring Framework", "Spring framework description"),
//				new Topic("Java", "Java Framework", "Java framework description"),
//				new Topic("Ruby", "Ruby Framework", "Ruby framework description")
//		));

	public List<Topic> getAllTopics(){
		List<Topic> allTopics = new ArrayList <>();
		topicRepository.findAll().forEach(allTopics::add);
		return allTopics;
	}

	public Topic getATopics(String id){
		return topicRepository.findById(id).get();
//		return getAllTopics().stream().filter(id1 -> id1.getId().equalsIgnoreCase(id)).findFirst().get();
	}

	public void addOrUpdateTopics(Topic topic){
		topicRepository.save(topic);
	}


	public void deleteTopic(String id){
		topicRepository.delete(topicRepository.findById(id).get());
	}
}
