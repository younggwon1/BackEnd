# eclipse setting
https://velog.io/@anisia20/Quarkus-%EC%9D%B4%ED%81%B4%EB%A6%BD%EC%8A%A4-%EA%B0%9C%EB%B0%9C%ED%99%98%EA%B2%BD-%EC%84%B8%ED%8C%85

# modify /etc/hosts
```
sudo vi /etc/hosts
YourIP test.mysql.com
```

# need mysql8
```
cd docker
docker-compose up -d
```

# guide
- openjdk11 install for macos
```
brew tap AdoptOpenJDK/openjdk
brew install --cask adoptopenjdk11
```

# build native image
```
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
docker build -f src/main/docker/Dockerfile.jvm -t example .
docker run --name example -i -d -p 8080:8080 --rm example
```
