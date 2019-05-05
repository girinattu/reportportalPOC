package io.springs.api.data.functionaltests.stepdefinition;



import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.springs.api.data.topic.topic.Topic;
import org.junit.Assert;


/**
 * Created by giridharvasudevan on 04/05/2019.
 */
public class TopicSteps {
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	Topic topic = new Topic();
	String nameOfTopic = null;
	String description = null;
	public TopicSteps() {
		RestAssured.baseURI = "http://localhost:8090/";
		RestAssured.basePath = "topics";
	}
	@Given("^user wants to create a topic$")
	public void topicCreation() throws Throwable {
		System.out.println("User wants to create a topic");
	}

	@When("^user creates a topic with the topic name and description$")
	public void topicNameAndDesc() throws Throwable {
		nameOfTopic = strGenerator(5,false);
		description = strGenerator(50,true);
		topic.setName(nameOfTopic);
		topic.setDescription(description);
		topic.setId(nameOfTopic);
		System.out.println("name fo topic" + nameOfTopic);
		System.out.println("description" + description);
		Response response =
		given().contentType(ContentType.JSON).body(new ObjectMapper().writeValueAsString(topic)).when().post().andReturn();
		System.out.println(response.asString());

	}
	@And("^the topic is created successfully$")
	public void verifyTopicCreated() throws Exception{
		Response response = given().contentType(ContentType.JSON).when().get("/"+nameOfTopic).andReturn();
		System.out.println(response.asString());

		Assert.assertTrue(response.statusCode()==200);
		Topic returnedTopic = new ObjectMapper().readValue(response.body().asString(),Topic.class);
		Assert.assertTrue(returnedTopic.getName().equals(nameOfTopic));
		System.out.println("expected " + description);
		System.out.println("actual" + returnedTopic.getDescription());
		Assert.assertTrue(returnedTopic.getDescription().equals(description));
	}




	public String strGenerator(int length, boolean spaces){
		String finalstr = "";
			StringBuilder builder = new StringBuilder();
			while (length-- != 0) {
				int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
				builder.append(ALPHA_NUMERIC_STRING.charAt(character));
				if(spaces && length%5==0) {
					finalstr = finalstr + " ";
					finalstr = finalstr + builder.toString();

				}
				else {
					finalstr = builder.toString();
				}
			}

		return finalstr;
	}




}
