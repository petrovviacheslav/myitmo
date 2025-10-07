
from owlready2 import *
import re

def parse_prolog_file(filename):
    """Парсинг Prolog файла с семейными данными"""
    
    persons = []
    births = []
    deaths = []
    marriages = []
    divorces = []
    parents = []
    
    with open(filename, 'r', encoding='utf-8') as f:
        content = f.read()
        
        # Парсинг людей
        person_pattern = r'person\((\d+),\s*\'([^\']+)\',\s*\'([^\']+)\',\s*([a-z]+)\)'
        persons = [(int(id), last_name, first_name, gender) 
                  for id, last_name, first_name, gender in re.findall(person_pattern, content)]
        
        # Парсинг рождений
        birth_pattern = r'birth\((\d+),\s*(\d+)\)'
        births = [(int(id), int(year)) for id, year in re.findall(birth_pattern, content)]
        
        # Парсинг смертей
        death_pattern = r'death\((\d+),\s*(\d+)\)'
        deaths = [(int(id), int(year)) for id, year in re.findall(death_pattern, content)]
        
        # Парсинг браков
        marriage_pattern = r'marriage\((\d+),\s*(\d+),\s*(\d+)\)'
        marriages = [(int(id1), int(id2), int(year)) for id1, id2, year in re.findall(marriage_pattern, content)]
        
        # Парсинг разводов
        divorce_pattern = r'divorce\((\d+),\s*(\d+),\s*(\d+)\)'
        divorces = [(int(id1), int(id2), int(year)) for id1, id2, year in re.findall(divorce_pattern, content)]
        
        # Парсинг родительских связей
        parent_pattern = r'parent\((\d+),\s*(\d+)\)'
        parents = [(int(parent_id), int(child_id)) for parent_id, child_id in re.findall(parent_pattern, content)]
    
    return persons, births, deaths, marriages, divorces, parents

def create_family_ontology(persons, births, deaths, marriages, divorces, parents):
    """Создание OWL онтологии на основе данных Prolog"""
    
    # Создаем новую онтологию
    onto = get_ontology("http://www.semanticweb.org/family-ontology")
    
    with onto:
        # Определяем классы
        class Person(Thing):
            pass
        
        class Event(Thing):
            pass
        
        class Birth(Event):
            pass
        
        class Death(Event):
            pass
        
        class Marriage(Event):
            pass
        
        class Divorce(Event):
            pass
        
        class Gender(Thing):
            pass
        
        class Male(Gender):
            pass
        
        class Female(Gender):
            pass
        
        # Свойства данных
        class personID(DataProperty, FunctionalProperty):
            domain = [Person]
            range = [int]
        
        class firstName(DataProperty, FunctionalProperty):
            domain = [Person]
            range = [str]
        
        class lastName(DataProperty, FunctionalProperty):
            domain = [Person]
            range = [str]
        
        class year(DataProperty, FunctionalProperty):
            domain = [Event]
            range = [int]
        
        # Объектные свойства
        class hasParent(ObjectProperty):
            domain = [Person]
            range = [Person]
        
        class hasChild(ObjectProperty):
            domain = [Person]
            range = [Person]
            inverse_property = hasParent
        
        class hasSpouse(ObjectProperty, SymmetricProperty):
            domain = [Person]
            range = [Person]
        
        class hasGender(ObjectProperty, FunctionalProperty):
            domain = [Person]
            range = [Gender]
        
        class hasBirth(ObjectProperty, FunctionalProperty):
            domain = [Person]
            range = [Birth]
        
        class hasDeath(ObjectProperty, FunctionalProperty):
            domain = [Person]
            range = [Death]
        
        class hasMarriage(ObjectProperty):
            domain = [Person]
            range = [Marriage]
        
        class hasDivorce(ObjectProperty):
            domain = [Person]
            range = [Divorce]
        
        # Создаем гендеры
        male_gender = Male("male")
        female_gender = Female("female")
        
        # Словарь для хранения созданных объектов
        person_dict = {}
        birth_dict = {}
        death_dict = {}
        marriage_dict = {}
        divorce_dict = {}
        
        # Создаем людей
        for person_id, last_name, first_name, gender in persons:
            person = Person(f"Person{person_id}")
            person.personID = person_id
            person.firstName = first_name
            person.lastName = last_name
            
            if gender == 'male':
                person.hasGender = male_gender
            else:
                person.hasGender = female_gender
                
            person_dict[person_id] = person
        
        # Создаем события рождения
        for birth_id, birth_year in births:
            birth = Birth(f"Birth{birth_id}")
            birth.year = birth_year
            birth_dict[birth_id] = birth
            
            # Связываем с человеком
            if birth_id in person_dict:
                person_dict[birth_id].hasBirth = birth
        
        # Создаем события смерти
        for death_id, death_year in deaths:
            death = Death(f"Death{death_id}")
            death.year = death_year
            death_dict[death_id] = death
            
            # Связываем с человеком
            if death_id in person_dict:
                person_dict[death_id].hasDeath = death
        
        # Создаем браки
        for i, (id1, id2, marriage_year) in enumerate(marriages, 1):
            marriage = Marriage(f"Marriage{i}")
            marriage.year = marriage_year
            marriage_dict[(id1, id2)] = marriage
            
            # Связываем с людьми
            if id1 in person_dict:
                person_dict[id1].hasMarriage.append(marriage)
            if id2 in person_dict:
                person_dict[id2].hasMarriage.append(marriage)
            
            # Устанавливаем супружеские отношения
            if id1 in person_dict and id2 in person_dict:
                person_dict[id1].hasSpouse.append(person_dict[id2])
        
        # Создаем разводы
        for i, (id1, id2, divorce_year) in enumerate(divorces, 1):
            divorce = Divorce(f"Divorce{i}")
            divorce.year = divorce_year
            divorce_dict[(id1, id2)] = divorce
            
            # Связываем с людьми
            if id1 in person_dict:
                person_dict[id1].hasDivorce.append(divorce)
            if id2 in person_dict:
                person_dict[id2].hasDivorce.append(divorce)
        
        # Устанавливаем родительские связи
        for parent_id, child_id in parents:
            if parent_id in person_dict and child_id in person_dict:
                person_dict[child_id].hasParent.append(person_dict[parent_id])
    
    return onto

def main():
    print("Парсинг Prolog файла...")
    
    try:
        persons, births, deaths, marriages, divorces, parents = parse_prolog_file("1.pl")
        
        print(f"Найдено людей: {len(persons)}")
        print(f"Найдено рождений: {len(births)}")
        print(f"Найдено смертей: {len(deaths)}")
        print(f"Найдено браков: {len(marriages)}")
        print(f"Найдено разводов: {len(divorces)}")
        print(f"Найдено родительских связей: {len(parents)}")
        
        print("\nСоздание OWL онтологии...")
        onto = create_family_ontology(persons, births, deaths, marriages, divorces, parents)
        
        # Сохраняем онтологию
        output_file = "family_ontology.owl"
        onto.save(file=output_file, format="rdfxml")
        
        print(f"\nОнтология успешно сохранена в файл: {output_file}")
        print("Теперь вы можете открыть этот файл в Protégé!")
        
        # Выводим статистику
        print("\n=== Статистика онтологии ===")
        print(f"Всего людей: {len(list(onto.Person.instances()))}")
        print(f"Событий рождения: {len(list(onto.Birth.instances()))}")
        print(f"Событий смерти: {len(list(onto.Death.instances()))}")
        print(f"Браков: {len(list(onto.Marriage.instances()))}")
        print(f"Разводов: {len(list(onto.Divorce.instances()))}")
        
        # Пример вывода нескольких людей для проверки
        print("\n=== Примеры созданных объектов ===")
        for i, person in enumerate(list(onto.Person.instances())[:3]):
            print(f"Person: {person.firstName} {person.lastName} (ID: {person.personID})")
            if hasattr(person, 'hasBirth') and person.hasBirth:
                print(f"  Рождение: {person.hasBirth.year}")
            if hasattr(person, 'hasDeath') and person.hasDeath:
                print(f"  Смерть: {person.hasDeath.year}")
        
    except FileNotFoundError:
        print("Ошибка: Файл 'family.pl' не найден!")
        print("Убедитесь, что файл находится в той же папке, что и этот скрипт.")
    except Exception as e:
        print(f"Произошла ошибка: {e}")

if __name__ == "__main__":
    main()