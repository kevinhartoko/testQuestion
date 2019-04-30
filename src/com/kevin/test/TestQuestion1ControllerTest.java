package com.kevin.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import com.kevin.controller.TestQuestion1Controller;

public class TestQuestion1ControllerTest {
	TestQuestion1Controller controller = new TestQuestion1Controller();
	
	@Test
	public void store_expectedSuccess() {
		String expected = "key1=value1;key2=value2\nkeyA=valueA;keyB=valueB";
		
		ArrayList<HashMap<String, String>> maps = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("key1","value1");
		map.put("key2","value2");
		HashMap<String, String> map1= new HashMap<String, String>();
		map1.put("keyA","valueA");
		map1.put("keyB","valueB");
		maps.add(map);
		maps.add(map1);
		String result = controller.store(maps);
		assertEquals(expected, result);
	}
	
	@Test
	public void load_expectedSuccess() {
		ArrayList<HashMap<String, String>> expected = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("key3","value3");
		map.put("key4","value4");
		HashMap<String, String> map1= new HashMap<String, String>();
		map1.put("keyC","valueC");
		map1.put("keyD","valueD");
		expected.add(map);
		expected.add(map1);
		
		String test = "key3=value3;key4=value4\nkeyC=valueC;keyD=valueD";
		ArrayList<HashMap<String, String>> maps = controller.load(test);
		assertEquals(expected, maps);
	}
}
