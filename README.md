# board
게시판
## Spec
- **언어 : JAVA (JDK 13)**
- **프레임워크 : SpringBoot 2.4.3.RELEASE, JPA & Hibernate)**
- **저장소 : H2(in-memory db)**
- **의존관리 : Maven**
- **Swagger 2.9.2 SNAPSHOT**

## 기능
- **로그인 => 로그인ID : user_id, 로그인PASS : user_pw => 하드코딩으로 고정**
- **게시글 리스트, 작성, 수정, 삭제**
- **패이징 처리 => 5개 이상일경우 패이징 처리**

## 프로그램 실행 방법
1.porm.xml => maven => Reload project
2.Applocation run

# 스웨거
- **http://localhost:8080/swagger-ui.html**
# 화면

![스크린샷 2021-03-16 오후 3 11 35](https://user-images.githubusercontent.com/60101005/111263699-a271ff00-8669-11eb-8dee-c7d32aa912e1.png)
![스크린샷 2021-03-16 오후 3 11 42](https://user-images.githubusercontent.com/60101005/111263705-a56cef80-8669-11eb-9d99-cbee1b6ca43d.png)
![스크린샷 2021-03-16 오후 3 15 08](https://user-images.githubusercontent.com/60101005/111263920-faa90100-8669-11eb-9acc-5b9ab0e24e55.png)
![스크린샷 2021-03-16 오후 3 11 59](https://user-images.githubusercontent.com/60101005/111263710-a867e000-8669-11eb-87bf-4d00be93005d.png)
 * 글 제목을 클릭 할시 상세 화면으로 전환
![스크린샷 2021-03-16 오후 3 12 23](https://user-images.githubusercontent.com/60101005/111263712-a9990d00-8669-11eb-96fa-c3b4bac71e5f.png)
![스크린샷 2021-03-16 오후 3 12 29](https://user-images.githubusercontent.com/60101005/111263715-aaca3a00-8669-11eb-8ce1-95949753ef04.png)
![스크린샷 2021-03-16 오후 3 12 50](https://user-images.githubusercontent.com/60101005/111263720-abfb6700-8669-11eb-98fc-cda5f0fea49b.png)
![스크린샷 2021-03-16 오후 3 13 07](https://user-images.githubusercontent.com/60101005/111263725-ae5dc100-8669-11eb-927b-badc5a814113.png)
![스크린샷 2021-03-16 오후 3 13 14](https://user-images.githubusercontent.com/60101005/111263730-b0c01b00-8669-11eb-8809-45dd0d30cde0.png)
