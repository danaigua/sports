            layui.use('form', function(){
				var form = layui.form;
				// 学院
		    	$.post("/admin/college/combobox",
		    	    	{},
		    	    	function (res) {
		    	    		for(let prop in res) {
		    	    	    		$(".form-theme").eq(0).append(`<option value=` + res[prop] + `>` + res[prop] +`</option>`)
		    	    		};
		    	    		form.render();
		    	 });
		    	// 系部
		    	$.post("/admin/department/combobox",
		    	    	{},
		    	    	function (res) {
		    	    		for(let prop in res) {
		    	    	    		$(".form-theme").eq(1).append(`<option value=` + res[prop] + `>` + res[prop] +`</option>`)
		    	    		};
		    	    		form.render();
		    	    	});
                form.render('select');   //表单渲染，得渲染才会有效果显示出来
            })
var info = $(".form-infor"); // 学生个人信息条
let tipText = $(".text-content"); // 提示框文本
let addCode =
	`<div class="form-infor">
							<ul class="row">
								<li class="col-md-3 text-center input-first"><i class="number addInfo">1</i><input type="text" class="layui-input" id="exampleInputName2"
									 placeholder="姓名"></li>
								<li class="col-md-3 text-center"><input type="text" class="layui-input" id="exampleInputName2" placeholder="班级"></li>
								<li class="col-md-3 text-center"><input type="text" class="layui-input" id="exampleInputName2" placeholder="年级"></li>
								<li class="col-md-1 text-center">
									<input list="browsers" class="form-control">
									<datalist id="browsers">
										<option value="男">
										<option value="女">
									</datalist>
								</li>
								<li class="col-md-2 text-center add-box">
									<i class="addInfo add" onclick="addStudent(this)">+</i>
									<i class="addInfo conneClear" onclick="conneClear(this)">-</i>
								</li>
							</ul>
						</div>`;
let addButton = `<i class="addInfo add" onclick="addStudent(this)">+</i>`;
let valueArr = []; // 定义一个预先存储所有学生个人信息的数组，当为空的时候不能赋值给infoArr
let infoArr = []; //定义一个存储所有学生个人信息的数组
let commonInfo = [];
let contrast = []; // 定义一个对比存储学生信息的数组，用于提交学生信息后再次修改提交，弹出提交提示框
let tip = $(".tip"); // 提示框
let infoObj = {
	address : "", //校区
	college : "", // 系部
	department : "", // 领队
};

function preserInfo() { // 当用户点击保存时，把所有的数据保存
	let info = $(".form-theme");
	for(let i = 0; i < info.length; i++) {
		if(info.eq(i).val() != "") {
			if (i === 0) {
				infoObj.college = info.eq(i).val();
			} else if (i === 1) {
				infoObj.department = info.eq(i).val();
			} else if (i === 2) {
				infoObj.address = info.eq(i).val();
			}
		};
	};
	//valueArr.push(infoObj)
	commonInfo.push(infoObj)
	for (var i = 0; i < $(".form-infor").length; i++) {
		let flag = true; // 判断学生信息是否填写完整
		var valueObj = {
			trueName: "", // 姓名
			clazz: "", // 班级
			grade: "", // 年级
			sexName: "" // 性别
		}; // 定义一个存储个人学生信息的对象
		var infoValue = $(".form-infor").eq(i).find(".layui-input");
		for (var j = 0; j < infoValue.length; j++) { // 遍历学生姓名，班级，年级，性别
			if (infoValue.eq(j).val() != "") { // 当不为空时，直接赋值
				console.log("第二次赋值的对比数组=", contrast);
				if (j === 0) {
					valueObj.trueName = infoValue.eq(j).val();
				} else if (j === 1) {
					valueObj.clazz = infoValue.eq(j).val();
				} else if (j === 2) {
					valueObj.grade = infoValue.eq(j).val();
				} else if (j === 3) {
					valueObj.sexName = infoValue.eq(j).val();
				}
			} else { // 当有空没填写时
				flag = false; // 预数组不存信息
				infoValue.eq(j).css({ // 把为空的输入框变成红色
					"border": "1px solid #f00",
					"box-shadow": "0 0 5px #f00"
				});
				infoValue.eq(j).focus(function() { // 给变红的输入框添加聚焦事件，当聚焦时恢复原来的样式
					$(this).css({
						"border": "1px solid #ccc",
						"box-shadow": "none"
					})
				});
				alert("学生信息未完善！"); // 并提示未填写
				break; // 跳出小循环
			};
		};
		if (flag) { // 如果填写完整，则放进预数组；
			valueArr.push(valueObj); // 把个人的学生信息放进数组
		} else { // 不完整，则清空预数组，并跳出循环
			valueArr = [];
			break;
		}
	};
	if (valueArr.length != 0) { // 当预数组不为空时，赋值给学生信息数组
		infoArr = [...valueArr];
		tip.css("display", "block"); // 提示框显示
		background.css("display", "block"); // 背景虛化
	};
	console.log(infoArr);
	console.log(commonInfo);
	contrast = [...valueArr]; // 赋值给对比用得数组
};

// 添加元素事件
function addStudent(obj) {
	$(obj).text("-"); // 改变内容
	$(obj).attr({ // 添加删除事件
		"onclick": "clearTab(this)"
	}); // 删除信息
	$(obj).parents(".form-infor").after(addCode); // 添加信息html
	$(obj).parents(".form-infor").next().find(".number").text(parseInt($(obj).parents(".form-infor").find(".number").text()) +
		1); // 变化序列号1，2，3...
	$(obj).next().remove(); // 删除旧的删除按钮
};

// 删除元素事件
function clearTab(obj) {
	var infoNum = $(".form-infor").length;
	$(obj).parents(".form-infor").remove(); // 删除元素
	// $(".form-infor").last().find(".addInfo").click(addStudent); // 给最后一个加号添加事件
	for (let i = 0; i < infoNum; i++) { // 当删除时重新给序列号排序
		$(".form-infor").eq(i).find(".number").text(i + 1);
	};
	if($(".form-infor").length === 1) {
		$(".form-infor").eq(0).find(".conneClear").remove()
	};
}
// 在增加旁边得删除事件
function conneClear(obj) {
	if($(".form-infor").length >= 3) {
		$(obj).parents(".form-infor").prev().find(".add").attr("onclick","conneClear(this)"); // 给上一个的删除键添加事件
		$(obj).parents(".form-infor").prev().find(".add-box").prepend(addButton); // 给上一个信息条增加添加按钮
	} else {
		$(obj).parents(".form-infor").prev().find(".add").attr("onclick","addStudent(this)"); // 给上一个的删除键添加增加事件
		$(obj).parents(".form-infor").prev().find(".add").text("+");// 给上一个的删除键添加增 "+"文本
	}
	clearTab(obj); // 执行正常的删除
};
$(".preservation").click(preserInfo); // 提交表单按钮添加点击事件



let boxSpaing = $(".box-spaing"); // 提示框的保存，取消按钮
let close = $(".closeIcon"); // 关闭小图标
let background = $(".background"); // 背景虚化
let prog = $(".progress"); // 进度条
// 当点击取消，关闭小图标时，关闭提示框-----> 清空数组
function closeTip() {

	let infoNum = $(".form-infor");
	tip.css("display", "none");
	background.css("display", "none");
	valueArr = []; // 当点击时清空预存数组
	infoArr = []; // 当点击关闭时清空数组

	//提交信息提示框
	tipText.html("是否提交名单 ?");
	$(".submitName").text("确定"); // 按钮换功能，跳转到确定文本
	$(".submitName").attr({
		"data-type": "loading",
		"onclick": ""
	});


	for (let i = 0; i < infoNum.length; i++) { // 清空学生信息
		if (i !== 0) { // 不是第一条时清空
			infoNum.eq(i).remove();
		} else { // 第一条时添加事件
			infoNum.eq(i).find(".add").text("+");
			infoNum.eq(i).find(".add").attr("onclick", "addStudent(this)");
			for (let j = 0; j < infoNum.eq(i).find(".layui-input").length; j++) { // 遍历第一条学生信息，清空
				console.log(infoNum.eq(i).find(".layui-input").length)
				infoNum.eq(i).find(".layui-input").eq(j).val("");
			}
		}
	};
};

// 跳转到下一步页面
function next() {
	window.location.href = "project.html";
};

// 进度条
layui.use('element', function() {
	var $ = layui.jquery,
		element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

	//触发事件
	var active = {
		loading: function(othis) {
			$.post("/admin/student/save",{
				collegeName:commonInfo[0].college,
				departmentName : commonInfo[0].department,
				address:commonInfo[0].address,
				studentJson:JSON.stringify(valueArr)},function(res){
					if(!res.success){
						alert(res.errorInfo);
					}
			});
			// 当提示框消失时，解除下一步按钮得禁用，清空学生信息
			$(".next").attr({
				"class": "next",
				"onclick": "next()"
			}); // 解除下一步按钮得禁用
			$(".next").css({ // 下一步按钮样式改变
				"background": "#f07029",
				"color": "#fff"
			});
			let sum = 0; // 整除100， 查看有多少段
			let load = parseInt(100 / $(".form-infor").length); // 存储平均每次长传所需要的百分比
			let times = 1; // 学生个数计时
			var DISABLED = 'layui-btn-disabled'; // 禁止按钮类名
			if (othis.hasClass(DISABLED)) return; // 当按钮的的class名存在layui-btn-disabled时退出循环，即停止进度
				// $.post("", {
				// 		information: infoArr
				// 	},
				// 	function(data) {
				// 		
				// 	});
			var timer = setInterval(function() { // 发送阿贾克斯定时器
				if ($(".form-infor").length >= times) {
					// $.ajax({
					// 	url : "",
					// 	data : {
					// 		student : infoArr[i] // 传对象形式的学生信息给后台
					// 	},
					// 	success : (res) => {
					sum += load; // 每次成功传送都让进度条增加
					if (sum > 100) { // 当100% 时
						sum = 100;
						clearInterval(timer);
						othis.removeClass(DISABLED); // 移除禁止按钮样式
						prog.css("display", "none"); // 进度条隐藏
						tipText.text("<strong>提交成功!</strong><br>点击下一步进行项目报名!");
						othis.text("下一步"); // 按钮换功能，跳转到下一步
						othis.attr({
							"data-type": "",
							"onclick": "next()"
						});
						
					};
					element.progress('demo', sum + '%');
					// }
					// })
				} else {
					(function() {
						sum += load; // 每次成功传送都让进度条增加
						if (sum > 100) { // 当100% 时
							sum = 100;
							clearInterval(timer)
							othis.removeClass(DISABLED); // 移除禁止按钮样式
							prog.css("display", "none"); // 进度条隐藏
							tipText.html("<strong>提交成功!</strong><br>点击下一步进行项目报名!");
							othis.text("下一步"); // 按钮换功能，跳转到下一步
							othis.attr({
								"data-type": "",
								"onclick": "next()"
							});
						}
						element.progress('demo', sum + '%');
					}())
				}
				times++;
			}, 1000 * Math.random())

			othis.addClass(DISABLED); // 添加禁止按钮样式
			console.log(infoArr);
		}
	};
	$('.submitName').on('click', function() {
		console.log(prog)
		prog.css("display", "block"); // 进度条显示
		var othis = $(this),
			type = $(this).data('type');
		active[type] ? active[type].call(this, othis) : '';
	});
});
