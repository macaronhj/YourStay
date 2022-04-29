<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html>
<title>YourStay</title>
<head>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<link href="/css/index.css" rel="stylesheet">
<!-- 구글웹폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
   href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap"
   rel="stylesheet">
<meta charset="utf-8" />
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<!-- 모달 -->
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<script src="/js/bootstrap.min.js"></script>

<!-- DataTimePicker template -->
<script type="text/javascript"
   src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
   src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script type="text/javascript"
   src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css" />
<link rel="stylesheet"
   href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" />
<!-- 인원수 -->
<link rel="stylesheet" href="../css/airDnDCSS.css">
<!-- sockJS -->
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<%
   String memail = (String) session.getAttribute("memail");
   long mseq = (long) session.getAttribute("mseq");
%>
<style>
body{
     margin-bottom:60px;
     font-family: 'Poor Story', cursive!important;
     font-size: 20px;
        }
</style>
<script type="text/javascript">
   $(document).ready(function() {
      $('#notifySendBtn').click(function(e) {
         let target = $("#mseq").val;
         let url = '${contextPath}/notify.do';
         // 전송한 정보를 db에 저장   
         $.ajax({
            type : 'post',
            url : '${contextPath}/notify.do',
            dataType : 'text',
            data : {
               target : target,
               content : content
            },
            success : function() { // db전송 성공시 실시간 알림 전송
               // 소켓에 전달되는 메시지
               // 위에 기술한 EchoHandler에서 ,(comma)를 이용하여 분리시킨다.
               //socket.send("관리자,"+target+","+content+","+url);   
               socket.send(target + "," + content);
            }
         });
      });
   });
</script>
</head>
<body>
   <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous">
      
   </script>
   <header class="blog-header py-3" style="margin-bottom: 5%;">
      <div
         class="row flex-nowrap justify-content-between align-items-center">
         <div class="col-4 pt-1"></div>
         <div class="col-4 text-center">
            <a class="blog-header-logo text-dark" href="/"
               style="text-decoration: none">YourTrip</a>
         </div>
         <div class="col-4 d-flex justify-content-end align-items-center">
            <a class="link-secondary" href="#" aria-label="Search"> <svg
                  xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                  fill="none" stroke="currentColor" stroke-linecap="round"
                  stroke-linejoin="round" stroke-width="2" class="mx-3" role="img"
                  viewBox="0 0 24 24">
                  <title>Search</title><circle cx="10.5" cy="10.5" r="7.5" />
                  <path d="M21 21l-5.2-5.2" /></svg>
            </a>
            <c:choose>
               <c:when test="${msg =='failure'}">
                  <a class="btn btn-secondary" href="../login/loginPage"
                     style="background-color: #2AC1BC !important; border-color: #2AC1BC !important;">Sign
                     up</a>
               </c:when>
               <c:when test="${msg == null}">
                  <!-- 로그인X -->

                  <%
                     if (memail == null) {
                  %>
                  <a class="btn btn-secondary" href="../login/loginPage"
                     style="background-color: #2AC1BC !important; border-color: #2AC1BC !important;">Sign
                     up</a>
                  <%
                     } else {
                  %>
                  <a href="/mypage/home" style="margin-top: 3%; margin-right: 3%;"><%=memail%>님
                     반갑습니다! </a>
                  <a href="../login/logout.do" class="btn btn-secondary"
                     style="background-color: #2AC1BC !important; border-color: #2AC1BC !important;">로그아웃</a>
                  <%
                     }
                  %>
               </c:when>
               <c:otherwise>
                  <a href="/mypage/home" style="margin-top: 3%; margin-right: 3%;"><%=memail%>님
                     반갑습니다! </a>
                  <a href="../login/logout.do" class="btn btn-secondary"
                     style="background-color: #2AC1BC !important; border-color: #2AC1BC !important;">로그아웃</a>
               </c:otherwise>
            </c:choose>
         </div>
      </div>
   </header>
   <form action="/res/reservation.do" method="post">
      <input type="hidden" value="${rdetail.aid}" name="aid"> 
      <input type="hidden" value="<%=mseq%>" name="mseq" id="mseq"> 
      <input type="hidden" value="${rdetail.apeople}" name="rpeople"> 
      <input type="hidden" value="${rdetail.rstart}" name="rstart"> 
      <input type="hidden" value="${rdetail.rend}" name="rend"> 
      <input type="hidden" value="${rdetail.aprice}" name="rprice">
      <div class="container px-4 px-lg-5">
         <!-- Heading Row-->
         <div class="row gx-4 gx-lg-5 align-items-center my-5 ">
            <div class="col-lg-5">
               <img class="img-fluid rounded mb-4 mb-lg-0"
                  src="../../../resources/images/roomImg/${rdetail.aid}/${rdetail.ipath1}"
                  alt="..." />
            </div>
            <div class="col-lg-7">
               <h6 class="font-weight-light">${rdetail.aname}</h6>
               </br>
               <h3>${rdetail.anotice}</h3>
               </br>
            </div>
         </div>
         <!-- content-->
         <div class="card text-white bg-secondary my-2 py-2 h-70" style="width:49%; float: left;">
            <div class="card-header">
               <p class="text-white m-0 text-center">예약 정보</p>
            </div>
            <div class="card-body">
               <p class="text-white m-0">1. 날짜</br> -> ${rdetail.rstart} ~ ${rdetail.rend}</p>
               </br>
               <p class="text-white m-0">2. 지역</br> -> ${rdetail.aloc}</p>
               </br>
               <p class="text-white m-0">3. 주소</br> -> ${rdetail.amap}</p>
               </br>
               <p class="text-white m-0">4. 인원수</br> -> ${rdetail.apeople}명</p>
            </div>
         </div>
         
         <div class="card text-white bg-secondary my-2 py-2 h-70 "style="width:49%; float: right;">
            <div class="card-header">
               <p class="text-white m-0 text-center">가격 정보</p>
            </div>
            <div class="card-body" style="margin-bottom: 0.7rem;">
               <p class="text-white m-0">*요금 세부정보*</p>
               </br>
               <p class="text-white">1. 1박 당 가격</br> -> ${rdetail.aprice}</p>
               <p class="text-white">2. 숙박 일 수</br> -> ${rdetail.days}일 </p>
               <p class="text-white">3. 합계</br> -> ${rdetail.resultprice}원</p>
				<br/>
            </div>
         </div>
         <div class="card text-white bg-secondary my-2 py-2 h-70 " style="display: inline-flex;width: 100%;">
            <div class="card-header">
               <p class="text-white m-0 text-center">환불 정책</p>
            </div>
            <div class="card-body">
               <p class="text-white m-3">날짜 전까지 무료 취소가 가능합니다. 날짜 체크인 전에 취소하면
                  부분 환불을 받으실 수 있습니다.</p>
               <button type="button" class="btn text-white move-left"
                     data-bs-toggle="modal" data-bs-target="#refund">자세히 알아보기</button>
               <p class="text-white m-3">코로나19로 인한 여행 문제에는 정상참작이 가능한 상황 정책이 적용
                  되지 않습니다.</p>
              <button type="button" class="btn text-white move-left"
                     data-bs-toggle="modal" data-bs-target="#norefund">자세히 알아보기</button>
            </div>
         </div>
         <div class="card text-white bg-secondary my-2 py-2 h-70 ">
            <div class="card-body">
               <p class="text-white m-3">아래 버튼을 선택함으로써, 호스트가 설정한 숙소 이용규칙,
                  에어비앤비 코로나19 방역 수칙 및 게스트 환불 정책에 동의합니다.</p>
               <div class="d-grid gap-2">
                  <button id="notifySendBtn" class="btn btn-warning text-white"
                     type="submit">예약 완료하기</button>
               </div>
            </div>
         </div>
   </form>

   <!-- Modal -->
   <div class="modal fade" id="refund" tabindex="-1"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">환불 정책</h5>
               <button type="button" class="btn-close" data-bs-dismiss="modal"
                  aria-label="Close"></button>
            </div>
            <div class="modal-body">
			<p>1. 게스트는 체크인 24시간 전까지 예약을 취소할 경우 전액 환불받을 수 있으며, 호스트에게는 대금이 지급되지 않습니다.
			</br>2. 그 후에 취소하는 경우, 이미 숙박한 일수와 하루치의 숙박비 전액이 호스트에게 지급됩니다.
			</br>3. 게스트가 체크인 5일 전까지 예약을 취소한다면 전액 환불받을 수 있으며, 호스트에게는 대금이 지급되지 않습니다.
			</br>4. 그 후에 취소하는 경우, 이미 숙박한 일수와 하루치의 숙박비 전액 및 남은 숙박 일수에 대한 숙박비 50%가 호스트에게 지급됩니다.
			</br>5. 게스트는 체크인까지 30일 이상 남은 시점에 취소해야 전액 환불을 받을 수 있습니다.
			</br>6. 체크인까지 7~30일이 남은 시점에 예약을 취소하면, 숙박비 50%가 호스트에게 지급됩니다.
			</br>7. 체크인까지 7일이 채 남지 않은 시점에 예약을 취소하면, 숙박비 전액이 호스트에게 지급됩니다.
			</br>8. 또한 체크인까지 30일이 남지 않은 시점에 예약한 게스트가 예약 후 48시간 이내에 취소하는 경우, 체크인까지 14일 이상 남았다면 전액 환불받을 수 있습니다.</p>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-bs-dismiss="modal">닫기</button>

            </div>
         </div>
      </div>
   </div>
      <!-- Modal -->
   <div class="modal fade" id="norefund" tabindex="-1"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">정상 참작 가능 상황</h5>
               <button type="button" class="btn-close" data-bs-dismiss="modal"
                  aria-label="Close"></button>
            </div>
            <div class="modal-body">
			<p>1. <bold>정부의 여행 제한 조치 변경.</bold> 정부 기관이 비자나 여권 발행 요건을 예기치 않게 변경하여 목적지로의 여행이 불가능한 경우. 여권의 분실이나 만료, 그 밖에 게스트의 개인적 사정으로 여행 허가 관련 문제가 발생한 경우는 해당하지 않습니다.
			</br>2.<bold> 긴급 상황 및 전염병 유행 선포.</bold> 정부가 선포한 지역/국가 차원의 긴급 상황, 전염병의 지역/전 세계 유행, 공중보건 긴급 상황. 태국의 말라리아나 하와이의 뎅기열과 같이 특정 지역과 일반적으로 연관된 풍토병은 해당되지 않습니다.
			</br>3.<bold> 정부의 여행 제한 조치.</bold> 숙소/체험 지역을 오가거나 해당 지역에서 체류하는 것을 금지하는 정부 기관의 여행 제한 조치. 구속력이 없는 여행 경보나 이와 유사한 정부 지침은 해당하지 않습니다.
			</br>4. <bold>군사 행동 및 기타 적대 행위.</bold> 전쟁, 적대 행위, 침략, 내전, 테러, 폭발, 폭격, 반란, 폭동, 봉기, 시민 소요 및 무질서 등.
			</br>5. <bold>자연재해.</bold> 자연재해, 천재지변, 필수 공공기반 서비스(수도, 전기 등)의 대규모 공급 중단, 화산 폭발, 쓰나미, 기타 심각하고 비정상적인 기상 여건. 해당 지역에서 흔히 발생하여 예상 가능한 기상 또는 자연 여건(예: 플로리다의 허리케인철에 발생하는 허리케인)은 여기에 해당하지 않습니다.</p>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-bs-dismiss="modal">닫기</button>

            </div>
         </div>
      </div>
   </div>
   <!-- Modal -->
   <div class="modal fade" id="myModal1" tabindex="-1"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">자세히 알아보기</h5>
               <button type="button" class="btn-close" data-bs-dismiss="modal"
                  aria-label="Close"></button>
            </div>
            <div class="modal-body">환불정책 알아보기1</div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-bs-dismiss="modal">Close</button>
               <button type="button" class="btn btn-primary">Save changes</button>
            </div>
         </div>
      </div>
   </div>
   <!-- Modal -->
   <div class="modal fade" id="myModal2" tabindex="-1"
      aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">자세히 알아보기</h5>
               <button type="button" class="btn-close" data-bs-dismiss="modal"
                  aria-label="Close"></button>
            </div>
            <div class="modal-body">환불 정책알아보기2</div>
            <div class="modal-footer">
               <button type="button" class="btn btn-secondary"
                  data-bs-dismiss="modal">Close</button>
               <button type="button" class="btn btn-primary">Save changes</button>
            </div>
         </div>
      </div>
   </div>


   <!-- 푸터 -->
   <div class="container">
      <footer class="py-3 my-4">
         <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="/"
               class="nav-link px-2 text-muted">Home</a></li>
            <li class="nav-item"><a href="/mypage/home"
               class="nav-link px-2 text-muted">MyPage</a></li>
            <li class="nav-item"><a href="/board/list"
               class="nav-link px-2 text-muted">FAQs</a></li>
            <li class="nav-item"><a href="/Projectreview"
               class="nav-link px-2 text-muted">About</a></li>
         </ul>
         <p class="text-center text-muted">© 2021 Company, Inc</p>
      </footer>
   </div>
</body>
</html>