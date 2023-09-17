package microservices.book.gamification.game.badgeprocessors;

import microservices.book.gamification.challenge.ChallengeSolvedDTO;
import microservices.book.gamification.game.domain.BadgeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LuckyNumberBadgeProcessorTest {
    private LuckyNumberBadgeProcessor luckyNumberBadgeProcessor;

    @BeforeEach
    public void setUp() {
        luckyNumberBadgeProcessor = new LuckyNumberBadgeProcessor();
    }

    @Test
    public void shouldGiveLuckyNumberBadge() {
        Optional<BadgeType> badgeType = luckyNumberBadgeProcessor.processForOptionalBadge(1, List.of(),
                new ChallengeSolvedDTO(1L, true, 1, 42, 1L, "John Doe"));
        assertThat(badgeType).contains(BadgeType.LUCKY_NUMBER);
    }

    @Test
    public void shouldNotGiveLuckyNumberBadge() {
        Optional<BadgeType> badgeType = luckyNumberBadgeProcessor.processForOptionalBadge(1, List.of(),
                new ChallengeSolvedDTO(1L, true, 5, 6, 1L, "John Doe"));
        assertThat(badgeType).isEmpty();
    }
}
