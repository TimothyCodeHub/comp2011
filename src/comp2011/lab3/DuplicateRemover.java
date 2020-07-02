package comp2011.lab3;

import java.lang.reflect.Array;
import java.util.*;

public class DuplicateRemover {
	public static String remove(String s) {
		char[] oldData = new char[s.length()];
		String word = s;
		int len = s.length();
		for (int i = 0; i < oldData.length; i++) {
			oldData[i] = word.charAt(i);  //change char to string
			
		}
	     
		// check duplicate
		for (int i = 0; i < oldData.length-1; i++) {
			for (int j = i+1; j < oldData.length; j++) {
				if (oldData[i]==oldData[j] && oldData[i]!='@') {
					oldData[i]='@';
					oldData[j]='@';
					
				}
			}
		}
		
		//gen a new string
		String newword = new String();
		for (int i = 0; i < len; i++) {
			if(oldData[i]!='@')
			  newword = newword + oldData[i];
		}
		
        return newword;
	}
	
	public static void main(String[] args) {
		String s;
		s = "careermonk";
		System.out.println(s + " becomes " + remove(s));
		s = "mississippi";
		System.out.println(s + " becomes " + remove(s));
	}
}
