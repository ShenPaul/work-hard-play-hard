import json
import csv

with open("RideCommandForHack 2.json", "r") as json_data:
	with open('polaris.csv', 'w') as csvfile:
		writer = csv.writer(csvfile, delimiter=',',quotechar='"', quoting=csv.QUOTE_MINIMAL)
		writer.writerow(['_id', 'creationDate', 'deletionDate', 'geometry', 'id', 'lastModifiedDate', 'properties', 'receivedDate', 'type'])
		for i, line in enumerate(json_data):
			data = json.loads(line)
			print(i, data['geometry'])
			writer.writerow([data['_id'], data['creationDate'], data['deletionDate'], data['geometry'], data['id'], data['lastModifiedDate'], data['properties'], data['receivedDate'], data['type']])