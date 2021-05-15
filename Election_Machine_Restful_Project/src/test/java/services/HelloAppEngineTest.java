package services;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Built in class left here for testing purposes.
 * 
 * @author Les
 *
 */
public class HelloAppEngineTest {

/**
 * Test method>>disregard
 * @throws IOException
 */
@Test
  public void test() throws IOException {
    MockHttpServletResponse response = new MockHttpServletResponse();
    new HelloAppEngine().doGet(null, response);
    Assert.assertEquals("text/plain", response.getContentType());
    Assert.assertEquals("UTF-8", response.getCharacterEncoding());
    Assert.assertEquals("Hello App Engine!\r\n", response.getWriterContent().toString());
  }
}
