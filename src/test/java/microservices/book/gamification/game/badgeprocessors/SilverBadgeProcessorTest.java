package microservices.book.gamification.game.badgeprocessors;

import microservices.book.gamification.game.domain.BadgeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SilverBadgeProcessorTest {
    private SilverBadgeProcessor silverBadgeProcessor;

    @BeforeEach
    public void setUp() {
        silverBadgeProcessor = new SilverBadgeProcessor();
    }

    @Test
    void shouldGiveBadgeIfScoreOverThreshold() {
        Optional<BadgeType> badgeType = silverBadgeProcessor.processForOptionalBadge(160, List.of(), null);
        assertThat(badgeType).contains(BadgeType.SILVER);
    }

    @Test
    void shouldNotGiveBadgeIfScoreUnderThreshold() {
        Optional<BadgeType> badgeType = silverBadgeProcessor.processForOptionalBadge(140, List.of(), null);
        assertThat(badgeType).isEmpty();
    }
}
