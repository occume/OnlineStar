package com.os.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.os.db.domain.Item;

@Service
public class ItemService {
	
	private static Map<Integer, Item> items;
	
	static{
		items = Maps.newHashMap();
		items.put(101, new Item(101, "凉拌铁丝", 66));
		items.put(102, new Item(102, "爆炒砖头", 108));
		items.put(103, new Item(103, "红烧猪蹄", 888));
		items.put(104, new Item(104, "绿豆汤", 10));
		items.put(105, new Item(105, "粉蒸肉", 100));
		items.put(106, new Item(106, "糖醋小排", 200));
	}
	
	public List<Item> getAllItems(){
		return Lists.newArrayList(items.values());
	}
	
	public Item getItemById(int id){
		return items.get(id);
	}
}
