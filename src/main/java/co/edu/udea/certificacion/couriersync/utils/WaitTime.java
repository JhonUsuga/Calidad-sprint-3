package co.edu.udea.certificacion.couriersync.utils;

public class WaitTime {

    private static WaitTime waitTime;

    public Integer millis;

    public WaitTime(Integer millis) {

        try {

            Thread.sleep(millis);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        this.millis = millis;

    }

    public static WaitTime putWaitTimeOf(Integer millis) {

        waitTime = new WaitTime(millis);

        return waitTime;

    }
}