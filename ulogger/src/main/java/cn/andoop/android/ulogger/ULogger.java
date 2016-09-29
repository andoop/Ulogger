package cn.andoop.android.ulogger;

import java.util.Set;

import cn.andoop.android.ulogger.sub.SubLogD;
import cn.andoop.android.ulogger.sub.SubLogE;
import cn.andoop.android.ulogger.sub.SubLogEmpty;
import cn.andoop.android.ulogger.sub.SubLogI;

/**
 * Created by 黄洞洞 on 2016/9/27.
 * Log工具，自动拼接堆栈信息，可点击追踪
 *
 * 为一次打印配置
 * ULogger.e()
 *        .tag("tag") //tag
 *        .lineS(100)  //每一行字符数
 *        .lineP("|")  //行开始字符，行分隔符
 *        .log("ssss") //要打印的信息
 *
 * 为一种类型配置/暂无此功能
 * ULogger.E.tag("tag")
 *          .lineS(100)
 *          .lintP("|")
 *
 * 为所有类型配置
 * ULogger.tag("tag")
 *        .lineS(100)
 *        .lineP("|")
 *        .ofs(5)
 */
public class ULogger {
    private static boolean enable=true;
  /*  public static ISubLogger E=new SubLogE();
    public static ISubLogger D=new SubLogD();
    public static ISubLogger I=new SubLogI();*/
    public static ISubLogger DEF=new SubLogEmpty();

    private static String tag;
    private static int lineS=500;
    private static String lineP=">";
    private static int ofs=0;

    public static void setEnable(boolean enable){
        ULogger.enable=enable;
    }

    public static ISubLogger e(){
        if(!enable)
            return DEF;
        return new SubLogE(tag,lineS,lineP,ofs);
    }

    public static ISubLogger d(){
        if(!enable)
            return DEF;
        return new SubLogD(tag,lineS,lineP,ofs);
    }
    public static ISubLogger i(){
        if(!enable)
            return DEF;
        return new SubLogI(tag,lineS,lineP,ofs);
    }

    public static Setting setting(){
        return new Setting();
    }

    public static class Setting{
        public Setting tag(String tag){
            ULogger.tag=tag;
            return this;
        }
        public  Setting lineS(int lines){
            ULogger.lineS=lines;
            return this;
        }
        public  Setting lineP(String lineP){
            ULogger.lineP=lineP;
            return this;
        }
        public Setting ofs(int ofs){
            ULogger.ofs=ofs;
            return this;
        }
    }


   /* public static void te(String msg){

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for(StackTraceElement stackTraceElement:stackTrace){
            Log.e("------",stackTraceElement.getClassName()+":"+stackTraceElement.getFileName()+":"+
            stackTraceElement.getMethodName()+":"+stackTraceElement.getLineNumber());
        }
        StackTraceElement stackTraceElement=stackTrace[3];
        Log.e("-------",stackTraceElement.getClassName()+":"+stackTraceElement.getFileName()+":"+
                stackTraceElement.getMethodName()+":"+stackTraceElement.getLineNumber());

        Throwable throwable = new Throwable("sssssssss");
        throwable.printStackTrace();

        Log.println(Log.ERROR,"---------","cn.andoop.android.uloggertest.MainActivity.testhhh(MainActivity.java:15)");
    }
   */

}
