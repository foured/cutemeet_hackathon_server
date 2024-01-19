package com.foured.cutemeet_hackathon.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Activity {
    private String name;
    private String senderName;
    private String senderContact;
    private String date;
    private String location;
    private List<String> tags;
}
