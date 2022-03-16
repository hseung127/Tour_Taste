<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
	<ul class="event-pagination">
	
		<c:if test="${pageMaker.prev}">
			<li class="paginate_button previous">
				<a data-pre-url="${pageMaker.makeQuery(pageMaker.startPage-1)}" href='javascript:void(0);' onclick="go_page(this);">[이전]</a>
			</li>
		</c:if>
				
		<!-- [1][2][3]... 표시 부분 -->
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
			<a href='javascript:void(0);' onclick="go_index(this);" class="p-index" id="p-index${index}"data-index="${index}" data-index-url="${pageMaker.makeQuery(index)}">${index}</a>
			
			<%-- <a href="event_list${pageMaker.makeQuery(index)}">[${index}]</a> --%>
		</c:forEach>
		
		<c:if test="${pageMaker.next}">
			<li class="paginate_button next">
				<a data-next-url="${pageMaker.makeQuery(pageMaker.startPage-1)}" href='javascript:void(0);' onclick="go_page(this);">[다음]</a>
			</li>
		</c:if>	
			
	</ul>
</div>
<!-- 
<script>
					$(document).ready(function(){
						/* function go_index(){ */
					        $('#p-index').click(function () {
					        	var indexUrl = event_list + $(this).attr('data-index');
					        	console.log(indexUrl);
								$('#tab-1').load(indexUrl);
								console.log($('#tab-1').load(indexUrl));
					    	});
						/* } */
					});
</script>

 -->
