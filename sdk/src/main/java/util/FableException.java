package util;

/**
 * Created by bll on 2017/9/2.
 */
public class FableException extends  RuntimeException {
    public FableException(String cause,Throwable throwable){
        super(cause,throwable);
    }
    public FableException(String message){
        super(message);
    }
}
