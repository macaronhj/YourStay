<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>YourTrip</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1"><!-- bootstrap-css -->
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<link rel="stylesheet" href="../css/airDnDCSS.css">

<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="../css/blog.css" type="text/css" media="all" />
<link rel="stylesheet" href="../css/navbar.css" type="text/css" media="all" />
</head>
<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
    </style>
  <body>
    
<div class="container">
  <header class="blog-header py-3" style="margin-bottom: 5%;">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <div class="col-4 pt-1">
      </div>
      <div class="col-4 text-center">
        <a class="blog-header-logo text-dark" href="#">YourTrip</a>
      </div>
      <div class="col-4 d-flex justify-content-end align-items-center">
        <a class="link-secondary" href="#" aria-label="Search">
          <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img" viewBox="0 0 24 24"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"/><path d="M21 21l-5.2-5.2"/></svg>
        </a>
        <a class="btn btn-sm btn-outline-secondary" href="login/loginPage">Sign up</a>
      </div>
    </div>
  </header>

<main class="container">
  <div class="row mb-2">
    <div class="col-md-6" style="width: 33%;">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">YourStay</strong>
          <h3 class="mb-0">Accomodation's Name</h3>
          <p class="card-text mb-auto">Please write your accomodation's name.</p>
        </div>
          <input class="form-control me-2" type="text" name="aname" size="60" placeholder="Room's Name" style="margin-bottom: 11%;">
      </div>
    </div>
	<div class="col-md-6" style="width: 33%;">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">YourStay</strong>
          <h3 class="mb-0">Accomodation's Location</h3>
          <p class="card-text mb-auto">Please write your accomodation's location.</p>
        </div>
          <input class="form-control me-2" type="text" name="aloc" size="60" placeholder="Room's Location" style="margin-bottom: 11%;">
      </div>
  </div>
  <div class="col-md-6" style="width: 33%;">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">YourStay</strong>
          <h3 class="mb-0">Accomodation's Price</h3>
          <p class="card-text mb-auto">Please write your accomodation's price.</p>
        </div>
          <input class="form-control me-2" type="text" name="aprice" size="60" placeholder="Room's Price" style="margin-bottom: 11%;">
      </div>
  </div>
  <div class="col-md-6" style="width: 33%;">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">YourStay</strong>
          <h3 class="mb-0">Accomodation Name</h3>
          <p class="card-text mb-auto">Please select your accomodation type.</p>
        </div>
		<div id="personnelDiv" style="width: 400px!important; height: 81px!important; margin-top: 0px!important;margin-bottom: 11%;">
        <p class="searchFont">Room Type</p>
           <select id="personnel" name="atype">
              <option value=1>집전체</option>
              <option value=2>개인실</option>
              <option value=3>호텔객실</option>
              <option value=4>다인실</option>
           </select>
        </div>
      </div>
  </div>
  <div class="col-md-6" style="width: 33%;">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">YourStay</strong>
          <h3 class="mb-0">Maximum Capacity</h3>
          <p class="card-text mb-auto">Please select accomodation's maximum capacity.</p>
        </div>
		<div id="personnelDiv" style="width: 400px!important; height: 81px!important; margin-top: 0px!important;margin-bottom: 11%;">
        <p class="searchFont">Maximum Capacity</p>
           <select id="personnel" name="apeople">
              <option value=1>인원 1명</option>
              <option value=2>인원 2명</option>
              <option value=3>인원 3명</option>
              <option value=4>인원 4명</option>
              <option value=5>인원 5명</option>
              <option value=6>인원 6명</option>
           </select>
        </div>
      </div>
  </div>
  <div class="col-md-6" style="width: 33%;">
      <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
        <div class="col p-4 d-flex flex-column position-static">
          <strong class="d-inline-block mb-2 text-primary">YourStay</strong>
          <h3 class="mb-0">Accomodation's Image</h3>
          <p class="card-text mb-auto">Please add your accomodation's Image.</p>
        </div>
        <input class="form-control me-2" type='file' name='file' size="60" placeholder="Room's Location" style="margin-bottom: 11%;">
      </div>
  </div>
  
</main>
<footer class="blog-footer">
  <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
  <p>
    <a href="#">Back to top</a>
  </p>
</footer>
    
  </body>
</html>