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
    <link href="/plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
    <!-- Chartist -->
    <link rel="stylesheet" href="/plugins/chartist/css/chartist.min.css">
    <link rel="stylesheet" href="/plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
    <!-- Custom Stylesheet -->
    <link href="/css/style.css" rel="stylesheet">

</head>

<body>


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

        <div class="container-fluid mt-3">
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="active-member">
                                <div class="table-responsive">
                                    <h3>Nhân viên chưa chấm công</h3>
                                    <br>
                                    <table class="table table-xs mb-0">
                                        <thead>
                                        <tr>
                                            <th>Nhân viên</th>
                                            <th>Gender</th>
                                            <th>DateOfBirth</th>
                                            <th>Department</th>
                                            <th>JobTitle</th>
                                            <th>CheckIn</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="nhanvien" items="${nhanVienNoCheckIns}">
                                            <tr>
                                                <td><img src="${nhanvien.getAvatar()}" class=" rounded-circle mr-3"
                                                         alt=""><a
                                                        href="/profile?id=${nhanvien.getEmployeeID()}">${nhanvien.getFullName()}</a>
                                                </td>
                                                <td>${nhanvien.getGender()}</td>
                                                <td>
                                                    <span>${nhanvien.getDateOfBirth()}</span>
                                                </td>
                                                <td>
                                                    <i class="fa fa-circle-o text-success  mr-2"></i> ${nhanvien.getDepartment()}
                                                </td>
                                                <td>
                                                    <i class="fa fa-circle-o text-success  mr-2"></i> ${nhanvien.getJobTitle()}
                                                </td>
                                                <td>
                                                    <span class="text-danger">Chưa chấm công</span>
                                                </td>

                                                <td>
                                                    <a href="/checkin?idNV=${nhanvien.getEmployeeID()}"
                                                       class="btn btn-success">CheckIN</a>
                                                    <span class="m-0 pl-3"><button onclick="dismissalStaff(${nhanvien.getEmployeeID()})" class="btn btn-danger">Sa Thải</button></span>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-body">
                            <div class="active-member">
                                <div class="table-responsive">
                                    <h3>Nhân viên đã chấm công</h3>
                                    <br>
                                    <table class="table table-xs mb-0">
                                        <thead>
                                        <tr>
                                            <th>Nhân viên</th>
                                            <th>Gender</th>
                                            <th>DateOfBirth</th>
                                            <th>Department</th>
                                            <th>JobTitle</th>
                                            <th>CheckIn</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="nhanvien" items="${nhanVienCheckIns}">
                                            <tr>
                                                <td><img src="${nhanvien.getAvatar()}" class=" rounded-circle mr-3"
                                                         alt=""><a
                                                        href="/profile?id=${nhanvien.getEmployeeID()}">${nhanvien.getFullName()}</a>
                                                </td>
                                                <td>${nhanvien.getGender()}</td>
                                                <td>
                                                    <span>${nhanvien.getDateOfBirth()}</span>
                                                </td>
                                                <td>
                                                    <i class="fa fa-circle-o text-success  mr-2"></i> ${nhanvien.getDepartment()}
                                                </td>
                                                <td>
                                                    <i class="fa fa-circle-o text-success  mr-2"></i> ${nhanvien.getJobTitle()}
                                                </td>
                                                <td>
                                                    <span class="text-success">Đã chấm công</span>
                                                </td>

                                                <td>
                                                    <a href="/checkin?idNV=${nhanvien.getEmployeeID()}"
                                                       class="btn btn-info">Show CheckIN</a>

                                                    <span class="m-0 pl-3"><button onclick="dismissalStaff(${nhanvien.getEmployeeID()})" class="btn btn-danger">Sa Thải</button></span>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-lg-3 col-sm-6">
                    <div class="card">
                        <div class="card-body">
                            <div class="text-center">
                                <img src="./images/users/8.jpg" class="rounded-circle" alt="">
                                <h5 class="mt-3 mb-1">Ana Liem</h5>
                                <p class="m-0">Senior Manager</p>
                                <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <div class="card">
                        <div class="card-body">
                            <div class="text-center">
                                <img src="./images/users/5.jpg" class="rounded-circle" alt="">
                                <h5 class="mt-3 mb-1">John Abraham</h5>
                                <p class="m-0">Store Manager</p>
                                <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <div class="card">
                        <div class="card-body">
                            <div class="text-center">
                                <img src="./images/users/7.jpg" class="rounded-circle" alt="">
                                <h5 class="mt-3 mb-1">John Doe</h5>
                                <p class="m-0">Sales Man</p>
                                <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-6">
                    <div class="card">
                        <div class="card-body">
                            <div class="text-center">
                                <img src="./images/users/1.jpg" class="rounded-circle" alt="">
                                <h5 class="mt-3 mb-1">Mehedi Titas</h5>
                                <p class="m-0">Online Marketer</p>
                                <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                            </div>
                        </div>
                    </div>
                </div>

            </div>


        </div>
        <!-- #/ container -->
    </div>

    <div class="footer">
        <div class="copyright">
            <p>Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018
            </p>
        </div>
    </div>
</div>

<!--**********************************
    Scripts
***********************************-->
<script src="/plugins/common/common.min.js"></script>
<script src="/js/custom.min.js"></script>
<script src="/js/settings.js"></script>
<script src="/js/gleek.js"></script>
<script src="/js/styleSwitcher.js"></script>

<!-- Chartjs -->
<script src="/plugins/chart.js/Chart.bundle.min.js"></script>
<!-- Circle progress -->
<script src="/plugins/circle-progress/circle-progress.min.js"></script>
<!-- Datamap -->
<script src="/plugins/d3v3/index.js"></script>
<script src="/plugins/topojson/topojson.min.js"></script>
<script src="/plugins/datamaps/datamaps.world.min.js"></script>
<!-- Morrisjs -->
<script src="/plugins/raphael/raphael.min.js"></script>
<script src="/plugins/morris/morris.min.js"></script>
<!-- Pignose Calender -->
<script src="/plugins/moment/moment.min.js"></script>
<script src="/plugins/pg-calendar/js/pignose.calendar.min.js"></script>
<!-- ChartistJS -->
<script src="/plugins/chartist/js/chartist.min.js"></script>
<script src="/plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>


<script src="/js/dashboard/dashboard-1.js"></script>

</body>

</html>

<script>
    function dismissalStaff(idNV) {
        if (confirm("bạn muốn sa thải nhân viên này chứ :")){
            location.href = "/dismissal?id="+idNV;
        }
    }
</script>