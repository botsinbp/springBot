package com.codeinbp.telegrambot.devices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource(value = "classpath:devices.properties", ignoreResourceNotFound = true)
public class DeviceId {
    @Value("${registered.device.id.mo}")
    private String mo;;

    @Value("${registered.device.id.hano}")
    private String hano;;

    @Value("${registered.device.id.sw}")
    private String sw;

    List<String> devices = new ArrayList<>();

    public List<String> getDevices(){
        devices.add(mo);
        //devices.add(hano);
        devices.add(sw);

        return devices;

    }

}
