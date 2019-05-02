package com.kevin.codingtest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataStoreController {
	public String store(List<Map<String, String>> a) {
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
					if(i!=a.size()-1) {
						result= result+"\n";
					}
				}
			}
		}
		return result;
	}
	
	public List<Map<String, String>> load(String a){
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
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
