package com.foured.cutemeet_hackathon.controllers;

import com.foured.cutemeet_hackathon.models.Activity;
import com.foured.cutemeet_hackathon.services.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("a")
@AllArgsConstructor
public class ActivityController {
    private ActivityService service;

    @RequestMapping("/all")
    public List<Activity> allActivities(){
        return service.getActivities();
    }

    @RequestMapping("/{tegs}")
    public List<Activity> activityByTegs(@PathVariable String[] tegs){
        return service.getActivitiesByTegs(Arrays.stream(tegs).toList());
    }

    @RequestMapping("/new")
    public String createNewActivity(@RequestBody Activity activity){
        service.addActivity(activity);
        return "Activity created";
    }
}
