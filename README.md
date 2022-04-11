# rest-challenge
RESTful Web services using RESTEasy and WildFly.
This web service provides the following functions - add person, edit person, get persons and the statistics, validate the payloads agains xsd schema. 


Postman collection and environment json files for the calls of the REST services are attached.
+ challenge.postman_collection.json 
+ local.postman_environment.json

## REST Endpoints
The following REST endpoints are implemented.

| HTTP Verb        | URL           | Paramaters | Description |
| ------------- |-------------|-------------|-------------|
| `GET` | `http://localhost:8080/challenge/rs/persons` |  | Obtains a list of all existing persons |
| `POST` | `http://localhost:8080/challenge/rs/persons/add` | `<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<persons>\r\n  <person>\r\n    <name>John Doe Sr</name>\r\n\t<gender>m</gender>\r\n\t<age>53</age>\r\n  </person>\r\n  <person>\r\n    <name>John Doe</name>\r\n\t<gender>m</gender>\r\n\t<age>23</age>\r\n  <person>\r\n    <name>John Doe Jr</name>\r\n\t<gender>m</gender>\r\n\t<age>2</age>\r\n  </person>\r\n  </person>\r\n</persons>` | validate xml and add new persons |
| `POST` | `http://localhost:8080/challenge/rs/persons/edit` | `<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n<persons>\r\n  <person>\r\n    <name>John Doe</name>\r\n\t<gender>m</gender>\r\n\t<age>53</age>\r\n  </person>\r\n  <person>\r\n    <name>Jane Doe</name>\r\n\t<gender>f</gender>\r\n\t<age>47</age>\r\n  </person>\r\n  <person>\r\n    <name>John-Jane Doe</name>\r\n\t<gender>n</gender>\r\n\t<age>23</age>\r\n  </person>\r\n</persons>` | validate xml and edit existing persons |
| `GET` | `http://localhost:8080/challenge/rs/statistics` |  | Obtains a statistic |
