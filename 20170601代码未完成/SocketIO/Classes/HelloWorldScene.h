#ifndef __HELLOWORLD_SCENE_H__
#define __HELLOWORLD_SCENE_H__

#include "cocos2d.h"
#include "network\SocketIO.h"
USING_NS_CC;


using namespace cocos2d::network;

//�̳�SocketIO::SIODelegate��ʵ���ĸ��麯��
class HelloWorld : public cocos2d::Layer, SocketIO::SIODelegate
{
public:
    // there's no 'id' in cpp, so we recommend returning the class instance pointer
    static cocos2d::Scene* createScene();

    // Here's a difference. Method 'init' in cocos2d-x returns bool, instead of returning 'id' in cocos2d-iphone
    virtual bool init();

	//socket����ʱ����
	void onConnect(SIOClient* client);
	//�յ�����ʱ����
	void onMessage(SIOClient* client, const std::string& data);
	//���Ӵ������յ������ź�ʱ����
	void onError(SIOClient* client, const std::string& data);
	//socket�ر�ʱ����
	void onClose(SIOClient* client);

	int isPingOK;
    // implement the "static create()" method manually
    CREATE_FUNC(HelloWorld);

	void chxThread(int x);

	SIOClient *client;

};

#endif // __HELLOWORLD_SCENE_H__
