package edu.adisd.poll.poll_creator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class PollOption {

    private String pollOptionName;
    private Long voteCount = 0L;
}
