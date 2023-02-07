## Lucy3 기술 스택 

<br>

`웹 프레임워크`
- SpringBoot 2.0

`Java`
- version 11


`SpringBoot docs`
- Swagger

`DB 접근 기술`
- JPA (Java Persistence API)
- QueryDSL
- MyBatis (복잡한 쿼리는 MyBatis로 해결할 때가 더 나을 때도 있기 때문에 필요)

`인증`
- JWT

`의존성 라이브러리`

- Retrofit
    - 외부 API 호출 라이브러리
    - LucyAPI 호출할 때 이용하면 편함.
    - 기존에는 HttpUrlConnection를 사용해 복잡하고 코드가 길어진다.
    - REST 뿐만 아니라 파일 업로드, 다운로드 등 모든 서버콜에 대해 짧고 간결한 코드로 대응이 가능하다.
    - okhttp 기반이라 매우 빠르다.
        - (OkHttp는 REST API, HTTP 통신을 간편하게 구현할 수 있도록 다양한 기능을 제공해주는 Java 라이브러리다)
    - JSON파싱을 gson파서가 알아서 해결
- lombok
- 객체 관리 라이브러리
- @Validated
    - 객체 값 검증 라이브러리
    - request 객체를 쉽게 검증할 수 있음
- junit
    - 테스트 코드 작성 라이브러리
- websocet