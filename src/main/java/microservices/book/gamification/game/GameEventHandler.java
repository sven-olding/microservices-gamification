package microservices.book.gamification.game;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.book.gamification.challenge.ChallengeSolvedEvent;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class GameEventHandler {
    private final GameService gameService;

    @RabbitListener(queues = "${amqp.queue.gamification}")
    void handleChallengeSolved(final ChallengeSolvedEvent event) {
        log.info("Challenge solved event received: {}", event.attemptId());
        try {
            gameService.newAttemptForUser(event);
        } catch (final Exception e) {
            log.error("Error while processing event", e);
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
