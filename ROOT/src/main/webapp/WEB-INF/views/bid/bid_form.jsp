<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/resources/module/admin_top.jsp" charEncoding="UTF-8" />

<div class="container-fluid text-center">
	<div class="row content">
		<!-- 메인화면  -->
		<div class="col-sm-12 text-left">
			<h1>입찰창</h1>

			<div class="table-responsive">
				<table class="table table-hover">

					<thead>
						<tr>※입찰보증금액표 :
						</tr>
						<div>판매상품가격이 5만원 미만 : 1,000원</div>
						<div>5만원 이상 20만원미만 : 5,000원</div>
						<div>20만원이상 50만원미만 : 10,000원</div>
						<div>50만원이상 200만원미만 : 30,000원</div>
						<div>200만원이상 : 100,000원</div>
						<tr>
							<h2>입찰하기</h2>

							<th>품목명: ${auctionGoodsName}</th>
							<th>시작가격:<fmt:formatNumber value="${auctionGoodsStartPrice}"
									groupingUsed="true" />원
							</th>
							<th>입찰단위:<fmt:formatNumber value="${auctionGoodsBidUnit}"
									groupingUsed="true" />원
							</th>
						</tr>
						<tr>
							<div>
								<td>
									<form role="form" id="priceaddForm"
										action="${pageContext.request.contextPath}/bid/price"
										method="get">
										<div class="form-group">
											<label for="bidPrice">입찰금액</label> <input type="int"
												class="form-control" id="bidPrice" name="bidPrice"
												placeholder="시작가 <fmt:formatNumber value="${auctionGoodsStartPrice}" groupingUsed="true"/>원">
												<input type="hidden" name="auctionGoodsCode" value="${auctionGoodsCode}">
												<input type="hidden" name="userId" value="${userId}">
												<input type="hidden" name="auctionGoodsName" value="${auctionGoodsName}">										
											  <button type="submit">입찰</button>
										</div>
									</form>
								</td>
							</div>
						</tr>
						<tr>
							<th>입찰자</th>
							<th>입찰가격</th>
							<th>입찰시간</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="goodsbid" items="${goodsbidlist}">
							<tr>
								<td>${goodsbid.userBuyerId}</td>
								<td><fmt:formatNumber value="${goodsbid.bidPrice}"
										groupingUsed="true" />원</td>
								<td>${goodsbid.bidDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div></div>
	

	<c:import url="/resources/module/admin_footer.jsp" charEncoding="UTF-8" />