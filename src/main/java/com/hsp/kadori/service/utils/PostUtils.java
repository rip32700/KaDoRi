package com.hsp.kadori.service.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hsp.kadori.domain.Post;

public class PostUtils {
	
	public static List<Post> mergeAndSort(List<Post> l1, List<Post> l2) {
		List<Post> resultList = new ArrayList<>();
		if(l1 != null) {
			resultList.addAll(l1);
		}
		if(l2 != null) {
			resultList.addAll(l2);
		}
		
		resultList.sort((Post p1, Post p2)->p1.getCreationTime().compareTo(p2.getCreationTime()));
		Collections.reverse(resultList);
		
		return resultList;
	}
	
}
