// 深拷贝和浅拷贝.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include<iostream>
using namespace std;

//简单的来说就是，在有指针的情况下，浅拷贝只是增加了一个指针指向已经存在的内存，
//而深拷贝就是增加一个指针并且申请一个新的内存，使这个增加的指针指向这个新的内存，
//采用深拷贝的情况下，释放内存的时候就不会出现在浅拷贝时重复释放同一内存的错误！


//浅拷贝：也就是在对象复制时，只是对对象中的数据成员进行简单的赋值，如果对象中存在动态成员，即指针，浅拷贝就会出现问题
//class A{
//private:
//	char *m_data;     // 一指针成员  
//
//public:
//	A(){ // 构造函数，p指向堆中分配的一空间  	
//		m_data = new char(100);
//		printf("默认构造函数\n");
//	}
//
//	~A(){ // 析构函数，释放动态分配的空间 	
//		if (m_data != NULL){
//			delete m_data;
//			m_data = NULL;
//			printf("析构函数\n");
//		}
//	}
//};


// 深拷贝：对于深拷贝，针对成员变量存在指针的情况，不仅仅是简单的指针赋值，而是重新分配内存空间
class A{
private:
	char *m_pdata;     // 一指针成员  

public:
	A(){ // 构造函数，p指向堆中分配的一空间  	
		m_pdata = new char(100);
		printf("默认构造函数\n");
	}

	A(const A& r){
		m_pdata = new char(100);    // 为新对象重新动态分配空间  
		memcpy(m_pdata, r.m_pdata, strlen(r.m_pdata));
		printf("copy构造函数\n");
	}

	~A(){ // 析构函数，释放动态分配的空间	
		if (m_pdata != NULL){
			delete m_pdata;
			printf("析构函数\n");
		}
	}
};

int main()
{
	A a;
	A b(a);   // 复制对象  

	char str[10];
	cin >> str;
	cout << str;

	return 0;
}



