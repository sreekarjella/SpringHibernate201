$(document).ready(function($) 
{
	$('#div1').hide();
	$('#div2').hide();
	getZonesViaAjax();
	getCategoriesViaAjax();
	getStatusViaAjax();
});

function getZonesViaAjax()
{
	$.ajax({
		url : "http://localhost:8080/SpringHibernate201/zones",
		success : function(data) {
					var selectBox = document.getElementById('zones');
					for(var i = 0, l = data.length; i < l; i++)
					{
						var option = data[i];
						if(i==0)
							selectBox.options.add( new Option(option.zoneName, option.zoneId,true) );
						else
							selectBox.options.add( new Option(option.zoneName, option.zoneId) );
					}
			    },
		error : function(data) {
					alert(data.responseText);
				}
	});
}

function getCategoriesViaAjax()
{
	$.ajax({
		url : "http://localhost:8080/SpringHibernate201/categories",
		success : function(data) {
					var selectBox = document.getElementById('categories');
					for(var i = 0, l = data.length; i < l; i++)
					{
						var option = data[i];
						if(i==0)
							selectBox.options.add( new Option(option.catgoryDescription, option.categoryId,true) );
						else
							selectBox.options.add( new Option(option.catgoryDescription, option.categoryId) );
					}
			    },
		error : function(data) {
					alert(data.responseText);
				}
	});
}

function getStatusViaAjax()
{
	$.ajax({
		url : "http://localhost:8080/SpringHibernate201/statuses",
		success : function(data) {
					var selectBox = document.getElementById('statuses');
					for(var i = 0, l = data.length; i < l; i++)
					{
						var option = data[i];
						if(i==0)
							selectBox.options.add( new Option(option.statusName, option.statusId,true) );
						else
							selectBox.options.add( new Option(option.statusName, option.statusId) );
					}
			    },
		error : function(data) {
					alert(data.responseText);
				}
	});
}

function getUav()
{
	var assessYear = document.getElementById("assessYear").value;
	var name = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var address = document.getElementById("address").value;
	var zone = document.getElementById("zones");
	var zoneId = zone.options[zone.selectedIndex].value;
	var category = document.getElementById("categories");
	var categoryId = category.options[category.selectedIndex].value;
	var stat = document.getElementById("statuses");
	var statId = stat.options[stat.selectedIndex].value;
	var startYear = document.getElementById("startYear").value;
	var area1 = document.getElementById("area").value;
	var u = {};
	u["categoryId"] = categoryId;
	u["zoneId"] = zoneId;
	u["statusId"] = statId;
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "http://localhost:8080/SpringHibernate201/uav",
		data : JSON.stringify(u),
		dataType : 'json',
		success : function(data) {
					var uav = parseFloat(JSON.stringify(data));
					var tax = 0;
					var total1 = area1 * uav * 10;
					var years = assessYear-startYear;
					var depriciationPer = 0;
					if(years <= 60)
						depriciationPer = years;
					else
						depriciationPer = 60;
					appDepri = total1 * (depriciationPer / 100);
					var total2 = total1 - appDepri;
					var total3 = total2 * 0.2;
					var total4 = total3 * 0.24;
					tax = total3 + total4;
					$("#tax").prop("disabled", true);
					$("#tax").prop("value", tax);
				  },
		error : function(data) {
					alert(data.responseText);
				}
	});
}

function postTaxViaAjax() 
{
	var paidTax = {};
	paidTax["paidTax"] = document.getElementById("tax").value;
	var zone = document.getElementById("zones");
	var zoneId = zone.options[zone.selectedIndex].value;
	paidTax["zoneId"] = zoneId;
	var stat = document.getElementById("statuses");
	var statId = stat.options[stat.selectedIndex].value;
	paidTax["statusId"] = statId;
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "http://localhost:8080/SpringHibernate201/tax",
		data : JSON.stringify(paidTax),
		dataType : 'json',
		success : function(data) {
					if(JSON.stringify(data)=="true")
					{
						$('#div1').show();
						$('#div2').hide();
					}
					else
					{
						$('#div1').hide();
						$('#div2').show();
					}
				  },
		error : function(data) {
					alert(data.responseText);
				}
	});
}