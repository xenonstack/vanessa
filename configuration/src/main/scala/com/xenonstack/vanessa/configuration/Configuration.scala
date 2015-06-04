package com.xenonstack.vanessa.configuration

import org.apache.commons.configuration.PropertiesConfiguration

class Configuration(){

	var conf: PropertiesConfiguration = new PropertiesConfiguration()

	def load(file: String) = {
		try{
			conf.load(file)
		} catch{
			case error: Throwable => error.printStackTrace()
		}
	}

	def get(key: String) = conf.getProperty(key)

	def set(key: String, value: String) = conf.setProperty(key, value)

}