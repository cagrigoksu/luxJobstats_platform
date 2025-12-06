package com.luxjobstats.dto;

public class CountByLabelDTO {

    private String label;
    private Long count;

    public CountByLabelDTO(String label, Long count){
        this.label = label;
        this.count = count;
    }

    public String getLabel(){return label;}
    public Long getCount(){return count;}

}
