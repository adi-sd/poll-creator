package edu.adisd.poll.poll_creator.repositories;

import edu.adisd.poll.poll_creator.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
}
