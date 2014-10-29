package org.motechproject.trigger.web;

import org.motechproject.trigger.service.TriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * Responds to HTTP queries to {motech-server}/module/trigger/trigger and sends motech 'trigger' event
 */
@Controller
public class TriggerController {

    private TriggerService triggerService;

    @Autowired
    public TriggerController(TriggerService triggerService) {
        this.triggerService = triggerService;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping(value = "/trigger")
    public String sendTriggerEvent(@RequestParam Map<String, String> params) {
	    triggerService.sendTriggerEvent(params);
        return "OK";
    }
}
