# Kafka 전반적인 내용

[Kafka DOCUMENTATION](https://kafka.apache.org/documentation/#gettingStarted)

[전반적인 Kafka 내용](https://www.popit.kr/author/peter5236)

[메시징 시스템( Messaging System )의 이해](https://victorydntmd.tistory.com/343)

[[Kafka] 기본 개념잡기](https://victorydntmd.tistory.com/344)

[Kafka 운영자가 말하는 처음 접하는 Kafka](https://www.popit.kr/kafka-%EC%9A%B4%EC%98%81%EC%9E%90%EA%B0%80-%EB%A7%90%ED%95%98%EB%8A%94-%EC%B2%98%EC%9D%8C-%EC%A0%91%ED%95%98%EB%8A%94-kafka/)

[Kafka 운영자가 말하는 Kafka Consumer Group](https://www.popit.kr/kafka-consumer-group/)



---



### Apache Kafka 생산자 소비자 CLI 튜토리얼

참고 : https://judo0179.tistory.com/117?category=454590



결과

<img width="1788" alt="스크린샷 2021-06-10 오후 6 17 44" src="https://user-images.githubusercontent.com/73063032/121499457-5fc98400-ca18-11eb-96e9-0be0e88be002.png">



---



### [SpringBoot] 간단한 Kafka 연동하기

[Kafka 연동하기](https://victorydntmd.tistory.com/m/348)

#### 1. Kafka Cluster 구축

[Docker 베이스 Kafka 환경 구축하기](https://victorydntmd.tistory.com/347)

=> Spring Boot와 Kafka를 연동하기 전 Kafka Cluster를 구축한다.

- KAFKA_ADVERTISED_HOST_NAME는 본인의 docker host ip로 수정
  - multi broker를 사용하지 않을 것이므로, localhost(127.0.0.1)을 작성

- **docker-compose up -d**

````yaml
version: '2'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    container_name: zookeeper
    ports:
      - "2181:2181"
  kafka:
    image: wurstmeister/kafka:2.12-2.5.0
    container_name: kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: 127.0.0.1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock
````

- 설치 결과

![스크린샷 2021-11-25 오후 4 43 32](https://user-images.githubusercontent.com/73063032/143400055-b097cf65-8e06-4b0c-8c4d-eb6726b2cd11.png)



#### 2. **build.gradle**

[Spring Kafka Support](https://mvnrepository.com/artifact/org.springframework.kafka/spring-kafka)

````groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'

    /* kafka */
    implementation 'org.springframework.kafka:spring-kafka'

    testImplementation('org.springframework.boot:spring-boot-starter-test') {
        exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
    }
}
````



#### 3. **구현하기**

- **1) application.yml**

  - consumer와 producer에 대한 설정을 해준다.

  ````yaml
  spring:
    kafka:
      consumer:
        bootstrap-servers: localhost:9092
        group-id: foo
        auto-offset-reset: earliest
        key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
        value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      producer:
        bootstrap-servers: localhost:9092
        key-serializer: org.apache.kafka.common.serialization.StringSerializer
        value-serializer: org.apache.kafka.common.serialization.StringSerializer

- spring.kafka.consumer
  -  bootstrap-servers
    - Kafka 클러스터에 대한 초기 연결에 사용할 호스트:포트쌍의 쉼표로 구분된 목록이다.
    - 글로벌 설정이 있어도, consumer.bootstrap-servers가 존재하면 consuemer 전용으로 오버라이딩 합니다.
  - group-id
    - Consumer는 Consumer Group이 존재하기 때문에, 유일하게 식별 가능한 Consumer Group을 작성합니다.
  - auto-offset-reset
    - Kafka 서버에 초기 offset이 없거나, 서버에 현재 offset이 더 이상 없는 경우 수행할 작업을 작성한다.
    - Consumer Group의 Consumer는 메시지를 소비할 때 Topic내에 Partition에서 다음에 소비할 offset이 어디인지 공유를 하고 있다. 그런데 오류 등으로 인해 이러한 offset 정보가 없어졌을 때 어떻게 offeset을 reset 할 것인지를 명시한다고 보면 된다.
      - latest : 가장 최근에 생산된 메시지로 offeset reset
      - earliest : 가장 오래된 메시지로 offeset reset
      - none : offset 정보가 없으면 Exception 발생
    - 직접 Kafka Server에 접근하여 offset을 reset할 수 있지만, Spring에서 제공해주는 방식은 위와 같다.
  - key-deserializer / value-deserializer
    - Kafka에서 데이터를 받아올 때, key / value를 역직렬화한다. ( consumer는 받는 입장이기에 key-value를 역직렬화해서 받는 설정.  )
    - 여기서 key와 value는 뒤에서 살펴볼 KafkaTemplate의 key, value를 의미한다.
    - 이 글에서는 메시지가 문자열 데이터이므로 StringDeserializer를 사용했습니다. JSON 데이터를 넘겨줄 것이라면 JsonDeserializer도 가능하다.
- spring.kafka.producer
  -  bootstrap-servers
    - consumer.bootstrap-servers와 동일한 내용이며, producer 전용으로 오버라이딩 하려면 작성한다.
  - key-serializer / value-serializer
    - Kafka에 데이터를 보낼 때, key / value를 직렬화 합니다. (producer는 직렬화를 해서 내보내주는 설정. )
    - consumer에서 살펴본 key-deserializer, value-deserializer와 동일한 내용이다.



---

**참고**

여기서는 Producer/Consumer 설정을 application.yml에 작성했지만, **bean을 통해 설정하는 방법**도 있다.

Producer, Consumer의 설정을 여러 개로 관리하고 싶다면 bean으로 구현하는 것도 좋은 방법일듯 하다.

---



- **KafkaController.java**

  - post 방식으로 message 데이터를 받아서, Producer 서비스로 전달한다.

  ````java
  import com.victolee.kafkaexam.Service.KafkaProducer;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PostMapping;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestParam;
  import org.springframework.web.bind.annotation.RestController;
  
  @RestController
  @RequestMapping(value = "/kafka")
  public class KafkaController {
      private final KafkaProducer producer;
  
      @Autowired
      KafkaController(KafkaProducer producer) {
          this.producer = producer;
      }
  
      @PostMapping
      public String sendMessage(@RequestParam("message") String message) {
          this.producer.sendMessage(message);
  
          return "success";
      }
  }



- **KafkaProducer.java**

  - [KafkaTemplate](https://docs.spring.io/spring-kafka/api/org/springframework/kafka/core/KafkaTemplate.html)에 Topic명과 Message를 전달한다.
    - Service 클래스에서 봐야 할 점은 **KafkaTemplate**이다. 
      - RestTemplate처럼 application.yml에 설정해놓은 Kafka 서버로 바로 통신할 수 있게 해주는 역할을 한다. 
      - KafkaTemplate 을 주입받고 이것을 통해 message를 보낸다. 그리고 send() 에서는 첫번째 파라미터로 **topic**을 두번째 파라미터로는 실제로 보낼 **메세지**를 넣어주면 된다. 
    - KafkaTemplate.send() 메서드가 실행되면, Kafka 서버로 메시지가 전송된다.

  ````java
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.kafka.core.KafkaTemplate;
  import org.springframework.stereotype.Service;
  
  @Service
  public class KafkaProducer {
      private static final String TOPIC = "exam";
      private final KafkaTemplate<String, String> kafkaTemplate;
  
      @Autowired
      public KafkaProducer(KafkaTemplate kafkaTemplate) {
          this.kafkaTemplate = kafkaTemplate;
      }
  
      public void sendMessage(String message) {
          System.out.println(String.format("Produce message : %s", message));
          this.kafkaTemplate.send(TOPIC, message);
      }
  }



- **KafkaConsumer.java**

  - Kafka로부터 메시지를 받으려면 [@KafkaListener](https://docs.spring.io/spring-kafka/api/org/springframework/kafka/annotation/KafkaListener.html) 어노테이션을 달아주면 된다.
    - 메소드 위에 @KafkaListener라는 설정을 해주고 여기에 내가 받을 topic에 대한 정보와 application.yml 에서 설정했던 groupId를 넣어준다.

  ````java
  import org.springframework.kafka.annotation.KafkaListener;
  import org.springframework.stereotype.Service;
  
  import java.io.IOException;
  
  @Service
  public class KafkaConsumer {
  
      @KafkaListener(topics = "exam", groupId = "foo")
      public void consume(String message) throws IOException {
          System.out.println(String.format("Consumed message : %s", message));
      }
  }







참고

[Springboot + Kafka 연동하여 pub/sub 구현 예제](https://oingdaddy.tistory.com/308)

[Kafka Cluster 구성하고 Spring Boot에서 Kafka 사용하기](https://sup2is.github.io/2020/06/03/spring-boot-with-kafka-cluster.html)