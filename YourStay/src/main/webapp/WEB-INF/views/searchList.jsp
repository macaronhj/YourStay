<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YourTrip</title>
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
   color: red;
   overflow: hidden;
   height: auto;
}

.list-font {
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
</style>

<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"
   media="all" />
<link rel="stylesheet" href="../css/blog.css">
<link rel="stylesheet" href="../css/style.css">
<!-- 구글웹폰트 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
   href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap"
   rel="stylesheet">

</head>
<body>
   <header class="blog-header py-3" style="margin-bottom: 4%;">
      <div
         class="row flex-nowrap justify-content-between align-items-center">
         <div class="col-4 pt-1"></div>
         <div class="col-4 text-center">
            <a class="blog-header-logo text-dark" href="#"
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
            </a> <a class="btn btn-sm btn-outline-secondary" href="login/loginPage">Sign
               up</a>
         </div>
      </div>
   </header>
   <div class="sort">
   <div class="sort-in">
   <c:forEach items="${acvo}" var="acvo">
      <div class="list-font">
         <div
            class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative"
            style="width: 100%;">
            <div class="col p-4 d-flex flex-column position-static">
               <strong class="d-inline-block mb-2 text-primary">${acvo.aloc}</strong>
               <h3 class="mb-0 list-font">${acvo.aname}</h3>
               <p class="card-text mb-auto">
                  숙소 가격 : ${acvo.aprice}<br />숙소 타입 : ${acvo.atype}<br />최대 가능 인원 :
                  ${acvo.apeople}
               </p>

            </div>
            <div class="col-auto d-none d-lg-block">
               <svg class="bd-placeholder-img" width="200" height="250"
                  xmlns="http://www.w3.org/2000/svg" role="img"
                  aria-label="Placeholder: Thumbnail"
                  preserveAspectRatio="xMidYMid slice" focusable="false">
                  <title>Placeholder</title><rect width="100%" height="100%"
                     fill="#55595c"></rect>
                  <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

            </div>
         </div>
      </div>
   </c:forEach>
   </div>
   <div class="map-area">
      <div id="map" style="width: 680px; height: 580px;"></div>
      <script type="text/javascript"
         src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b87f2182c111fec7ca0b3a2aaede2356"></script>
      <script>
         var container = document.getElementById('map');
         var options = {
            center : new kakao.maps.LatLng(37.478890, 126.878650),
            level : 3
         };

         var map = new kakao.maps.Map(container, options);

         var data = [
               [ 37.478890, 126.878650,
                     '<div style="padding:5px">내용</div>' ],
               [ 37.47796194357405, 126.8805951377817,
                     '<div style="padding:5px">내용</div>' ],
               [ 37.481417597740965, 126.87617383635731,
                     '<div style="padding:5px">내용</div>' ]

         ]

         for (var i = 0; i < data.length; i++) {

            // 마커가 표시될 위치입니다 
            var markerPosition = new kakao.maps.LatLng(37.478890,
                  126.878650);

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
               position : markerPosition
            });

            // 마커가 지도 위에 표시되도록 설정합니다
            marker.setMap(map);

            var iwContent = '<div style="padding:5px;">숙소 이름<br><a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">카카오맵 길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
            iwPosition = new kakao.maps.LatLng(data[i][0], data[i][1]); //인포윈도우 표시 위치입니다

            // 인포윈도우를 생성합니다
            var infowindow = new kakao.maps.InfoWindow({
               position : iwPosition,
               content : data[i][2]
            });

            // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
            infowindow.open(map, marker);

         }
      </script>
   </div>
   </div>


   <!-- 푸터 -->
   <div class="container">
      <footer class="py-3 my-4">
         <ul class="nav justify-content-center border-bottom pb-3 mb-3">
            <li class="nav-item"><a href="#"
               class="nav-link px-2 text-muted">Home</a></li>
            <li class="nav-item"><a href="#"
               class="nav-link px-2 text-muted">Features</a></li>
            <li class="nav-item"><a href="#"
               class="nav-link px-2 text-muted">Pricing</a></li>
            <li class="nav-item"><a href="#"
               class="nav-link px-2 text-muted">FAQs</a></li>
            <li class="nav-item"><a href="#"
               class="nav-link px-2 text-muted">About</a></li>
         </ul>
         <p class="text-center text-muted">© 2021 Company, Inc</p>
      </footer>
   </div>

</body>
</html>