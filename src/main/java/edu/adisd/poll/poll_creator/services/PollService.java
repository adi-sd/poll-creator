package edu.adisd.poll.poll_creator.services;

import edu.adisd.poll.poll_creator.model.Poll;
import edu.adisd.poll.poll_creator.model.PollOption;
import edu.adisd.poll.poll_creator.repositories.PollRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public ResponseEntity<Poll> getPollById(Long id) {
        return pollRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public void vote(Long pollId, int optionIndex) {
        // Get Poll By ID
        Poll requiredPoll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll not found!"));

        // Get all its option
        List<PollOption> options = requiredPoll.getOptions();

        // option index validation for the poll
        if (optionIndex < 0 || optionIndex >= options.size()) {
            throw new IllegalArgumentException("Invalid Option Index");
        }

        // Get Selected Option
        PollOption selectedOption = options.get(optionIndex);

        // Increment the vote count
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);

        // Save the poll to DB
        pollRepository.save(requiredPoll);
    }
}
