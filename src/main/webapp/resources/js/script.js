$(()=>{

	var input = $(".input-city input") ;
	var url = "http://localhost:4400/jee/api/cities" ;
	
	async function findCities(name) {
	
		return axios.get(url+"?q="+name);
	}

	input.focus(function() {
		var ul = $(this).parent().find("ul.proposition");
		var cities =[]
		$(this).on("keyup",function(e) {

			ul.css("display","block");
			findCities($(this).val()).then(res=>{
				cities=res.data;
				cities.forEach(c => ul.append("<li> <i class=\"fas fa-globe\"></i> <span>"+c['name']+"</span></li>"))
			})
			ul.empty();
			cities=[];
		})

		ul.on('click','li',e=>{
		
			var city = e.target.lastElementChild.textContent;
			console.log(city);
			$(this).val(city)
			console.log();
			ul.empty();
			ul.remove();

		})

	})


});