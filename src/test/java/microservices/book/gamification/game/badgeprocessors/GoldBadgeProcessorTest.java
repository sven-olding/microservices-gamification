package microservices.book.gamification.game.badgeprocessors;

import microservices.book.gamification.game.domain.BadgeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class GoldBadgeProcessorTest {
    private GoldBadgeProcessor goldBadgeProcessor;

    @BeforeEach
    public void setUp() {
        goldBadgeProcessor = new GoldBadgeProcessor();
    }

    @Test
    public void shouldNotGiveBadgeIfScoreUnderThreshold() {
        Optional<BadgeType> badgeType = goldBadgeProcessor.processForOptionalBadge(300, List.of(), null);
        assertThat(badgeType).isEmpty();
    }

    @Test
    public void shouldGiveBadgeIfScoreOverThreshold() {
        Optional<BadgeType> badgeType = goldBadgeProcessor.processForOptionalBadge(500, List.of(), null);
        assertThat(badgeType).contains(BadgeType.GOLD);
    }
}
