import json
import csv
import ast
import sys

csv.field_size_limit(sys.maxsize)

output = []

with open('polaris_1.csv', 'r') as csvfile:
	reader = csv.DictReader(csvfile)
	for i, data in enumerate(reader):
		dic = {"_id": data['_id'], 
			"creationDate": ast.literal_eval(data['creationDate']), 
			"deletionDate": data['deletionDate'], 
			"geometry": ast.literal_eval(data['geometry']), 
			"id": ast.literal_eval(data['id']), 
			"lastModifiedDate": ast.literal_eval(data['lastModifiedDate']), 
			"properties": ast.literal_eval(data['properties']), 
			"receivedDate": data['receivedDate'], 
			"type": data['type']}
		output.append(dic)

with open('output.json', 'w') as outfile:
    json.dump(output, outfile)

