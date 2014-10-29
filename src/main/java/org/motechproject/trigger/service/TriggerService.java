package org.motechproject.trigger.service;

import java.util.Map;

public interface TriggerService {
    void sendTriggerEvent(Map<String, String> params);
}
