package edu.adisd.poll.poll_creator.dto;

import lombok.Data;
import java.util.List;

@Data
public class PollRequest {
    private String question;
    private List<OptionRequest> options;
}
