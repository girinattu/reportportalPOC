package io.springs.api.data.course;

import io.springs.api.data.topic.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giridharvasudevan on 04/10/2018.
 */
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId){
		return courseService.getAllCourses(topicId);
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id){
		return courseService.getACourse(id);
	}


	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses" )
	public void addCourse(@PathVariable String topicId, @RequestBody Course course){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addOrUpdateCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{id}" )
	public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addOrUpdateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}" )
	public void deleteCourse(@PathVariable String id){
		courseService.deleteCourse(id);
	}
}
