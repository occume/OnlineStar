;
$(function(){
	
	$("#wordcloud").awesomeCloud({
		"size" : {
			"grid" : 8,
			"factor" : 0,
			"normalize" : true
		},
		"options" : {
			"color" : "random-dark",
			"rotationRatio" : 0,
			"printMultiplier" : 1,
			"sort" : "highest"
		},
		"shape" : "circle"
	});
	
	var upBang = {
		run: function(){
			if(!$("#upbang").length) return;
			this.tags = [];
			this.render();
			this.bind();
		},
		getData: function(){
			Http.get("tags", "", "json", _.bind(this.onData, this));
		},
		onData: function(data){
			var html = "";
			$(data).each(function(idx, itm){
				var parts = itm.split(",");
				html += '<span class="label label-success" data-tag-id="'+ parts[1] +'">'+ parts[0] +'</span>';
			});
			$(".d3-tags-wrp").html(html);
		},
		render: function(){
			this.getData();
		},
		bind: function(){
			var self = this;
			$(document)
			.on("click", ".d3-tags-wrp span", function(){
				var me = $(this),
					tagId = me.attr("data-tag-id");
				if(me.attr('selected')){
					me.attr('selected', !1);
					me.removeClass("label-warning");
					self.tags = _.without(self.tags, tagId)
				}
				else{
					me.attr('selected', !0);
//					self.tags.push(me.attr("data-tag-id"));
					self.tags = [me.attr("data-tag-id")];
					me.siblings().removeClass("label-warning");
					me.siblings().attr('selected', !1);
					me.addClass("label-warning");
				}
			});
			
			var upBangForm = $("#up-bang-form");
			$("#btn-send")
			.click(function(){
				upBangForm.append("<input type='hidden' name='tags' value='"+ self.tags.join(",") +"'>");
				upBangForm.submit();
			});
		}
	};
	upBang.run();
	
	var Opinions = {
		run: function(){
			var opinions = $("#opinions");
			if(!opinions.length) return;
			this.container = opinions.find(".info-box");
			this.render(1);
			this.template = $("#temp_opinions_item").html();
		},
		getData: function(){
			Http.get("opinions/all", "", "json", _.bind(this.onData, this));
		},
		onData: function(data){
			this.model = data;
			var temp = this.template;
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
	Opinions.run();
});