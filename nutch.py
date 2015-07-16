from flask import Flask
import subprocess as sp
import sqlite3
import json
import re
from flask import request
from flask import Response,stream_with_context

app = Flask(__name__)

@app.route('/')
def index():
	return json.dumps("Welcome")

@app.route('/create/<table>')
def create(table):
	try:
		conn = sqlite3.connect("url.db")
		c = conn.cursor()
		c.execute('drop table if exists url')
		c.execute('''CREATE TABLE '''+table+'''(id text,url text)''')
		return json.dumps("Table created")
	except:
		return json.dumps("Table name already exists")

@app.route('/insert/<id>/<path:url>')
def insert(id,url):
	try:
		conn = sqlite3.connect("url.db")
		
		conn.execute("INSERT INTO url VALUES(?,?)",(id,url))
		conn.commit()
		conn.close()
		return json.dumps("Values Inserted")
	except ValueError:
		return json.dumps(ValueError)

@app.route('/select')
def select():
	def generate():	
		conn = sqlite3.connect('url.db')
		cc = conn.cursor()
		
		for row in cc.execute('select * from url'):
				
			yield ','.join(row) + '\n'
		#except ValueError:
			#return json.dumps(ValueError)
		conn.commit()
		conn.close()
	return Response(stream_with_context(generate()))

@app.route('/sel/<name>/<path:data>')
def sel(name,data):
	#path = path[1:]
	conn = sqlite3.connect('url.db')
	cc = conn.cursor()
	data = re.split('[/]',data)
	file = open(str(name),'a+')
	for x in data:

		for row in cc.execute("select url from url where id='%s'"%x):
				d = ''.join(row)
				d.strip("(u',)")				
				file.write(str(d) + "\n")

			
	return "hi"

@app.route('/start_crawl/<path>')
def inject(path):
	#sp.call(['java','-jar','start.jar'],cwd='/home/python/search/solr')
	#sp.call(['nutch','inject',path+'/crawldb','./url/'])
	sp.call(['crawl',path,'-dir','crawl','-depth','3','-topN','5'])
	return 'data crawled'

if __name__ == "__main__":
	app.run(debug=True)
