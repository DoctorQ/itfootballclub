//隔行显示背景色
//$(document).ready(function(){
//});
$(function(){
	$("tbody tr:even").css("background-color", "#ECE9D8");
	/*var tds = $("tbody td:even");
	tds.click(function(){
		//input text tags
		var tid = $(this);
		var text = tid.html();
		tid.html("");
		var inputText = $("<input type='submit'>").css("border-width", "1")
		.css("font-size","14px")
		.css("background-color",tid.css("background-color"))
		.width(tid.width())
		.val("删除").appendTo(tid);
		inputText.get(0).select();
		inputText.trigger("focus").trigger("select");
		inputText.click(function(){
			return false;
		});
		inputText.click(function(){
			$.post("deleteClub",{cname:text},function(response){	
			});
		});	
		inputText.keyup(function(event){
			var keycode = event.which;
			if(keycode==13) {
				$.post("deleteClub",{cname:text});
				var name = $(this).val();
				//tid.html(name);
				tid.html(text);
			}
			if(keycode == 27){
				tid.html(text);
			}
		});
	});*/
});