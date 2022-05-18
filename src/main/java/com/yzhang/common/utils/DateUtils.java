package com.yzhang.common.utils;

public class DateUtils {

    public static void pause(int seconds) {
        LogUtils.info("Sleep " + seconds + " seconds ...");

        for (int i = 1; i < seconds; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                LogUtils.error(e.getMessage());
            }
            if (i % 5 == 0) {
                LogUtils.info((seconds - i) + " second remains ...");
            }
        }
    }

}
