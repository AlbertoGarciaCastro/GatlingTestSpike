package computerdatabase

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:8080")
		.proxy(Proxy("localhost", 8080).httpsPort(8080))
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.userAgentHeader("PostmanRuntime/7.6.0")

	val headers_0 = Map(
		"Postman-Token" -> "7b5bb2e6-efa5-471b-8303-2eef9bc9a37a",
		"cache-control" -> "no-cache")

	val headers_1 = Map(
		"Postman-Token" -> "98b68567-520e-43a7-97f7-872fb72a7f27",
		"cache-control" -> "no-cache")

	val headers_2 = Map(
		"Postman-Token" -> "6e46a2d5-9c0c-40ab-88df-6c4cacd2b6f4",
		"cache-control" -> "no-cache")



	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/api/movement?userId=626539724")
			.headers(headers_0))
		.pause(76)
		.exec(http("request_1")
			.get("/api/user/651007331")
			.headers(headers_1))
		.pause(10)
		.exec(http("request_2")
			.get("/api/user/validate/626539724")
			.headers(headers_2))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}