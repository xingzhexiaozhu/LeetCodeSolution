// Shuffle.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"

#include<iostream>
using namespace std;

#define MAX 54

/*全局洗牌法：
1）首先生成一个数组，大小为54，初始化为1-54；
2）按照索引1到54逐步对每一张索引牌进行洗牌，首先生成一个余数value=rand，索引牌就和这个余数牌进行交换
3）等索引到54一副牌就洗好了
*/
void get_rand_number(int array[], int length) {
	int index;
	int value;
	int temp;

	if (NULL == array || 0 == length)
		return;

	//每次发牌的时候任意分配待交换的数据
	for (int index = 0; index < length; index++) {
		value = rand() % length;

		temp = array[index];
		array[index] = array[value];
		array[value] = temp;
	}
}

/*局部洗牌法：
针对上面的洗牌算法，发现每次洗牌之后原来洗好的牌都会进行二次操作，所以可以改进：
1）同样首先生成一个大小为54的数组，数组排列为1-54
2）索引牌从1开始到54结束。这一次索引牌只和剩下还没有洗的牌进行交换，value=index+rand()%(54-index)
3）等到所有的索引牌都洗好之后一副牌就洗好了
*/
void get_rand_number2(int array[], int length) {
	int index;
	int value;
	int temp;

	if (NULL == array || 0 == length)
		return;

	//发牌的时候对于已经分配的数据不再修改
	for (int index = 0; index < MAX; index++) {
		value = index + rand() % (length - index);

		temp = array[index];
		array[index] = array[value];
		array[value] = temp;
	}
}


int main()
{
	int array[MAX];
	for (int i = 0; i < MAX; i++) {
		array[i] = i + 1;
		cout << array[i] << " ";
	}
	cout << endl;

	//全局洗牌法
	get_rand_number(array, MAX);
	for (int i = 0; i < MAX; i++) {
		cout << array[i] << " ";
	}
	cout << endl;

	//局部洗牌法
	get_rand_number2(array, MAX);
	for (int i = 0; i < MAX; i++) {
		cout << array[i] << " ";
	}
	cout << endl;

    return 0;
}

