<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../header.jsp" %>

<head>
      <style>
        .contract{
            font-size: small; 
            font-family: Arial, '맑은 고딕';
            width: 430px;
            margin: 0 auto;
		    margin-bottom: 100px;
		    margin-top: 70px;
        }
        h3.contarct_agree{
            margin: 30px;
            text-align: center;
        }
        #all_select{
            text-decoration: underline;
        }
        .agree_btn{            
            text-align: center;
            margin-top: 30px;
        }
        .ag_btn{
            width: 55.99306px;
            height: 25.99306px;
            cursor: pointer;
        }
   	 </style>
</head>

<body>
     <div class="contract">
        <h3 class="contarct_agree">약관 동의</h3>
        <form action="join_form" method="post" id="contract_form">
            <p id="all_select">
                <label>
                    <input type="checkbox" name="all" id="all">
                    Tour And Taste 이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택)에 모두 동의합니다.
                </label>
            </p>
            <p>
                <label>
                    <input type="checkbox" name="chk" id="chk1"> 
                    Tour And Taste 이용약관 동의<span style="color: #45b8ac;">(필수)</span>
                </label>
            </p>
            <td><textarea readonly="readonly" rows="4" cols="60" style="resize: none;">
                제 1 조 (목적)
                
                이 약관은 Tour And Taste 주식회사 ("회사" 또는 "Tour And Taste")가 제공하는 Tour And Taste 및 Tour And Taste 관련 제반 서비스의 이용과 관련하여 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.
                
                
                제 2 조 (정의)
                
                이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
                ①"서비스"라 함은 구현되는 단말기(PC, TV, 휴대형단말기 등의 각종 유무선 장치를 포함)와 상관없이 "회원"이 이용할 수 있는 Tour And Taste 및 Tour And Taste 관련 제반 서비스를 의미합니다.
                ②"회원"이라 함은 회사의 "서비스"에 접속하여 이 약관에 따라 "회사"와 이용계약을 체결하고 "회사"가 제공하는 "서비스"를 이용하는 고객을 말합니다.
                ③"아이디(ID)"라 함은 "회원"의 식별과 "서비스" 이용을 위하여 "회원"이 정하고 "회사"가 승인하는 문자와 숫자의 조합을 의미합니다.
                ④"비밀번호"라 함은 "회원"이 부여 받은 "아이디와 일치되는 "회원"임을 확인하고 비밀보호를 위해 "회원" 자신이 정한 문자 또는 숫자의 조합을 의미합니다.
                ⑤"유료서비스"라 함은 "회사"가 유료로 제공하는 각종 온라인디지털콘텐츠(각종 정보콘텐츠, VOD, 아이템 기타 유료콘텐츠를 포함) 및 제반 서비스를 의미합니다.
                ⑥"포인트"라 함은 서비스의 효율적 이용을 위해 회사가 임의로 책정 또는 지급, 조정할 수 있는 재산적 가치가 없는 "서비스" 상의 가상 데이터를 의미합니다.
                ⑦"게시물"이라 함은 "회원"이 "서비스"를 이용함에 있어 "서비스상"에 게시한 부호ㆍ문자ㆍ음성ㆍ음향ㆍ화상ㆍ동영상 등의 정보 형태의 글, 사진, 동영상 및 각종 파일과 링크 등을 의미합니다. 
                </textarea>
            <p>
                <label>
                    <input type="checkbox" name="chk" id="chk2"> 
                    개인정보 수집 및 이용에 대한 안내<span style="color: #45b8ac;">(필수)</span>
                </label>
            </p>
            <textarea readonly="readonly" rows="4" cols="60" style="resize: none;">
                정보통신망법 규정에 따라 Tour And Taste에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.
    
                1. 수집하는 개인정보
    
                이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 Tour And Taste 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, Tour And Taste는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.
                        
            </textarea>
            <p>
                <label>
                    <input type="checkbox" name="chk" id="chk3"> 
                    위치정보 이용약관 동의<span style="color: gray;">(선택)</span>
                </label>
            </p>
            <textarea readonly="readonly" rows="4" cols="60" style="resize: none;">
            위치정보 이용약관에 동의하시면, 위치를 활용한 광고 정보 수신 등을 포함하는 Tour And Taste 위치기반 서비스를 이용할 수 있습니다.
    
    
            제 1 조 (목적)
            이 약관은 Tour And Taste 주식회사 (이하 “회사”)가 제공하는 위치정보사업 또는 위치기반서비스사업과 관련하여 회사와 개인위치정보주체와의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.
    
    
            제 2 조 (약관 외 준칙)
            이 약관에 명시되지 않은 사항은 위치정보의 보호 및 이용 등에 관한 법률, 정보통신망 이용촉진 및 정보보호 등에 관한 법률, 전기통신기본법, 전기통신사업법 등 관계법령과 회사의 이용약관 및 개인정보취급방침, 회사가 별도로 정한 지침 등에 의합니다.
    
    
            제 3 조 (서비스 내용 및 요금)
            ①회사는 직접 위치정보를 수집하거나 위치정보사업자인 이동통신사로부터 위치정보를 전달받아 아래와 같은 위치기반서비스를 제공합니다. 1.Geo Tagging 서비스: 게시글 등록 시점의 개인위치정보주체의 위치정보를 게시글과 함께 저장합니다.
            2.위치정보를 활용한 검색결과 제공 서비스: 정보 검색을 요청하거나 개인위치정보주체 또는 이동성 있는 기기의 위치정보를 제공 시 본 위치정보를 이용한 검색결과 및 주변결과(맛집, 주변업체, 교통수단 등)를 제시합니다.
            3.위치정보를 활용한 친구찾기 및 친구맺기: 현재 위치를 활용하여 친구를 찾아주거나 친구를 추천하여 줍니다.
            4.연락처 교환하기: 위치정보를 활용하여 친구와 연락처를 교환할 수 있습니다.
            5.현재 위치를 활용한 광고정보 제공 서비스: 광고정보 제공 요청 시 개인위치정보주체의 현 위치를 이용하여 광고소재를 제시합니다.
            6. 이용자 보호 및 부정 이용 방지: 개인위치정보주체 또는 이동성 있는 기기의 위치를 이용하여 권한없는 자의 비정상적인 서비스 이용 시도 등을 차단합니다.
            </textarea>
            <div class="agree_btn">
            	<input type="reset" value="미동의" class="ag_btn">
                <input type="submit" value="동의" id="nextBtn" class="ag_btn">
            </div>
        </form>
    </div>
    <script>
    $(document).ready(function() {
    	
    	//전체 선택시 전부 체크됨
     	$("#all").click(function() {
			if($("#all").is(":checked")) $("input[name=chk]").prop("checked", true);
			else $("input[name=chk]").prop("checked", false);
		});
     	
    	//한개라도 체크 해제되면 전체 선택도 해제됨
     	$("input[name=chk]").click(function() {
			var total = $("input[name=chk]").length;
			var checked = $("input[name=chk]:checked").length;
			if(total != checked) $("#all").prop("checked", false);
			else $("#all").prop("checked", true); 
		});
     	     	
     	//필수 체크 안되어있을시 경고
     	$("#nextBtn").click(function(){
    		if($("#chk1").is(":checked") && $("#chk2").is(":checked")){
    			$("#contract_form").attr('action', 'join_form').submit();
    			
    		} else {
    			
    			if(!$("#chk1").is(":checked")){
    				alert("이용 약관을 동의하셔야 합니다.");
   					return false;
    			}
    			
   				if(!$("#chk2").is(":checked")){
   					alert("개인정보처리 방침에 동의하셔야 합니다.");
   					return false;
   				}
   			}
   		});
    	
    });
    </script>
</body>
<%@ include file="../footer.jsp" %>


