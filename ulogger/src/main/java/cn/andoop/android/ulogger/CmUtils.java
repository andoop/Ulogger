package cn.andoop.android.ulogger;

/**
 * Created by 黄栋 andoop on 2016/9/28.
 */
public class CmUtils {
    public static String dealWithMsg(String msg,int linesize,String lineSeprator){
        if(msg==null)
            msg="null";

        if(linesize>0){
            String ss=lineSeprator+" ";
            while (msg.length()>linesize){
                ss+=msg.substring(0,linesize)+"\n"+lineSeprator+" ";
                msg=msg.substring(linesize,msg.length());
            }
            ss+=msg;
            msg=ss;
        }

        return msg;
    }
}
