package cn.meteor.centauri.alpha.returnmsg;

/**
 * @ProjectName: alpha-centauri
 * @Description: 空bean异常
 * @Author: Daivd Zhang
 * @CreateDate: 2018/8/29 8:35
 * @Version: 1.0.0
 */
public class BeanEmptyException extends Exception {
    public BeanEmptyException(String msg){
        super(msg);
    }
}
