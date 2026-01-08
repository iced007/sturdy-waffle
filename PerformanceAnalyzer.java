import java.util.HashMap;
import java.util.List;

public class PerformanceAnalyzer {

    public HashMap<String, Double> calculateAverageByTopic(Student student) {

        HashMap<String, Double> totalPercent = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        List<Exam> exams = student.getExams();

        for (int i = 0; i < exams.size(); i++) {
            List<TopicScore> topics = exams.get(i).getTopicScores();

            for (int j = 0; j < topics.size(); j++) {
                TopicScore ts = topics.get(j);

                double percent = ((double) ts.getScore() / ts.getMaxScore()) * 100;
                String topicName = ts.getTopicName();

                totalPercent.put(
                    topicName,
                    totalPercent.getOrDefault(topicName, 0.0) + percent
                );

                count.put(
                    topicName,
                    count.getOrDefault(topicName, 0) + 1
                );
            }
        }

        HashMap<String, Double> averages = new HashMap<>();

        for (String topic : totalPercent.keySet()) {
            averages.put(topic, totalPercent.get(topic) / count.get(topic));
        }

        return averages;
    }
}
