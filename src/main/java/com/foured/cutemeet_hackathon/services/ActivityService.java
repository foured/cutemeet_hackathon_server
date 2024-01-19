package com.foured.cutemeet_hackathon.services;

import com.foured.cutemeet_hackathon.models.Activity;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private List<Activity> activities = new ArrayList<>();

    @PostConstruct
    public void test(){
        Activity activity = Activity.builder()
                .name("Chess")
                .senderName("Ivan")
                .date("Today")
                .location("School")
                .tags(Arrays.asList("sport", "chess", "together"))
                .senderContact("vk")
                .build();

        activities.add(activity);
    }

    public List<Activity> getActivities(){
        return activities;
    }

    public List<Activity> getActivitiesByTags(List<String> tags){
        List<Activity> res = new ArrayList<Activity>();

        res.addAll(activities.stream()
                .filter(app -> app.getTags().containsAll(tags))
                .toList());

        return res;
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }
}
