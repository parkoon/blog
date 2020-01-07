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
    - Node: v10.9.0
    - Npm: 6.2.0
    - React


## Preparation's
### Spring Project creating
  - Spring Initializr 사용방법(2가지)
    ~~~
    1. Spring 공식 홈페이지(spring.io)에서 제공하는 기능을 사용합니다.
      1-1. spring.io 접속
      1-2. projects(상단메뉴) > spring boot(조회된 메뉴) > Quick start(상세 탭) > Spring Initializr 이용
     
    2. IDE(Intelli-J, STS 등)에서 제공하는 기능을 사용합니다.
      2-1. 각 tools마다 사용법 상이.
    ~~~
    
  - Spring Initializr Description
    ~~~
    - Project: Maven Project 또는 Gradle Project
      - 빌드, 베포 툴인 Maven과 Gradle 중 택
      - Language: Java, Kotlin, Groovy
      - Spring Boot: Spring Boot의 version
      - Project Metadata: group, artifact 등을 지정합니다.
        - 일반적으로 group은 project의 도메인 및 Default package 경로를 뜻하며, artifact는 프로젝트 명을 암시합니다.
      - Dependencies
        - 프로젝트의 의존성을 추가합니다. (간단히 소프트웨어의 플러그인 정도로 생각하면 됩니다.) 
    ~~~
      
### React interlocking in Spring Boot
  - React 앱을 생성
    ~~~
    npm install -i react react-dom
    
    또는
    
    npm install -g create-react-app
    ~~~
    
  - 의존성 추가(Webpack, Babel, loader 등)
    ~~~
    npm i webpack webpack-cli @babel/core @babel/preset-env @babel/preset-react babel-loader css-loader style-loader -D
    ~~~
      - babel-loader : 자바스크립트 모듈 번들링을 위한 로더이며, 보통 ES6 코드를 ES5로 변환하기 위해 사용한다.
      - css-loader : 모듈 번들링은 자바스크립트 기반으로 이뤄지기 때문에 CSS 파일을 자바스크립트로 변환하기 위해 사용한다.
      - style-loader : css-loader에 의해 모듈화 되고, 모듈화 된 스타일 코드를 HTML 문서의 STYLE 태그 안에 넣어주기 위해 사용된다.
      - url-loader : 스타일에 설정된 이미지나 글꼴 파일을 문자열 형태의 데이터(Base64)로 변환하여 해당 CSS 파일 안에 포함시켜버리기 때문에 정적 파일을 관리하기 쉬워진다. 하지만 실제 파일들보다 용량이 커지고, CSS 파일이 무거워지므로 적당히 사용하는 것을 권장한다.
      - file-loader : 정적 파일을 로드하는데 사용되며, 보통 프로젝트 환경에 맞게 특정 디렉토리에 파일을 복사하는 역할을 수행한다.
     
  - webpack
    - root directory에 'webpack.config.js' file 생성
    - webpack.config.js 작성(파일 참조)
      ~~~
      Source 경로: module.exports = {context: path.resolve(__dirname, 'Source 경로') ... }
      Build SRC: module.exports = { ... entry: {Build SRC entry: '경로'} ... }
      Build DST: module.exports = { ... output: {path: __dirname, filename: '경로'} ... }
      ~~~
    
  - react router
    - React router install
      ~~~
      npm i react-router-dom
      
      npm install --save react-router
      ~~~
    - import
      ~~~
      import { Router, Route, IndexRoute, browserHistory } from 'react-router';
      ~~~
        - Router: 이 컴포넌트는 react-router 의 주요 컴포넌트로서, 라우터의 속성을 정의하고 이 내부에서 라우트 설정을 합니다.
        - Route: 이 컴포넌트는 우리가 설정한 경로에서 어떤 컴포넌트를 렌더링 할 지 정하는 컴포넌트 입니다. 이 라우트 컴포넌트의 자식에 또 다른 Route 컴포넌트를 넣으면 해당 자식 컴포넌트는 부모 라우트의 서브 라우트가 됩니다.
        - IndexRoute: 라우트에서 서브라우트가 주어지지 않았을 때, 즉 특정 라우트의 / 경로로 들어 왔을 때, 이 라우트에서 지정한 컴포넌트를 보여줍니다.
        - browserHistory: HTML5 의 History API 를 사용하여 브라우저의 URL 변화를 주시하고, 조작합니다.