% Платформы
platform(pc).
platform(playstation).
platform(xbox).
platform(nintendo_switch).
platform(mobile).
platform(mac).

% Жанры
genre(action).
genre(adventure).
genre(rpg).
genre(strategy).
genre(simulation).
genre(sports).
genre(horror).
genre(racing).
genre(puzzle).
genre(fighting).

% Типы игр
type(singleplayer).
type(multiplayer).
type(coop).
type(online_multiplayer).

game('Cyberpunk 2077').
game('Grand Theft Auto V').
game('The Witcher 3: Wild Hunt').
game('The Legend of Zelda: Breath of the Wild').
game('Red Dead Redemption 2').
game('Elden Ring').
game('Skyrim').
game('Civilization VI').
game('StarCraft II').
game('Resident Evil 4').
game('Silent Hill 2').
game('FIFA 23').
game('NBA 2K23').
game('Genshin Impact').
game('PUBG Mobile').
game('It Takes Two').
game('Overcooked 2').
game('Forza Horizon 5').
game('Mortal Kombat 11').


game_platform('Cyberpunk 2077', pc).
game_platform('Cyberpunk 2077', playstation).
game_platform('Cyberpunk 2077', xbox).
game_platform('Grand Theft Auto V', pc).
game_platform('Grand Theft Auto V', playstation).
game_platform('Grand Theft Auto V', xbox).
game_platform('The Witcher 3: Wild Hunt', pc).
game_platform('The Witcher 3: Wild Hunt', playstation).
game_platform('The Witcher 3: Wild Hunt', xbox).
game_platform('The Witcher 3: Wild Hunt', nintendo_switch).
game_platform('The Legend of Zelda: Breath of the Wild', nintendo_switch).
game_platform('Red Dead Redemption 2', pc).
game_platform('Red Dead Redemption 2', playstation).
game_platform('Red Dead Redemption 2', xbox).
game_platform('Elden Ring', pc).
game_platform('Elden Ring', playstation).
game_platform('Elden Ring', xbox).
game_platform('Skyrim', pc).
game_platform('Skyrim', playstation).
game_platform('Skyrim', xbox).
game_platform('Skyrim', nintendo_switch).
game_platform('Civilization VI', pc).
game_platform('Civilization VI', playstation).
game_platform('Civilization VI', xbox).
game_platform('Civilization VI', nintendo_switch).
game_platform('Civilization VI', mobile).
game_platform('StarCraft II', pc).
game_platform('StarCraft II', mac).
game_platform('Resident Evil 4', pc).
game_platform('Resident Evil 4', playstation).
game_platform('Resident Evil 4', xbox).
game_platform('Silent Hill 2', pc).
game_platform('Silent Hill 2', playstation).
game_platform('FIFA 23', pc).
game_platform('FIFA 23', playstation).
game_platform('FIFA 23', xbox).
game_platform('NBA 2K23', pc).
game_platform('NBA 2K23', playstation).
game_platform('NBA 2K23', xbox).
game_platform('Genshin Impact', mobile).
game_platform('Genshin Impact', pc).
game_platform('Genshin Impact', playstation).
game_platform('PUBG Mobile', mobile).
game_platform('It Takes Two', pc).
game_platform('It Takes Two', playstation).
game_platform('It Takes Two', xbox).
game_platform('Overcooked 2', pc).
game_platform('Overcooked 2', playstation).
game_platform('Overcooked 2', xbox).
game_platform('Overcooked 2', nintendo_switch).
game_platform('Forza Horizon 5', pc).
game_platform('Forza Horizon 5', xbox).
game_platform('Mortal Kombat 11', pc).
game_platform('Mortal Kombat 11', playstation).
game_platform('Mortal Kombat 11', xbox).
game_platform('Mortal Kombat 11', nintendo_switch).



game_genre('Cyberpunk 2077', action).
game_genre('Cyberpunk 2077', rpg).
game_genre('Grand Theft Auto V', action).
game_genre('Grand Theft Auto V', adventure).
game_genre('The Witcher 3: Wild Hunt', rpg).
game_genre('The Witcher 3: Wild Hunt', adventure).
game_genre('The Legend of Zelda: Breath of the Wild', adventure).
game_genre('The Legend of Zelda: Breath of the Wild', action).
game_genre('Red Dead Redemption 2', action).
game_genre('Red Dead Redemption 2', adventure).
game_genre('Elden Ring', rpg).
game_genre('Elden Ring', action).
game_genre('Skyrim', rpg).
game_genre('Skyrim', adventure).
game_genre('Civilization VI', strategy).
game_genre('StarCraft II', strategy).
game_genre('Resident Evil 4', horror).
game_genre('Resident Evil 4', action).
game_genre('Silent Hill 2', horror).
game_genre('Silent Hill 2', adventure).
game_genre('FIFA 23', sports).
game_genre('NBA 2K23', sports).
game_genre('Genshin Impact', rpg).
game_genre('Genshin Impact', adventure).
game_genre('PUBG Mobile', action).
game_genre('It Takes Two', adventure).
game_genre('Overcooked 2', simulation).
game_genre('Forza Horizon 5', racing).
game_genre('Mortal Kombat 11', fighting).


game_type('Cyberpunk 2077', singleplayer).
game_type('Grand Theft Auto V', singleplayer).
game_type('Grand Theft Auto V', multiplayer).
game_type('The Witcher 3: Wild Hunt', singleplayer).
game_type('The Legend of Zelda: Breath of the Wild', singleplayer).
game_type('Red Dead Redemption 2', singleplayer).
game_type('Red Dead Redemption 2', multiplayer).
game_type('Elden Ring', singleplayer).
game_type('Elden Ring', multiplayer).
game_type('Skyrim', singleplayer).
game_type('Civilization VI', singleplayer).
game_type('Civilization VI', multiplayer).
game_type('StarCraft II', singleplayer).
game_type('StarCraft II', multiplayer).
game_type('Resident Evil 4', singleplayer).
game_type('Silent Hill 2', singleplayer).
game_type('FIFA 23', singleplayer).
game_type('FIFA 23', multiplayer).
game_type('NBA 2K23', singleplayer).
game_type('NBA 2K23', multiplayer).
game_type('Genshin Impact', singleplayer).
game_type('PUBG Mobile', multiplayer).
game_type('It Takes Two', coop).
game_type('Overcooked 2', coop).
game_type('Forza Horizon 5', singleplayer).
game_type('Forza Horizon 5', multiplayer).
game_type('Mortal Kombat 11', singleplayer).
game_type('Mortal Kombat 11', multiplayer).

game_minimal_age('Mortal Kombat 11', 18).
game_minimal_age('Forza Horizon 5', 3).
game_minimal_age('Overcooked 2', 3).
game_minimal_age('It Takes Two', 12).
game_minimal_age('PUBG Mobile', 16).
game_minimal_age('Genshin Impact', 12).
game_minimal_age('NBA 2K23', 3).
game_minimal_age('FIFA 23', 3).
game_minimal_age('Silent Hill 2', 18).
game_minimal_age('Resident Evil 4', 18).
game_minimal_age('StarCraft II', 12).
game_minimal_age('Civilization VI', 12).
game_minimal_age('Skyrim', 18).
game_minimal_age('Elden Ring', 16).
game_minimal_age('Red Dead Redemption 2', 18).
game_minimal_age('The Legend of Zelda: Breath of the Wild', 12).
game_minimal_age('The Witcher 3: Wild Hunt', 18).
game_minimal_age('Grand Theft Auto V', 18).
game_minimal_age('Cyberpunk 2077', 18).


% Дополнительные правила для расширенного поиска
game_with_multiple_platforms(Game) :-
    game(Game),
    findall(Platform, game_platform(Game, Platform), Platforms),
    length(Platforms, Count),
    Count > 1.

game_with_multiple_genres(Game) :-
    game(Game),
    findall(Genre, game_genre(Game, Genre), Genres),
    length(Genres, Count),
    Count > 1.

new_release(Game) :-
    game_minimal_age(Game, 16);
    game_minimal_age(Game, 18).

family_friendly(Game) :-
    game_minimal_age(Game, 3);
    game_minimal_age(Game, 7).

% Правило для проверки возрастного ограничения
game_age_appropriate(Game, UserAge) :-
    game_minimal_age(Game, GameMinAge),
    UserAge >= GameMinAge.