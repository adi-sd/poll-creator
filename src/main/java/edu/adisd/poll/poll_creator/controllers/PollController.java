package edu.adisd.poll.poll_creator.controllers;

import edu.adisd.poll.poll_creator.dto.PollRequest;
import edu.adisd.poll.poll_creator.dto.PollResponse;
import edu.adisd.poll.poll_creator.services.PollService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/polls")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public ResponseEntity<PollResponse> createPoll(@RequestBody PollRequest pollRequest) {
        PollResponse pollResponse = pollService.createPoll(pollRequest);
        return ResponseEntity.ok(pollResponse);
    }

}
