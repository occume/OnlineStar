
$(function(){
	/**
	 *  内容写入
	 */
	var WxView = {
		container: $(".info-box"),
		getData: function(){
			Http.get("wx/list", "", "json", _.bind(this.onData, this));
		},
		onData: function(data){
			this.model = data;
			var temp = Template.hull(wx_info_item);
			var html = "";
			$(data).each(function(idx, itm){
				html += Template.parse(temp, itm);
			});
			this.container.append(html);
		},
		render: function(page){
			this.getData();
		}
	};
	WxView.render(1);
});

wx.config({
    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: 'wx1b7a5432dfba7d65', // 必填，公众号的唯一标识
    timestamp: 1426833863844, // 必填，生成签名的时间戳
    nonceStr: 'a9f83745-16d0-48b2-a6d6-921c4d0a37b7', // 必填，生成签名的随机串
    signature: '4a90ae91d46afaf4639047f59c6790f991d8554b',// 必填，签名，见附录1
    jsApiList: [
                'checkJsApi',
                'onMenuShareTimeline',
                'onMenuShareAppMessage',
                'onMenuShareQQ',
                'onMenuShareWeibo',
                'hideMenuItems',
                'showMenuItems',
                'hideAllNonBaseMenuItem',
                'showAllNonBaseMenuItem',
                'translateVoice',
                'startRecord',
                'stopRecord',
                'onRecordEnd',
                'playVoice',
                'pauseVoice',
                'stopVoice',
                'uploadVoice',
                'downloadVoice',
                'chooseImage',
                'previewImage',
                'uploadImage',
                'downloadImage',
                'getNetworkType',
                'openLocation',
                'getLocation',
                'hideOptionMenu',
                'showOptionMenu',
                'closeWindow',
                'scanQRCode',
                'chooseWXPay',
                'openProductSpecificView',
                'addCard',
                'chooseCard',
                'openCard'
              ]
});
wx.error(function(res){
	console.log(res);
});
wx.ready(function(){
	wx.checkJsApi({
	    jsApiList: ['chooseImage'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
	    success: function(res) {
	        // 以键值对的形式返回，可用的api值true，不可用为false
	        // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
	    	console.log(res);
	}});
	wx.onMenuShareTimeline({
	    title: '', // 分享标题
	    link: '', // 分享链接
	    imgUrl: '', // 分享图标
	    success: function () { 
	        // 用户确认分享后执行的回调函数
	    },
	    cancel: function () { 
	        // 用户取消分享后执行的回调函数
	    }
	});
});
