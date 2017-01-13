$(function(){
	
	/**
	 * 购物车
	 */
	var cartView = {
		container: 	$("#mc-cart tbody"),
		getData: function(){
			var cart = Storage.get("cart");
			if(cart){
				this.onData(cart);
			}
		},
		template: function(){
			var temp = "<tr class='{clazz}'>" +
				       "     <td>{name}</td>" +
				       "     <td>{price}</td>" +
				       "     <td>{count}</td>" +
				       "</tr>";
			return temp;
		},
		onData: function(data){
			this.model = data;
//			var temp = this.template();
			var temp = $("#temp_cart_item tbody").html();
			var html = "";
			$(data).each(function(idx, itm){
				if(idx % 2 == 1){
					itm['clazz'] = "pure-table-odd";
				}
				html += Template.parse(temp, itm);
			});
			this.container.append(html);
		},
		change: function(count){
			$("#cart-count").html(Cart.count());
			$("#cart-total-count").html(Cart.count());
			$("#cart-total-price").html(Cart.totalPrice());
		},
		incCartCount: function(itemId){
			Cart.add({id: itemId});
			this.change();
		},
		decCartCount: function(itemId){
			Cart.remove({id: itemId});
			this.change();
		},
		clear: function(){
			Cart.clear();
			this.change();
			this.container.html("");
		},
		ordering: function(cart){
			Http.post("ordering", cart, "json", _.bind(this.onOrdered, this));
		},
		onOrdered: function(data){
			console.log(data);
		},
		bind: function(){
			var self = this;
			$(".clean-btn").on("click", function(){
				self.clear();
			})
			$(".cart-inc").on("click", function(){
				var 
					next = $(this).next(),
					count = parseInt(next.html());
				next.html(count + 1);
				var itemId = $(this).parent().attr("data-item-id");
				
				self.incCartCount(itemId);
			});
			$(".cart-dec").on("click", function(){
				var me = $(this),
					prev = me.prev(),
					count = parseInt(prev.html());
				if(count == 1){
					me.parents("tr").remove();
				}
				prev.html(count - 1);
				var itemId = me.parent().attr("data-item-id");
				self.decCartCount(itemId);
			});
			$(".done-btn").on("click", function(){
				var cart = Cart.getAll();
				self.ordering(cart);
			})
		},
		render: function(){
			this.change();
			this.getData();
			this.bind();
		}
	}
	cartView.render();
});
