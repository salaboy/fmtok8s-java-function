package uppercase;

import org.springframework.cloud.function.cloudevent.CloudEventMessageBuilder;
import org.springframework.cloud.function.web.util.HeaderUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.UUID;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.cloud.function.cloudevent.CloudEventMessageUtils.*;

@Component("UpperCasedEvent")
public class UpperCasedImproveFunction implements Function<Message<Output>, Message<Output>> {
    private static final Logger LOGGER = Logger.getLogger(
      UpperCasedImproveFunction.class.getName());

  
  @Override
  public Message<Output> apply(Message<Output> inputMessage) {
    HttpHeaders httpHeaders = HeaderUtils.fromMessage(inputMessage.getHeaders());

      LOGGER.log(Level.INFO, "Input CE Id:{0}", httpHeaders.getFirst(
          ID));
      LOGGER.log(Level.INFO, "Input CE Spec Version:{0}",
          httpHeaders.getFirst(SPECVERSION));
      LOGGER.log(Level.INFO, "Input CE Source:{0}",
          httpHeaders.getFirst(SOURCE));
      LOGGER.log(Level.INFO, "Input CE Subject:{0}",
          httpHeaders.getFirst(SUBJECT));

      Output output = inputMessage.getPayload();
      output.setOutput(output.getOutput() != null ? output.getOutput() + " Improved!" : "NO DATA");
      output.setOperation("UpperCased content improved!");
      return CloudEventMessageBuilder.withData(output)
        .setType("UpperCasedImprovedEvent").setId(UUID.randomUUID().toString())
        .setSubject("Improve UpperCased content")
        .setSource(URI.create("http://example.com/improve")).build();
  }
}
