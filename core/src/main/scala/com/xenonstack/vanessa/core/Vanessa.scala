package com.xenonstack.vanessa.core

import com.xenonstack.vanessa.web.HTTPServer
//import com.xenonstack.vanessa.web.HTTPSServer

/*
import com.xenonstack.vanessa.configuration.Configuration
import com.xenonstack.vanessa.scheduler.SchedulerDaemon
*/
object Vanessa{

	def main(args: Array[String]): Unit = {

		if(args.length > 1){
			if(args(1).equals("http")){
				val server: HTTPServer = new HTTPServer()
				server.start()
			} else{
				if(args(1).equals("scheduler")){
					println("FAKE: CRAWL SCHEDULER SERVER STARTED!")
				} else {
					if(args(1).equals("https")){
						println("FAKE: HTTPS server started.")
					} else{
						_printUsageInformation()
					}
				}
			}
		} else{
			_printUsageInformation()
		}

	}

	def _printUsageInformation(): Unit = println("\n--------------------------\nVanessa 1.0.0 - XenonStack\n--------------------------\n\nUsage: vanessa <command>\n\nAvailable Commands :\n\thttp\t\tStarts vanessa HTTP server.\n\thttps\t\tStarts vanessa HTTPS server.\n\tscheduler\tStarts vanessa crawl scheduler server.\n\n")

}