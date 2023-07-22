## 😊안녕하세요! 저희 프로젝트에 대해 설명드리도록 하겠습니다.

#### 저희는 대출상품 추천 웹 애플리케이션을 개발했습니다. 

###### 프로젝트 기간은 2023년 5월 2일부터 6월 26일까지이며, Spring Boot, React, 그리고 Python을 사용하여 구현했습니다.
###### 이 프로젝트의 목표는 Spring과 React를 효과적으로 연동하는 방법을 경험하고, Python의 라이브러리와 프레임워크를 직접 활용해 보는 것입니다.
###### 프로젝트를 진행하면서 회원 인증/인가, Rest API 연동, 그리고 Python을 활용한 데이터 수집과 React와의 연결에 대한 고민을 하며 코드를 작성했습니다.
#### 구현 영상 유투브 https://www.youtube.com/watch?v=mKPWsGN8HYI
## ✨ 저희 프로젝트는 세 가지 과정으로 구성되어 있습니다.

#### 과정1 : React + java + SpringBoot + JPA + DB [my sql ]기반의 웹어플리케이션 개발

#### 과정2 : Python 기반의 데이터분석: 수집(web scraping) + 정제(numpy,pandas) + 분석 + 시각화(ELK)

#### 과정3 : Python 기반의 데이터 예측: AI 알고리즘 [ex)선형회귀, 로지스틱 회귀, DNN]을 활용하여 데이터 예측 시스템 구축

###### 프로젝트에서는 Java를 사용하여 회원과 게시판 기능을 React와 Spring Boot를 통해 구현했습니다. 

###### Python을 통해 공공 API에 접근하여 데이터를 수집하고 정제한 후, ELK를 통해 시각화하고 다시 React에서 표현할 수 있도록 설정했습니다.

###### 또한, 데이터를 훈련시켜 회원에게 맞는 대출 상품을 추천하는 기능도 Python을 통해 구현했습니다.

## ✍️ 목차

- STACKS
- 구현 기능
- ERD 설계
- 구현 화면 및 설명
- Python 기반의 데이터 분석 및 예측
- 자체 평가 의견

## 📚 STACKS

<div align=center>
<img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black">
<img src="https://img.shields.io/badge/Axios-5A29E4?style=for-the-badge&logo=Axios&logoColor=white">
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">   
<br>
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
<img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white"> 
<img src="https://img.shields.io/badge/Apache Maven-C71A36?style=for-the-badge&logo=Apache Maven&logoColor=white">  
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> 
<img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
<br>
<img src="https://img.shields.io/badge/PyCharm-F7DF1E?style=for-the-badge&logo=PyCharm&logoColor=black">
<img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=for-the-badge&logo=PyCharm&logoColor=white">
  
<br>
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"> 
<img src="https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=white">
</div>

## ✴️ 구현기능

* **회원 기능**
  - Spring Security,jwt
  - 로그인/로그아웃
  - 회원가입/탈퇴, 회원정보 수정
    
* **게시판 기능**
  - 게시글 작성/수정/삭제
  - 댓글 기능
  - 첨부 파일 기능

## 🪄 ERD 설계    
![ERD](https://github.com/Hooddduck/BKHJ-backend/assets/125169764/f1bd871a-e52d-491b-8da9-296e0dfba2f7)

## ✅ 구현 화면 및 설명

### (1) 회원 기능
### ✔️ 회원 기능 구현 화면
https://github.com/Hooddduck/BKHJ-backend/assets/125169764/20bde107-e186-4225-9bc1-6e4f48be3731

### ✔️ Spring Security 
###### # WebSecurityConfigurerAdapter은 Spring Security에서 보안 구현을 담당하는 핵심 클래스입니다.
###### # UserDetailsService를 통해 사용자 정보를 로드하고, UsernamePasswordAuthenticationToken을 사용하여 로그인 요청을 인증합니다.
###### # OncePerRequestFilter를 사용하여 JWT 유효성을 검사하고, 인증된 사용자의 세부 정보를 로드하고 권한을 확인합니다.
###### # AuthenticationEntryPoint는 인증되지 않은 액세스에 대한 오류를 처리하고 401을 반환합니다.
###### # Repository는 데이터베이스 작업을 처리하는 UserRepository와 RoleRepository를 포함합니다.
###### # Controller는 요청을 처리하며, AuthController는 회원 가입 및 로그인을 처리하고, TestController에는 역할 기반 검증이 있는 보호된 리소스에 액세스하는 메서드가 있습니다.
###### # WebSecurityConfig은 SecurityFilterChain filterChain을 확장합니다.
###### # UserDetailsServiceImpl은 UserDetailsService를 구현합니다.
###### # UserDetailsImpl은 UserDetails를 구현합니다.
###### # AuthEntryPointJwt는 AuthenticationEntryPoint를 구현합니다.
###### # AuthTokenFilter는 OncePerRequestFilter를 확장합니다.
###### # JwtUtils는 JWT 생성, 구문 분석, 유효성 검사를 위한 메서드를 제공합니다.
###### # 컨트롤러는 회원 가입/로그인 요청 및 인증된 요청을 처리합니다.
###### # 리포지토리에는 Spring Data JPA JpaRepository를 확장하는 인터페이스가 있습니다.
###### # 모델은 인증(User) 및 권한(Role)을 위한 두 가지 주요 모델을 정의합니다.
###### # 페이로드는 요청 및 응답 객체를 위한 클래스를 정의하고 application.properties 파일을 사용하여 Spring Datasource, Spring Data JPA 및 앱 속성을 구성합니다.

### (2) 게시판 기능
### ✔️ 게시판 기능 구현 화면
https://github.com/Hooddduck/BKHJ-backend/assets/125169764/7aa835d3-5248-4c74-9ed1-1fb7d2345c5a

### ✔️ 댓글 기능

![댓글](https://github.com/Hooddduck/BKHJ-backend/assets/125169764/0f720d7c-88bf-421e-a4c6-d2075c8ae681)
###### # comment.java[model] 에 게시판에 PK를 가져와야 합니다. 
###### # 마찬가지로 각각, Controller , Repository ,Serivce에도 해당 board ID를 추가해야 합니다.

### ✔️ 첨부 파일 기능 
###### # 댓글과 마찬가지로 Board_id[Pk] 값을 속성으로 가져와야 합니다.
![첨부파일1](https://github.com/Hooddduck/BKHJ-backend/assets/125169764/c294df06-0deb-4c0c-820e-6ef5c0f283de)
###### # 댓글 구성과 다른 점은, 게시판 등록 시 파일과 게시판이 같이 저장되는 것을 염두에 두어야 하는 것입니다.
###### # 파일 부분에 대해서 예외처리가 꼭 필요합니다.
![첨부파일2](https://github.com/Hooddduck/BKHJ-backend/assets/125169764/763e41b7-7450-4865-a665-680ad81f3a81)

## 👌 Python 기반의 데이터 분석 및 예측

### ✔️ Python 기반의 데이터 분석 및 예측 구현 화면
https://github.com/Hooddduck/BKHJ-backend/assets/125169764/ca4a6d08-45b5-41c9-9a3d-c71bf72297c8

### (1) Data 수집
##### 저희 프로젝트의 목표 중 하나는 대출 상품을 비교하는 서비스를 제공하는 것입니다. 
###### 이를 위해 공공데이터 포털 사이트([https://www.data.go.kr/data/15074500/openapi.do])에서 해당 데이터를 다운로드하여 사용했습니다.

### (2) Data 정제 및 분석 [Python]
######  공공 데이터에서 원하는 column을 파싱하여 JSON 형태로 추출할 수 있으며, 추출한 데이터를 CSV 파일로 다운로드할 수도 있습니다. 
###### 이렇게 변환된 파일은 ELK (Elasticsearch, Logstash, Kibana)에 등록하여 활용할 수 있습니다.
##### 코드 확인 [Python] 
[분석code.txt](https://github.com/Hooddduck/BKHJ-backend/files/11928853/code.txt)

### (3) Data 시각화
######  Python을 사용하여 데이터를 ELK (Elasticsearch, Logstash, Kibana)에 등록하고, 그 데이터를 REST API를 통해 호출하여 React 애플리케이션에서 대출 상품을 비교하는 형태로 나타냈습니다.
![대출상품](https://github.com/Hooddduck/BKHJ-backend/assets/125169764/0d3249a9-fe4b-4b17-8340-5a35dd6d6a13)

### (4) AI 예측
###### 개인정보 보호법으로 인해 고객 데이터를 구하는 것이 어려워 저희는 고객 데이터 대신 가상의 DummyData를 활용하여 고객들에게 선호하는 상품을 자동으로 추천하는 AI 프로그램을 개발했습니다. 
###### 이 프로그램은 같은 나이와 성별을 기준으로 가장 많이 구매한 상품을 추천하며, 또한 대출한도와 대출기간을 활용하여 금리를 예측하는 기능도 구현 했습니다.
[preditmodel.xls](https://github.com/Hooddduck/BKHJ-backend/files/11928878/preditmodel.xls)

[LoanProduct.5.xlsx](https://github.com/Hooddduck/BKHJ-backend/files/11928879/LoanProduct.5.xlsx)

##### 코드 확인 [AI Python 코드]
[AI예측.txt](https://github.com/Hooddduck/BKHJ-backend/files/11928882/AI.txt)

## 😺 자체 평가 의견
#### 팀원들과 함께 Spring Boot, React, Python, 그리고 ELK(엘라스틱서치, 로그스태시, 키바나)를 사용하면서 다양한 경험을 쌓았습니다. 이를 통해 서버 공유에 대해 얼마나 열심히 공부해야하는지 깨달았고, 데이터 분석과 정제의 중요성을 인지했습니다. 특히, 데이터를 분석하고 정제하는 과정에서 DB에 대한 공부 필요성을 더욱 느끼게 되었습니다.
#### 지금까지 저의 글을 읽어주셔서 감사합니다 🙋‍♀️



