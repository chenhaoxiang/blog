// test.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "Student.h"
#include <stdio.h>
#include <tchar.h>
#include<iostream>

using namespace std;

//��ʵ���޷���������ֻ��Ϊ����ʾ
int main(int argc, char* argv[])
{
	Student stu;
	//ͨ���������ͳ�Ա���������"."������  
	stu.print();
	stu.getAge();
	//ͨ��ָ������ָ��������  
	Student *p = &stu;
	p->print();
	p->getAge();

	//ͨ������������  
	Student &s = stu;//����s��stu�ı���
	s.print();
	s.getAge();

	getchar();
	return 0;
}

