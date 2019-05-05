package io.springs.api.data.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by giridharvasudevan on 05/10/2018.
 */

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCourses(String topicId){
		List<Course> allCourses = new ArrayList <>();
		courseRepository.findByTopicId(topicId).forEach(allCourses::add);
		return allCourses;
	}

	public Course getACourse(String id){
		return courseRepository.findById(id).get();
	}

	public void addOrUpdateCourse(Course course){
		courseRepository.save(course);
	}


	public void deleteCourse(String id){
		courseRepository.delete(courseRepository.findById(id).get());
	}
}
