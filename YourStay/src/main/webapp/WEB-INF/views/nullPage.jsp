   <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YourStay</title>
<style>
div.search-info {
   width: 1518px;
   height: 600px;
}

div.list {
   width: 54%;
   float: left;
   box-sizing: border-box;
   text-align: left;
   margin-left: 0.5%;
}

div.map-area {
   width: 40%;
   float: right;
   box-sizing: border-box;
}

div.list-font {
   overflow: hidden;
   height: auto;
}

body {
   font-family: 'Poor Story', cursive;
}

.sort{
   display: flex;
   flex-direction: row;
   justify-content: space-around;
}

.sort-in{
   width: 35%
}
.wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
.wrap * {padding: 0;margin: 0;}
.wrap .info {width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
.wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
.info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
.info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
.info .close:hover {cursor: pointer;}
.info .body {position: relative;overflow: hidden;}
.info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
.desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
.desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
.info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
.info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
.info .link {color: #5085BB;}
</style>

<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"
   media="all" />
<link rel="stylesheet" href="../css/blog.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/airDnDCSS.css">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/reset.css">
<script src="///js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
   href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!-- 구글웹폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
   href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap"
   rel="stylesheet">
<script>
   $(document)
       .ready(
             function() {
                var checkShow = false;
                $("#searchSubmitBtn")
                      .click(
                            function() {
                               //alert($("#city").val() + " , " + $("#datepicker1").val() + " ~ " + $("#datepicker2").val() +" , "+$("#personnel option:selected").val());
                               if ($("#aloc").val() == "모든 위치"
                                     || $("#aloc").val() == "") {
                                  alert("위치를 입력해 주세요.");
                               } else if ($("#datepicker1").val() == "모든 날짜"
                                     || $("#datepicker1").val() == "") {
                                  alert("출발 날짜를 입력해 주세요.");
                               } else if ($("#datepicker2").val() == "모든 날짜"
                                     || $("#datepicker2").val() == "") {
                                  alert("도착 날짜를 입력해 주세요.");
                               } else {
                                  location.href = "searchInListFromMainGet.do?aloc="
                                        + $("#aloc").val()
                                        + "&startdate="
                                        + $("#datepicker1")
                                              .val()
                                        + "&deadline="
                                        + $("#datepicker2")
                                              .val()
                                        + "&person="
                                        + $("#personnel").val();
                               }
                            });
                $("#datepicker1").datepicker({
                   dateFormat : 'yy-mm-dd'
                });
                $("#datepicker2").datepicker({
                   dateFormat : 'yy-mm-dd'
                });
                $("#rollDown").hide();
                $("#tempImg").click(function() {
                   if (checkShow == false) {
                      $("#rollDown").show();
                      checkShow = true;
                   } else {
                      $("#rollDown").hide();
                      checkShow = false;
                   }
                });
                $("#logo").click(function() {
                   window.location = "index.jsp";
                });
                
                $("#aloc").val("${city}");
                $("#datepicker1").val("${startDate}");
                $("#datepicker2").val("${endDate}");
                $("#personnel").val("${person}").prop("selected", true); 
                
                var city1 = $("#aloc").val();
                var startDate1 = $("#datepicker1").val();
                var endDate1 = $("#datepicker2").val();
                var person1 = $("#personnel").val();

                var jData1 = {
                   "city" : city1,
                   "startDate" : startDate1,
                   "endDate" : endDate1,
                   "person" : person1
                };
                
              $("#godetail").on("keydown", function(){
                 $.ajax({
                    url: "roomDetailInfo", 
                    type: "GET", 
                    data : jData1,
                    dataType : 'json',
                    success: function(data){
                       result = data;
                            $.each(data, function(idx, item) {
                               if(data==null){
                                  $("<b>예약 가능한 숙소가 없습니다.</b>").appendTo("#contentInput");

                               }else{
                                  $("<div class='item'><div class='itemPic'><a href='searchDetail.do?aid=" + item.aid + "'></div><div class='itemCost'><h5>" + item.aprice + "원</h5></div><div class='itemTitle'><h5>" + item.aname + "</h5></div><div class='itemRecommandPoint'></div></div>")
                                  .appendTo("#contentInput");

                               }
                               
                            });
                            $('#hiddenCity').val(city1);
                            $('#hiddenStartDate').val(startDate1);
                            $('#hiddenEndDate').val(endDate1);
                            $('#hiddenPerson').val(person1);
                    }
                 });
              });
             });
</script>
<%
   String memail = (String) session.getAttribute("memail");
%>
</head>
<body>
   <header class="blog-header py-3" style="margin-bottom: 4%;">
      <div
         class="row flex-nowrap justify-content-between align-items-center">
         <div class="col-4 pt-1"></div>
         <div class="col-4 text-center">
            <a class="blog-header-logo text-dark" href="/"
               style="text-decoration: none">YourStay</a>
         </div>
         <div class="col-4 d-flex justify-content-end align-items-center">
            <c:choose>
         <c:when test="${msg =='failure'}">
        <a class="btn btn-secondary" href="../login/loginPage" style="background-color: #2AC1BC!important;border-color: #2AC1BC!important;">Sign up</a>
        </c:when> 
         <c:when test="${msg == null}"> <!-- 로그인X -->
         
         <% 
            if(memail == null){
         %>
           <a class="btn btn-secondary" href="../login/loginPage" style="background-color: #2AC1BC!important;border-color: #2AC1BC!important;">Sign up</a>
          <%
            }else{
         %>
         <a href="/mypage/home" style="margin-top: 3%; margin-right: 3%;"><%=memail %>님 반갑습니다!</a>
         <a href="../login/logout.do" class="btn btn-secondary" style="background-color: #2AC1BC!important;border-color: #2AC1BC!important;">로그아웃</a>
         <%} %>
         </c:when> 
         <c:otherwise>
         <a href="/mypage/home" style="margin-top: 3%; margin-right: 3%;font-size: 130%;"><%=memail %>님 반갑습니다!</a>
         <a href="../login/logout.do" class="btn btn-secondary" style="background-color: #2AC1BC!important;border-color: #2AC1BC!important;">로그아웃</a>
         </c:otherwise>
         </c:choose>
         </div>
      </div>
   </header>
   <main class="container" style="min-height : 900px">

         <form id="seatrchForm">
            <div id="search" class="radius">
               <p id="indexH1">YourStay 숙소 찾기</p>
               <div id="cityDiv">
                  <p class="searchFont">위치</p>
                  <input type="text" id="aloc" name="aloc" placeholder="지역명을 입력해주세요." style="width: 60%;height: 50%;border: none;">
               </div>
               <div id="datepickerDiv" />
               <div class='col-md-3 col-xs-4'>
                  <div class="form-group">
                     <div class="input-group date" id="datetimepicker1"
                        data-target-input="nearest">
                        <input type="text" id="datepicker1" name="startdate"
                           placeholder="날짜를 선택해주세요." style="margin-left: 7px!important;">
                        <div class="input-group-append" data-target="#datetimepicker1"
                           data-toggle="datetimepicker">
                           <div class="input-group-text">
                              <i class="fa fa-calendar"></i>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class='col-md-3 col-xs-4'>
                  <div class="form-group">
                     <div class="input-group date" id="datetimepicker2"
                        data-target-input="nearest">
                        <input type="text" id="datepicker2" name="deadline"
                          placeholder="날짜를 선택해주세요."  style="margin-left: 7px!important;">
                        <div class="input-group-append" data-target="#datetimepicker2"
                           data-toggle="datetimepicker">
                           <div class="input-group-text">
                              <i class="fa fa-calendar"></i>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div id="personnelDiv">
               <p class="searchFont">인원</p>
               <select id="personnel" name="person">
                  <option value=1>인원 1명</option>
                  <option value=2>인원 2명</option>
                  <option value=3>인원 3명</option>
                  <option value=4>인원 4명</option>
                  <option value=5>인원 5명</option>
                  <option value=6>인원 6명</option>
               </select>
            </div>
            <input type="button" id="searchSubmitBtn" value="검색"
               style="cursor: pointer;">
      </div>
      </form>
               <div class="row row-cols-md-3 g-3">
            <div style="margin-left: 25%;margin-top: 5%;" >
                  <p></hr><h2 style="width:1500px">검색 결과가 없습니다. 뒤로 가시려면 아래 버튼을 눌러주세요.</h2></p>
                  <button style="width: 500px; margin-left: 15%;background-color: #2AC1BC!important;border-color: #2AC1BC!important;" class="btn btn-secondary" type="button" onClick="history.go(-1)">뒤로 가기</button>
                  <div class="d-flex justify-content-between align-items-center">
                  </div>
            </div>
         </div>
</main>

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
         <p class="text-center text-muted">© 2022 Company, Inc</p>
      </footer>
   </div>

</body>
</html>