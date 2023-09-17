package microservices.book.gamification.game;

import microservices.book.gamification.game.domain.LeaderBoardRow;
import microservices.book.gamification.game.domain.ScoreCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends CrudRepository<ScoreCard, Long> {
    @Query("SELECT SUM(s.score) FROM ScoreCard s WHERE s.userId = :userId GROUP BY s.userId")
    Optional<Integer> getTotalScoreForUser(long userId);

    List<ScoreCard> findByUserIdOrderByScoreTimestampDesc(long userId);

    @Query("SELECT NEW microservices.book.gamification.game.domain.LeaderBoardRow(s.userId, SUM(s.score)) " +
            "FROM ScoreCard s " +
            "GROUP BY s.userId ORDER BY SUM(s.score) DESC")
    List<LeaderBoardRow> findFirst10();
}
