package yahoo.garg.sharad.springmockitojunit.exceptions;

import java.util.Map;

public class DBException extends RuntimeException{

    private Map<String, ?> exceptionMetaMap;

    public DBException() {

    }

    public DBException(String message, Map<String, ?> exceptionMetaMap) {
        super(message);
        this.exceptionMetaMap=exceptionMetaMap;
    }

    public DBException(String message, Throwable cause, Map<String, ?> exceptionMetaMap) {
        super(message, cause);
        this.exceptionMetaMap=exceptionMetaMap;
    }

    public DBException(Throwable cause) {
        super(cause);
        this.exceptionMetaMap=exceptionMetaMap;
    }

    public DBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Map<String, ?> exceptionMetaMap) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionMetaMap=exceptionMetaMap;
    }
}
