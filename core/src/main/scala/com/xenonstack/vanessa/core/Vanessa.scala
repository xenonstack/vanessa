package com.xenonstack.vanessa.core

import com.twitter.finatra.FinatraServer
import com.xenonstack.vanessa.configuration.Configuration

object Vanessa extends FinatraServer{

    var conf: Configuration = new Configuration()
    conf.load(System.getProperty("conf.path").toString())

    System.setProperty("com.twitter.finatra.config.adminPort", ":8888");
    System.setProperty("com.twitter.finatra.config.appName", "vanessa");
    System.setProperty("com.twitter.finatra.config.env", "production");
    System.setProperty("com.twitter.finatra.config.logNode", "vanessa");
    System.setProperty("com.twitter.finatra.config.port", ":" + conf.get("server.port").toString());

    val assetControl = new AssetControl()
    val dataControl = new DataControl()

    register(assetControl)
    register(dataControl)

}
