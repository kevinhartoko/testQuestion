package com.kevin.codingtest.testQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kevin.codingtest.controller.DataStoreController;

public class TestQuestion1 {

	public static void main(String[] args) {
		//for test functin store
		DataStoreController controller = new DataStoreController();
		List<Map<String, String>> a = new ArrayList<Map<String, String>>();
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("key1","value1");
		map.put("key2","value2");
		HashMap<String, String> map1= new HashMap<String, String>();
		map1.put("keyA","valueA");
		map1.put("keyB","valueB");
		a.add(map);
		a.add(map1);
		String result = controller.store(a);
		System.out.println(result);
		
		//for test function load
		String test = "key3=value3;key4=value4\n" + "keyC=valueC;keyD=valueD";
		List<Map<String, String>> maps = controller.load(test);
		String result1 = maps.toString();
		System.out.println(result1);
	}
}