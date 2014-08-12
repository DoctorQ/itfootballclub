


$(document).ready(
		function() {
			var field = $("#fieldtype");
			var cnameselect = $("#clubtype");
			var sportselect = $("#sporttype");
			var timeselect = $("#timestage");
			var minuteselect = $("#minute");
			var goaltextarea = $("#goaltime");
			var pgoal = $("#pgoal");
			var cgoal = $("#cgoal");
			var pnamevalue = "no";
			var cnamevalue = "no";
			$("#ptype").change(function() {
				pnamevalue = $(this).val();
				field.html("");
				if (pnamevalue == "no") {
					alert("请选择主队");
				} else {
					$.post("autoInput", {
						keyword : pnamevalue,
						flag : "pname"
					}, function(response) {
						var data = eval(response);
						field.attr("value", data[0]);
						//field.html(data[0]);

					});
				}

			});
			$("#ctype").change(
					function() {
						cnamevalue = $(this).val();
						if (pnamevalue != null && cnamevalue != null&&cnamevalue!=pnamevalue) {
							cnameselect.html("");
							$("<option value=\"no\">请选择进球球队</option>")
									.appendTo(cnameselect);
							$(
									"<option value='" + pnamevalue + "'>"
											+ pnamevalue + "</option>")
									.appendTo(cnameselect);
							$(
									"<option value='" + cnamevalue + "'>"
											+ cnamevalue + "</option>")
									.appendTo(cnameselect);
						} else{
							alert("请选择比赛双方且不要相同");
						}
					});
			cnameselect.change(function() {
				var clubtype = $(this).val();
				sportselect.html("");
				$.post("autoInput", {
					keyword : clubtype,
					flag : "sportname"
				}, function(response) {
					var data = eval(response);
					if (data.length != 0) {
						$("<option value='no'>请选择进球者</option>").appendTo(
								sportselect);
						for ( var i = 0; i < data.length; i++) {
							$(
									"<option value='" + data[i] + "'>"
											+ data[i] + "</option>").appendTo(
									sportselect);
						}
						sportselect.show();
					}else{
						alert("wrong");
					}
				});
			});
			sportselect.change(function(){
				var stage = timeselect.val();
				var max = 0;
				minuteselect.html("");
				if(stage!="no"){
					 if(stage == "FIRST-HALF"||stage=="SECOND-HALF"){
						max = 45;
					}else {
						max = 30;
					}
					 $("<option value='no'>进球时间</option>").appendTo(minuteselect);
						for(var i = 1;i<=max;i++){
							$(
								"<option value='"+i+"'>"+i+"</option>"	
							
							).appendTo(minuteselect);
						}
						minuteselect.show();
				}	
				});
			minuteselect.change(function(){
				var goalmes = goaltextarea.html();
				var a = cnameselect.val();
				var b = sportselect.val();
				var c = timeselect.val();
				var d = $(this).val();
				var mes ="GOAL:"+a+"_"+b+"_"+c+"_"+d;
				goaltextarea.html(goalmes+"\n"+mes);
				var goalnum = goaltextarea.html();
				$.post("autoInput",{keyword:goalnum,
					pname:pnamevalue,flag:"score",
					cname:cnamevalue},function(response){
						var data = eval(response);
						pgoal.html("");
						pgoal.attr("value", data[0]);
						cgoal.html("");
						cgoal.attr("value",data[1]);
					
				});
				$(this).hide();
			});

		});