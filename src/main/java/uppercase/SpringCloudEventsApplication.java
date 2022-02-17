package uppercase;

import static org.springframework.cloud.function.cloudevent.CloudEventMessageUtils.ID;
import static org.springframework.cloud.function.cloudevent.CloudEventMessageUtils.SOURCE;
import static org.springframework.cloud.function.cloudevent.CloudEventMessageUtils.SPECVERSION;
import static org.springframework.cloud.function.cloudevent.CloudEventMessageUtils.SUBJECT;

import java.net.URI;
import java.util.UUID;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.cloudevent.CloudEventMessageBuilder;
import org.springframework.cloud.function.context.message.MessageUtils;
import org.springframework.cloud.function.web.util.HeaderUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.Message;


import org.springframework.nativex.hint.MethodHint;
import org.springframework.nativex.hint.TypeHint;
// Remove when release is ready
@TypeHint(types = MessageUtils.MessageStructureWithCaseInsensitiveHeaderKeys.class, methods = @MethodHint(name = "getHeaders"))
@SpringBootApplication
public class SpringCloudEventsApplication {

//  private static final Logger LOGGER = Logger.getLogger(
//      SpringCloudEventsApplication.class.getName());

  public static void main(String[] args) {
    SpringApplication.run(SpringCloudEventsApplication.class, args);
  }

//  @Bean
//  public Function<Message<Input>, Message<Output>> uppercase() {
//    return m -> {
//      HttpHeaders httpHeaders = HeaderUtils.fromMessage(m.getHeaders());
//      
//      LOGGER.log(Level.INFO, "Input CE Id:{0}", httpHeaders.getFirst(
//          ID));
//      LOGGER.log(Level.INFO, "Input CE Spec Version:{0}",
//          httpHeaders.getFirst(SPECVERSION));
//      LOGGER.log(Level.INFO, "Input CE Source:{0}",
//          httpHeaders.getFirst(SOURCE));
//      LOGGER.log(Level.INFO, "Input CE Subject:{0}",
//          httpHeaders.getFirst(SUBJECT));
//
//      Input input = m.getPayload();
//      LOGGER.log(Level.INFO, "Input {0} ", input);
//      Output output = new Output();
//      output.input = input.input;
//      output.operation = httpHeaders.getFirst(SUBJECT);
//      output.output = input.input != null ? input.input.toUpperCase() : "NO DATA";
//      return CloudEventMessageBuilder.withData(output)
//        .setType("UpperCasedEvent").setId(UUID.randomUUID().toString())
//        .setSubject("Convert to UpperCase")
//        .setSource(URI.create("http://example.com/uppercase")).build();
//    };
//  }

}
