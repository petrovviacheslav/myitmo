from pyswip import Prolog
from pyswip.prolog import PrologError


class PrologBase:
    def __init__(self, path):
        self.prolog = Prolog()
        try:
            self.prolog.consult(path)
        except PrologError:
            print(f"Could not read knowledge base by path: {path}.")
            exit(22)

    def get_available_platforms(self):
        request = "platform(Platform)."
        available_game_platforms = self.prolog.query(request)
        return [game_platform["Platform"] for game_platform in available_game_platforms]

    def get_available_genres(self):
        request = "genre(Genre)."
        available_game_genres = self.prolog.query(request)
        return [game_genre["Genre"] for game_genre in available_game_genres]

    def get_available_types(self):
        request = "type(Type)."
        available_game_types = self.prolog.query(request)
        return [game_type["Type"] for game_type in available_game_types]

    def get_minimal_age(self, game_name):
        query = f"game_minimal_age('{game_name}', Age)."
        return (list(self.prolog.query(query)))[0]["Age"]

    def look_for_matching_games(self, platforms, genres, types, user_age):
        request = "game(Game),"
        request += "("
        for platform in platforms:
            request += f"game_platform(Game, {platform});"
        request = request[:len(request) - 1] + "),"
        request += "("
        for genre in genres:
            request += f"game_genre(Game, {genre});"
        request = request[:len(request) - 1] + "),"
        request += "("
        for type in types:
            request += f"game_type(Game, {type});"
        request = request[:len(request) - 1] + "),"
        request += f"game_age_appropriate(Game, {user_age})."

        matching_games = [matching_game["Game"] for matching_game in list(self.prolog.query(request))]
        matching_games = map(lambda matching_game: matching_game + f" ({self.get_minimal_age(matching_game)}+)",
                             matching_games)
        return matching_games


class UserInterface:
    platforms_msg_format = "Я играю на:"
    genres_msg_format = "Мне нравятся жанры:"
    types_msg_format = "Я предпочитаю типы:"
    age_msg_format = "Мой возраст:"

    def __init__(self, prolog_base):
        self.prolog_base = prolog_base

    def validate_msg(self, msg, msg_start_format):
        if len(msg) == 0:
            return False
        if not msg.startswith(msg_start_format.lower()):
            return False
        return True

    def check_choice(self, items, available_items):
        suitable_items = []
        for cur_item in items:
            if cur_item not in available_items:
                print(f"'{cur_item}' - нет в списке.")
            else:
                suitable_items.append(cur_item)
        return suitable_items

    def read_msg(self, msg_start_format):
        while True:
            msg = input("> ")
            msg = msg.strip().replace("  ", " ").lower()
            if msg == "exit":
                exit(1)
            if self.validate_msg(msg, msg_start_format):
                break
            print("Неверный ввод. Попробуйте ещё раз!")
        return msg

    def ask_user_platforms(self):
        print("Введите игровые платформы, которые вы используете. Список доступных платформ:\n")
        available_platforms = self.prolog_base.get_available_platforms()
        for cur_platform in available_platforms:
            print(f"- {cur_platform}")
        print(f"\nВведите сообщение в формате: \"{self.platforms_msg_format} <ваши платформы>\"")
        print(f"Пример: {self.platforms_msg_format} pc, mobile\n")
        while True:
            msg = self.read_msg(self.platforms_msg_format)
            user_platforms = msg[len(self.platforms_msg_format)::].strip().replace(" ", "").split(",")
            user_platforms = self.check_choice(user_platforms, available_platforms)
            if len(user_platforms) != 0:
                return user_platforms
            print("Вы не ввели ни одной корректной игровой платформы. Попробуйте ещё раз!")

    def ask_user_genres(self):
        print("Введите игровые жанры, которые вам нравятся. Список доступных жанров:\n")
        available_genres = self.prolog_base.get_available_genres()
        for cur_genre in available_genres:
            print(f"- {cur_genre}")
        print(f"\nВведите сообщение в формате: \"{self.genres_msg_format} <ваши жанры>\"")
        print(f"Пример: {self.genres_msg_format} action, horror\n")
        while True:
            msg = self.read_msg(self.genres_msg_format)
            user_genres = msg[len(self.genres_msg_format):].strip().replace(" ", "").split(",")
            user_genres = self.check_choice(user_genres, available_genres)
            if len(user_genres) != 0:
                return user_genres
            print("Вы не ввели ни одного корректного жанра. Попробуйте ещё раз!")

    def ask_user_types(self):
        print("Введите типы игр, которые вы предпочитаете. Список доступных типов::\n")
        available_types = self.prolog_base.get_available_types()
        for cur_type in available_types:
            print(f"- {cur_type}")
        print(f"\nВведите сообщение в формате: \"{self.types_msg_format} <ваши типы>\"")
        print(f"Пример: {self.types_msg_format} singleplayer, multiplayer\n")
        while True:
            msg = self.read_msg(self.types_msg_format)
            user_game_types = msg[len(self.types_msg_format):].strip().replace(" ", "").split(",")
            user_game_types = self.check_choice(user_game_types, available_types)
            if len(user_game_types) != 0:
                return user_game_types
            print("Вы не ввели ни одного корректного типа игр. Попробуйте ещё раз!")

    def ask_user_age(self):
        print("Введите свой возраст:")
        print(f"Введите сообщение в формате: \"{self.age_msg_format} <ваш возраст>\"")
        print(f"Пример: {self.age_msg_format} 21\n")
        while True:
            msg = self.read_msg(self.age_msg_format)
            try:
                user_age = int(msg[len(self.age_msg_format):].strip().replace(" ", ""))
                if user_age > 0:
                    return user_age
                print("Возраст введён некорректно. Попробуйте ещё раз!")
            except ValueError:
                print("Возраст должен быть числом. Попробуйте ещё раз!")

    def start_searching(self):
        print("Вы используете CLI-программу для поиска подходящих игр.")
        print("Вам надо ответить на некоторые вопросы, чтобы мы могли Вам помочь с выбором.")

        user_platforms = self.ask_user_platforms()
        user_genres = self.ask_user_genres()
        user_types = self.ask_user_types()
        user_age = self.ask_user_age()

        variants = self.prolog_base.look_for_matching_games(user_platforms, user_genres, user_types, user_age)
        return list(set(variants))


prolog_base = PrologBase("./base.pl")
user_interface = UserInterface(prolog_base)

games = user_interface.start_searching()

if len(games) == 0:
    print("Не нашлось подходящих игр")
else:
    print("Вот, что мне удалось найти:")
    for cur_game in games:
        print(f"- {cur_game}")
