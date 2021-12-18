# [Spring] RestTemplate 사용 시 필요한 기능

#### restTemplate 설정 메서드

````
    // restTemplate 설정 메서드
    public RestTemplate restTemplateConfig() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000); // 타임아웃 설정 5초
        factory.setReadTimeout(5000); // 타임아웃 설정 5초
       
        // HttpClient 관련 설정
        HttpClient httpClient = HttpClientBuilder.create()
                                    .setMaxConnTotal(50) // 최대 커넥션 수
                                    .setMaxConnPerRoute(20) // 각 호스트 당 커넥션 풀에 생성가능한 커넥션 수
                                    .build();
       
        factory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(factory);
        return restTemplate;
    }
````



#### SSL이 적용된 RestTemplate 메서드 구현

````
    // SSL이 적용된 RestTemplate 메서드 구현
    public RestTemplate createSslRestTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
 
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionTimeToLive(30, TimeUnit.SECONDS)
                .setMaxConnPerRoute(300)
                .setMaxConnPerRoute(100)
                .setSSLSocketFactory(csf)
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
 
        return new RestTemplate(requestFactory);
    }
````



#### HttpHeader 메서드 설정

````
    // HttpHeader 메서드 설정
    public HttpHeaders createHttpHeaders() {
        // create headers
        HttpHeaders reqheaders = new HttpHeaders();
        // set 'content-type' header
        reqheaders.setContentType(MediaType.APPLICATION_JSON);
        // set 'accept' header
        reqheaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
       
        return reqheaders;
    }
````



#### Object -> Json으로 변경

````
    // Object -> Json으로 변경
    public String getJsonParam(ExampleDto exampleDto) {
        String jsonParam = "";
        try {
            jsonParam = objectMapper.writeValueAsString(exampleDto);
            return jsonParam;
        } catch (JsonProcessingException e) {
            log.error("ConvertToJson Error Occured. {}", e);
            throw new CcpApiException(
                    ccpMessage.getArgumentsMessagetype("cmm.unknown.err")
                    , ccpMessage.getArgumentsMessage("cmm.unknown.err"));
        }
    }
````

