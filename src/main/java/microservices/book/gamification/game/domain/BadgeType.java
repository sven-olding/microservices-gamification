package microservices.book.gamification.game.domain;

import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BadgeType {
    BRONZE("Bronze"), SILVER("Silver"), GOLD("Gold"), FIRST_WON("First time"), LUCKY_NUMBER("Lucky number");

    private final String description;
}
