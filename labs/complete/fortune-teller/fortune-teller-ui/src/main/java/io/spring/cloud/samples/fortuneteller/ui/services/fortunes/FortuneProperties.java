package io.spring.cloud.samples.fortuneteller.ui.services.fortunes;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author sgupta
 * @since 2/28/16.
 */
@ConfigurationProperties(prefix = "fortune")
@RefreshScope
public class FortuneProperties {

  private static final Random RANDOM = new Random();

  List<String> messages = new ArrayList<>();

  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  public void addMessage(String message) {
    this.messages.add(message);
  }

  public Fortune getRandomFortuneFromProperty() {
    if(messages == null || messages.size() == 0) {
      return new Fortune(9999L, "Your Future is Unclear, but Cloudy");
    }
    else {
      int index = RANDOM.nextInt(messages.size());
      return new Fortune((long) index, messages.get(index));
    }
  }
}
