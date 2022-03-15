<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<style>
#aside .side-menu {
            width: 45px;
            z-index: 10;
            background: #ff5858;
            border-right: 1px solid rgba(0, 0, 0, 0.07);
            bottom: 50px;
            height: 100%;
         
            position: fixed;
           box-shadow: 0 0px 24px 0 rgb(0 0 0 / 6%), 0 1px 0px 0 rgb(0 0 0 / 2%);
            color: black;
        }

        #aside .sidebar-inner {
            height: 100%;
            padding-top: 30px;
        }

        #sidebar-menu,
        #sidebar-menu ul,
        #sidebar-menu li,
        #sidebar-menu a {
            border: 0;
            font-weight: normal;
            line-height: 1;
            list-style: none;
            margin: 0;
            padding: 0;
            position: relative;
            text-decoration: none;
        }

        #sidebar-menu>ul>li a {
            color: #fff;
            font-size: 20px;
            display: block;
            padding: 14px 0px;
            margin: 0px 0px 0px 8px;
            border-top: 1px solid rgba(0, 0, 0, 0.1);
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
            width: 28px;
            cursor: pointer;
        }

        #sidebar-menu .fas {
            padding-left: 6px;
        }

        /* 사이드 메뉴 */
        #aside input[type="search"] {
            width: 180px;
            margin: 0 auto;
            margin-left: 9px;
            border: 2px solid #797979;
            font-size: 14px;
            margin-top: 10px;
            padding: 4px 0 4px 14px;
            border-radius: 50px;
        }

        #aside .left_sub_menu {
            position: fixed;
            width: 200px;
            z-index: 10;
            left: 45px;
            background: white;
            border-right: 1px solid rgba(0, 0, 0, 0.07);
            bottom: 50px;
            height: 100%;
            box-shadow: 0 0px 24px 0 rgb(0 0 0 / 6%), 0 1px 0px 0 rgb(0 0 0 / 2%);
            color: black;
        }

        #aside .sub_menu {
            margin-top: 50px;
        }

        #aside .left_sub_menu>.sub_menu li:hover {
            color: ff5858;
            background-color: #e1e1e1;
        }

        #aside .left_sub_menu>.sub_menu li {
            color: #333;
            font-size: 17px;
            font-weight: 600;
            padding: 20px 0px 8px 14px;
            border-bottom: 1px solid #e1e1e1;
        }

        #aside .sub_menu>h2 {
            padding-bottom: 4px;
            border-bottom: 3px solid #797979;
            margin-top: 30px;
            font-size: 21px;
            font-weight: 600;
            color: #333;
            margin-left: 10px;
            margin-right: 10px;
            font-family: 'NotoKrB';
            line-height: 35px;
        }

        #aside .sub_menu .fas {
            color: #ff5858;
            font-size: 20px;
            line-height: 20px;
            float: right;
            margin-right: 20px;
        }

        #aside .sub_menu>.big_menu>.small_menu li {
            color: #333;
            font-size: 14px;
            font-weight: 600;
            border-bottom: 0px solid #e1e1e1;
            margin-left: 14px;
            padding-top: 8px;
        }

        .big_menu {
            cursor: pointer;
        }

        #aside ul {
            padding-inline-start: 0px;
        }

        #aside a {
            color: #797979;
            text-decoration: none;
            background-color: transparent;
        }

        #aside ul {
            list-style: none;
        }
		
        #aside ol,
        #aside ul {
            margin-top: 0;
            margin-bottom: 10px;
        }

        #aside .has_sub {
            width: 100%;
        }


        #aside .hide_sidemenu {
            display: none;
        }
</style>
<!-- 왼쪽 사이드 메뉴 스크립트 -->
<script>
    $(function () {
        $(".left_sub_menu").hide();
        $(".has_sub").click(function () {
            $(".left_sub_menu").fadeToggle(300);
        });
        // 왼쪽메뉴 드롭다운
        $(".sub_menu ul.small_menu").hide();
        $(".sub_menu ul.big_menu").click(function () {
            $("ul", this).slideToggle(300);
        });
        // 외부 클릭 시 좌측 사이드 메뉴 숨기기
        $('').on('click', function () {
            $('.left_sub_menu').fadeOut();
            $('.hide_sidemenu').fadeIn();
        });
    });
</script>
</head>
<body>
<div id="aside">
        <div class="topbar" style="position: absolute; top:0;">
            <!-- 왼쪽 메뉴 -->
            <div class="left side-menu">
                <div class="sidebar-inner">
                    <div id="sidebar-menu">
                        <ul>
                            <li class="has_sub"><a href="javascript:void(0);" class="waves-effect">
                            	<img class="img-submenu" src="images/menu_icon.png"/>
                                <i class="fas fa-bars"></i>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- 왼쪽 서브 메뉴 -->
            <div class="left_sub_menu">
                <div class="sub_menu">
                    <input type="search" name="SEARCH" placeholder="SEARCH">
                    <h2>TnT</h2>
                    <ul class="big_menu">
                        <li>관리자게시판 <i class="arrow fas fa-angle-right"></i></li>
	                        <ul class="small_menu">
		                        <li><a href='admin_newsboard_list'> 소식</a></li>
								<li><a href='admin_eventboard_list'> 이벤트</a></li>
								<li><a href='admin_seasonboard_list'> 시즌테마</a></li>
								<li><a href='admin_member0_tboard_list'>회원 여행지</a></li>
								<li><a href='admin_member0_rboard_list'> 회원 맛집</a></li>
								<li><a href='admin_member1_tboard_list'> 관리자 여행지</a></li>
								<li><a href='admin_member1_rboard_list'> 관리자 맛집</a></li>
								<li><a href='admin_comments_list'> 댓글</a></li>
	                        </ul>
                    </ul>
                    <ul class="big_menu">
                        <li><a href='admin_member_list'> 회원리스트</a><i class="arrow fas fa-angle-right"></i></li>
                    </ul>
                    <ul class="big_menu">
                        <li><a href='admin_chart_list'> 접속자 DBA</a><i class="arrow fas fa-angle-right"></i></li>
                    </ul>
                </div>
            </div>
         
        </div>
        </div>
        
</body>
</html>