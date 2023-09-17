package microservices.book.gamification.game;

import lombok.RequiredArgsConstructor;
import microservices.book.gamification.challenge.ChallengeSolvedDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attempts")
@RequiredArgsConstructor
@CrossOrigin
public class GameController {
    private final GameService gameService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void postResult(@RequestBody ChallengeSolvedDTO challengeSolvedDTO) {
        gameService.newAttemptForUser(challengeSolvedDTO);
    }
}
