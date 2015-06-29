
var isError = new Array(0, 0, 0, 0, 0, 0);
/**
 * 常用的公共JS类
 * 
 */
Common = new function() {
	var _this = this;

	/**
	 * 指定位置显示
	 */
	$.extend($.messager, {
		showBySite : function(options, param) {
			var site = $.extend({
				left : "",
				top : "",
				right : 0,
				bottom : -document.body.scrollTop
						- document.documentElement.scrollTop
			}, param || {});
			var win = $("body > div .messager-body");
			if (win.length <= 0)
				$.messager.show(options);
			win = $("body > div .messager-body");
			win.window("window").css({
				left : site.left,
				top : site.top,
				right : site.right,
				zIndex : $.fn.window.defaults.zIndex++,
				bottom : site.bottom
			});
		}
	});

	this.showBySite = function(param1Tit, param2Msg) {
		$.messager.showBySite({
			title : param1Tit,
			msg : param2Msg,
			showType : 'slide',
			timeout : 2000
		}, {
			top : 0,
			left : ($(document.body).width() / 2 - 100),
			bottom : ""
		});
	};
};

/**
 * 	表单校验 操作类
 */
var storeReg = {
		"init" : function() {
			// 店铺名称校验
			$(document).on('blur',".s-title",  function() {
				$(this).siblings(".error").remove();
				if (storeReg.isEmpty(this)) {
					storeReg.appendInfo(this, "店铺名称不能为空!");
					isError[0] = 0;
					return;
				} else if (!storeReg.lengthCheck(this,5, 15)) {
					storeReg.appendInfo(this, "请输入5-15个汉字  !");
					isError[0] = 0;
					return;
				} 
				$(this).siblings(".error").remove();
				storeReg.toNormal(this);
				isError[0] = 1;
			});
			// 店铺地址校验
			$(document).on('blur',".s-content", function() {
				$(this).siblings(".error").remove();
				if (storeReg.isEmpty(this)) {
					storeReg.appendInfo(this, "店铺地址不能为空!");
					isError[1] = 0;
					return;
				} else if (!storeReg.lengthCheck(this,5, 50)) {
					storeReg.appendInfo(this, "请输入5-50个汉字  !");
					isError[1] = 0;
					return;
				} 
				$(this).siblings(".error").remove();
				storeReg.toNormal(this);
				isError[1] = 1;
			});
			// 提交表单
			$(document).on('click',"#send",  function() {
				$(".s-title").trigger("blur");
				$(".s-content").trigger("blur");
				var flag = true;
				for ( var i = 0; i <= 6; i++) {
					if (isError[i] == 0) {
						flag = false;
					}
				}
				if (flag) {
					$("#form_rec").ajaxFormUnbind();
					/*if($("#send").attr("data-modify") == "true"){
						$("#form_rec").attr("action",$("#form_rec").attr("action").replace("_imgUpload","_update"));
					}else{*/
						//$("#form_rec").attr("action",$("#form_rec").attr("action").replace("_imgUpload","_add"));
					//}
					var sendData = $("#form_rec").serialize();
					ajax($("#form_rec").attr("action"),sendData,function(data){
						if(data=="error"){
							alert("表单中含有未知错误,请重试 !");
						}else{
							/*if($("#send").attr("data-modify") == "true"){
								alert("修改成功！");
							}else{*/
								alert("发布成功！");
								location.href = $.trim($("#projectName").val()) + '/article/allArticle.jsp';
							//}
						}
					});
				}else{
					alert("您的表单中包含一些错误 ！");
				}
			});

		},
		"isEmpty" : function(input) {
			if ($.trim($(input).val()).length > 0) {
				return false;
			} else {
				return true;
			}
		},
		"isEmail" : function(input) {
			return /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/.test($(input).val());
		},
		"passwordLevel" : function(input) {

		},
		"isPwdSame" : function(input) {
			if ($.trim($(".J-pwd").val()) == $.trim($(input).val())) {
				return true;
			} else {
				return false;
			}
		},
		"lengthCheck" : function(input, min, max) {
			if ($.trim($(input).val()).length >= min
					&& $.trim($(input).val()).length <= max) {
				return true;
			} else {
				return false;
			}
		},
		"isNum" : function(value) {
			return isNaN($.trim(value));
		},
		// 增加错误信息
		"appendInfo" : function(input, info) {
			$(input).css("border", "rgb(247,97,32) 1px solid");
			$(input)
					.after(
							"<span class='error J-unitive-tip unitive-tip' style='color:#393939'><i class='fa fa-times-circle fa-lg' style='color:#F76120;'></i>&nbsp;"
									+ info + "</span>");
		},
		// 返回原状态
		"toNormal" : function(input) {
			$(input).css("border", "rgb(170,170,170) 1px solid");
		}
	};

var pwdReg = {
		"init" : function() {
			// 店铺名称校验
			$(document).on('blur',".s-oldPwd",  function() {
				$(this).siblings(".error").remove();
				if (storeReg.isEmpty(this)) {
					storeReg.appendInfo(this, "原来密码不能为空!");
					isError[0] = 0;
					return;
				} else if (!storeReg.lengthCheck(this,6, 12)) {
					storeReg.appendInfo(this, "请输入6-12个字符  !");
					isError[0] = 0;
					return;
				} 
				$(this).siblings(".error").remove();
				storeReg.toNormal(this);
				isError[0] = 1;
			});
			// 店铺地址校验
			$(document).on('blur',".s-newPwd", function() {
				$(this).siblings(".error").remove();
				if (storeReg.isEmpty(this)) {
					storeReg.appendInfo(this, "新的密码不能为空!");
					isError[1] = 0;
					return;
				} else if (!storeReg.lengthCheck(this,6, 12)) {
					storeReg.appendInfo(this, "请输入6-12个字符  !");
					isError[1] = 0;
					return;
				} 
				$(this).siblings(".error").remove();
				storeReg.toNormal(this);
				isError[1] = 1;
			});
			$(document).on('blur',".s-rePwd", function() {
				$(this).siblings(".error").remove();
				if (storeReg.isEmpty(this)) {
					storeReg.appendInfo(this, "确认密码不能为空!");
					isError[2] = 0;
					return;
				} else if (!storeReg.lengthCheck(this,6, 12)) {
					storeReg.appendInfo(this, "请输入6-12个字符  !");
					isError[2] = 0;
					return;
				} 
				$(this).siblings(".error").remove();
				storeReg.toNormal(this);
				isError[2] = 1;
			});
			// 提交表单
			$(document).on('click',"#send",  function() {
				$(".s-oldPwd").trigger("blur");
				$(".s-newPwd").trigger("blur");
				$(".s-rePwd").trigger("blur");
				var flag = true;
				for ( var i = 0; i <= 6; i++) {
					if (isError[i] == 0) {
						flag = false;
					}
				}
				if (flag) {
					$("#form_rec").ajaxFormUnbind();
					var sendData = $("#form_rec").serialize();
					ajax($("#form_rec").attr("action"),sendData,function(data){
						if(data=="error"){
							alert("表单中含有未知错误,请重试 !");
						}else{
							alert("发布成功！");
							location.href = $.trim($("#projectName").val()) + '/article/allArticle.jsp';
						}
					});
				}else{
					alert("您的表单中包含一些错误 ！");
				}
			});

		},
		"isEmpty" : function(input) {
			if ($.trim($(input).val()).length > 0) {
				return false;
			} else {
				return true;
			}
		},
		"isEmail" : function(input) {
			return /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/.test($(input).val());
		},
		"passwordLevel" : function(input) {

		},
		"isPwdSame" : function(input) {
			if ($.trim($(".J-pwd").val()) == $.trim($(input).val())) {
				return true;
			} else {
				return false;
			}
		},
		"lengthCheck" : function(input, min, max) {
			if ($.trim($(input).val()).length >= min
					&& $.trim($(input).val()).length <= max) {
				return true;
			} else {
				return false;
			}
		},
		"isNum" : function(value) {
			return isNaN($.trim(value));
		},
		// 增加错误信息
		"appendInfo" : function(input, info) {
			$(input).css("border", "rgb(247,97,32) 1px solid");
			$(input)
					.after(
							"<span class='error J-unitive-tip unitive-tip' style='color:#393939'><i class='fa fa-times-circle fa-lg' style='color:#F76120;'></i>&nbsp;"
									+ info + "</span>");
		},
		// 返回原状态
		"toNormal" : function(input) {
			$(input).css("border", "rgb(170,170,170) 1px solid");
		}
	};

/**
 * 图片上传js类
 * 
 */
var file_control =  {
	"init":function(){
		$(document).on('change',"#file_upload",function(){
			if($.trim($("#file_upload").val()) == ""){
				return;
			}
			$(".loading").show();
			$(".photo").hide();
			$("#form_rec").ajaxFormUnbind();
			$("#form_rec").ajaxForm({
				url : $("#form_rec").attr("action"), // 请求的url
				type : "post", // 请求方式
				dataType : "json", // 响应的数据类型
				async :true, // 异步
				success : function(data){
					$("#img").attr("src","/shop/images/"+data);
					data = data.substr(data.indexOf("temp/")+5);
					$("#pic_name").val(data);
					$(".loading").hide();
					$(".photo").show();
				},
				error : function(msg){
					alert("error:"+msg);
					$(".loading").hide();
					$(".photo").show();
				}
			});
			$("#form_rec").attr("enctype", "multipart/form-data");
			$("#form_rec").submit();
		});
		$(document).on('click',".photo",function(){
			$("#file_upload").trigger("click");
		});
	}
}

/**
 * 	表单校验
 */
var publishIsError = new Array(0, 0, 0);
var publishReg = {
	"init" : function() {
		// 增加规格
		$(document).on('click',".add", function() {
			if($("tr").length>=10){
				alert("对不起，最多设置 10 个 规格哦");
				return;
			}
			var standard = $(".standard").val();
			var price = $(".standard_price").val();
			if(publishReg.isEmpty($(".standard"))){
				alert("规格名称不能为空哦");
				$(".standard").css("border","solid 1px red");
				$(".standard").focus();
				return;
			}
			if(publishReg.isEmpty($(".standard_price"))){
				alert("价格不能为空哦");
				$(".standard_price").css("border","solid 1px red");
				$(".standard_price").focus();
				return;
			}else{
				if(publishReg.isNum(price)){
					alert("价格只能输入数字哦");
					$(".standard_price").css("border","solid 1px red");
					$(".standard_price").focus();
					return;
				}
			}
			$("table").append("<tr class='close_wrap' data='"+standard+"$"+price+"'><td>"+standard+"</td><td>&nbsp;&nbsp;"+price+" 元</td><td><span class='close'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;X&nbsp;</span></td></tr>");
		});
		// 关闭
		$(document).on('click',".close", function() {
			$(this).parent().parent().remove();
		});
		$(document).on('blur',".standard_price",function() {
			$(this).css("border","solid 1px #e5e5e5");
		});
		$(document).on('blur',".standard", function() {
			$(this).css("border","solid 1px #e5e5e5");
		});
		// 菜名校验
		$(document).on('blur',".v-name", function() {
			$(this).siblings(".error").remove();
			if (publishReg.isEmpty(this)) {
				publishReg.appendInfo(this, "菜名不能为空!");
				publishIsError[0] = 0;
				return;

			} else if (!publishReg.lengthCheck(this,2, 15)) {
				publishReg.appendInfo(this, "2-15个汉字  !");
				publishIsError[0] = 0;
				return;
			} 
			$(this).siblings(".error").remove();
			publishIsError[0] = 1;
			publishReg.toNormal(this);
		});
		// 现价校验
		$(document).on('blur',".price", function() {
			$(this).siblings(".error").remove();
			if (publishReg.isEmpty(this)) {
				publishReg.appendInfo(this, "现价不能为空 !");
				publishIsError[1] = 0;
				return;
			}else if(publishReg.isNum($(this).val())){
				publishReg.appendInfo(this, "含有非法字符 !");
				publishIsError[1] = 0;
				return;
			}else {
				publishIsError[1] = 1;
				publishReg.toNormal(this);
			}
		});
		// 原价校验
		$(document).on('blur',".origin",  function() {
			$(this).siblings(".error").remove();
			if (publishReg.isNum($(this).val())){
				publishReg.appendInfo(this, "含有非法字符 !");
				return;
			} else {
				publishReg.toNormal(this);
			}
		});
		// 单位校验
		$(document).on('blur',".unit", function() {
			$(this).siblings(".error").remove();
			if (publishReg.isEmpty(this)) {
				publishReg.appendInfo(this, "单位不能为空 !");
				publishIsError[2] = 0;
				return;
			}else if(publishReg.isNum($(this).val())){
				publishReg.appendInfo(this, "含有非法字符 !");
				publishIsError[2] = 0;
				return;
			}else {
				publishIsError[2] = 1;
				publishReg.toNormal(this);
			}
		});
		// 提交表单
		$(document).on('click',"#send", function() {
			$(".v-name").trigger("blur");
			$(".price").trigger("blur");
			$(".origin").trigger("blur");
			$(".unit").trigger("blur");
			var flag = true;
			for ( var i = 0; i <= 2; i++) {
				if (publishIsError[i] == 0) {
					flag = false;
				}
			}
			if (flag) {
				$("#form_rec").ajaxFormUnbind();
				if($("#send").attr("data-modify") == "true"){
					$("#form_rec").attr("action",$("#form_rec").attr("action").replace("_imgUpload","_update"));
				}else{
					$("#form_rec").attr("action",$("#form_rec").attr("action").replace("_imgUpload","_add"));
				}
				// standard data
				var temp = "";
				if($("tr").length > 0){
					$("tr").each(function(){
						temp += $(this).attr("data") + "@";
					});
					temp = temp.substring(0, temp.length-1);
				}
				var sendData = $("#form_rec").serialize() + "&standard="+temp;
				ajax($("#form_rec").attr("action"),sendData,function(data){
					if(data=="error"){
						alert("表单中含有未知错误,请重试 !");
					}else{
						if($("#send").attr("data-modify") == "true"){
							alert("修改成功！");
						}else{
							alert("发布成功！");
							location.reload();
						}
					}
				});
				
			}else{
				alert("您的表单中包含一些错误 ！");
			}
		});

	},
	"isEmpty" : function(input) {
		if ($.trim($(input).val()).length > 0) {
			return false;
		} else {
			return true;
		}
	},
	"isEmail" : function(input) {
		return /^[\w\-\.]+@[\w\-\.]+(\.\w+)+$/.test($(input).val());
	},
	"passwordLevel" : function(input) {

	},
	"isPwdSame" : function(input) {
		if ($.trim($(".J-pwd").val()) == $.trim($(input).val())) {
			return true;
		} else {
			return false;
		}
	},
	"lengthCheck" : function(input, min, max) {
		if ($.trim($(input).val()).length >= min
				&& $.trim($(input).val()).length <= max) {
			return true;
		} else {
			return false;
		}
	},
	"isNum" : function(value) {
		return isNaN($.trim(value));
	},
	// 增加错误信息
	"appendInfo" : function(input, info) {
		$(input).css("border", "rgb(247,97,32) 1px solid");
		$(input)
				.after(
						"<span class='error J-unitive-tip unitive-tip' style='color:#393939'><i class='fa fa-times-circle fa-lg' style='color:#F76120;'></i>&nbsp;"
								+ info + "</span>");
	},
	// 返回原状态
	"toNormal" : function(input) {
		$(input).css("border", "rgb(170,170,170) 1px solid");
	}
};

/**
 * 	表格操作
 */

var table = {
	"init":function(){
		// tr点击
		table.trClick();
		// 全选操作
		$(".all").click(function(){
			if($(this).text() == "全不选"){
				$(this).text("全选");
				$(":checkbox").prop('checked',false);
			}else{
				$(this).text("全不选");
				$(":checkbox").prop('checked',true);
			}
		});
		// 修改
		$(document).on('click',".modify", function(){
			$("#create-user").trigger("click");
			
			var id = $(this).attr("data-id");
			var val = $.trim($(this).parent().parent().siblings("td[id='data-name']").text());
			$("#name").val(val);
			mode = "modify";
			params[0] = id;
		});
		// 删除全部
		$(document).on('click',".delete", function(){
			if($(":checkbox[checked='true']").length ==0){
				alert("请选择删错类目");
				return;
			}
			if(confirm("确定删除？此操作将不可恢复")){
				var sendData = "";
				$(":checkbox[checked='true']").each(function(){
					sendData += "foodCateids="+$(this).val()+"&";
				});
				sendData = sendData.substring(0, sendData.length-1);
				
				ajax(projName+"/shop_center/TakeoutFoodCate_delete",sendData,function(data){
					if(data=="error"){
						alert("发生未知错误,请重试 !");
					}else{
						location.reload();
					}
				});
			}
		});
		// 删除单个
		$(document).on('click',".delete_item", function(){
			if(confirm("确定删除？此操作将不可恢复")){
				var id = $(this).attr("data-id");
				ajax(projName+"/shop_center/TakeoutFoodCate_delete",{foodCateids:id},function(data){
					if(data=="error"){
						alert("发生未知错误,请重试 !");
					}else{
						location.reload();
					}
				});
			}
		});
	},
	"trClick":function(){
		$("tr").unbind("click");
		$("tr").click(function(){
			if($(this).children().children(".checkbox:first").prop('checked')){
				$(this).children().children(".checkbox:first").removeAttr("checked");
			}else{
				$(this).children().children(".checkbox:first").prop('checked',true);
			}
		});
	}
};

/**
 * ajax 通用方法
 */

function ajax(url,senddata,handler){
	$.ajax({
		url : url, // 请求的url
		type : "post", // 请求方式
		data:senddata,
		timeout:5000,
		dataType : "json", // 响应的数据类型
		async :false, // 异步
		success : handler,
		error : function(msg){
			/*var data = "";
			$.each(msg,function(index,obj){
				data += obj;
			});*/
			alert("系统错误 ！" + msg);
		},
		complete : function(XMLHttpRequest,status){
			if(status=='timeout'){
				ajaxTimeoutTest.abort();
				alert("请求超时，请检查网络状态！");
			}
		}
	});
}
// Logout
$(document).ready(function(){
	$(".logout").click(function(){
		var proj = $("#projName").val();
		ajax(proj+"/user/Login_logout",{username:$("#login").attr("data-value")},function(data){
			if(data == "ok"){
				$("#login").attr("data-flag","off");
				$("#popUserInfoId").hide();
				$("#login").removeClass("mn-lk");
				$("#login").text("登录");
			}
		});
	});
});
/**
 * ajax 搜索提示栏  用法
 * var searchSuggest =  new oSearchSuggest(inputId,suggestId);
 */
function oSearchSuggest(inputId,suggestId){
var input = $("#"+inputId);
var suggestWrap = $("#"+suggestId);
var key = "";
var init = function(){
	$(document).on('keyup',input, sendKeyWord);
	$(document).on('blur',input, function(){setTimeout(hideSuggest,100);});
}
var hideSuggest = function(){
	suggestWrap.hide();
}
var searchFun = function(keyword){
	var url="http://api.map.baidu.com/place/v2/suggestion?query=1&region=%E5%85%A8%E5%9B%BD&ak=qrv9QyGyarHcECg2IW63cvGx&output=json&jsoncallback=?";
	var queryValue = keyword;
	var regionValue = "全国";
	var akValue = "qrv9QyGyarHcECg2IW63cvGx";
	var outputValue = "json";
	$.ajax({
		url:"http://api.map.baidu.com/place/v2/suggestion?query="+queryValue+"&region="+regionValue+"&ak="+akValue+"&output="+outputValue,
		dataType: "jsonp",
		jsonp: "callback",
		success: function (data) {
			var aData = [];
			var length = 0;
			length = data.result.length;
			for(var i = 0; i < length; i++){
				aData.push(data.result[i].name);
			}
			//将返回的数据传递给实现搜索输入框的输入提示js类
			dataDisplay(aData);
		}
	});
}

//发送请求，根据关键字到后台查询
var sendKeyWord = function(event){
	
	//键盘选择下拉项
	if(suggestWrap.css('display')=='block'&&event.keyCode == 38||event.keyCode == 40){
		var current = suggestWrap.find('li.hover');
		if(event.keyCode == 38){
			if(current.length>0){
				var prevLi = current.removeClass('hover').prev();
				if(prevLi.length>0){
					prevLi.addClass('hover');
					input.val(prevLi.html());
				}
			}else{
				var last = suggestWrap.find('li:last');
				last.addClass('hover');
				input.val(last.html());
			}
			
		}else if(event.keyCode == 40){
			if(current.length>0){
				var nextLi = current.removeClass('hover').next();
				if(nextLi.length>0){
					nextLi.addClass('hover');
					input.val(nextLi.html());
				}
			}else{
				var first = suggestWrap.find('li:first');
				first.addClass('hover');
				input.val(first.html());
			}
		}
		
	//输入字符
	}else{ 
		var valText = $.trim(input.val());
		if(valText ==''||valText==key){
			return;
		}
		searchFun(valText);
		key = valText;
	}			
	
}
//请求返回后，执行数据展示
var dataDisplay = function(data){
	if(data.length<=0){
        suggestWrap.hide();
		return;
	}
	
	//往搜索框下拉建议显示栏中添加条目并显示
	var li;
	var tmpFrag = document.createDocumentFragment();
	suggestWrap.find('ul').html('');
	for(var i=0; i<data.length; i++){
		li = document.createElement('LI');
		li.innerHTML = data[i];
		tmpFrag.appendChild(li);
	}
	suggestWrap.find('ul').append(tmpFrag);
	suggestWrap.show();
	
	//为下拉选项绑定鼠标事件
	suggestWrap.find('li').hover(function(){
			suggestWrap.find('li').removeClass('hover');
			$(this).addClass('hover');
	
		},function(){
			$(this).removeClass('hover');
		}).bind('click',function(){
		input.val(this.innerHTML);
		suggestWrap.hide();
	});
	}
	init();
};

var getNODealOrderCount = {
	"init" : function() {
		$(".InfoTip").click(function(){getNODealOrderCount.slideTop()});
		getNODealOrderCount.doGet();
	},	
	"slideTop" : function() {
		location.href = $("#projectName").val()+'/shop_center/Order?status=8';
	},	
	"doGet" : function() {
		window.setInterval(function(){
			$.get($("#projectName").val()+"/shop_center/Order_getCount?status=8",
				    function(data) {
				    	data = data.replace("\"","").replace("\"","");
				    	if($.trim($("#amount").val())*1 < data * 1){
				    		$(".InfoTip").animate({
				    	    	top: "0"
				    	 	},400,'swing',null);
				    		$("embed").show();
				    	}else{
				    		;
				    	}
				});
		},10000);  
	}
}
/**
 * 用户订单类
 */
//店铺页面  用户收藏操作类
var userOrder = {
	"init" : function() {
		$(document).on('click',".comment-order", function(){
			userOrder.open_comment_dialog($(this));
		});
		$(".dialog-btn-close").click(function() {
			userOrder.close_comment_dialog($(this));
		});
		$(".confrim-btn").click(function() {
			var content = $("#context").val();
			var rank = $(".result").text();
			var deliveryTime =  $(".deliveryTime").val();
			var shopId =  $(".shopId").val();
			var orderIdForshop =  $(".orderId").text();
			userOrder.commit_comment($(this),content,rank,deliveryTime,shopId,orderIdForshop);
		});
		$(".dialog-btn-cancel").click(function() {
			userOrder.close_comment_dialog($(this));
		});
		userOrder.rat('star', 'result', 1);
	},
	"commit_comment" : function(temp,content,rank,deliveryTime,shopId,orderIdForshop) {	//提交评论窗口
		$.post(
			projName+"/user_center/Order_addComment?",
			{ 
				"comment.content": content,
				"comment.commentRank": rank,
				"comment.deliveryTime": deliveryTime,
				"comment.shopId": shopId,
				"comment.orderId": orderIdForshop
			},     
			function (data, textStatus){   
				if(data.success == true){
					alert("成功");
					location.replace(location.href);
				}else{
					alert(data.data);
				}	
			},
			"json"
		);
	},
	"open_comment_dialog" : function(temp) {	//打开评论窗口
		var data = temp.attr("data");
		var strList = data.split("$");
		var name = strList[0];
		var orderId = strList[1];
		var datatime = strList[2];
		var shopId = strList[3];
		$(".shopName").text(name);
		$(".orderId").text(orderId);
		$(".dataTime").text(datatime);
		$(".shopId").val(shopId);
		$("#context").val("");
		$(".dialog-shadow").fadeIn();context
		$(".ui-confirm-uc").slideDown(300);
	},
	"close_comment_dialog" : function(temp) {  //关闭评论窗口
		$(".ui-confirm-uc").slideUp(300);
		$(".dialog-shadow").fadeOut();
		userOrder.rat('star', 'result', 1);
		$(".shopId").val("");
		$("#context").val("");
	},
	"cancle_order" : function(temp) {  //取消订单
		$.post(
			projName+"/user_center/Order_toCancle?",
			{ 
				"orderId": orderIdForshop
			},     
			function (data, textStatus){   
				if(data.success == true){
					alert("成功");
					location.replace(location.href);
				}else{
					alert(data.data);
				}	
			},
			"json"
		);
	},
	"delivery_order" : function(temp) {  //确认收货
		$.post(
			projName+"/user_center/Order_toConfirm?",
			{ 
				"orderId": orderIdForshop
			},     
			function (data, textStatus){   
				if(data.success == true){
					alert("成功");
					location.replace(location.href);
				}else{
					alert(data.data);
				}	
			},
			"json"
		);
	},
	"pay_order" : function(temp) {  //去付款
		
	},
	"rat": function (star, result, m) {  //评分
		star = '#' + star;
		result = '#' + result;
		$(result).hide(); //将结果DIV隐藏
		$(star).raty({
			hints: ['1', '2', '3', '4', '5'],
			path: projName,
			starOff: "img/star-off-big.png",
			starOn: '/img/star-on-big.png',
			size: 24,
			start: 40,
			showHalf: true,
			target: result,
			targetKeep: true, //targetKeep 属性设置为true，用户的选择值才会被保持在目标DIV中，否则只是鼠标悬停时有值，而鼠标离开后这个值就会消失
			click: function(score, evt) {
			//第一种方式：直接取值
			//最后的评分为score*m
			//隐藏在result div中
				$(".rank-text").removeClass("hide");
				var r_case = $(".result").text();
				switch(r_case){
					case "1":
					case "2":$(".rank-text").text("差评");
					break;
					case "3":$(".rank-text").text("中评");
					break;
					case "4":
					case "5":$(".rank-text").text("好评");
					break;
				}
			}
		});
	}
};

var financial = {
		"init":function(){
			$("#submitPay").click(function(){
				if($.trim($("#orderId").val()).length == 0){
					return ;
				}
				ajax($("#projName").val() + "/takeout/Payway_toAlipay",{orderId:$("#orderId").val()},function(msg){
					if(msg == "error"){
						alert("未知错误，提交失败");
					}else{
						window.open(msg,'_blank');
						// redirect to myOrder
						location.href = $("#projName").val()+"/user_center/Order";
					}
				});
			});
			financial.bindToPay();
			financial.bindCancel();
		},
		"bindToPay":function(){
			$(".toPay").click(function(){
				var data = $(this).attr("data-id");
				ajax($("#projName").val() + "/takeout/Payway_toAlipay",{orderId:data},function(msg){
					if(msg == "error"){
						alert("未知错误，提交失败");
					}else{
						window.open(msg,'_blank');
					}
				});
			});
		},
		"bindCancel":function(){
			$(".toCancle").click(function(){
				var datas = $(this).attr("data").split("$");
				ajax($("#projName").val() + "/user_center/Order_toCancle",{orderId:datas[1]},function(data){
					if(data.success == true){
						alert("成功取消订单");
						location.reload();
					}else{
						alert(data.data);
					}	
				});
			});
		}
};