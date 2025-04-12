package edu.adisd.poll.poll_creator.services;

import edu.adisd.poll.poll_creator.dto.OptionResponse;
import edu.adisd.poll.poll_creator.dto.PollRequest;
import edu.adisd.poll.poll_creator.dto.PollResponse;
import edu.adisd.poll.poll_creator.model.Poll;
import edu.adisd.poll.poll_creator.model.PollOptions;
import edu.adisd.poll.poll_creator.repositories.PollRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public PollResponse createPoll(PollRequest pollRequest) {
        Poll poll = new Poll();
        poll.setQuestion(pollRequest.getQuestion());

        List<PollOptions> options = pollRequest.getOptions().stream().map(optionRequest -> {
            PollOptions option = new PollOptions();
            option.setName(optionRequest.getName());
            option.setVoteCount(0L);
            option.setPoll(poll); // ✅ set parent reference
            return option;
        }).toList();

        poll.setOptions(options);

        Poll savedPoll = pollRepository.save(poll);

        // Map entity to response DTO
        PollResponse response = new PollResponse();
        response.setId(savedPoll.getId());
        response.setQuestion(savedPoll.getQuestion());
        response.setOptions(savedPoll.getOptions().stream().map(option -> {
            OptionResponse optionResponse = new OptionResponse();
            optionResponse.setId(option.getId());
            optionResponse.setName(option.getName());
            optionResponse.setVoteCount(option.getVoteCount());
            return optionResponse;
        }).toList());

        return response;
    }
}
