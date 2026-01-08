import java.util.HashMap;
import java.util.List;

public class Main{
  public static void main(String [] args){
    //Student creation
    Student student = new Student(1000058678);
    //Exam creation
    Exam exam1 = new Exam("Maths Mid-Term","2025-12-02");
    exam1.addTopicScore(new TopicScore("Algebra", 89, 100));
    exam1.addTopicScore(new TopicScore("Geometry", 80, 100));
    exam1.addTopicScore(new TopicScore("Trigonometry", 70, 100));
    
    
    Exam exam2 = new Exam("Maths Final","2025-11-05");
    exam2.addTopicScore(new TopicScore("Geometry", 69, 100));
    exam2.addTopicScore(new TopicScore("Trigonometry", 78, 100));
    exam2.addTopicScore(new TopicScore("Algebra", 99, 100));
    
    //attaching exams to student
    student.addExam(exam1);
    student.addExam(exam2);
    
//    //Printing
//    System.out.println("Student ID: " + student.getStudentId());
//    System.out.println("Total Exams: " + student.getExams().size());
//    System.out.println(
//                       "Topics in Exam 1: " +
//                       student.getExams().get(0).getTopicScores().size()
//                      );
//    
//    PerformanceAnalyzer analyzer = new PerformanceAnalyzer();
//    HashMap<String, Double> averages = analyzer.calculateAverageByTopic(student);
//    
//    List<String> topics = new java.util.ArrayList<>(averages.keySet());
//    for (int i = 0; i < topics.size(); i++) {
//      String topic = topics.get(i);
//      System.out.println(topic + " → " + averages.get(topic) + "%");
//    }
//    
//    
//    RiskEvaluator evaluator = new RiskEvaluator();
//    
//    List<String> weakTopics = evaluator.detectWeakTopics(student, averages);
//    System.out.println("Weak Topics: " + weakTopics);
//    
//    List<String> decliningTopics = evaluator.detectDecliningTopics(student);
//    System.out.println("Declining Topics: " + decliningTopics);
    
    
    // --- Generate report ---
        ReportGenerator report = new ReportGenerator();
        report.generateReport(student);
    
  }
}