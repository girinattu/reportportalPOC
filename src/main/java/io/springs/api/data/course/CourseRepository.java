package io.springs.api.data.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by giridharvasudevan on 06/10/2018.
 */
public interface CourseRepository extends CrudRepository<Course,String> {

	List<Course> findByTopicId(String topicId);
	List<Course> findByName(String name);
	List<Course> findByDescription(String description);

}
