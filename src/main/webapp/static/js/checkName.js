$(".search-bnt").click(function () {
	$.post("/student/searchStudentProject",
		{
		name : $(".layui-input").eq(0).val(), // 姓名
		grade : $(".layui-input").eq(1).val() // 年级
		},
		function (res) {
			$(".tip-text").text(res.info)
		}
	)
})
