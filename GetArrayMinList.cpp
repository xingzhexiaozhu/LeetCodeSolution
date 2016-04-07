// GetArrayMinList.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include"stdafx.h"

//��������������һ�����������飬������������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ��
//��:���������3��32��321�������ӡ���������������ų���С������Ϊ321323


//����˼·����������Ҫ��������m��n��ƴ�ӳ�����mn��nm�����mn<nm��ôӦ�ô�ӡ��mn��Ҳ����m��n��ǰ�棬������Ƕ���m<n
//�������������ֵ�ƴ�ӣ�����m��n����int��Χ�ڣ���������ƴ������������mn��nm��int��ʾ�Ϳ�������ӣ������⻹��һ�����δ�������
#include<iostream>

#include<algorithm>
#include<string>
#include<sstream>

#include<vector>

using namespace std;


bool cmp(const int &num1, const int &num2) {
	string _str1 = to_string(num1);
	string _str2 = to_string(num2);
	_str1.append(_str2);
	_str2.append(_str1);

	return _str1 < _str2;
}

string PrintMinNumber(vector<int> numbers) {
	sort(numbers.begin(), numbers.end(), cmp);
	string res;
	for (int i = 0; i < numbers.size(); i++)
		res += to_string(numbers[i]);
	return res;
}


int main() {
	vector<int> v = { 3,32,321 };
	cout << PrintMinNumber(v) << endl;
}

//�ⷨһ��
//int compare1(string str1, string str2)//�Զ���ıȽϴ�С�ĺ�����str1 "С"�Ļ�������true
//{
//	string tmp1 = str1.append(str2);
//	string tmp2 = str2.append(str1);
//	if (tmp1.compare(tmp2)<0)
//		return true;
//	return false;
//}
//
//int main()
//{
//	int num[] = { 3,32,321 };
//	int len = sizeof(num) / sizeof(int);
//	cout << "len = " << len << endl;
//	string *word = new string[len];
//	stringstream sst;
//	for (int i = 0; i<len; i++)//��int����ת�����ַ���
//	{
//		sst << num[i];
//		sst >> word[i];
//		sst.clear();
//	}
//	cout << endl;
//	sort(word, word + len, compare1);//���÷����㷨����
//	for (int i = 0; i<len; i++)
//	{
//		cout << word[i];
//	}
//	getchar();
//	return 0;
//}


//�ⷨ�����麯��
//struct num_compare
//{
//	bool operator()(const int &lhs, const int &rhs) {
//		return to_string(lhs) + to_string(rhs) < to_string(rhs) + to_string(lhs);
//	}
//};
//string PrintMinNumber(vector<int> numbers) {
//	sort(numbers.begin(), numbers.end(), num_compare());
//	string res;
//	for (int i = 0; i < numbers.size(); i++)
//		res += to_string(numbers[i]);
//	return res;
//}
//
//int main() {
//	vector<int> v = { 3,32,321 };
//	cout << PrintMinNumber(v) << endl;
//}


//
//bool cmp(const string &str1, const string &str2) {
//	string _str1 = str1;
//	string _str2 = str2;
//	_str1.append(str2);
//	_str2.append(str1);
//
//	return _str1 < _str2;
//}
//int num[200];
//string str_num[200];
//int main() {
//	int n;
//	while (cin >> n) {
//		for (int i = 0; i < n; i++) {
//			cin >> num[i];
//			stringstream stream;
//			stream << num[i];
//			str_num[i] = stream.str();
//		}
//
//		sort(str_num, str_num + n, cmp);
//
//		for (int i = 0; i < n; i++) {
//			cout << str_num[i];
//		}
//		cout << endl;
//	}
//
//	return 0;
//}