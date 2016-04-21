// �����ǳ����.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"
#include<iostream>
using namespace std;

//�򵥵���˵���ǣ�����ָ�������£�ǳ����ֻ��������һ��ָ��ָ���Ѿ����ڵ��ڴ棬
//�������������һ��ָ�벢������һ���µ��ڴ棬ʹ������ӵ�ָ��ָ������µ��ڴ棬
//�������������£��ͷ��ڴ��ʱ��Ͳ��������ǳ����ʱ�ظ��ͷ�ͬһ�ڴ�Ĵ���


//ǳ������Ҳ�����ڶ�����ʱ��ֻ�ǶԶ����е����ݳ�Ա���м򵥵ĸ�ֵ����������д��ڶ�̬��Ա����ָ�룬ǳ�����ͻ��������
//class A{
//private:
//	char *m_data;     // һָ���Ա  
//
//public:
//	A(){ // ���캯����pָ����з����һ�ռ�  	
//		m_data = new char(100);
//		printf("Ĭ�Ϲ��캯��\n");
//	}
//
//	~A(){ // �����������ͷŶ�̬����Ŀռ� 	
//		if (m_data != NULL){
//			delete m_data;
//			m_data = NULL;
//			printf("��������\n");
//		}
//	}
//};


// ����������������Գ�Ա��������ָ���������������Ǽ򵥵�ָ�븳ֵ���������·����ڴ�ռ�
class A{
private:
	char *m_pdata;     // һָ���Ա  

public:
	A(){ // ���캯����pָ����з����һ�ռ�  	
		m_pdata = new char(100);
		printf("Ĭ�Ϲ��캯��\n");
	}

	A(const A& r){
		m_pdata = new char(100);    // Ϊ�¶������¶�̬����ռ�  
		memcpy(m_pdata, r.m_pdata, strlen(r.m_pdata));
		printf("copy���캯��\n");
	}

	~A(){ // �����������ͷŶ�̬����Ŀռ�	
		if (m_pdata != NULL){
			delete m_pdata;
			printf("��������\n");
		}
	}
};

int main()
{
	A a;
	A b(a);   // ���ƶ���  

	char str[10];
	cin >> str;
	cout << str;

	return 0;
}



