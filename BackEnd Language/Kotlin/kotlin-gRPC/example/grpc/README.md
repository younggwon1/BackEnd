# grpc proto 
파일 위치는 `/src/main/proto` 경로 밑에 작성

# server
[grpc-server git](https://bitbucket.org/architecturelabs/example/src/master/grpc/grpc-server/)

grpc 통신 해서 데이터를 제공 하는

### grpc 통신 서버 port 지정(property 설정)
```yaml
grpc:
  server:
    port: 9898
```
### include grpc proto project 
```kotlin
implementation(project(":grpc:grpc-proto"))
```

### 비지니스 로직 작성
```kotlin
@GrpcService
class GrpcServerDemoService : GreetingServiceGrpc.GreetingServiceImplBase() {
    private val log = LoggerFactory.getLogger(javaClass)

    override fun greeting(request: GreetingRequest, responseObserver: StreamObserver<GreetingResponse>) {
        val message = request.message
        log.info("request data $message")

        val greeting = GreetingResponse.newBuilder().setMessage("hello $message").build()

        responseObserver.onNext(greeting)
        responseObserver.onCompleted()
    }
}
```

- proto project에서 생성된 XXXXXServiceImplBase 상속 구현

- 서비스 로직은 `override` 하여 재정의(proto 파일 기준)

- 통신 객체 기준은 proto 파일에 작성된 `message` 기준

# client
[grpc-client git](https://bitbucket.org/architecturelabs/example/src/master/grpc/grpc-client)

grpc 통신 해서 데이터 사용 하는곳

### grpc 통신할 서버 설정(property 설정)
```yaml
grpc:
  client:
    local-grpc-server:
      address: 'static://127.0.0.1:9898'
      enableKeepAlive: true
      keepAliveWithoutCalls: true
      negotiationType: plaintext
```
통신할 grpc 서버 주소 지정
### include grpc proto project
```kotlin
implementation(project(":grpc:grpc-proto"))
```

### 통신 client bean 생성 및 서비스에 의존 주입
```kotlin
@Configuration
@GrpcClientBean(
    clazz = GreetingServiceGrpc.GreetingServiceBlockingStub::class,
    beanName = "greetingServiceBlockingStub", 
    client = GrpcClient("local-grpc-server")
)
class GrpcConfig {

    @Bean
    fun grpcClientDemoService(@Autowired greetingServiceBlockingStub: GreetingServiceGrpc.GreetingServiceBlockingStub): GrpcClientDemoService? {
        return GrpcClientDemoService(greetingServiceBlockingStub)
    }
}
```

- `GrpcClient`이름은 `property` 작성된 client 이름

### client 통신
```kotlin
class GrpcClientDemoService(private val  greetingServiceBlockingStub w: GreetingServiceGrpc.GreetingServiceBlockingStub) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun hello(str: String) : String{
        var req = GreetingRequest.newBuilder().setMessage(str).build()

        val result = greetingServiceBlockingStub.greeting(req)

        log.info("result $result.message")

        return result.message
    }
}
```