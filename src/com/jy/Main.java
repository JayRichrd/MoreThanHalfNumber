package com.jy;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		System.out.println("数组元素:" + Arrays.toString(numbers));
		System.out.print("数量超出一半的数字:" + moreThanHalfNumbers(numbers));
	}

	/**
	 * 查找数组中数量超过一半的数字
	 * 
	 * @param numbers
	 *            待查找的数组
	 * @return 数量超过一般的数字
	 */
	public static int moreThanHalfNumbers(int[] numbers) {
		int arrayLength = numbers.length;
		// 鲁棒性检查
		if (numbers == null || arrayLength <= 0)
			throw new RuntimeException("Invalid Input!!!");

		// 保存一个数
		int result = numbers[0];
		// 保存次数
		int times = 1;

		// 循环寻找
		for (int i = 1; i < arrayLength; i++) {
			if (times == 0) {
				result = numbers[i];
				times = 1;
			} else if (result == numbers[i])
				times++;
			else
				times--;
		}

		// 检查找出的数在数组中是否超过数组元素总和的一般
		int sumTimes = 0;
		for (int i : numbers) {
			if (i == result)
				sumTimes++;
		}
		if (sumTimes < (arrayLength >> 1))
			throw new RuntimeException("there is no number more than half of the array!");

		// 返回数量超过数组元素总和一般的数字
		return result;

	}

}
