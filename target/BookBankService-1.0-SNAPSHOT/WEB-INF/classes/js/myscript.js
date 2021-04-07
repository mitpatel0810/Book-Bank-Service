'use strict';


//$(document).ready(function(){
//    $('#loginButton').click(function(){
//        var email = $('#email').val();
//        var password = $('#password').val();
//        $.ajax({
//            type:'POST',
//            data: {
//                email : email,
//                password : password
//            },
//            url : '/LoginServlet',
//            success : function(response){
//                $('#errorMsg').append(response);
//            }
//        });
//
//    });
//    
//    $('#registerButton').click(function(){
//    	var name = $('#name').val();
//        var email = $('#email').val();
//        var password = $('#password').val();
//        $.ajax({
//            type:'POST',
//            data: {
//            	name : name,
//                email : email,
//                password : password
//            },
//            url : '/RegistrationServlet',
//            success : function(response){
//                $('#errorMsg').html(response);
//            }
//        });
//
//    });
//
//});


$(function() {
	$("input[type='password'][data-eye]").each(function(i) {
		var $this = $(this),
			id = 'eye-password-' + i,
			el = $('#' + id);

		$this.wrap($("<div/>", {
			style: 'position:relative',
			id: id
		}));

		$this.css({
			paddingRight: 60
		});
		$this.after($("<div/>", {
			html: 'Show',
			class: 'btn btn-primary btn-sm',
			id: 'passeye-toggle-'+i,
		}).css({
				position: 'absolute',
				right: 10,
				top: ($this.outerHeight() / 2) - 12,
				padding: '2px 7px',
				fontSize: 12,
				cursor: 'pointer',
		}));

		$this.after($("<input/>", {
			type: 'hidden',
			id: 'passeye-' + i
		}));

		var invalid_feedback = $this.parent().parent().find('.invalid-feedback');

		if(invalid_feedback.length) {
			$this.after(invalid_feedback.clone());
		}

		$this.on("keyup paste", function() {
			$("#passeye-"+i).val($(this).val());
		});
		$("#passeye-toggle-"+i).on("click", function() {
			if($this.hasClass("show")) {
				$this.attr('type', 'password');
				$this.removeClass("show");
				$(this).removeClass("btn-outline-primary");
			}else{
				$this.attr('type', 'text');
				$this.val($("#passeye-"+i).val());
				$this.addClass("show");
				$(this).addClass("btn-outline-primary");
			}
		});
	});

	$(".my-login-validation").submit(function() {
		var form = $(this);
        if (form[0].checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
		form.addClass('was-validated');
	});
});

