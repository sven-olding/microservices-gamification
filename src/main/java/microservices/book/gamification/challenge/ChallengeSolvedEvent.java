package microservices.book.gamification.challenge;

public record ChallengeSolvedEvent(long attemptId, boolean correct, int factorA, int factorB, long userId,
                                   String userAlias) {
}
