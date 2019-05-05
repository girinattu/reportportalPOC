# springapp_cucumber
Spring boot application with cucumber tests and connecting it to report portal for reporting and dashboards.

To build the spring boot app:
docker-compose run -p 9000:8090 topics-courses

The app will be running at port 9000
http://localhost:9000/topics

To run tests:
mvn clean test -Dtest=TestRunner

The report portal must be running on port 8080 on the localhost and the launch will be updated accordingly.



