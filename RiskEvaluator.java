import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class RiskEvaluator{
  //Detect weak topics (avg < 60%)
  public List<String> detectWeakTopics(Student student, HashMap<String, Double> averages) {
    List<String> weakTopics = new ArrayList<>();
    List<String> topics = new ArrayList<>(averages.keySet());
    
    for (int i = 0; i < topics.size(); i++) {
      String topic = topics.get(i);
      double avg = averages.get(topic);
      
      // If average < 60%, mark as weak
      if (avg < 60) {
        weakTopics.add(topic);
      }
    }
    
    return weakTopics;
  }
  
  // Detect declining topics across exams
  public List<String> detectDecliningTopics(Student student) {
    List<String> decliningTopics = new ArrayList<>();
    List<Exam> exams = student.getExams();
    
    if (exams.size() < 2) {
      return decliningTopics; // not enough exams to detect trend
    }
    
    // Get all topic names from the first exam
    List<TopicScore> firstExamTopics = exams.get(0).getTopicScores();
    List<String> topics = new ArrayList<>();
    for (int i = 0; i < firstExamTopics.size(); i++) {
      topics.add(firstExamTopics.get(i).getTopicName());
    }
    
    // Check trend for each topic
    for (int i = 0; i < topics.size(); i++) {
      String topic = topics.get(i);
      boolean declining = true;
      
      for (int j = 1; j < exams.size(); j++) {
        Exam prevExam = exams.get(j - 1);
        Exam currExam = exams.get(j);
        
        int prevScore = 0;
        int currScore = 0;
        
        List<TopicScore> prevTopics = prevExam.getTopicScores();
        List<TopicScore> currTopics = currExam.getTopicScores();
        
        // Find score of topic in previous exam
        for (int k = 0; k < prevTopics.size(); k++) {
          if (prevTopics.get(k).getTopicName().equals(topic)) {
            prevScore = prevTopics.get(k).getScore();
            break;
          }
        }
        
        // Find score of topic in current exam
        for (int k = 0; k < currTopics.size(); k++) {
          if (currTopics.get(k).getTopicName().equals(topic)) {
            currScore = currTopics.get(k).getScore();
            break;
          }
        }
        
        // If current score >= previous score → not declining
        if (currScore >= prevScore) {
          declining = false;
          break; // stop checking further exams for this topic
        }
      }
      
      if (declining) {
        decliningTopics.add(topic);
      }
    }
    
    return decliningTopics;
  }
}

