//wx.config({
//    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
//    appId: 'wx1b7a5432dfba7d65', // 必填，公众号的唯一标识
//    timestamp: 1426851610474, // 必填，生成签名的时间戳
//    nonceStr: '406dd99d-b829-4506-ad37-60c407c6213c', // 必填，生成签名的随机串
//    signature: 'd5422f5476e41c7172c75b39cef54f305158b779',// 必填，签名，见附录1
//    jsApiList: [
//                'checkJsApi',
//                'onMenuShareTimeline',
//                'onMenuShareAppMessage',
//                'onMenuShareQQ',
//                'onMenuShareWeibo',
//                'hideMenuItems',
//                'showMenuItems',
//                'hideAllNonBaseMenuItem',
//                'showAllNonBaseMenuItem',
//                'translateVoice',
//                'startRecord',
//                'stopRecord',
//                'onRecordEnd',
//                'playVoice',
//                'pauseVoice',
//                'stopVoice',
//                'uploadVoice',
//                'downloadVoice',
//                'chooseImage',
//                'previewImage',
//                'uploadImage',
//                'downloadImage',
//                'getNetworkType',
//                'openLocation',
//                'getLocation',
//                'hideOptionMenu',
//                'showOptionMenu',
//                'closeWindow',
//                'scanQRCode',
//                'chooseWXPay',
//                'openProductSpecificView',
//                'addCard',
//                'chooseCard',
//                'openCard'
//              ]
//});
//
//wx.error(function(res){
//	
//});
//wx.ready(function(){
	
//});
$(function(){
	/**
	 *  列表渲染
	 */
	var FoodListView = {
		container: $(".food-list-wrp"),
		getData: function(id){
			Http.get("food/list/" + id, "", "json", _.bind(this.onData, this));
		},
		onData: function(data){
			this.model = data;
			var temp = $("#temp_food_list_item").html();
			var html = "";
			$(data).each(function(idx, itm){
				html += Template.parse(temp, itm);
			});
			this.container.append(html);
		},
		follow: function(id){
			Http.post("follow/" + id, "", "json", _.bind(this.onFollow, this))
		},
		onFollow: function(data){
			console.log(data);
		},
		bind: function(){
			$(".food-list .f-item .f-item-3").on("click", function(){
				
				var self = $(this),
					youkuId = self.attr("data-item-youkuid")
					;
				
				FoodListView.follow(youkuId);
				self.removeCss("f-item-3").addCss("f-item-4");
				dialog.alert("已到碗里");
			});
		},
		render: function(page){
			this.bind();
		}
	};
	FoodListView.render(1);
});

