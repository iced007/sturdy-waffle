public class TopicScore{
  private String topicName;
  private int score;
  private int maxScore;
  
  public TopicScore(String topicName, int score, int maxScore) {
    this.topicName = topicName;
    this.score = score;
    this.maxScore = maxScore;
  }
  
  public String getTopicName() {
    return topicName;
  }
  public int getScore(){
    return score;
  }
  public int getMaxScore(){
    return maxScore;
  }
}