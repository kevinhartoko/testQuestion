package com.kevin.testQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TestQuestion1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for test functin store
		ArrayList<HashMap<String, String>> a = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("key1","value1");
		map.put("key2","value2");
		HashMap<String, String> map1= new HashMap<String, String>();
		map1.put("keyA","valueA");
		map1.put("keyB","valueB");
		a.add(map);
		a.add(map1);
		String result = store(a);
		System.out.println(result);
		
		//for test function load
		String test = "key3=value3;key4=value4\n" + "keyC=valueC;keyD=valueD";
		ArrayList<HashMap<String, String>> maps = load(test);
		String result1 = maps.toString();
		System.out.println(result1);
	}
	
	private static String store(ArrayList<HashMap<String, String>> a) {
		String result = "";
		for(int i=0;i<a.size();i++) {
			Set<String> keys = a.get(i).keySet();
			Iterator<String> iterator= keys.iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				result = result+key+"="+a.get(i).get(key);
				if(iterator.hasNext()){
					result= result+";";
				}else {
					result= result+"\n";
				}
			}
		}
		return result;
	}
	
	private static ArrayList<HashMap<String, String>> load(String a){
		ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		String[] stringMap = a.split("\n");
		for(int i =0;i<stringMap.length;i++) {
			HashMap<String, String> map= new HashMap<String, String>();
			String[] set = stringMap[i].split(";");
			for(int j=0;j<set.length;j++) {
				String[] valueKey = set[j].split("=");
				map.put(valueKey[0], valueKey[1]);
			}
			result.add(map);
		}
		return result;
	}
}
