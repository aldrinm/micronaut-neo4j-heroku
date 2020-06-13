package micronaut.neo4j.heroku;


import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import java.util.List;
import javax.inject.Inject;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

@Controller("/hello")
public class HelloController {

	@Inject
	Driver driver;

	@Get
	@Produces(MediaType.TEXT_PLAIN)
	public String index() {
		Session session = driver.session();

		Result result = session.run("Match (n) return count(n)");
		List<Record> records = result.list();
		return records.toString();
	}
}
