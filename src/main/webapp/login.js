
	function loginValidation()
	{
		
		var email = document.getElementById("email").value;
		var pass = document.getElementById("password").value;
		alert('hahahahah : '+email+' '+pass);
	
		baseurl="http://localhost:8080/OrganisationRegistration/webapi/org/verifyuser?id="+email+"&key="+ pass;
		$.ajax({
					type: 'GET',
					url: baseurl,
					async:false,
					success: function(data){
						//alert("su : "+data);
						var res = data['result'];
						alert(res);
						if(res===true)
							{
							   //debugger;
							   //window.location="OrganisationCRUD.html";
							   //window.location.Redirect();
							     window.location.href="OrganisationCRUD.html";
							}
					},
				    error: function(data,res)
				    {
				    	//alert('error'+JSON.stringify(data));
				    	alert("haha");
				    }
				});
		
	}






