// MinArraySubtraction.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include<iostream>
#include<math.h>
#include<vector>
using namespace std;

//题意描述：有两个升序的数组A，B 求|A[i]-B[j]|的最小值

int GetMinArraySubtraction(int A[], int lenA, int B[], int lenB) {
	if (lenA == 0 && lenB == 0)
		return 0;
	if (A[0] > B[lenB - 1])
		return A[0] - B[lenB - 1];
	if (B[0] > A[lenA - 1])
		return B[0] - A[lenA - 1];

	int min = abs(A[0] - B[0]);//所求最小

	int i = 0, j = 0;
	if (A[i] > B[j])
		j++;
	else i++;

	int flagA = 0;//记录数组上一个下标
	int flagB = 0;
	while (i < lenA && j < lenB) {
		if (A[i] > B[j]) {
			int temp = abs(A[flagA] - B[j]);
			min = temp < min ? temp : min;

			flagB = j;
			j++;
		}
		else {
			int temp = abs(A[i] - B[flagB]);
			min = temp < min ? temp : min;

			flagA = i;
			i++;
		}
	}

	while (i < lenA) {//B遍历完了
		int temp = abs(A[i++] - B[flagB]);
		min = temp < min ? temp : min;
	}
	while (j < lenB) {//A遍历完了
		int temp = abs(B[j++] - A[flagA]);
		min = temp < min ? temp : min;
	}

	return min;
}

int minA_B(vector<int>& A, vector<int>& B) {
	int lenA = A.size(), lenB = B.size();
	if (lenA == 0 && lenB == 0)return 0;
	//if (lenA == 0)return min(abs(B[0]), abs(B[lenB - 1]));
	//if (lenB == 0)return min(abs(A[0]), abs(A[lenA - 1]));

	int minV = 0x7fffffff;
	for (int i = 0; i<lenA; i++) {
		int beginB = 0;
		int thisV = minV;
		for (int j = beginB; j<lenB; j++) {
			if (abs(A[i] - B[j])<thisV) {
				thisV = abs(A[i] - B[j]);
				++beginB;
			}
			else {
				break;
			}
		}
		if (thisV<minV)minV = thisV;
	}
	return minV;
}


int main()
{
	int arrayA[] = { 1,10,23,45,97 };
	int arrayB[] = { 6,17,33,62,87,96 };
	int arrayC[] = { 6,17,33,62,87,98 };	
	cout << GetMinArraySubtraction(arrayA, 5, arrayB, 6) << endl;
	cout << GetMinArraySubtraction(arrayA, 5, arrayC, 6) << endl;

	vector<int> v1 = { 1,10,23,45,97 };
	vector<int> v2 = { 6,17,33,62,87,96 };
	vector<int> v3 = { 6,17,33,62,87,98 };
	cout << minA_B(v1, v2) << endl;
	cout << minA_B(v1, v3) << endl;

    return 0;
}

