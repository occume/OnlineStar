//var _ = {};
//var ArrayProto = Array.prototype, FuncProto = Function.prototype;
//var nativeBind = FuncProto.bind;
//var slice            = ArrayProto.slice;
//var ctor = function(){};
//_.bind = function(func, context) {
//    var args, bound;
//    if (nativeBind && func.bind === nativeBind) return nativeBind.apply(func, slice.call(arguments, 1));
//    if (!_.isFunction(func)) throw new TypeError;
//    args = slice.call(arguments, 2);
//    return bound = function() {
//      if (!(this instanceof bound)) return func.apply(context, args.concat(slice.call(arguments)));
//      ctor.prototype = func.prototype;
//      var self = new ctor;
//      ctor.prototype = null;
//      var result = func.apply(self, args.concat(slice.call(arguments)));
//      if (Object(result) === result) return result;
//      return self;
//    };
//  };
var Http = {
	get: function(url, data, dataType, caller) {
		Http.request(url, "GET", data, dataType, caller)
	},
	post: function(url, data, dataType, caller) {
		Http.request(url, "POST", data, dataType, caller)
	},
	request: function(url, type, data, dataType, caller) {
		$.ajax({
			url : url,
			type : type,
			cache : false,
			data : data,
			datatype : dataType,
			contentType : 'application/json',
			success : function(data) {
				if (caller)
					caller.call(null, data);
			}
		});
	},
	wait : function() {
		var anim = $("#wait-animate"), tiles = anim.children(), curr = -1;
		anim.show();
		this.loop = setInterval(function() {
			var elem = tiles[curr++ % 6];
			tiles.css({
				background : "#fff"
			});
			$(elem).css({
				background : "#368EE0"
			});
		}, 250);
	},
	stopWait : function() {
		if (this.loop) {
			clearInterval(this.loop);
			$("#wait-animate").hide();
		}
	}
};

var Template = {
		hull: function(fn){
			/**
			 * %20 空格
			 * %0D 换行
			 * %0A 回车
			 * %09 制表
			 */
			var origHtml = fn.toString(),
			removeOut = /.*{\/(.*)\/}/;
			var html = origHtml.match(removeOut),
				/**
				 * 替换所有 空格， 回车， 换行， 制表
				 */
				htmlNoGap = encodeURIComponent(origHtml).replace(/(%0D|%0A|%09)/g, ""),
				/**
				 * 还原
				 */
				html2 = decodeURIComponent(htmlNoGap),
				/**
				 * 去除函数格式
				 */
				html3 = html2.match(removeOut)[1],
				/**
				 * 最终html字符串
				 */
				ret = html3.replace(/\*/g, "");
			return ret;
		},
		parse: function(temp, data) {
			return temp.replace(/\\?\{([^{}]+)\}/g, function(match, name) {
				var ret;
				if (name.indexOf(".") >= 0) {
					var n = name.split(".");
					ret = data[n[0]][n[1]];
				} else {
					ret = (data[name] === undefined) ? '' : data[name];
				}
				return ret;
			});
		}
	};


var dialog = {
		height: 100,
		wrap: "#dialog",
		show: function(){
			$(this.wrap).animate({top: 0});
		},
		alert: function(msg){
			clearTimeout(dialog.tmid);
			$(this.wrap).html(msg);
			
			this.show();
			this.tmid = setTimeout(function(){
				$(dialog.wrap).animate({top: -200});
				clearTimeout(dialog.tmid);
			}, 3000);
		}
	};
var Cart = {
	getAll: function(){
		var cart = Storage.getString("cart");
		return cart;
	},
	add: function(item){
		var cart = Storage.get("cart");
		
		if(cart){
			var _index = _.findIndex(cart, item, "id");
			console.log(_index);
			if(_index >= 0){
				var _item = cart[_index],
					_count = _item.count + 1;
				_item.count = _count;
			}
			else{
				cart.push(item);
			}
		}
		else{
			cart = [item];
		}
		Storage.put("cart", cart);
	},
	remove: function(item){
		var cart = Storage.get("cart");
		
		var _index = _.findIndex(cart, item, "id");
		if(_index >= 0){
			var _item = cart[_index];
			if(_item.count > 1){
				_count = _item.count - 1;
				_item.count = _count;
			}
			else{
				cart.splice(_index, 1);
			}
		}
		
		Storage.put("cart", cart);
	},
	count: function(){
		var count = 0;
			cart = Storage.get("cart");
		if(cart && cart.length){
			cart.forEach(function(itm, idx){
				count += itm.count;
			});
		}
		return count;
	},
	totalPrice: function(){
		var count = 0;
			cart = Storage.get("cart");
		if(cart && cart.length){
			cart.forEach(function(itm, idx){
				count += itm.count * itm.price;
			});
		}
		return count;
	},
	clear: function(){
		Storage.put("cart", "");
	}
};
var Storage = {
	put: function(key, value){
		localStorage.setItem(wrapedKey(key), JSON.stringify(value));
	},
	get: function(key){
		var value = localStorage.getItem(wrapedKey(key));
		return JSON.parse(value);
	},
	getString: function(key){
		return localStorage.getItem(wrapedKey(key));
	},
	remove: function(key){
		localStorage.removeItem(wrapedKey(key));
	},
	alter: function(key, attr, value){
		var value = localStorage.getItem(wrapedKey(key)),
			cart = JSON.parse(value);
		cart.forEach(function(itm, idx){
//			if()
		});
	}
};

var wrapedKey = function(key){
	return "MyCity:" + key;
}

$(function(){
	var cart = Storage.get("cart");

	if(cart){
		$("#cart-count").html(Cart.count());
	}
})