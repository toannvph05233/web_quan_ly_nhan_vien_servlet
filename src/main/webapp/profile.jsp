<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 05/11/2023
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">

    <!-- theme meta -->
    <meta name="theme-name" content="quixlab"/>

    <title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
    <!-- Pignose Calender -->
    <link href="./plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
    <!-- Chartist -->
    <link rel="stylesheet" href="./plugins/chartist/css/chartist.min.css">
    <link rel="stylesheet" href="./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
    <!-- Custom Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <style>
        .emp-profile {
            padding: 3%;
            margin-top: 3%;
            margin-bottom: 3%;
            border-radius: 0.5rem;
            background: #fff;
        }

        .profile-img {
            text-align: center;
        }

        .profile-img img {
            width: 70%;
            height: 100%;
        }

        .profile-img .file {
            position: relative;
            overflow: hidden;
            margin-top: -20%;
            width: 70%;
            border: none;
            border-radius: 0;
            font-size: 15px;
            background: #212529b8;
        }

        .profile-img .file input {
            position: absolute;
            opacity: 0;
            right: 0;
            top: 0;
        }

        .profile-head h5 {
            color: #333;
        }

        .profile-head h6 {
            color: #0062cc;
        }

        .profile-edit-btn {
            border: none;
            border-radius: 1.5rem;
            width: 70%;
            padding: 2%;
            font-weight: 600;
            color: #6c757d;
            cursor: pointer;
        }

        .proile-rating {
            font-size: 12px;
            color: #818182;
            margin-top: 5%;
        }

        .proile-rating span {
            color: #495057;
            font-size: 15px;
            font-weight: 600;
        }

        .profile-head .nav-tabs {
            margin-bottom: 5%;
        }

        .profile-head .nav-tabs .nav-link {
            font-weight: 600;
            border: none;
        }

        .profile-head .nav-tabs .nav-link.active {
            border: none;
            border-bottom: 2px solid #0062cc;
        }

        .profile-work {
            padding: 14%;
            margin-top: -15%;
        }

        .profile-work p {
            font-size: 12px;
            color: #818182;
            font-weight: 600;
            margin-top: 10%;
        }

        .profile-work a {
            text-decoration: none;
            color: #495057;
            font-weight: 600;
            font-size: 14px;
        }

        .profile-work ul {
            list-style: none;
        }

        .profile-tab label {
            font-weight: 600;
        }

        .profile-tab p {
            font-weight: 600;
            color: #0062cc;
        }
    </style>

</head>

<body>

<!--*******************
    Preloader start
********************-->
<div id="preloader">
    <div class="loader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10"/>
        </svg>
    </div>
</div>
<!--*******************
    Preloader end
********************-->


<!--**********************************
    Main wrapper start
***********************************-->
<div id="main-wrapper">

    <div class="nav-header">
        <div class="brand-logo">
            <a href="/nhanvien">
                <b class="logo-abbr"><img src="images/logo.png" alt=""> </b>
                <span class="logo-compact"><img
                        src="https://seeklogo.com/images/A/as-roma-logo-61DF23CC37-seeklogo.com.png" alt=""></span>
                <span class="brand-title">
                        <img style="width: 150px; height: 90px; object-fit: cover; margin-top: -30px" src="https://seeklogo.com/images/A/as-roma-logo-61DF23CC37-seeklogo.com.png"  alt="">
                    </span>
            </a>
        </div>
    </div>

    <div class="header">
        <div class="header-content clearfix">

            <div class="nav-control">
                <div class="hamburger">
                    <span class="toggle-icon"><i class="icon-menu"></i></span>
                </div>
            </div>
            <div class="header-left">
                <div class="input-group icons">
                    <div class="input-group-prepend">
                        <span class="input-group-text bg-transparent border-0 pr-2 pr-sm-3" id="basic-addon1"><i
                                class="mdi mdi-magnify"></i></span>
                    </div>
                    <form action="/nhanvien" class="row" method="post">
                        <input name="search" type="search" class="form-control col-8" placeholder="Search Dashboard"
                               aria-label="Search Dashboard">
                        <button class="btn-primary col-4" type="submit">Search</button>
                    </form>
                </div>
            </div>
            <div class="header-right">
                <ul class="clearfix">
                    <li class="icons dropdown d-none d-md-flex">
                        <a href="javascript:void(0)" class="log-user" data-toggle="dropdown">
                            <span>${sessionScope.account.username}</span> <i class="fa fa-angle-down f-s-14"
                                                                             aria-hidden="true"></i>
                        </a>
                    </li>
                    <li class="icons dropdown">
                        <div class="user-img c-pointer position-relative" data-toggle="dropdown">
                            <span class="activity active"></span>
                            <img src="${sessionScope.account.avatar}" height="40" width="40" alt="">
                        </div>
                        <div class="drop-down dropdown-profile animated fadeIn dropdown-menu">
                            <div class="dropdown-content-body">
                                <ul>
                                    <li>
                                        <a href="app-profile.html"><i class="icon-user"></i> <span>Profile</span></a>
                                    </li>
                                    <li>
                                        <a href="javascript:void(0)">
                                            <i class="icon-envelope-open"></i> <span>Inbox</span>
                                            <div class="badge gradient-3 badge-pill gradient-1">3</div>
                                        </a>
                                    </li>

                                    <hr class="my-2">
                                    <li>
                                        <a href="page-lock.html"><i class="icon-lock"></i> <span>Lock Screen</span></a>
                                    </li>
                                    <li><a href="page-login.html"><i class="icon-key"></i> <span>Logout</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="nk-sidebar">
        <div class="nk-nav-scroll">
            <ul class="metismenu" id="menu">
                <li class="nav-label">Dashboard</li>
                <li>
                    <a class="has-arrow" href="javascript:void(0)" aria-expanded="false">
                        <i class="icon-user menu-icon"></i><span class="nav-text">Nhân viên</span>
                    </a>
                    <ul aria-expanded="false">
                        <li><a href="/nhanvien">Tất cả</a></li>
                        <li><a href="/nhanvien?contract=false">Biên chế</a></li>
                        <li><a href="/nhanvien?contract=true">Hợp đồng</a></li>
                    </ul>
                </li>
                <li>
                    <br>
                    <a style="width: 80%; margin-left: 20px;" href="/createStaff" type="button" class="btn btn-success">Create Staff</a>
                </li>


            </ul>
        </div>
    </div>

    <div class="content-body">

        <div class="container emp-profile">

            <div class="row">
                <div class="col-md-4">
                    <div class="profile-img">
                        <img src="${nhanVien.getAvatar()}" alt="" class="fixed-size-img" style="width: 250px; height: 200px; object-fit: cover; " />
                        <div class="file btn btn-lg btn-primary">
                            Change Photo
                            <input type="file" name="file" />
                        </div>
                    </div>

                </div>
                <div class="col-md-6">
                    <div class="profile-head">
                        <h4>
                            <c:out value="${nhanVien.getFullName()}"/>
                        </h4>
                        <c:forEach var="job" items="${jobs}">
                            <h5 style="color: #00cc66">Job Now : ${job.getJobDescription()}</h5>
                        </c:forEach>
                        <h5>
                            <c:out value="${nhanVien.getJobTitle()}"/>
                        </h5>

                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab"
                                   aria-controls="home" aria-selected="true">About</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <%--                <div class="col-md-2">--%>
                <%--                    <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>--%>
                <%--                </div>--%>
            </div>
            <div class="row">
                <div class="col-md-4">

                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Employee ID</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getEmployeeID()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Full Name</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getFullName()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Date of Birth</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getDateOfBirth()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Gender</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getGender()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>ID Card Number</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getIDCardNumber()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Educational Background</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getEducationalBackground()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Language Skills</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getLanguageSkills()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Permanent Residence</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getPermanentResidence()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Address</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getAddress()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Ethnicity</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getEthnicity()}"/></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="border-left: 1px solid #000; padding-left: 50px" class="col-md-6">
                    <div id="profile">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Religion</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getReligion()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Date Join Youth Union</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getDateJoinYouthUnion()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Date Join Party</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getDateJoinParty()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Parents</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getParents()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Siblings</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getSiblings()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Marital Status</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getMaritalStatus()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Children</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getChildren()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Policy Category</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getPolicyCategory()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Department</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getDepartment()}"/></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Job Title</label>
                            </div>
                            <div class="col-md-6">
                                <p style="color: #0e4cfd"><c:out value="${nhanVien.getJobTitle()}"/></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <hr>
            <div>
                <h3>Lộ trình nghề nghiệp</h3>
                <c:forEach var="work" items="${workHistory}">
                    <div class="card mt-5 border-5 pt-2 active pb-0 px-3">
                        <div class="card-body" style="background: rgba(196,216,193,0.79)">
                            <div class="row">
                                <div class="col-12 ">
                                    <h4 class="card-title "><b>${work.getJobDescription()}</b></h4>

                                </div>
                                <div class="col">
                                    <h6 class="card-subtitle mb-2 text-muted">
                                        <p class="card-text text-muted small ">
                                            <img src="https://img.icons8.com/metro/26/000000/star.png" class="mr-1 "
                                                 width="19"
                                                 height="19" id="star"> <span class="vl mr-2 ml-0"></span>
                                            <span>StartDate : <strong>${work.getStartDate()}</strong></span>
                                            <br>
                                            <span>EndDate : <strong>${work.getEndDate()}</strong></span>
                                        </p>
                                    </h6>
                                </div>
                            </div>

                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
        <!-- #/ container -->
    </div>

    <!--**********************************
        Footer start
    ***********************************-->
    <div class="footer">
        <div class="copyright">
            <p>Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018
            </p>
        </div>
    </div>
    <!--**********************************
        Footer end
    ***********************************-->
</div>
<!--**********************************
    Main wrapper end
***********************************-->

<!--**********************************
    Scripts
***********************************-->
<script src="plugins/common/common.min.js"></script>
<script src="js/custom.min.js"></script>
<script src="js/settings.js"></script>
<script src="js/gleek.js"></script>
<script src="js/styleSwitcher.js"></script>

<!-- Chartjs -->
<script src="./plugins/chart.js/Chart.bundle.min.js"></script>
<!-- Circle progress -->
<script src="./plugins/circle-progress/circle-progress.min.js"></script>
<!-- Datamap -->
<script src="./plugins/d3v3/index.js"></script>
<script src="./plugins/topojson/topojson.min.js"></script>
<script src="./plugins/datamaps/datamaps.world.min.js"></script>
<!-- Morrisjs -->
<script src="./plugins/raphael/raphael.min.js"></script>
<script src="./plugins/morris/morris.min.js"></script>
<!-- Pignose Calender -->
<script src="./plugins/moment/moment.min.js"></script>
<script src="./plugins/pg-calendar/js/pignose.calendar.min.js"></script>
<!-- ChartistJS -->
<script src="./plugins/chartist/js/chartist.min.js"></script>
<script src="./plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>


<script src="./js/dashboard/dashboard-1.js"></script>

</body>

</html>

