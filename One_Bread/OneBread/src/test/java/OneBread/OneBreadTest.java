package OneBread;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

import OneBread.OneBread;

import org.json.*;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class OneBreadTest {
	private static JSONObject input;

	@BeforeClass
	public static void createInput() throws IOException {
		// TODO: set up your sample input object here.
		input = null;
	}

	private Context createContext() {
		TestContext ctx = new TestContext();

		// TODO: customize your context here if needed.
		ctx.setFunctionName("Your Function Name");

		return ctx;
	}

	@Test
	public void testplus() {
		OneBread handler = new OneBread();
		Context ctx = createContext();

		JSONObject output = handler.handleRequest(input, ctx);

		// TODO: validate output here if needed.
		if (output != null) {
			System.out.println(output.toString());
		}
	}
}
