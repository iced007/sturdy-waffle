 import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ReportGenerator {

    public void generateReport(Student student) {
        System.out.println("===== PERFORMANCE REPORT =====");
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Total Exams: " + student.getExams().size());
        System.out.println();

        // 1️⃣ Calculate averages
        PerformanceAnalyzer analyzer = new PerformanceAnalyzer();
        HashMap<String, Double> averages = analyzer.calculateAverageByTopic(student);

        System.out.println("Average Scores by Topic:");
        List<String> topics = new ArrayList<>(averages.keySet());
        for (int i = 0; i < topics.size(); i++) {
            String topic = topics.get(i);
            System.out.printf("%-15s : %.2f%%\n", topic, averages.get(topic));
        }
        System.out.println();

        // 2️⃣ Detect weak and declining topics
        RiskEvaluator evaluator = new RiskEvaluator();
        List<String> weakTopics = evaluator.detectWeakTopics(student, averages);
        List<String> decliningTopics = evaluator.detectDecliningTopics(student);

        System.out.println("Weak Topics (average < 60%): " + weakTopics);
        System.out.println("Declining Topics (score decreasing): " + decliningTopics);
        System.out.println();

        // 3️⃣ Recommendations
        List<String> recommendations = new ArrayList<>();
        for (int i = 0; i < weakTopics.size(); i++) {
            recommendations.add(weakTopics.get(i));
        }
        for (int i = 0; i < decliningTopics.size(); i++) {
            if (!recommendations.contains(decliningTopics.get(i))) {
                recommendations.add(decliningTopics.get(i));
            }
        }

        if (recommendations.size() > 0) {
            System.out.println("Recommendation: Focus on improving these topics: " + recommendations);
        } else {
            System.out.println("Recommendation: Keep up the good work!");
        }

        System.out.println("==============================");
    }
}

