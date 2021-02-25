<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<!-- 항상  jquery먼저 넣기, jquery-3.5.1.slim.min.js에서 slim빼도 된다-->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
<script>
	$(function() {
		$("#liveToastBtn").on("click", function() {
			$(".toast").toast("show");
		});
		$('.btn').tooltip();
		$('#btnRejister').on("click", function(){
			$(".modal").modal("show");
		})
	});
</script>

<title>bootstrap.jsp</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<!--col-숫자일때 합이 12여야 한다  -->
			<div class="col-4 border">
				<a href="#" class="btn btn-info" data-toggle="tooltip"
					data-placement="bottom" title="로그인페이지로 이동">로그인</a> 
					<span id="btnRejister" class="btn btn-outline-success">회원가입</span>
				<button class="btn btn-primary">게시판</button>
			</div>
			<div class="col-7 border">
				<!-- 토스트 내용은 맨 아래에 있어도 괜찮다 -->
				<button type="button" class="btn btn-primary" id="liveToastBtn">Show
					live toast</button>
				<div class="position-fixed bottom-0 right-0 p-3"
					style="z-index: 5; right: 100; bottom: 0;">
					<div id="liveToast" class="toast hide" role="alert"
						aria-live="assertive" aria-atomic="true" data-delay="1000">
						<div class="toast-header">
							<img src="..." class="rounded mr-2" alt="..."> <strong
								class="mr-auto">Bootstrap</strong> <small>8 mins ago</small>
							<button type="button" class="ml-2 mb-1 close"
								data-dismiss="toast" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="toast-body">Hello, Nakyung.</div>
					</div>
				</div>
			</div>
			<div class="col-1 border">third</div>
		</div>
		<div class="row">
			<div class="col-lg-6 cal-md-12 colborder">
				<table class="table table-bordered">
					<thead class="thead-dark">
						<tr>
							<td>번호</td>
							<td>이름</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>a</td>
						</tr>
						<tr>
							<td>2</td>
							<td>b</td>
						</tr>
						<tr>
							<td>3</td>
							<td>c</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-lg-6 cal-md-12 border"></div>
		</div>
		<!-- end of row -->
		<div class="row">
			<div class="card mr-5 pt-5" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			<!-- end of card -->
			<div class="card mr-5 pt-5" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			<!-- end of card -->
			<div class="card mr-5 pt-5" style="width: 18rem;">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			<!-- end of card -->
		</div>
	</div>
	<!-- end of content -->
	<!-- toast start -->
	<div class="alert alert-warning alert-dismissible fade show"
		role="alert">
		<strong>A</strong> simple primary <a href="#" class="alert-link">alert—check</a>
		it out!
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<div class="position-fixed bottom-0 right-0 p-3"
		style="z-index: 5; right: 0; bottom: 100;">
		<div id="liveToast" class="toast hide" role="alert"
			aria-live="assertive" aria-atomic="true" data-delay="2000">
			<div class="toast-header">
				<img src="..." class="rounded mr-2" alt="..."> <strong
					class="mr-auto">Bootstrap</strong> <small>8 mins ago</small>
				<button type="button" class="ml-2 mb-1 close" data-dismiss="toast"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="toast-body">Hello, Nakyung.</div>
		</div>
	</div>
	<!-- toast end -->
	<!-- modal start -->
	<div class="modal hide" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group row">
							<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
							<div class="col-sm-10">
								<input type="text" readonly class="form-control-plaintext"
									id="staticEmail" value="email@example.com">
							</div>
						</div>
						<div class="form-group row">
							<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPassword">
							</div>
						</div>
						<div class="form-group row">
							<label for="staticEmail" class="col-sm-2 col-form-label">취미</label>
							<div class="col-sm-10">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="checkbox" value=""
										id="defaultCheck1"> <label class="form-check-label"
										for="defaultCheck1"> Default checkbox </label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="checkbox" value=""
										id="defaultCheck2" disabled> <label
										class="form-check-label" for="defaultCheck2"> Disabled
										checkbox </label>
								</div>
							</div>
						</div>
						<div class="form-group row justify-content-center">
							<button class="btn btn-info">등록</button>
							<button class="btn btn-warning">취소</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">등록</button>
					<button type="button" class="btn btn-primary">취소</button>
				</div>
			</div>
		</div>
	</div>
	<!-- modal end -->
</body>
</html>