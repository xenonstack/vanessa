package com.xenonstack.vanessa.core

import com.twitter.finatra.Controller

class AssetControl extends Controller{

	get("/") {
		request => render.static("/vanessa-index.html").toFuture
	}

	get("/index.html") {
		request => render.static("/vanessa-index.html").toFuture
	}

	get("/index") {
		request => render.static("/vanessa-index.html").toFuture
	}

	get("/home") {
		request => render.static("/vanessa-index.html").toFuture
	}

	get("/home.html") {
		request => render.static("/vanessa-index.html").toFuture
	}

}