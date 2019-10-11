package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import adt.linkedList.set.SetLinkedListImpl;

public class Testes {
	
	SetLinkedListImpl<Integer> setInteger = new SetLinkedListImpl<Integer>();
	SetLinkedListImpl<Integer> setInteger2 = new SetLinkedListImpl<Integer>();
	SetLinkedListImpl<Integer> setIntegerUnion = new SetLinkedListImpl<Integer>();
	SetLinkedListImpl<Integer> setIntegerIntersection = new SetLinkedListImpl<Integer>();
	SetLinkedListImpl<Integer> setIntegerConcatenate = new SetLinkedListImpl<Integer>();
	
	SetLinkedListImpl<String> setString = new SetLinkedListImpl<String>();
	SetLinkedListImpl<String> setString2 = new SetLinkedListImpl<String>();
	SetLinkedListImpl<String> setStringUnion = new SetLinkedListImpl<String>();
	SetLinkedListImpl<String> setStringIntersection = new SetLinkedListImpl<String>();
	SetLinkedListImpl<String> setStringConcatenate = new SetLinkedListImpl<String>();

	
	@Test
	void testInteger() {
		for(int i = 0; i < 5; i++)setInteger.insert(i);
		for(int i = 2; i < 8; i++)setInteger2.insert(i);
		for(int i = 0; i < 8; i++)setIntegerUnion.insert(i);
		for(int i = 2; i < 5; i++)setIntegerIntersection.insert(i);
		for(int i = 0; i < 8; i++)setIntegerConcatenate.insert(i);
		
		
		assertEquals(Arrays.toString(setIntegerUnion.toArray()),Arrays.toString((setInteger.union(setInteger2)).toArray()));
		assertEquals(Arrays.toString(setIntegerIntersection.toArray()),Arrays.toString((setInteger.intersection(setInteger2)).toArray()));
		setInteger.concatenate(setInteger2);
		assertEquals(Arrays.toString(setIntegerConcatenate.toArray()),Arrays.toString((setInteger).toArray()));
		
	}

	void testString() {
		setString.insert("a");setString.insert("b");setString.insert("c");setString.insert("d");
		setString.insert("e");setString.insert("f");setString.insert("g");setString.insert("g");
		
		setString2.insert("e");setString2.insert("f");setString2.insert("g");setString2.insert("g");
		setString2.insert("h");setString2.insert("i");setString2.insert("j");setString2.insert("k");
		
		setStringUnion.insert("a");setStringUnion.insert("b");setStringUnion.insert("c");setStringUnion.insert("d");
		setStringUnion.insert("e");setStringUnion.insert("f");setStringUnion.insert("g");setStringUnion.insert("g");
		setStringUnion.insert("h");setStringUnion.insert("i");setStringUnion.insert("j");setStringUnion.insert("k");
		
		setStringIntersection.insert("e");setStringIntersection.insert("f");
		setStringIntersection.insert("g");setStringIntersection.insert("g");
		
		setStringConcatenate.insert("a");setStringConcatenate.insert("b");
		setStringConcatenate.insert("c");setStringConcatenate.insert("d");
		setStringConcatenate.insert("e");setStringConcatenate.insert("f");
		setStringConcatenate.insert("g");setStringConcatenate.insert("g");
		setStringConcatenate.insert("h");setStringConcatenate.insert("i");
		setStringConcatenate.insert("j");setStringConcatenate.insert("k");
		
		
		
		assertEquals(Arrays.toString(setStringUnion.toArray()),Arrays.toString((setString.union(setString2)).toArray()));
		assertEquals(Arrays.toString(setStringIntersection.toArray()),Arrays.toString((setString.intersection(setString2)).toArray()));
		setString.concatenate(setString2);
		assertEquals(Arrays.toString(setStringConcatenate.toArray()),Arrays.toString((setString).toArray()));
		
	}

}
