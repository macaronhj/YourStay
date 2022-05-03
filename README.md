YourStay
=============

* port: 8080 
* 웹: http://localhost:8080/

## Technologies
### Front-End
* JSP
* HTML
* CSS
* JavaScript
* BootStrap
* JQuery
* Ajax
### Back-End
* Java 1.8
* lombok
* Spring Framework
### DataBase
* Oracle Database

## 기능별 Http 주소
    1. GET
      - Welcome Page 이동 (http://localhost:8080/)
      - 검색 조건에 따른 결과 조회 페이지 이동 (/searchInListFromMainGet.do?aloc=aloc)
      - 선택한 숙소의 상세 정보 조회 가능한 페이지 이동 (/roomDetailInfo?aid=aid&rstart=rstart&rend=rend) 
      - 자세한 예약 정보 페이지 이동 (/res/reservdetail)
      - 데이터 전체 조회 (/checkList/list)
      - MY PAGE 이동 (/mypage/home)
      - 찜 목록 페이지 이동 (/mypage/wishlist/{mseq})
      - 내가 예약한 숙소 목록 조회 페이지 이동(/mypage/roomReservation?mseq=mseq)
      - 리뷰 페이지 이동 (/mypage/review?aid=5&mseq=mseq)
      - 숙소 등록 페이지 이동 (/mypage/roomRegister?mseq=mseq)
      - 내가 등록한 숙소 조회 페이지 이동 (/mypage/myRoom?mseq=mseq)
      - 내가 등록한 숙소 수정 페이지 이동 (/mypage/modifyRoom?aid=aid&mseq=mseq)
      - 내가 등록한 숙소를 예약한 사람 조회 페이지 이동 (/mypage/goReservationList?mseq=mseq)
      
     2. POST
      - ToDoList 등록 수행 (/checkList/register)
      - ToDoList 삭제 수행 (/checkList/delete) 
      - ToDoList 수정 수행 (/checkList/update)
[![Anurag's GitHub stats](https://github-readme-stats.vercel.app/api?username=macaronhj)](https://github.com/anuraghazra/github-readme-stats)
