import json
import csv

import time
start = time.time()

def extract_dict_values(data):
    results = []
    for key, value in data.items():
        if isinstance(value, dict):
            results.extend(extract_dict_values(value))
        else:
            results.append(value)
    return results

def json_to_csv(json_data, csv_file):
    with open(json_data) as file:
        data = json.load(file)

    with open(csv_file, 'w', newline='') as csvfile:
        writer = csv.writer(csvfile)

        for item in data:
            if isinstance(data[item], dict):
                values = extract_dict_values(data[item])
                writer.writerow([item] + values)
            else:
                writer.writerow([item, data[item]])

    print(f"Файл CSV успешно создан: {csv_file}")


# Пример использования
json_file = "schedulle.json"
csv_file = "output.csv"

json_to_csv(json_file, csv_file)


end = time.time()
print(end-start)