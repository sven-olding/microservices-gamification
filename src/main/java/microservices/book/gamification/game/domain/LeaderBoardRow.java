package microservices.book.gamification.game.domain;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@AllArgsConstructor
public class LeaderBoardRow {
    Long userId;
    Long totalScore;
    @With
    List<String> badges;

    public LeaderBoardRow(Long userId, Long totalScore) {
        this.userId = userId;
        this.totalScore = totalScore;
        this.badges = List.of();
    }
}
