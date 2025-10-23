package com.example.shopmohinh.dto.response;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.List;
import java.util.Map;

@Getter
public class Top10KeywordsUpdateEvent extends ApplicationEvent {
    private final List<Map<String, Object>> top10;

    public Top10KeywordsUpdateEvent(Object source, List<Map<String, Object>> top10) {
        super(source);
        this.top10 = top10;
    }
}
