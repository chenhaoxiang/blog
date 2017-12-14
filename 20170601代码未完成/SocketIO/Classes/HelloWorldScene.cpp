#include "HelloWorldScene.h"
#include "cocostudio/CocoStudio.h"
#include "ui/CocosGUI.h"

USING_NS_CC;

using namespace cocostudio::timeline;

Scene* HelloWorld::createScene()
{
    // 'scene' is an autorelease object
    auto scene = Scene::create();
    
    // 'layer' is an autorelease object
    auto layer = HelloWorld::create();

    // add layer as a child to scene
    scene->addChild(layer);

    // return the scene
    return scene;
}

// on "init" you need to initialize your instance
bool HelloWorld::init()
{
    /**  you can create scene with following comment code instead of using csb file.
    // 1. super init first
    if ( !Layer::init() )
    {
        return false;
    }
    
    Size visibleSize = Director::getInstance()->getVisibleSize();
    Vec2 origin = Director::getInstance()->getVisibleOrigin();

    /////////////////////////////
    // 2. add a menu item with "X" image, which is clicked to quit the program
    //    you may modify it.

    // add a "close" icon to exit the progress. it's an autorelease object
    auto closeItem = MenuItemImage::create(
                                           "CloseNormal.png",
                                           "CloseSelected.png",
                                           CC_CALLBACK_1(HelloWorld::menuCloseCallback, this));
    
	closeItem->setPosition(Vec2(origin.x + visibleSize.width - closeItem->getContentSize().width/2 ,
                                origin.y + closeItem->getContentSize().height/2));

    // create menu, it's an autorelease object
    auto menu = Menu::create(closeItem, NULL);
    menu->setPosition(Vec2::ZERO);
    this->addChild(menu, 1);

    /////////////////////////////
    // 3. add your codes below...

    // add a label shows "Hello World"
    // create and initialize a label
    
    auto label = Label::createWithTTF("Hello World", "fonts/Marker Felt.ttf", 24);
    
    // position the label on the center of the screen
    label->setPosition(Vec2(origin.x + visibleSize.width/2,
                            origin.y + visibleSize.height - label->getContentSize().height));

    // add the label as a child to this layer
    this->addChild(label, 1);

    // add "HelloWorld" splash screen"
    auto sprite = Sprite::create("HelloWorld.png");

    // position the sprite on the center of the screen
    sprite->setPosition(Vec2(visibleSize.width/2 + origin.x, visibleSize.height/2 + origin.y));

    // add the sprite as a child to this layer
    this->addChild(sprite, 0);
    **/
    
    //////////////////////////////
    // 1. super init first
    if ( !Layer::init() )
    {
        return false;
    }
    


	//Size size = Director::getInstance()->getWinSize();
	//client = nullptr;//初始化为空指针

	//auto menu = Menu::create();
	//menu->setPosition(Vec2::ZERO);
	//addChild(menu);

	//auto lblInit = Label::create("init socket", "Arial", 22);
	//auto menuInit = MenuItemLabel::create(lblInit, [=](Ref *sender){
	//	//1.connect方法创建实例
	//	client = SocketIO::connect("ws://gfsrv2.59kx.cn:18000", *this);
	//	client->setTag("init socket");
	//	//4.初始化的时候设置一个监听器：使用on监听事件和获取接收到的数据
	//	client->on("loginresult", [=](SIOClient *client, const std::string &data){//使用C++匿名函数实现
	//		log("login result is :%s", data.c_str());
	//	});
	//});
	//1.connect方法创建实例

	isPingOK = 123456;

	std::thread chx(&HelloWorld::chxThread,this,1);
	
	std::thread chxa(&HelloWorld::chxThread, this,2);
	
	std::thread chxb(&HelloWorld::chxThread, this,3);
	
	std::thread chxe(&HelloWorld::chxThread, this,4);

	chx.detach();
	chxa.detach();
	chxb.detach();
	chxe.detach();
	
	//while (true){

	//}

	//client->setTag("init socket");

	

	////menuInit->setPosition(size / 2);
	////menu->addChild(menuInit);

	//auto lblSend = Label::create("send message", "Arial", 22);
	//auto menuSend = MenuItemLabel::create(lblSend, [=](Ref *sender){
	//	//2.send方法发送数据
	//	client->send("hello socket.io");

	//});
	//menuSend->setPosition(size.width / 2, size.height / 2 - 50);
	//menu->addChild(menuSend);

	//auto lblSendEvent = Label::create("emit event", "Arial", 22);
	//auto menuSendEvent = MenuItemLabel::create(lblSendEvent, [=](Ref *sender){
	//	//3.向服务器发送login事件，并把名字和密码传给服务器  
	//	client->emit("login", "[{\"name\":\"myname\",\"pwd\":\"mypwd\"}]");
	//});

	//menuSendEvent->setPosition(size.width / 2, size.height / 2 - 100);
	//menu->addChild(menuSendEvent);

    //auto rootNode = CSLoader::createNode("MainScene.csb");
    //addChild(rootNode);

    return true;
}

void HelloWorld::onConnect(SIOClient* client){
	log("onConnect");
	log("%s connect", client->getTag());
}

void HelloWorld::onMessage(SIOClient* client, const std::string& data){
	log("onMessage");
	log("%s received content is:%s", client->getTag(), data.c_str());
}

void HelloWorld::onClose(SIOClient * client){
	log("onClose");
	log("%s is closed", client->getTag());
}
void HelloWorld::onError(SIOClient* client, const std::string& data){
	log("onError");//init socket error is:Failed to connect to test.59kxa.cn port 18000: Timed out
	log("%s error is:%s", client->getTag(), data.c_str());//Empty reply from server
	
	std::string str = data.c_str();
	std::string str1 = "Empty reply from server";
	std::string::size_type idx = str.find(str1);
	if (idx != std::string::npos)
	{//含有
		log("can ping");
		log("can ping shuzi:%d",isPingOK);
	}
	else
	{//不含有，也就是可以ping通的
		log("can not ping");
		log("can not ping shuzi:%d", isPingOK);
	}
}
void HelloWorld::chxThread(int x){
	log("chxThread S x is :%d",x);

	char* ip = "ws://test.59kx.cn:18000";
	//client = SocketIO::connect(ip, *this);
	SocketIO::connect(ip, *this);

	log("chxThread E x is :%d", x);

}