package org.motechproject.trigger.service;

import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.EventRelay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("triggerService")
public class TriggerServiceImpl implements TriggerService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private EventRelay eventRelay;

    @Autowired
    public TriggerServiceImpl(EventRelay eventRelay) {
        this.eventRelay = eventRelay;
    }

    public void sendTriggerEvent(Map<String, String> params) {
        logger.debug("sendTriggerEvent({})", params.toString());
        Map<String, Object> eventParams = new HashMap<>();
        eventParams.put("params", params);
        MotechEvent event = new MotechEvent("trigger", eventParams);
        eventRelay.sendEventMessage(event);
    }

}
