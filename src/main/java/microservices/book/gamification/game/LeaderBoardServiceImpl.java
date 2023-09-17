package microservices.book.gamification.game;

import lombok.RequiredArgsConstructor;
import microservices.book.gamification.game.domain.LeaderBoardRow;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {
    private final ScoreRepository scoreRepository;
    private final BadgeRepository badgeRepository;

    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard() {
        List<LeaderBoardRow> scoreOnly = scoreRepository.findFirst10();

        return scoreOnly.stream().map(row -> {
            List<String> badges = badgeRepository.findByUserIdOrderByBadgeTimestampDesc(row.getUserId()).stream()
                    .map(badge -> badge.getBadgeType().getDescription()).toList();
            return row.withBadges(badges);
        }).toList();
    }
}
