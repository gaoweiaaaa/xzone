package cn.md.qingce.service.Ex;

public class uploadException extends ServiceException {

    public uploadException() {
    }

    public uploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public uploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public uploadException(String message) {
        super(message);
    }

    public uploadException(Throwable cause) {
        super(cause);
    }
}
