package org.sendmsg.test;

import java.util.List;

import org.d3.wx.api.Out;
import org.d3.wx.vo.ArticleItem;

import com.google.common.collect.Lists;

public class OutTest {

	public static void main(String[] args) {
		sendNewsMsg();
	}

	public static void sendNewsMsg(){
		List<ArticleItem> items = Lists.newArrayList();
//		items.add(new ArticleItem("title", "asdf", "123", "234"));
		Out.sendCSNewsMsg(Lists.newArrayList("oGDxut6UIp27um1Z7eDOeImRzcYg"), items);
	}
}
