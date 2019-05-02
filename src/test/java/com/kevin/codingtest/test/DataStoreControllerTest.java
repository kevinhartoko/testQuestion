package com.kevin.codingtest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.kevin.codingtest.controller.DataStoreController;

public class DataStoreControllerTest {
	DataStoreController controller = new DataStoreController();
	
	@Test
	public void testStoreExpectedSuccess() {
		String expected = "key1=value1;key2=value2\nkeyA=valueA;keyB=valueB";
		
		List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
		Map<String, String> map= new HashMap<String, String>();
		map.put("key1","value1");
		map.put("key2","value2");
		Map<String, String> map1= new HashMap<String, String>();
		map1.put("keyA","valueA");
		map1.put("keyB","valueB");
		maps.add(map);
		maps.add(map1);
		String result = controller.store(maps);
		assertEquals(expected, result);
	}
	
	@Test
	public void testLoadExpectedSuccess() {
		List<Map<String, String>> expected = new ArrayList<Map<String, String>>();
		Map<String, String> map= new HashMap<String, String>();
		map.put("key3","value3");
		map.put("key4","value4");
		Map<String, String> map1= new HashMap<String, String>();
		map1.put("keyC","valueC");
		map1.put("keyD","valueD");
		expected.add(map);
		expected.add(map1);
		
		String test = "key3=value3;key4=value4\nkeyC=valueC;keyD=valueD";
		List<Map<String, String>> maps = controller.load(test);
		assertEquals(expected, maps);
	}
}
