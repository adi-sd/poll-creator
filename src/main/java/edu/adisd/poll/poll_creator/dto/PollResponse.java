package edu.adisd.poll.poll_creator.dto;

import lombok.Data;
import java.util.List;

@Data
public class PollResponse {
    private Long id;
    private String question;
    private List<OptionResponse> options;
}
