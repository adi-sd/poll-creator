package edu.adisd.poll.poll_creator.dto;

import lombok.Data;

@Data
public class OptionResponse {
    private Long id;
    private String name;
    private Long voteCount;
}
