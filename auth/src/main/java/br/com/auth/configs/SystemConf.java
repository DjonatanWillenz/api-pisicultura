package br.com.auth.configs;

public class SystemConf {

    private static SystemConf uniqueInstance = new SystemConf();

    public final static int TIME_SCHEDULE_INIT = 10;

    public final static int TIME_TASK_PH = 10;
    public final static int TIME_TASK_TEMPERATURE = 10;
    public final static int TIME_TASK_FOOD = 10;
    public final static int TIME_TASK_NOTIFICATIO = 10;
    public final static int TIME_TASK_REQUEST = 10;

    private SystemConf() {
    }

    public static SystemConf getInstance() {
        return uniqueInstance;
    }
}
