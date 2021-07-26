package week4;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class FindDirectoryPath {

	@Test
	public void test1() {
		String s = "/home/";
		Assert.assertEquals("/home", findPath(s));
	}

	@Test
	public void test2() {
		String s = "/../";
		Assert.assertEquals("/", findPath(s));
	}

	@Test
	public void test3() {
		String s = "/home//foo/";
		Assert.assertEquals("/home/foo", findPath(s));
	}

	@Test
	public void test4() {
		String s = "/a/./b/../../c/";
		Assert.assertEquals("/c", findPath(s));
	}

	private String findPath(String s) {
		String[] directories = s.split("/");
		Stack<String> stack = new Stack<String>();
		for (String dir : directories) {
			if (dir.isEmpty() || dir.equals("."))
				continue;
			else if (dir.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else
				stack.push(dir);
		}
		StringBuilder sb = new StringBuilder();
		for (String eachEle : stack) {
			sb.append("/").append(eachEle);
		}
		return sb.length() == 0 ? "/" : sb.toString();
	}
}
