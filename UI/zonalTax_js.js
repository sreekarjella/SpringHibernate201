$(document).ready(function($) 
{
	getReportViaAjax();
});

function getReportViaAjax() 
{
	$.ajax({
		url : "http://localhost:8080/SpringHibernate201/report",
		success : function(data) {
					arrangeReport(data);
			    },
		error : function(data) {
					alert(data.responseText);
				}
		});
}

function arrangeReport(data)
{
	var table = "<table class='table'><thead><tr><th>ZONE NAME</th><th>PROPERTY TYPE</th><th>AMOUNT COLLECTED</th></tr></thead><tbody>";
	var obj = data;
	for(var i = 0; i < obj.length; i++)
	{
		if(i%2==0)
			table += "<tr><td rowspan='2'>" + obj[i].zoneName + "</td><td>" + obj[i].statusName + "</td><td>" + parseFloat(obj[i].totalTax) + "</td></tr>";
		else
			table += "<tr><td>" + obj[i].statusName + "</td><td>" + parseFloat(obj[i].totalTax) + "</td></tr>";
	}
	table += "</tbody></table>";
	$("#div1").html(table);
}