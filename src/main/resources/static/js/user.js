let index ={
	init: function(){
		$("#btn-save").on("click",()=>{ 
			this.save();
		});
		
		/*
		$("#btn-login").on("click",()=>{ 
			this.login();
		});
		*/
	},
	
	save: function(){
		//alert('user의 save 함수 호출됨');
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		}
		
		//console.log(data);
		
		//ajax 호출시 default가 비동기 호출
		//ajax 통신을 이용해서 3개의 데이터 json으로 변경하여 insert 요청
		//ajax가 통신을 성공하고 나서 json을 리턴해주면 자동으로 자바 오브젝트로 변환이 됨
		$.ajax({
			type:"POST",
		    url: "/auth/joinProc", 
		    data:JSON.stringify(data),  
		    contentType:"application/json; charset=utf-8",   //body데이터가 어떤 타입인지(MIME)
		    dataType: "json" //요청을 서버로 해서 응답이 왔을때 기본적으로 모든 것이 문자열(생긴게 json이라면) => javascrtip 오브젝트로 변경 
		})
		// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
		.done(function(resp) {
		    alert("회원가입이 완료되었습니다.");
			console.log(resp);
			location.href="/";
		})
		// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
		.fail(function(error) {
		     alert(JSON.stringify(error));
		});
	
	},
	
	/*
	login: function(){
		//alert('user의 save 함수 호출됨');
		let data = {
			username:$("#username").val(),
			password:$("#password").val()
		}
		
		$.ajax({
			type:"POST",
		    url: "/api/user/login", 
		    data:JSON.stringify(data),  
		    contentType:"application/json; charset=utf-8",   //body데이터가 어떤 타입인지(MIME)
		    dataType: "json" //요청을 서버로 해서 응답이 왔을때 기본적으로 모든 것이 문자열(생긴게 json이라면) => javascrtip 오브젝트로 변경 
		})
		// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
		.done(function(resp) {
		    alert("로그인이 완료되었습니다.");
			location.href="/";
		})
		// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
		.fail(function(error) {
		     alert(JSON.stringify(error));
		});
	
	}
	*/
}

index.init();