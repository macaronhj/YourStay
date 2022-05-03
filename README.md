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
      - 로그인 페이지 이동 (/login/loginPage) 
      - 회원가입 페이지 이동 (/login/joinPage)
      - 로그아웃 (/login/logout.do)
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
      - 공지사항 리스트 페이지 이동 (/board/list.do?cp=cp)
      - 공지사항 상세 페이지 이동 (/board/content?boardnum=boardnum)
      - 회원 정보 수정 페이지 이동 (/mypage/updateUser?memail=memail)
      
     2. POST
      - 로그인 수행 (/login/loginCheck.do) 
      - 회원가입 수행 (/login/join.do)
      - 숙소 등록 수행 (/mypage/register.do)
      - 숙소 정보 수정 수행 (/mypage/modifyRoom)
      - 숙소 삭제 수행 (/mypage/delete)
      - 회원 정보 수정 수행 (/mypage/updateUser.do)
      - 회원 탈퇴 수행 (/mypage/removeUser.do)
      - 찜 목록 추가 수행 (/mypage/wishlist/addwish) 
      - 예약 테이블 정보 확인 후 예약 완료/반려 처리 (/res/reservation.do)
      - 예약 요청 세부 정보 확인 처리 (/res/reservdetail)
      - 호스트 예약 수락 처리 (/res/hostUpdate)
      - 게스트 예약 수락 처리(/res/guestUpdate)
      - 리뷰 등록 처리 (/review/registerReview)
[![Anurag's GitHub stats](https://github-readme-stats.vercel.app/api?username=macaronhj)](https://github.com/anuraghazra/github-readme-stats)
