<!doctype html>
<%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Sly - jQuery plugin</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="jQuery plugin for one-directional scrolling with item based navigation support.">
<meta name="viewport" content="width=device-width">
<!-- <link href='http://fonts.googleapis.com/css?family=Exo:700'
	rel='stylesheet' type='text/css'>
	 -->
<link rel="stylesheet" href="css/main.css">
</head>
<body id="top">

		<div id="sections" class="container">
			<div id="vertical" class="clearfix">
				<div class="slyWrap example2">
					<div class="scrollbar">
						<div class="handle"></div>
					</div>
					<div class="sly" data-options='{ "startAt": 1, "scrollBy": 1}'>
						<div>
							<article>
								<header>
									<h1>一日言</h1>
								</header>
								<p>生命那么短暂,为什么不选择做自己喜欢做的事.</p>
								<section>
									<header>
										<h1></h1>
									</header>
									<p>Life is so short, why not do what you like to do.</p>
									<hr class="line"></hr>
								</section>
								<section>
									<header>
										<h1>本月球员</h1>
									</header>
									<p class="next-to-aside">杰拉德</p>
									<figure>
										<img src="images/gerrard.jpg" alt="Photograph of Stonehenge"
											width="500" height="300">
										<figcaption>Steven Gerrard</figcaption>
									</figure>
									<hr class="line"></hr>
								</section>
								<section>
									<header>
										<h1>本月俱乐部</h1>
									</header>
									<p class="next-to-aside">利物浦</p>
									<figure>
										<img src="images/liverpool.bmp" alt="Photograph of Stonehenge"
											width="500" height="300">
										<figcaption>Liverpool</figcaption>
									</figure>
								</section>
							</article>
						</div>
					</div>
				</div>

			</div>
			<!--end:#vertical-->
		</div>
		<!--end:#sections-->
	<!--end:#content-->

	<!-- Grab Google CDN's jQuery, with a protocol relative URL; fall back to local if offline -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-1.7.2.min.js"><\/script>')
	</script>

	<!-- scripts -->
	<script src="js/jquery.sly.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
	<!-- end scripts -->
</body>
</html>