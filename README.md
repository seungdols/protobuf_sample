
# protobuf 학습 프로젝트 

- protobuf 파일을 생성하고, 빌드 하여 어떤 구현체가 생성 되는지 확인 한다. 
- kotlin 베이스로 프로젝트가 구성 되어 있어서, kotlin으로 작성 하는 것이 유익하다.

## build.gradle.kts

```kotlin
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:${rootProject.ext["protobufVersion"]}"
    }
    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${rootProject.ext["grpcVersion"]}"
        }
        create("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:${rootProject.ext["grpcKotlinVersion"]}:jdk8@jar"
        }
    }
    // omitted protoc and plugins config
    generateProtoTasks {
        all().forEach {
            it.plugins {
                create("grpc")
                create("grpckt")
            }
            it.builtins {
                create("kotlin")
            }
        }
    }
}
```

해당 블록의 설정대로 protobuf 파일 generatedProtoTasks가 동작하게 된다.
