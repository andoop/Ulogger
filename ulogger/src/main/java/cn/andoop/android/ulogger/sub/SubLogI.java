package cn.andoop.android.ulogger.sub;

import android.text.TextUtils;
import android.util.Log;

import cn.andoop.android.ulogger.CmUtils;
import cn.andoop.android.ulogger.ISubLogger;

/**
 * Created by 黄栋 andoop on 2016/9/28.
 */
public class SubLogI implements ISubLogger {
    private final int ofs;
    private String tag;
    private int linesize;
    private String lineSeprator;

    public SubLogI(String tag, int lineS, String lineP, int ofs) {
        this.tag=tag;
        this.linesize=lineS;
        this.lineSeprator=lineP;
        this.ofs=ofs;
    }

    @Override
    public ISubLogger tag(String tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public ISubLogger lineS(int linesize) {
        this.linesize = linesize;
        return this;
    }

    @Override
    public ISubLogger lineP(String lineSeprator) {
        this.lineSeprator = lineSeprator;
        return this;
    }

    @Override
    public void log(String msg) {
        msg = CmUtils.dealWithMsg(msg, linesize, lineSeprator);

        Thread thread = Thread.currentThread();
        StackTraceElement stackTraceElement = thread.getStackTrace()[3+ofs];
        String name = stackTraceElement.getFileName().substring(0,stackTraceElement.getFileName().length()-5);
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();

        if(TextUtils.isEmpty(tag)){
            //拼接默认参数
            tag="["+name+"."+methodName+"]";
        }
        String ss="==========link("+name+".java:"+lineNumber+")==========\n"+msg;
        Log.println(Log.INFO, tag, ss);
    }
}
