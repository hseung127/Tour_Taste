<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<head>
<style>
		#mypage{
            width: 1000px;
            margin: 0 auto;
            margin-top: 50px;
        }

        .mypage_txt{
            width: 1000px;
            border-bottom: 3px solid;
            position: relative;
        }

        .modify_pwd{
            color: gray;
        }

        .more_function{            
            position: absolute;
            right: 0;
            top: 15px;
        }

        .btn_withdraw{
            all: unset;
            cursor: pointer;
            color: gray;
        }

        .mypage_banner{
            margin-top: 40px;
        }
        
        .btn_mylist{
            border: 1px solid rgb(142, 179, 228);
            width: 100px;
            height: 100px;
            box-shadow: gray;
            float: left;
        }

        a{
            text-decoration: none;
            color: black;
            text-align: left;
        }
       
        .btn_mypage_mylist {
            margin-top: 40px;
            margin-bottom: 300px;
        }

        .btn_mypage_box {
            background-color: #cedcfa;
            width: 225px;
            height: 150px;
            padding-top: 10px;
            padding-left: 10px;
            
        }

        .btn_mypage_number{
            text-align: right;
            width: 250px;
            position: relative;
            top: 60px;
            right: 50px;
            
        }

        .btn_mypage_title{
            float: left;
            margin-left: 33px;
            font-size: 17px;
        }

        .btn_mypage_numbering{
            font-size: 30px;
        }
</style>

</head>
<body>
    <div id="mypage">
        <div class="mypage_txt">
            <h3 style="font-size: 30px;"><sapn><img src="images/mypage/mypage-icon.png" width="45px" height="45px"></sapn> 마이 페이지</h3>
            <div class="more_function">
                <a class="modify_pwd" onclick="location='modify_pwd_form'" style="cursor: pointer;">비밀번호 변경 |</a>
                <a class="btn_withdraw" onclick="location='delete_member_form'" style="cursor: pointer;">회원 탈퇴</a>
            </div>
        </div>
        <div class="mypage_banner">
            <a href="event-news"><img class="mypage_banner_img" src="images/mypage/mypage_event.jpg" style="width: 1000px; height: 400px;"></a>
        </div>
        <div class="btn_mypage_mylist">
            <a href="index" class="btn_mypage_title" style="margin-left: 0px;">
                <div class="btn_mypage_box">좋아요
                    <div class="btn_mypage_number"><span class="btn_mypage_numbering">00</span></div>
                </div>
            </a>
            <a href="index" class="btn_mypage_title">
                <div class="btn_mypage_box">코스
                    <div class="btn_mypage_number"><span class="btn_mypage_numbering">00</span></div>
                </div>
            </a>
            <a href="index" class="btn_mypage_title">
                <div class="btn_mypage_box">댓글
                    <div class="btn_mypage_number"><span class="btn_mypage_numbering">00</span></div>
                </div>
            </a>
            <a href="index" class="btn_mypage_title">
                <div class="btn_mypage_box">내가 작성한 글
                    <div class="btn_mypage_number"><span class="btn_mypage_numbering">00</span></div>
                </div>
            </a>
        </div>
    </div>
</body>
<%@ include file="../footer.jsp" %>