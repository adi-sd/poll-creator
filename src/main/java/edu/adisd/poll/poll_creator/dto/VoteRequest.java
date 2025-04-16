package edu.adisd.poll.poll_creator.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VoteRequest {

    private Long pollId;
    private int optionIndex;
}
