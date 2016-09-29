package cn.andoop.android.ulogger.sub;

import cn.andoop.android.ulogger.ISubLogger;

/**
 * Created by Administrator on 2016/9/28.
 */
public class SubLogEmpty implements ISubLogger {
    @Override
    public ISubLogger tag(String tag) {
        return this;
    }

    @Override
    public ISubLogger lineS(int linesize) {
        return this;
    }

    @Override
    public ISubLogger lineP(String lineSeprator) {
        return this;
    }

    @Override
    public void log(String msg) {

    }
}
