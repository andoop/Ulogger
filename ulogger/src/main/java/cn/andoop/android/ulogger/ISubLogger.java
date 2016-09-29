package cn.andoop.android.ulogger;

/**
 * Created by 黄栋 andoop on 2016/9/28.
 */
public interface ISubLogger {

    ISubLogger tag(String tag);
    ISubLogger lineS(int linesize);
    ISubLogger lineP(String lineSeprator);
    void log(String msg);
}
