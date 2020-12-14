package com.PongPingJava.GameUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Controls {
    private final String controlUp;
    private final String controlDown;

    public boolean isControlUp(String key) {
        return controlUp.equals(key);
    }

    public boolean isControlDown(String key) {
        return controlDown.equals(key);
    }
}
