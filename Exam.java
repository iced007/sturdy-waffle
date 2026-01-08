import java.util.List;
import java.util.ArrayList;

public class Exam{
  private String subject;
  private String date;
  private List<TopicScore> topicScores = new ArrayList<>();
  
  public Exam(String subject, String date) {
    this.subject = subject;
    this.date = date;
  }
  
  public void addTopicScore(TopicScore ts) {
    topicScores.add(ts);
  }
  
  public List<TopicScore> getTopicScores() {
    return topicScores;
  }
}