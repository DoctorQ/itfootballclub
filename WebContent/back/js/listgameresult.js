/**
 * 
 */
$(document).ready(function(){
	var legselect = $("#leg");
	var tablebody = $("tbody");
	legselect.change(function(){
		var legvalue = $(this).val();
		tablebody.html("");
		$.post("autoInput",{keyword:legvalue,flag:"leg"},function(response){
			var data = eval(response);
			if(data.length!=0){
			  for(var i=0;i<data.length;i++){
				$("<tr><td>"+data[i].pName+"</td>"
						+"<td>"+data[i].pGoal+"</td>"
						+"<td>"+data[i].cGoal+"</td>"
						+"<td>"+data[i].cName+"</td>"
						+"<td>"+data[i].gameTime+"</td>"
						+"<td>"+data[i].field+"</td>"
					+"</tr>"
				).appendTo(tablebody);
			  }
			  $("tbody tr:even").css("background-color", "#ECE9D8");
			}
		});
		
	});
	
});
	
