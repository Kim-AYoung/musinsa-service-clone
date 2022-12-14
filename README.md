# ****[프로젝트] 무신사 서비스 구현****

## 프로젝트 개요
![image](https://user-images.githubusercontent.com/57066971/197216501-5c39bd61-d956-4705-aac3-47892556488c.png)
### 주제

> `주문관리 클론 프로젝트`를 참고하여, `무신사(의류 쇼핑몰) 서비스`로 구현해보기
>

### 목적

1. 클론 프로젝트에서 도메인을 변경해, 다양한 도메인을 경험해본다.
2. 카카오 로그인 기능을 구현해본다.

### 구현 기능

1. 상품 관리
2. 주문 관리
3. 카카오 로그인

## 기술 스택

- **Server** : java 17, spring boot 2.7.4
- **DB**
    - Main  : MySQL
    - Test : 메모리 기반의 H2
- **JPA** : spring data jpa
- **Test** : JUnit5
- **API Docs, Test** : Postman
- **프로젝트 관리 툴** : Notion
    - **Notion 주소** : [https://www.notion.so/imkima/57864c98c1ed49edb8568e8b67148ec8](https://www.notion.so/57864c98c1ed49edb8568e8b67148ec8)
- **기타 편의 툴** : Lombok

## API 문서

[PostMan - Musinsa Service Api Documentation](https://documenter.getpostman.com/view/15111130/2s84Dmw3Xu)

## 프로젝트 회고

- 이제 기본적인 CRUD는 익숙해졌다.
    - 복잡한 CRUD도 해봐야겠다.
        - JPA 공부도 좀 더 필요하다.
    - CRUD 이외의 기능도 구현해봐야겠다.
- 카카오 로그인 API는 엄청 편리하다.
    - API 설계의 중요성을 깨달았다.
- develop해야할 점
    - 서버에 회원 정보를 저장
    - 기타 쇼핑몰에 필요한 기능들