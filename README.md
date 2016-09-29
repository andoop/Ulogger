##ULogger
###一个轻量方便美观的log工具

###用法：
####Android Studio中添加关联

---
最外层build.gradle中指定maven仓库：

	allprojects {
			    repositories {
			        jcenter()
			        maven {
			            //指定maven仓库地址
			            url "https://raw.githubusercontent.com/andoop/UloggerLib/master"
			        }
			    }
			}

对应项目的build.grale中添加依赖：

	compile 'cn.andoop.android:ulogger:1.0.0'

####使用方法
---

全局配置：

	        ULogger.setEnable(true);//是否开启log，默认开启
	        ULogger.setting()
	                .lineP("<>") //指定全局默认行分割线
	                .lineS(10)   //指定全局默认行字数
	                .ofs(0);     //指定方法偏移量（如果对ULogger进行了封装，需要调整方法偏移量，这样才能正确打印堆栈信息）

打印信息：

	        ULogger.e().log("eeeeeeeeeeeeeee");
	        ULogger.d().log("dddddddddddddddd");
	        ULogger.i().log("iiiiiiiiiiiiiiii");

效果如下：


 ![](http://i.imgur.com/F9e85MB.png)

>每行10个字符（因为没有设置lineS,所以使用上面全局配置的10）
>
>行分隔符为：“<>”（因为没有配置lineP，所以使用全局配置的“<>”）
>
>tag默认为：类.方法名(打印log所在位置)
>
>点击link可跳转到log所在处

更多使用：

		ULogger.e()
                .tag("I am a tag for e")
                .lineS(20)
                .lineP(">")
                .log("aaaaabbbbbcccccddddd");

        ULogger.d()
                .tag("I am a tag for d")
                .lineS(10)
                .lineP("#")
                .log("aaaaabbbbbcccccddddd");

        ULogger.i()
                .tag("I am a tag for i")
                .lineS(5)
                .lineP("*")
                .log("aaaaabbbbbcccccddddd");
效果图：

![](http://i.imgur.com/VumlIEt.png)

---
end
