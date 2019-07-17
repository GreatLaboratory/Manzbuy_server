# Manzbuy_server
1. AWS EC2에서 우분투서버 인스턴스 생성
2. 리눅스 우분투서버에 tomcat8 + java8 + mysql 환경구축
3. AWS RDS에서 mysql로 데이터베이스 생성 후 EC2와 내부 VPC연결설정으로 연동
4. java, tomcat 환경변수 설정
5. mysql, ubuntu server 시간 및 인코딩 환경설정
6. freenom으로부터 ip주소와 도메인이름 연결
7. EC2 보안그룹 인바운드에서 포트설정 (+ tomcat 기본포트 80으로 변경)
8. java spring - mysql - webserver 연동
9. 관리자 로그인페이지 + 관리자회원 db구축
10. 관리자 로그인페이지 -> 업로드페이지 (세션구현)



- 패키지 구조

![image](https://user-images.githubusercontent.com/46255148/61382634-1e8dcf80-a8e8-11e9-8371-309ac64100d3.png)


- 로그인 화면

![image](https://user-images.githubusercontent.com/46255148/61382538-edad9a80-a8e7-11e9-8fc1-e1123e8980b0.png)


- 상품 등록 화면

![image](https://user-images.githubusercontent.com/46255148/61383301-5fd2af00-a8e9-11e9-886d-a64c55866ff7.png)


- 이미지정보 db등록 성공

![image](https://user-images.githubusercontent.com/46255148/61383456-b8a24780-a8e9-11e9-8d97-a772390b1001.png)


- 해당 url로 이미지 접근 성공

![image](https://user-images.githubusercontent.com/46255148/61383507-cfe13500-a8e9-11e9-86f4-90c0f99239b9.png)

