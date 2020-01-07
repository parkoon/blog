# blog
## Environment's
  - Server
    - Nginx/Tomcat
  - Database
    - MySQL, Redis
  - Language
    - Java(JDK 1.8)
  - Framework
    - Spring Boot(2.1.6.RELEASE) 
  - View
    - React


## Preparation's
  - Project creating
      ~~~
      * Spring Initializr 사용방법(2가지)
      
        1. Spring 공식 홈페이지(spring.io)에서 제공하는 기능을 사용합니다.
          1-1. spring.io 접속
          1-2. projects(상단메뉴) > spring boot(조회된 메뉴) > Quick start(상세 탭) > Spring Initializr 이용
          
        2. IDE(Intelli-J, STS 등)에서 제공하는 기능을 사용합니다.
          2-1. 각 tools마다 사용법 상이.
          
      * Spring Initializr Description
        - Project: Maven Project 또는 Gradle Project
           - 빌드, 베포 툴인 Maven과 Gradle 중 택
        - Language: Java, Kotlin, Groovy
        - Spring Boot: Spring Boot의 version
        - Project Metadata: group, artifact 등을 지정합니다.
          - 일반적으로 group은 project의 도메인 및 Default package 경로를 뜻하며, artifact는 프로젝트 명을 암시합니다.
        - Dependencies
          - 프로젝트의 의존성을 추가합니다. (간단히 소프트웨어의 플러그인 정도로 생각하면 됩니다.) 
      ~~~