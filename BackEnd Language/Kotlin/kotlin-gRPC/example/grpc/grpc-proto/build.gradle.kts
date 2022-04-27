import com.google.protobuf.gradle.*
import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation("io.grpc:grpc-protobuf:1.42.2")
    implementation("io.grpc:grpc-stub:1.42.2")
    implementation("javax.annotation:javax.annotation-api:1.3.2")

}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.20.0"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.45.1"
        }
    }

    generateProtoTasks {
        ofSourceSet("main").forEach { generateProtoTask ->
            generateProtoTask
                .plugins {
                    id("grpc")
                }
        }
    }
}
