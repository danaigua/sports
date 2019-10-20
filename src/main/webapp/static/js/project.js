let gymnastics = [{}, {}]; // 广播操比赛， 第一个为男生，第二个为女生
let gymId = []; // 存储每个名字的唯一标识index-data, 在有保存参赛人员的情况下再次点击报名时，复原当时的操作
let tug = [{}, {}]; // 广播操比赛， 第一个为男生，第二个为女生
let tugId = []; // 存储每个名字的唯一标识index-data, 在有保存参赛人员的情况下再次点击报名时，复原当时的操作
let collective = [{}, {}]; // 集体项目， 第一个为男生，第二个为女生
let collectiveId = []; // 存储每个名字的唯一标识index-data, 在有保存参赛人员的情况下再次点击报名时，复原当时的操作
let standard = [{}, {}]; // 达标四项， 第一个为男生，第二个为女生
let standardId = []; // 存储每个名字的唯一标识index-data, 在有保存参赛人员的情况下再次点击报名时，复原当时的操作
let singleLink = $(".singLink");
let project = $(".project");
let athleLimit = []; // 各项每人限报五人，记录他们的id
let manId = []; // 存储100男生得ID
let girlId = []; // 存储100女生得ID
let twoManId = []; // 存储200男生得ID
let twoGirlId = []; // 存储200女生得ID
let fourManId = []; // 存储400男生得ID
let fourGirlId = []; // 存储400女生得ID
let eightManId = []; // 存储800男生得ID
let eightGirlId = []; // 存储800女生得ID
let tenManId = []; // 存储1500男生得ID
let tenNumId = []; // 存储1500女生得ID  Relay
let oneRelManId = []; // 存储4*100接力男生得ID
let oneRelGirlId = []; // 存储4*100女生得ID
let fourRelManId = []; // 存储4*400男生得ID
let fourRelGirlId = []; // 存储4*400女生得ID

let shotManId = []; // 存储铅球男生得ID
let shotGirlId = []; // 存储铅球女生得ID
let heightManId = []; // 存储跳高男生得ID
let heightGirlId = []; // 存储跳高女生得ID  Relay
let farManId = []; // 存储跳远男生得ID
let thereFarManId = []; // 存储三级跳远男生得ID

let totalId = []; //存储所有单项人数，
let twoTotal = [];
let leaTo = []; // 去重后的,径赛项目
let fieldTo = []; // 田赛项目
let cancel = $(".tip-cancel"); // 提示框取消按钮
let preser = $(".tip-pre"); // 提示框保存按钮
let obj = [{
		0: "梁东海",
		1: "梁西江",
		2: "梁小溪",
		3: "梁大河",
		4: "梁东海",
		5: "梁西江",
		6: "梁小溪",
		7: "梁大河",
		8: "梁东海",
		9: "梁西江",
		10: "梁小溪",
		11: "梁大河",
		12: "梁东海",
		13: "梁西江",
		14: "梁小溪",
		15: "梁大河",
		16: "梁东海",
		17: "梁西江",
		18: "梁小溪",
		19: "梁大河",
		20: "梁东海",
		21: "梁西江",
		22: "梁小溪",
		23: "梁大河",
		24: "梁大河",
		25: "梁东海",
		26: "梁西江",
		27: "梁小溪",
		28: "梁大河"
	},
	{
		29: "陈莹琪",
		30: "陈阿古",
		31: "陈佳琪",
		32: "陈大胜",
		33: "陈莹琪",
		34: "陈阿古",
		35: "陈佳琪",
		36: "陈大胜",
		37: "陈莹琪",
		38: "陈阿古",
		39: "陈佳琪",
		40: "陈大胜",
		41: "陈莹琪",
		42: "陈阿古",
		43: "陈佳琪",
		44: "陈大胜",
		45: "陈莹琪",
		46: "陈阿古",
		47: "陈佳琪",
		48: "陈大胜",
		49: "陈莹琪",
		50: "陈阿古",
		51: "陈佳琪",
		52: "陈大胜",
		53: "陈莹琪",
		54: "陈阿古",
		55: "陈佳琪",
		56: "陈大胜",
		57: "陈莹琪",
		58: "陈阿古",
		59: "陈佳琪",
		60: "陈大胜"
	}
]
let close = $(".closeIcon"); // 提示框关闭图标
let background = $(".background"); // 遮盖背景
let projectName = $(".project-name"); // 这是一个隐藏的input，用于存放提示哪一个项目名称
let signUp = $(".signUp"); // 报名按钮
let notNam = $(".not-manName"); // 提示框男生存放 未 参加名字区域
let notGirl = $(".not-girlName"); // 提示框女生存放 未 参加名字区域
let hasNan = $(".has-manName"); // 提示框男生存放 已 参加名字区域
let hasGirl = $(".has-girlName"); // 提示框女生存放 已 参加名字区域
let tip = $(".tip");
let athleLink = $(".athle-link"); // 所有田径比赛标签
let tip1 = $(".tip1"); // 田径比赛提示框
let noJoin = $(".noJoin"); // 未参加
let yesJoin = $(".yesJoin"); // 已参加
let athle100 = [{}, {}]; // 存储田径一百米男女
let oneId = []; // 存储田径一百米的id
let athle200 = [{}, {}]; // 存储田径二百米男女
let twoId = []; // 存储田径二百米的id
let athle400 = [{}, {}]; // 存储田径四百米男女
let fourId = []; // 存储田径四百米的id
let athle800 = [{}, {}]; // 存储田径八百米男女
let eightId = []; // 存储田径八百米的id
let athle1500 = [{}, {}]; // 存储田径一千五百米男女
let tenId = []; // 存储田径一千五百米的id
let relay1 = [{}, {}]; // 存储田径4*100米接力男女
let relay1Id = []; // 存储田径4*100米的id
let relay4 = [{}, {}]; // 存储田径4*400米男女
let relay4Id = []; // 存储田径4*400米的id
let shot = [{}, {}]; // 存储铅球比赛
let shotId = []; // 存储铅球ID
let far = [{}]; // 存储跳远
let farId = []; // 存储跳远的id
let thereFar = [{}]; // 存储田径三级跳远
let thereFarId = []; // 存储田径三级跳远的id
let height = [{}, {}]; // 存储跳高比赛
let heightId = []; // 存储跳高ID
let athGender = $(".athletics-gender"); // 存储性别
project.eq(0).css("display", "block"); // 让第一个项目显示

// 初始化，把所有项目隐藏
function hiddenSingle() {
	for (let i = 0; i < project.length; i++) {
		project.eq(i).css("display", "none");
		$(".singLink").eq(i).css("color", "#000");
		$(".singLink").eq(i).next().css("color", "#000");
	}
}
// 给所有元素添加点击事件，添加css样式
for (let i = 0; i < singleLink.length; i++) {
	(function(j) {
		singleLink.eq(j).click(function() {
			hiddenSingle();
			project.eq(j).css("display", "block");
			$(this).css("color", "#f07029");
			$(this).next().css("color", "#f07029");
		})
	}(i))
};

// 点击报名事件
function join() {
	background.css("display", "block"); //
	projectName.val($(this).attr("index-data")); // 存放点击的哪一个项目名称
	tip.css("display", "block"); // 点击报名弹出提示框
	// 当点击广播体操时
	if ($(this).attr("index-data") === "gymnastics") {
		if (Object.keys(gymnastics[0]) == 0 && Object.keys(gymnastics[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			for (let prop in obj) { // 遍历数组，取出名字
				if (prop === "0") { // 数组第一个为男生
					for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
						notNam.append(`
											<div index-id='1' class="nameBox" index-data=` + data + `>
												<span>` + obj[
							prop][data] + `</span>
												<i class="addInfo">+</i>
											</div>`);
					};
				} else { // 第二个为女生
					for (let data in obj[prop]) {
						notGirl.append(`
										<div index-id='0' class="nameBox" index-data=` + data + `>
											<span>` + obj[
							prop][data] + `</span>
											<i class="addInfo">+</i>
										</div>`);
					};
				};
			};
		} else {
			initiName(".manName"); // 初始化参赛人员名单
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if (prop === "0") { // 数组第一个为男生
					for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
						if (gymId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
							hasNan.append(`
									<div index-id="1" class="nameBox" index-data=` + data + `>
										<span>` +
								gymnastics[prop][data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
							hasNan.children().last().click(hasIncrease); // 给新进入已参加的男生名字添加删除功能
						} else {
							notNam.append(`
													<div index-id='1' class="nameBox" index-data=` + data + `>
														<span>` +
								obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
						}
					};
				} else { // 第二个为女生
					for (let data in obj[prop]) {
						if (gymId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
							hasGirl.append(`
								<div index-id="0" class="nameBox" index-data=` + data + `>
									<span>` +
								gymnastics[prop][data] + `</span>
									<i class="addInfo">-</i>
								</div>`);
							hasGirl.children().last().click(hasIncrease); // 给新进入已参加的女生名字添加删除功能
						} else {
							notGirl.append(`
												<div index-id='0' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						}
					};
				};
			};
		}
	};
	// 当点击广播体操时
	if ($(this).attr("index-data") === "tug") {
		if (Object.keys(tug[0]) == 0 && Object.keys(tug[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			for (let prop in obj) { // 遍历数组，取出名字
				if (prop === "0") { // 数组第一个为男生
					for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
						notNam.append(`
											<div index-id='1' class="nameBox" index-data=` + data + `>
												<span>` + obj[
							prop][data] + `</span>
												<i class="addInfo">+</i>
											</div>`);
					};
				} else { // 第二个为女生
					for (let data in obj[prop]) {
						notGirl.append(`
										<div index-id='0' class="nameBox" index-data=` + data + `>
											<span>` + obj[
							prop][data] + `</span>
											<i class="addInfo">+</i>
										</div>`);
					};
				};
			};
		} else {
			initiName(".manName"); // 初始化参赛人员名单
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if (prop === "0") { // 数组第一个为男生
					for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
						if (gymId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
							hasNan.append(`
									<div index-id="1" class="nameBox" index-data=` + data + `>
										<span>` + tug[prop]
								[data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
							hasNan.children().last().click(hasIncrease); // 给新进入已参加的男生名字添加删除功能
						} else {
							notNam.append(`
													<div index-id='1' class="nameBox" index-data=` + data + `>
														<span>` +
								obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
						}
					};
				} else { // 第二个为女生
					for (let data in obj[prop]) {
						if (gymId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
							hasGirl.append(`
								<div index-id="0" class="nameBox" index-data=` + data + `>
									<span>` + tug[prop]
								[data] + `</span>
									<i class="addInfo">-</i>
								</div>`);
							hasGirl.children().last().click(hasIncrease); // 给新进入已参加的女生名字添加删除功能
						} else {
							notGirl.append(`
												<div index-id='0' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						}
					};
				};
			};
		}
	}

	// 当点击集体项目
	if ($(this).attr("index-data") === "collective") {
		if (Object.keys(collective[0]) == 0 && Object.keys(collective[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			for (let prop in obj) { // 遍历数组，取出名字
				if (prop === "0") { // 数组第一个为男生
					for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
						notNam.append(`
											<div index-id='1' class="nameBox" index-data=` + data + `>
												<span>` + obj[
							prop][data] + `</span>
												<i class="addInfo">+</i>
											</div>`);
					};
				} else { // 第二个为女生
					for (let data in obj[prop]) {
						notGirl.append(`
										<div index-id='0' class="nameBox" index-data=` + data + `>
											<span>` + obj[
							prop][data] + `</span>
											<i class="addInfo">+</i>
										</div>`);
					};
				};
			};
		} else {
			initiName(".manName"); // 初始化参赛人员名单
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if (prop === "0") { // 数组第一个为男生
					for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
						if (collectiveId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
							hasNan.append(`
									<div index-id="1" class="nameBox" index-data=` + data + `>
										<span>` +
								collective[prop]
								[data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
							hasNan.children().last().click(hasIncrease); // 给新进入已参加的男生名字添加删除功能
						} else {
							notNam.append(`
													<div index-id='1' class="nameBox" index-data=` + data + `>
														<span>` +
								obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
						}
					};
				} else { // 第二个为女生
					for (let data in obj[prop]) {
						if (collectiveId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
							hasGirl.append(`
								<div index-id="0" class="nameBox" index-data=` + data + `>
									<span>` +
								collective[prop]
								[data] + `</span>
									<i class="addInfo">-</i>
								</div>`);
							hasGirl.children().last().click(hasIncrease); // 给新进入已参加的女生名字添加删除功能
						} else {
							notGirl.append(`
												<div index-id='0' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						}
					};
				};
			};
		}
	}
	// 当点击广播体操时
	if ($(this).attr("index-data") === "standard") {
		if (Object.keys(standard[0]) == 0 && Object.keys(standard[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			for (let prop in obj) { // 遍历数组，取出名字
				if (prop === "0") { // 数组第一个为男生
					for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
						notNam.append(`
											<div index-id='1' class="nameBox" index-data=` + data + `>
												<span>` + obj[
							prop][data] + `</span>
												<i class="addInfo">+</i>
											</div>`);
					};
				} else { // 第二个为女生
					for (let data in obj[prop]) {
						notGirl.append(`
										<div index-id='0' class="nameBox" index-data=` + data + `>
											<span>` + obj[
							prop][data] + `</span>
											<i class="addInfo">+</i>
										</div>`);
					};
				};
			};
		} else {
			initiName(".manName"); // 初始化参赛人员名单
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if (prop === "0") { // 数组第一个为男生
					for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
						if (standardId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
							hasNan.append(`
									<div index-id="1" class="nameBox" index-data=` + data + `>
										<span>` + standard[
									prop]
								[data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
							hasNan.children().last().click(hasIncrease); // 给新进入已参加的男生名字添加删除功能
						} else {
							notNam.append(`
													<div index-id='1' class="nameBox" index-data=` + data + `>
														<span>` +
								obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
						}
					};
				} else { // 第二个为女生
					for (let data in obj[prop]) {
						if (standardId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
							hasGirl.append(`
								<div index-id="0" class="nameBox" index-data=` + data + `>
									<span>` + tug[prop]
								[data] + `</span>
									<i class="addInfo">-</i>
								</div>`);
							hasGirl.children().last().click(hasIncrease); // 给新进入已参加的女生名字添加删除功能
						} else {
							notGirl.append(`
												<div index-id='0' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						}
					};
				};
			};
		}
	}

	// 给参赛报名提示框的未参加男生，女生添加事件
	for (let i = 0; i < $(".not-Name").children().length; i++) {
		$(".not-Name").children().eq(i).click(increase);
	};
};

// 给报名添加点击事件
for (let i = 0; i < signUp.length; i++) {
	signUp.eq(i).click(join); // 给事件传 体操（gymnastics） 或者 拔河（tug） 的参数
};
// 点击 未 参加姓名男生
function increase() {
	$(this).remove(); // 删除节点
	if ($(this).attr("index-id") === "1") { // 判定：1.男生放进 已参赛 的男生区域 0.女生放进 已参赛 的女生区域
		hasNan.append(`
					<div index-id="1" class="nameBox" index-data=` + $(this).attr("index-data") + `>
						<span>` +
			$(this).children("span").text() + `</span>
						<i class="addInfo">-</i>
					</div>`);
		hasNan.children().last().click(hasIncrease); // 给新进入已参加的男生名字添加删除功能
	} else {
		hasGirl.append(`
					<div index-id="0" class="nameBox" index-data=` + $(this).attr("index-data") + `>
						<span>` +
			$(this).children("span").text() + `</span>
						<i class="addInfo">-</i>
					</div>`);
		hasGirl.children().last().click(hasIncrease); // 给新进入已参加的女生名字添加删除功能
	};
}
// 点击 已 参加姓名男生
function hasIncrease() {
	$(this).remove();
	if ($(this).attr("index-id") === "1") { // 判定：1.男生放进 未参赛 的男生区域 0.女生放进 未参赛 的女生区域
		notNam.append(`
					<div index-id="1" class="nameBox" index-data=` + $(this).attr("index-data") + `>
						<span>` +
			$(this).children("span").text() + `</span>
						<i class="addInfo">+</i>
					</div>`);
		notNam.children().last().click(increase); // 给新进入 未 参加的男生名字添加进入已选功能
	} else {
		notGirl.append(`
					<div index-id="0" class="nameBox" index-data=` + $(this).attr("index-data") + `>
						<span>` +
			$(this).children("span").text() + `</span>
						<i class="addInfo">+</i>
					</div>`);
		notGirl.children().last().click(increase); // 给新进入 未 参加的女生名字添加进入已选功能
	}
};
// 初始化未参赛人名单
function initiName(target) {
	for (let i = 0; i < $(target).length; i++) { // 当取消提示框时，清除名字
		$(target).eq(i).empty();
	};
};

// 关闭提示框小图标或取消
function cancelClo() {
	initiName(".manName"); // 初始化未参赛人名单
	tip.css("display", "none"); // 提示框显示
	background.css("display", "none"); //  
};



//按保存按钮时，把已报名的名字放进数组里，第一个数组放男生，第二个数组放女生
function preservation(obj, target) {
	let hasNamNum = $(".has-manName").children().length; // 参加的男生人数
	let hasGirlNum = $(".has-girlName").children().length; // 参加的女生人数
	let athle100Num = $(".yesJoin").children().length; // 田径100米参加的人数
	switch (projectName.val()) { // 筛选每个项目
		case "gymnastics":
			if (hasNamNum >= 15 && (hasNamNum + hasGirlNum) === 45) {
				gymId = []; // 清空数组，避免重复加入
				gymnastics = [{}, {}]; // 清空对象，避免重复加入
				for (let i = 0; i < $(".has-manName").children().length; i++) { // 把男生存入数组第一对象
					gymnastics[0][$(".has-manName").children().eq(i).attr("index-data")] = $(".has-manName").children().eq(i).find(
						"span").text();
					gymId.push($(".has-manName").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
				for (let i = 0; i < $(".has-girlName").children().length; i++) { // 把女生存入数组第二对象
					gymnastics[1][$(".has-girlName").children().eq(i).attr("index-data")] = $(".has-girlName").children().eq(i).find(
						"span").text();
					gymId.push($(".has-girlName").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
				alert("保存成功！");
				console.log(gymnastics);
				console.log(gymId);
			} else {
				alert("每单位参赛人数不超过45人(男生不少于15人)");
			}
			break;
		case "tug":
			if (hasNamNum === 10 && hasGirlNum === 5) {
				tugId = []; // 清空数组，避免重复加入
				tug = [{}, {}]; // 清空对象，避免重复加入
				for (let i = 0; i < $(".has-manName").children().length; i++) { // 把男生存入数组第一对象
					tug[0][$(".has-manName").children().eq(i).attr("index-data")] = $(".has-manName").children().eq(i).find("span").text();
					tugId.push($(".has-manName").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
				for (let i = 0; i < $(".has-girlName").children().length; i++) { // 把女生存入数组第二对象
					tug[1][$(".has-girlName").children().eq(i).attr("index-data")] = $(".has-girlName").children().eq(i).find("span").text();
					tugId.push($(".has-girlName").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
				alert("保存成功!");
				console.log(tug);
				console.log(tugId);
			} else {
				alert("每单位参赛人数10男5女")
			}
			break;
		case "100M":
			oneId = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				athle100[0] = {}; //清空对象，避免数据叠加
				manId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					athle100[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					manId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
				console.log(manId);
				console.log(girlId);
			} else { // 女生框放入第二个数组
				athle100[1] = {}; //清空对象，避免数据叠加
				girlId = []; //清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把女生存入数组第二对象
					athle100[1][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					girlId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
				console.log(manId);
				console.log(girlId);

			};
			oneId = [...manId, ...girlId]; // 合并两个数组
			totalId = [...oneId, ...twoId, ...fourId, ...eightId, ...tenId, ...relay1Id, ...relay4Id]; // 全部人总和，
			leaTo = Array.from(new Set(totalId));

			if (Object.keys(athle100[0]).length + Object.keys(athle100[1]).length > 5 || leaTo.length > 5) { //男神和女生超过5人时
				athle100 = [{}, {}]; // 清空数组
				twoId = []; // 清空唯一ID
				oneId = [];
				fourId = [];
				eightId = [];
				totalId = [];
				tenId = [];
				relay1Id = [];
				relay4Id = [];
				totalId = [];
				leaTo = Array.from(new Set(totalId));
				alert("各系每项限报5人");
			};
			console.log("去重", leaTo);
			console.log("总人数", totalId);
			console.log("100", athle100);
			console.log("100", oneId);
			break;
		case "200M":
			twoId = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				athle200[0] = {}; //清空对象，避免数据叠加
				twoManId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					athle200[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					twoManId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			} else { // 女生框放入第二个数组
				athle200[1] = {}; //清空对象，避免数据叠加
				twoGirlId = []; //清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把女生存入数组第二对象
					athle200[1][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					twoGirlId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			};
			twoId = [...twoManId, ...twoGirlId]; // 合并两个数组
			totalId = [...oneId, ...twoId, ...fourId, ...eightId, ...tenId, ...relay1Id, ...relay4Id]; // 全部人总和，
			leaTo = Array.from(new Set(totalId));

			if (Object.keys(athle200[0]).length + Object.keys(athle200[1]).length > 5 || Array.from(new Set(totalId)).length > 5) { //男神和女生超过5人时
				athle200 = [{}, {}]; // 清空数组
				twoId = []; // 清空唯一ID
				oneId = [];
				fourId = [];
				eightId = [];
				totalId = [];
				tenId = [];
				relay1Id = [];
				relay4Id = [];
				leaTo = Array.from(new Set(totalId));
				alert("各系每项限报5人");
			};
			console.log("去重", leaTo);
			console.log("总人数", totalId);
			console.log("200", athle200);
			

			console.log("200", twoId);
			break;
		case "400M":
			fourId = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				athle400[0] = {}; //清空对象，避免数据叠加
				fourManId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					athle400[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					fourManId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			} else { // 女生框放入第二个数组
				athle400[1] = {}; //清空对象，避免数据叠加
				fourGirlId = []; //清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把女生存入数组第二对象
					athle400[1][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					fourGirlId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			};
			fourId = [...fourManId, ...fourGirlId]; // 合并两个数组
			totalId = [...oneId, ...twoId, ...fourId, ...eightId, ...tenId, ...relay1Id, ...relay4Id]; // 全部人总和，
			leaTo = Array.from(new Set(totalId));

			if (Object.keys(athle400[0]).length + Object.keys(athle400[1]).length > 5 || leaTo.length > 5) { //男神和女生超过5人时
				athle400 = [{}, {}]; // 清空数组
				twoId = []; // 清空唯一ID
				oneId = [];
				fourId = [];
				eightId = [];
				totalId = [];
				tenId = [];
				relay1Id = [];
				relay4Id = [];
				totalId = [];
				leaTo = Array.from(new Set([]));
				alert("各系每项限报5人");
			};
			console.log("去重", leaTo);
			console.log("总人数", totalId);
			console.log("400", athle400);
			console.log("400", fourId);
			break;

		case "800M":
			eightId = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				athle800[0] = {}; //清空对象，避免数据叠加
				eightManId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					athle800[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					eightManId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			} else { // 女生框放入第二个数组
				athle800[1] = {}; //清空对象，避免数据叠加
				eightGirlId = []; //清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把女生存入数组第二对象
					athle800[1][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					eightGirlId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			};
			eightId = [...eightManId, ...eightGirlId]; // 合并两个数组
			totalId = [...oneId, ...twoId, ...fourId, ...eightId, ...tenId, ...relay1Id, ...relay4Id]; // 全部人总和，
			leaTo = Array.from(new Set(totalId));
			console.log("去重", leaTo);
			if (Object.keys(athle800[0]).length + Object.keys(athle800[1]).length > 5 || leaTo.length > 5) { //男神和女生超过5人时
				athle800 = [{}, {}]; // 清空数组
				twoId = []; // 清空唯一ID
				oneId = [];
				fourId = [];
				eightId = [];
				totalId = [];
				tenId = [];
				relay1Id = [];
				relay4Id = [];
				totalId = [];
				leaTo = Array.from(new Set([]));
				alert("各系每项限报5人");
			};
			console.log("总人数", totalId);
			console.log("800", athle800);
			console.log("800", eightId);
			break;
		case "1500M":
			tenId = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				athle1500[0] = {}; //清空对象，避免数据叠加
				tenManId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					athle1500[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					tenManId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			} else { // 女生框放入第二个数组
				athle1500[1] = {}; //清空对象，避免数据叠加
				tenNumId = []; //清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把女生存入数组第二对象
					athle1500[1][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					tenNumId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			};
			tenId = [...tenManId, ...tenNumId]; // 合并两个数组
			totalId = [...oneId, ...twoId, ...fourId, ...eightId, ...tenId, ...relay1Id, ...relay4Id]; // 全部人总和，
			leaTo = Array.from(new Set(totalId));

			if (Object.keys(athle1500[0]).length + Object.keys(athle1500[1]).length > 5 || leaTo.length > 5) { //男神和女生超过5人时
				athle1500 = [{}, {}]; // 清空数组
				twoId = []; // 清空唯一ID
				oneId = [];
				fourId = [];
				eightId = [];
				totalId = [];
				tenId = [];
				relay1Id = [];
				relay4Id = [];
				totalId = [];
				leaTo = Array.from(new Set([]));
				alert("各系每项限报5人");
			};
			console.log("去重", leaTo);
			console.log("总人数", totalId);
			console.log("1500", athle1500);
			console.log("1500", tenId);
			break;
		case "4*100M":
			relay1Id = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				relay1[0] = {}; //清空对象，避免数据叠加
				oneRelManId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					relay1[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					oneRelManId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
			} else { // 女生框放入第二个数组
				relay1[1] = {}; //清空对象，避免数据叠加
				oneRelGirlId = []; //清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把女生存入数组第二对象
					relay1[1][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					oneRelGirlId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			};
			relay1Id = [...oneRelManId, ...oneRelGirlId]; // 合并两个数组
			totalId = [...oneId, ...twoId, ...fourId, ...eightId, ...tenId, ...relay1Id, ...relay4Id]; // 全部人总和，
			leaTo = Array.from(new Set(totalId));

			if (Object.keys(relay1[0]).length + Object.keys(relay1[1]).length > 5 || leaTo.length > 5) { //男神和女生超过5人时
				relay1 = [{}, {}]; // 清空数组
				twoId = []; // 清空唯一ID
				oneId = [];
				fourId = [];
				eightId = [];
				totalId = [];
				tenId = [];
				relay1Id = [];
				relay4Id = [];
				totalId = [];
				leaTo = Array.from(new Set([]));
				alert("各系每项限报5人");
			};
			console.log("去重", leaTo);
			console.log("总人数", totalId);
			console.log("4*100", relay1);
			console.log("4*100", relay1Id);
			break;
		case "4*400M":
			relay4Id = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				relay4[0] = {}; //清空对象，避免数据叠加
				fourRelManId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					relay4[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					fourRelManId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			} else { // 女生框放入第二个数组
				relay4[1] = {}; //清空对象，避免数据叠加
				fourRelGirlId = []; //清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把女生存入数组第二对象
					relay4[1][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					fourRelGirlId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			};
			relay4Id = [...fourRelManId, ...fourRelGirlId]; // 合并两个数组
			totalId = [...oneId, ...twoId, ...fourId, ...eightId, ...tenId, ...relay1Id, ...relay4Id]; // 全部人总和，
			leaTo = Array.from(new Set(totalId));

			if (Object.keys(relay4[0]).length + Object.keys(relay4[1]).length > 5 || leaTo.length > 5) { //男神和女生超过5人时
				relay4 = [{}, {}]; // 清空数组
				twoId = []; // 清空唯一ID
				oneId = [];
				fourId = [];
				eightId = [];
				totalId = [];
				tenId = [];
				relay1Id = [];
				relay4Id = [];
				totalId = [];
				leaTo = Array.from(new Set([]));
				alert("各系每项限报5人");
			};
			console.log("去重", leaTo);
			console.log("总人数", totalId);
			console.log("4*400", relay4);
			console.log("4*400", relay4Id);
			break;

		// 
		case "shot":
			shotId = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				shot[0] = {}; //清空对象，避免数据叠加
				shotManId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					shot[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					shotManId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			} else { // 女生框放入第二个数组
				shot[1] = {}; //清空对象，避免数据叠加
				shotGirlId = []; //清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把女生存入数组第二对象
					shot[1][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					shotGirlId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			};
			shotId = [...shotManId, ...shotGirlId]; // 合并两个数组
			twoTotal = [...shotId, ...heightId, ...farId, ...thereFarId]; // 全部人总和，
			fieldTo = Array.from(new Set(twoTotal));

			if (Object.keys(shot[0]).length + Object.keys(shot[1]).length > 5 || fieldTo.length > 5) { //男神和女生超过5人时
				shot = [{}, {}]; // 清空数组
				shotId = []; // 清空唯一ID
				heightId = []; 
				farId = [];
				thereFarId = [];
				twoTotal = [];
				fieldTo = Array.from(new Set([]));
				alert("各系每项限报5人");
			};
			console.log("去重", fieldTo);
			console.log("总人数", twoTotal);
			console.log("4*400", shot);
			console.log("4*400", shotId);
			break;
		case "height":
			heightId = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				height[0] = {}; //清空对象，避免数据叠加
				heightManId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					height[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					heightManId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			} else { // 女生框放入第二个数组
				height[1] = {}; //清空对象，避免数据叠加
				heightGirlId = []; //清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把女生存入数组第二对象
					height[1][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					heightGirlId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			};
			heightId = [...heightManId, ...heightGirlId]; // 合并两个数组
			twoTotal = [...shotId, ...heightId, ...farId, ...thereFarId]; // 全部人总和，
			fieldTo = Array.from(new Set(twoTotal));

			if (Object.keys(height[0]).length + Object.keys(height[1]).length > 5 || fieldTo.length > 5) { //男神和女生超过5人时
				height = [{}, {}]; // 清空数组
				heightId = []; // 清空唯一ID
				twoTotal = [];
				fieldTo = Array.from(new Set([]));
				alert("各系每项限报5人");
			};
			console.log("去重", fieldTo);
			console.log("总人数", twoTotal);
			console.log("4*400", height);
			console.log("4*400", relay4Id);
			break;
		case "far":
			farId = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				far[0] = {}; //清空对象，避免数据叠加
				farManId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					far[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					farManId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			};
			farId = [...farManId];
			twoTotal = [...shotId, ...heightId, ...farId, ...thereFarId]; // 全部人总和，
			fieldTo = Array.from(new Set(twoTotal));

			if (Object.keys(far[0]).length > 5 || fieldTo.length > 5) { //男神和女生超过5人时
				far = [{}]; // 清空数组
				shotId = []; // 清空唯一ID
				heightId = []; 
				farId = [];
				thereFarId = [];
				twoTotal = [];
				fieldTo = Array.from(new Set([]));
				alert("各系每项限报5人");
			};
			console.log("去重", fieldTo);
			console.log("总人数", twoTotal);
			console.log("4*400", far);
			console.log("4*400", farId);
			break;
		case "thereFar":
			thereFarId = []; // 清空数组，避免重复
			if (athGender.val() === "man") { // 男生框放入第一个数组
				thereFar[0] = {}; //清空对象，避免数据叠加
				thereFarManId = []; // 清空数组，避免数据叠加
				for (let i = 0; i < $(".yesJoin").children().length; i++) { // 把男生存入数组第一对象
					thereFar[0][$(".yesJoin").children().eq(i).attr("index-data")] = $(".yesJoin").children().eq(i).find("span").text();
					thereFarManId.push($(".yesJoin").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};

			};
			thereFarId = [...thereFarManId]; // 合并两个数组
			twoTotal = [...shotId, ...heightId, ...farId, ...thereFarId]; // 全部人总和，
			fieldTo = Array.from(new Set(twoTotal));

			if (Object.keys(thereFar[0]).length > 5 || fieldTo.length > 5) { //男神和女生超过5人时
				thereFar = [{}]; // 清空数组
				shotId = []; // 清空唯一ID
				heightId = []; 
				farId = [];
				thereFarId = [];
				twoTotal = [];
				fieldTo = Array.from(new Set([]));
				alert("各系每项限报5人");
			};
			console.log("去重", fieldTo);
			console.log("总人数", twoTotal);
			console.log("4*400", thereFar);
			console.log("4*400", thereFarId);
			break;

		case "collective":
			if (hasNamNum === 10 && hasGirlNum === 10) {
				collectiveId = []; // 清空数组，避免重复加入
				collective = [{}, {}]; // 清空对象，避免重复加入
				for (let i = 0; i < $(".has-manName").children().length; i++) { // 把男生存入数组第一对象
					collective[0][$(".has-manName").children().eq(i).attr("index-data")] = $(".has-manName").children().eq(i).find(
						"span").text();
					collectiveId.push($(".has-manName").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
				for (let i = 0; i < $(".has-girlName").children().length; i++) { // 把女生存入数组第二对象
					collective[1][$(".has-girlName").children().eq(i).attr("index-data")] = $(".has-girlName").children().eq(i).find(
						"span").text();
					collectiveId.push($(".has-girlName").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
				alert("保存成功！");
				console.log(collective);
				console.log(collectiveId);
			} else {
				alert("参赛人数为男生，女生各十人！");
			}
			break;
		case "standard":
			if (hasNamNum + hasGirlNum <= 5) {
				standardId = []; // 清空数组，避免重复加入
				standard = [{}, {}]; // 清空对象，避免重复加入
				for (let i = 0; i < $(".has-manName").children().length; i++) { // 把男生存入数组第一对象
					standard[0][$(".has-manName").children().eq(i).attr("index-data")] = $(".has-manName").children().eq(i).find(
						"span").text();
					standardId.push($(".has-manName").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
				for (let i = 0; i < $(".has-girlName").children().length; i++) { // 把女生存入数组第二对象
					standard[1][$(".has-girlName").children().eq(i).attr("index-data")] = $(".has-girlName").children().eq(i).find(
						"span").text();
					standardId.push($(".has-girlName").children().eq(i).attr("index-data")); // 保存每个名字的唯一id
				};
				alert("保存成功！");
				console.log(standard);
				console.log(standardId);
			} else {
				alert("各系每项限报5人");
			}
			break;
	};
	initiName(target); // 初始化未参赛人名单
	tip.css("display", "none");
	tip1.css("display", "none");
	background.css("display", "none");
};

// 
//田径参赛逻辑
// 
// 点击报名按钮事件
function athleJoin() {
	background.css("display", "block"); //
	projectName.val($(this).attr("index-data")); // 存放点击的哪一个项目名称
	athGender.val($(this).attr("index-gender")); // 存放点击的性别
	tip1.css("display", "block"); // 点击报名弹出提示框

	//田径一百米
	if ($(this).attr("index-data") === "100M") { // 当点击广播体操时
		if (Object.keys(athle100[0]) == 0 && Object.keys(athle100[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			} else { // 女生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "1") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(oneId);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (oneId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				} else { // 第二个为女生
					console.log("女生")
					for (let data in obj[prop]) {
						if (prop === "1") {
							if (oneId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
									<div index-id="0" class="nameBox" index-data=` + data + `>
										<span>` + obj[
									prop][data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的女生名字添加删除功能
							} else {
								noJoin.append(`
													<div index-id='0' class="nameBox" index-data=` + data + `>
														<span>` +
									obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
							}
						}
					};
				};
			};
		}
	};
	// 田径比赛两百米
	if ($(this).attr("index-data") === "200M") { // 当点击广播体操时
		if (Object.keys(athle200[0]) == 0 && Object.keys(athle200[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			} else { // 女生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "1") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(twoId);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (twoId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				} else { // 第二个为女生
					console.log("女生")
					for (let data in obj[prop]) {
						if (prop === "1") {
							if (twoId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
									<div index-id="0" class="nameBox" index-data=` + data + `>
										<span>` + obj[
									prop][data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的女生名字添加删除功能
							} else {
								noJoin.append(`
													<div index-id='0' class="nameBox" index-data=` + data + `>
														<span>` +
									obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
							}
						}
					};
				};
			};
		}
	};
	// 田径比赛四百米
	if ($(this).attr("index-data") === "400M") { // 当点击广播体操时
		if (Object.keys(athle400[0]) == 0 && Object.keys(athle400[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			} else { // 女生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "1") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(fourId);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (fourId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				} else { // 第二个为女生
					console.log("女生")
					for (let data in obj[prop]) {
						if (prop === "1") {
							if (fourId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
									<div index-id="0" class="nameBox" index-data=` + data + `>
										<span>` + obj[
									prop][data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的女生名字添加删除功能
							} else {
								noJoin.append(`
													<div index-id='0' class="nameBox" index-data=` + data + `>
														<span>` +
									obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
							}
						}
					};
				};
			};
		}
	};
	// 田径比赛八百米
	if ($(this).attr("index-data") === "800M") { // 当点击广播体操时
		if (Object.keys(athle800[0]) == 0 && Object.keys(athle800[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			} else { // 女生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "1") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(eightId);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (eightId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				} else { // 第二个为女生
					console.log("女生")
					for (let data in obj[prop]) {
						if (prop === "1") {
							if (eightId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
									<div index-id="0" class="nameBox" index-data=` + data + `>
										<span>` + obj[
									prop][data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的女生名字添加删除功能
							} else {
								noJoin.append(`
													<div index-id='0' class="nameBox" index-data=` + data + `>
														<span>` +
									obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
							}
						}
					};
				};
			};
		}
	};
	// 田径比赛一千五百米
	if ($(this).attr("index-data") === "1500M") { // 当点击广播体操时
		if (Object.keys(athle1500[0]) == 0 && Object.keys(athle1500[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			} else { // 女生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "1") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(tenId);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (tenId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				} else { // 第二个为女生
					console.log("女生")
					for (let data in obj[prop]) {
						if (prop === "1") {
							if (tenId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
									<div index-id="0" class="nameBox" index-data=` + data + `>
										<span>` + obj[
									prop][data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的女生名字添加删除功能
							} else {
								noJoin.append(`
													<div index-id='0' class="nameBox" index-data=` + data + `>
														<span>` +
									obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
							}
						}
					};
				};
			};
		}
	};
	// 4*100米接力
	if ($(this).attr("index-data") === "4*100M") { // 当点击广播体操时
		if (Object.keys(relay1[0]) == 0 && Object.keys(relay1[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			} else { // 女生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "1") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(relay1Id);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (relay1Id.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				} else { // 第二个为女生
					console.log("女生")
					for (let data in obj[prop]) {
						if (prop === "1") {
							if (relay1Id.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
									<div index-id="0" class="nameBox" index-data=` + data + `>
										<span>` + obj[
									prop][data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的女生名字添加删除功能
							} else {
								noJoin.append(`
													<div index-id='0' class="nameBox" index-data=` + data + `>
														<span>` +
									obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
							}
						}
					};
				};
			};
		}
	};

	//4*400米接力
	if ($(this).attr("index-data") === "4*400M") { // 当点击广播体操时
		if (Object.keys(relay4[0]) == 0 && Object.keys(relay4[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			} else { // 女生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "1") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(relay4Id);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (relay4Id.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				} else { // 第二个为女生
					console.log("女生")
					for (let data in obj[prop]) {
						if (prop === "1") {
							if (relay4Id.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
									<div index-id="0" class="nameBox" index-data=` + data + `>
										<span>` + obj[
									prop][data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的女生名字添加删除功能
							} else {
								noJoin.append(`
													<div index-id='0' class="nameBox" index-data=` + data + `>
														<span>` +
									obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
							}
						}
					};
				};
			};
		}
	};

	//铅球
	if ($(this).attr("index-data") === "shot") { // 当点击广播体操时
		if (Object.keys(shot[0]) == 0 && Object.keys(shot[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			} else { // 女生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "1") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(shotId);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (shotId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				} else { // 第二个为女生
					console.log("女生")
					for (let data in obj[prop]) {
						if (prop === "1") {
							if (shotId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
									<div index-id="0" class="nameBox" index-data=` + data + `>
										<span>` + obj[
									prop][data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的女生名字添加删除功能
							} else {
								noJoin.append(`
													<div index-id='0' class="nameBox" index-data=` + data + `>
														<span>` +
									obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
							}
						}
					};
				};
			};
		}
	};
	//跳高
	if ($(this).attr("index-data") === "height") { // 当点击广播体操时
		if (Object.keys(height[0]) == 0 && Object.keys(height[1]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			} else { // 女生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "1") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(heightId);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (heightId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				} else { // 第二个为女生
					console.log("女生")
					for (let data in obj[prop]) {
						if (prop === "1") {
							if (heightId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
									<div index-id="0" class="nameBox" index-data=` + data + `>
										<span>` + obj[
									prop][data] + `</span>
										<i class="addInfo">-</i>
									</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的女生名字添加删除功能
							} else {
								noJoin.append(`
													<div index-id='0' class="nameBox" index-data=` + data + `>
														<span>` +
									obj[prop][data] + `</span>
														<i class="addInfo">+</i>
													</div>`);
							}
						}
					};
				};
			};
		}
	};
	//跳远
	if ($(this).attr("index-data") === "far") { // 当点击广播体操时
		if (Object.keys(far[0]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(farId);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (farId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				}
			};
		}
	};
	//三级跳远
	if ($(this).attr("index-data") === "thereFar") { // 当点击广播体操时
		if (Object.keys(thereFar[0]) == 0) { // 判定存放名字的对象是否为空，下标0为男生，下标1为女生
			if ($(this).attr("index-id") === "1") { // 男生
				for (let prop in obj) { // 遍历数组，取出名字
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识
							noJoin.append(`
												<div index-id='1' class="nameBox" index-data=` + data + `>
													<span>` +
								obj[prop][data] + `</span>
													<i class="addInfo">+</i>
												</div>`);
						};
					};
				}
			}
		} else {
			initiName(".join"); // 初始化参赛人员名单
			console.log(thereFarId);
			for (let prop in obj) { // 第二次遍历数组，过滤上次保存的已参赛名字，把没有参赛的名字放进去
				if ($(this).attr("index-id") === "1") {
					console.log("男生")
					if (prop === "0") { // 数组第一个为男生
						for (let data in obj[prop]) { // 遍历所有名字，并赋值index-data作为标识

							if (thereFarId.includes(data)) { // 看数组里的index-data是否包含从后台获取的全部Index-data,如果包含，则放入已参赛，
								yesJoin.append(`
										<div index-id="1" class="nameBox" index-data=` + data + `>
											<span>` + obj[
									prop][data] + `</span>
											<i class="addInfo">-</i>
										</div>`);
								yesJoin.children().last().click(athHasIn); // 给新进入已参加的名字添加删除功能
							} else {
								noJoin.append(`
														<div index-id='1' class="nameBox" index-data=` + data + `>
															<span>` +
									obj[prop][data] + `</span>
															<i class="addInfo">+</i>
														</div>`);
							}
						}
					}
				}
			};
		}
	};



	// 给参赛报名提示框的未参加男生，女生添加事件
	for (let i = 0; i < $(".noJoin").children().length; i++) {
		$(".noJoin").children().eq(i).click(athIncrease);
	};
};

// 给田径所有比赛项目添加报名事件
for (let i = 0; i < athleLink.length; i++) {
	athleLink.eq(i).click(athleJoin); // 
};
// 田径提示框的关闭图标，取消按钮
function closeCan() {
	initiName(".join"); // 初始化未参赛人名单
	tip1.css("display", "none"); // 提示框显示
	background.css("display", "none"); //  
};

// 点击 未 参加姓名男生
function athIncrease() {
	$(this).remove(); // 删除节点
	yesJoin.append(`
					<div index-id="1" class="nameBox" index-data=` + $(this).attr("index-data") + `>
						<span>` +
		$(this).children("span").text() + `</span>
						<i class="addInfo">-</i>
					</div>`);
	yesJoin.children().last().click(athHasIn); // 给新进入已参加的男生名字添加删除功能
};

// 点击 已 参加姓名男生
function athHasIn() {
	$(this).remove();
	noJoin.append(`
					<div index-id="1" class="nameBox" index-data=` + $(this).attr("index-data") + `>
						<span>` +
		$(this).children("span").text() + `</span>
						<i class="addInfo">+</i>
					</div>`);
	noJoin.children().last().click(athIncrease); // 给新进入 未 参加的男生名字添加进入已选功能
};

// 提交比赛人员名单
$(".referTo").click(function() {
	if (gymId.length === 0 && // 广播操
		tugId.length === 0 && // 拔河
		collectiveId.length === 0 && // 集体项目
		standardId.length === 0 && // 达标四项
		oneId.length === 0 && // 100m
		twoId.length === 0 && // 200m
		fourId.length === 0 && // 400m
		eightId.length === 0 && // 800m
		tenId.length === 0 && // 1500m
		relay1Id.length === 0 && // 4*100
		relay4Id.length === 0 && // 4*400
		shotId.length === 0 && // 铅球
		farId.length === 0 && // 跳远
		heightId.length === 0 && // 跳高
		thereFarId.length === 0 // 三级跳远
	) {
		alert("报名不能为空!")
	} else {
		$.post("", {
				gymnastics : gymnastics, // 广播体操
				tug : tug, // 拔河
				collective : collective, // 集体项目
				standard : standard, // 达标四项
				athle100 : athle100, // 100m
				athle200 : athle200,  // 200m
				athle400 : athle400, // 400m
				athle800 : athle800, // 800m
				athle1500 : athle1500,  // 1500m
				relay1 : relay1,  // 4*100
				relay4 : relay4,  // 4*400
				shot : shot, // 铅球
				far : far,  // 跳远
				height : height,  // 跳高
				thereFar : thereFar // 三级跳远
			},
			function (res) {
				
			}
		);
	};
});

// 查看报名
$(".check").click(function () {
	$(".tip3").css("display", "block");
	console.log($(".name-box").children().length);
	// 广播体操
	for(let prop in gymnastics) {
		for(let obj in gymnastics[prop]) {
			$(".name-box").eq(0).append(`<span>` + gymnastics[prop][obj] + `</span>`);
		}
	};
	// 拔河
	for(let prop in tug) {
		for(let obj in tug[prop]) {
			$(".name-box").eq(1).append(`<span>` + tug[prop][obj] + `</span>`);
		}
	};
	// 100M
	for(let prop in athle100) {
		for(let obj in athle100[prop]) {
			console.log(athle100[prop][obj])
			$(".name-box").eq(2).append(`<span>` + athle100[prop][obj] + `</span>`);
		}
	};
	// 200M
	for(let prop in athle200) {
		for(let obj in athle200[prop]) {
			$(".name-box").eq(3).append(`<span>` + athle200[prop][obj] + `</span>`);
		}
	};
	// 400M
	for(let prop in athle400) {
		for(let obj in athle400[prop]) {
			$(".name-box").eq(4).append(`<span>` + athle400[prop][obj] + `</span>`);
		}
	};
	// 1500M
	for(let prop in athle1500) {
		for(let obj in athle1500[prop]) {
			$(".name-box").eq(5).append(`<span>` + athle1500[prop][obj] + `</span>`);
		}
	};
	// 4*100
	for(let prop in relay1) {
		for(let obj in relay1[prop]) {
			$(".name-box").eq(6).append(`<span>` + relay1[prop][obj] + `</span>`);
		}
	};
	// 4*400
	for(let prop in relay4) {
		for(let obj in relay4[prop]) {
			$(".name-box").eq(7).append(`<span>` + relay4[prop][obj] + `</span>`);
		}
	};
	// 铅球
	for(let prop in shot) {
		for(let obj in shot[prop]) {
			$(".name-box").eq(8).append(`<span>` + shot[prop][obj] + `</span>`);
		}
	};
	// 跳高
	for(let prop in height) {
		for(let obj in height[prop]) {
			$(".name-box").eq(9).append(`<span>` + height[prop][obj] + `</span>`);
		}
	};
	// 跳远
	for(let prop in far) {
		for(let obj in far[prop]) {
			$(".name-box").eq(11).append(`<span>` + far[prop][obj] + `</span>`);
		}
	};
	// 三级跳远
	for(let prop in thereFar) {
		for(let obj in thereFar[prop]) {
			$(".name-box").eq(12).append(`<span>` + thereFar[prop][obj] + `</span>`);
		}
	};
	// 达标四项
	for(let prop in standard) {
		for(let obj in standard[prop]) {
			$(".name-box").eq(13).append(`<span>` + standard[prop][obj] + `</span>`);
		}
	};
	// 集体项目
	for(let prop in collective) {
		for(let obj in collective[prop]) {
			$(".name-box").eq(14).append(`<span>` + collective[prop][obj] + `</span>`);
		}
	};
});

// 查看姓名得提示框关闭按钮
function checkClo() {
	for(let i = 0; i < $(".name-box").length; i ++) {
		$(".name-box").eq(i).empty();
		$(".tip3").css("display","none");
	}
}